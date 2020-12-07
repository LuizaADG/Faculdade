package trabalhoaciii;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.accessibility.AccessibleRole;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author LuizHG
 */
public class TesteInterface extends JFrame{
    JanelaInstrucao janela;
    Execucao execucao;
    int clock;
    JLabel clock_Label;
    JLabel instrucoesRealizadas_Label;
    JTable execucaoTable;
    JTable mem;
    JTable jan;
    JTable executadosTable;
    JPanel Painel1;
    
    public TesteInterface(String title, JanelaInstrucao j){
        super(title);
        setSize(800, 600);
        
        this.janela = j;
        this.execucao = janela.ex;
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        clock = 0;
        clock_Label = new JLabel("Clock: " + clock);
        instrucoesRealizadas_Label = new JLabel("IR: " + Execucao.quantRealizadas);
        
        //add(clock_Label);
        //======== Cria a tabela da Memoria Principal ==================================
        Painel1 = new JPanel();
        Painel1.add(clock_Label);
        Painel1.add(new JLabel("Memória Principal:"));
        Painel1.add(instrucoesRealizadas_Label);
        Painel1.setLayout(new BoxLayout(Painel1, BoxLayout.Y_AXIS));
        add(Painel1);
        mem = criarTabela(Memoria.memoriatoArrayString());
        mem.setPreferredSize(new Dimension(120, Memoria.getCont() * 16));
        System.out.println("Instrucoes: "+ Memoria.getCont());
        add(mem);
        /*
        JPanel Painel1 = new JPanel();
        Painel1.add(new JLabel("Memória Principal"));
        mem = criarTabela(Memoria.memoriatoArrayString());
        Painel1.add(mem);
        Painel1.setLayout(new BoxLayout(Painel1, BoxLayout.Y_AXIS));
        add(Painel1);
        */
        
        add(new JLabel("Janela:"));
        jan = criarTabela(janela.jantoArrayString());
        jan.setPreferredSize(new Dimension(120, janela.tam * 16));
        add(jan);
        
        
        add(new JLabel("Execucao:"));
        execucaoTable = criarTabela(execucao.execucaotoArrayString());
        execucaoTable.setPreferredSize(new Dimension(120, 5 * 16));
        add(execucaoTable);
        
        add(new JLabel("Executados:"));
        executadosTable = criarTabela(execucao.executadostoArrayString());
        executadosTable.setPreferredSize(new Dimension(120, Memoria.getCont() * 16));
        add(executadosTable);
        
        
 


        
        
        
        //setContentPane(getJContentPane());
        
        
        JPanel painel = new JPanel();
        //JButton b_carregar = new JButton("Trace");
        JButton b_proximo = new JButton("Next");
        //painel.add(b_carregar);
        painel.add(b_proximo);
        
        /*
        b_carregar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                File file = null;
                try{
                    file = buscarArquivo();
                }catch(Exception ErroCriarArquivo){
        
        
                }
            }
        });
        */
        
        b_proximo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                clock = clock + 1;
                TrabalhoACIII.teste.clock_Label.setText("Clock: " + clock);
                //TrabalhoACIII.teste.label.updateUI();
                TrabalhoACIII.clock();
                atualizarIR();
                if(j.janela.size() == 0 && j.ex.todasLivres()){
                    String ipc = String.format("%.2f", (Execucao.quantRealizadas/(double)Execucao.clockExe));
                    JOptionPane.showMessageDialog(null, "O IPC e: " + ipc);
                }
                //TrabalhoACIII.teste.execucaoTable.repaint();
                //TrabalhoACIII.teste.update(TrabalhoACIII.teste.getGraphics());
            }
        });
        add(painel);
        //add(criarTabelaScroll(colunas, dados));
        pack();//Serve para organizar os componentes da frame para que ocupem menos espaço possível
        setVisible(true);
    }
    
    public void mostrarJanela(){
        TrabalhoACIII.teste.atualizarTable(jan, janela.jantoArrayString());
    }
    public void mostrarExecucao(){
        TrabalhoACIII.teste.atualizarTable(execucaoTable, execucao.execucaotoArrayString());
    }
    public void mostrarExecutados() {
        TrabalhoACIII.teste.atualizarTable(executadosTable, execucao.executadostoArrayString());
    }
    
    public JScrollPane criarTabelaScroll(String[] colunas, String[][] dados){
        /**
         * Criando uma JTable
         */
        Tabela table = new Tabela(dados, colunas);
        //Por padrão vem sem bordas então vou colocar....
        table.setBorder(new LineBorder(Color.black));
        table.setGridColor(Color.black);
        table.setShowGrid(true);
        //Fazendo a parte de scroll da JTable
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().setBorder(null);
        scroll.getViewport().add(table);//Adicionar a table criada no scroll
        scroll.setBounds(table.bounds());
        //scroll.setSize(100,100);//Definir o tamanho do scroll
        return scroll;
    }
    
    public JTable criarTabela(String[][] dados){
        String[] colunas = new String[dados[0].length];

        for(int i = 0; i < dados[0].length; i++){
            colunas[i] = " ";
        }
        Tabela table = new Tabela(dados, colunas);
        //Por padrão vem sem bordas então vou colocar....
        table.setBorder(new LineBorder(Color.black));
        table.setGridColor(Color.black);
        table.setShowGrid(true);
        return table;
    }
    
    public void atualizarTable(JTable tabela, String[][] array){
        for(int i = 0; i < array.length; i++){
            tabela.setValueAt(array[i][0], i, 0);
        }
    }
    
    public void atualizarIR(){
        TrabalhoACIII.teste.instrucoesRealizadas_Label.setText("IR: " + Execucao.quantRealizadas);
    }
    
    public File buscarArquivo() throws Exception{
        File file = null;
        JFileChooser filechooser = new JFileChooser();//Posso colocar o diretório como parametro (String)
        //filechooser.setFileFilter(new FileNameExtensionFilter("Apenas Batata", "xml"));//Posso escolher que tipo de arquivo vou ler
        int retorno = filechooser.showOpenDialog(null);
        if(retorno == JFileChooser.APPROVE_OPTION){
            file = filechooser.getSelectedFile();
            JOptionPane.showMessageDialog(null, "Arquivo carregado com sucesso!");
        }
        else{
            throw new Exception("Erro ao abrir o arquivo");
        }
        return file;
    }
}


