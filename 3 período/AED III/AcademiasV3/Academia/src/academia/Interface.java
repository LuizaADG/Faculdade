package academia;

/**
 *
 * @author Luiz Guimarães
 */
import java.util.Scanner;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Interface {

    private static Scanner Read = new Scanner(System.in);
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        int operacao = 0;
        Menu();
        Arquivo arquivo = new Arquivo();
        Cliente cliente = new Cliente();
        Modalidades modalidade = new Modalidades();
        do {
            operacao = Read.nextInt();
            switch (operacao) {
                case 0:
                    System.out.println("Obrigado por usar o programa!");
                    break;
                case 1:
                    cadastroCliente(cliente);
                    break;
                case 2:
                    arquivo.listarArq(cliente);
                    break;
                case 3:
                    arquivo.mostraRegistro(cliente, Read.nextInt());
                    break;
                case 4:
                    deletarCliente(arquivo, cliente);
                    break;
                case 5:
                    Menu();
                    break;
                case 6:
                    cadastroModalidade(modalidade);
                    break;
                case 7:
                    arquivo.listarArq(modalidade);
                    break;
                case 8:
                    break;
                case 9:
                    deletarModalidades(arquivo, modalidade);
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    break;
                case 13:
                    Menu();
                case 14:
                    break;
            }
            if (operacao != 0) {
                System.out.println("+------------------------------------------------------------------------------+");
                System.out.println("Digite a opercao:");
            }
        } while (operacao != 0);

    }

    public static void Menu() {
        System.out.println("+----------------------------------------------------------------------------------+");
        System.out.println("|====================================== MENU ======================================|");
        System.out.println("|0 -> sair                |                            |                           |");
        System.out.println("|1 -> Cadastrar Cliente   |  6 -> Cadastrar Modalidade |  10 -> Cadastrar Academia |");
        System.out.println("|2 -> Listar Clientes     |  7 -> Listar Modalidade    |  11 -> Listar Academia    |");
        System.out.println("|3 -> Editar Clientes     |  8 -> Editar Modalidade    |  12 -> Editar Academia    |");
        System.out.println("|4 -> Deletar Cliente     |  9 -> Deletar Modalidade   |  13 -> Deletar Academia   |");
        System.out.println("|5 -> Menu                |                            |  14 -> Pesquisar          |");
        System.out.println("+----------------------------------------------------------------------------------+");
        System.out.println("Digite a opercao:");
    }

    /**
     * @Cadastros Contém cadastro de clientes, de Academias e de Modalidades
     */
    public static void cadastroCliente(Registro registro) {
        Arquivo arq = new Arquivo();
        System.out.println("+------------------------------------------------------------------------------+");
        System.out.println("| Cadastrando Cliente:                                                         |");
        System.out.println("+------------------------------------------------------------------------------+");
        char confirmado = 'n', sexo;
        String nome, email, login, senha, logradouro, complemento, bairro, cidade, estado, pais, cep;
        long nascimento;
        int numero;
        Cliente tmp;
        try {
            do {
                System.out.println("Digite o nome:");
                nome = in.readLine();
                System.out.println("Digite o e-mail:");
                email = in.readLine();
                System.out.println("Digite o sexo:(M/F)");
                sexo = (char) in.readLine().charAt(0);
                System.out.println("Digite o login:");
                login = in.readLine();
                System.out.println("Digite a senha:");
                senha = in.readLine();
                System.out.println("Digite a data de nascimento.:(dd/mm/aaaa)");
                nascimento = new Cliente().CalculaData(in.readLine());//Long.parseLong(in.readLine()) ;
                System.out.println("Digite o logradouro: ");
                logradouro = in.readLine();
                System.out.println("Digite o numero residencial:Ex.:(123)");
                numero = Integer.parseInt(in.readLine());
                System.out.println("Digite o complemento:");
                complemento = in.readLine();
                System.out.println("Digite o bairro:");
                bairro = in.readLine();
                System.out.println("Digite o CEP:");
                cep = in.readLine();
                System.out.println("Digite a cidade:");
                cidade = in.readLine();
                System.out.println("Digite o estado:");
                estado = in.readLine();
                System.out.println("Digite o pais:");
                pais = in.readLine();
                System.out.println("+------------------------------------------------------------------------------+");
                System.out.println("Confirma o cadastro: \nDigite 's' para sim \nDigite 'n' para nao");
                confirmado = (char) in.readLine().charAt(0);
                if (confirmado == 'N' || confirmado == 'n') {
                    System.out.println("Deseja refazer o cadastro: \nDigite 's' para sim \nDigite 'n' para nao");
                    confirmado = (char) in.readLine().charAt(0);
                    if (confirmado == 'S' || confirmado == 's') {
                        confirmado = 'n';
                    } else {
                        confirmado = 'q';
                    }
                }
            } while ((confirmado != 's' && confirmado != 'S') || confirmado == 'q');
            if (confirmado == 'S' || confirmado == 's') {
                tmp = new Cliente(arq, nome, email, sexo, login, senha, nascimento, logradouro, numero, complemento, bairro, cep, cidade, estado, pais);
                new Arquivo().incluiArq(tmp);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void cadastroModalidade(Registro registro) {
        Arquivo arq = new Arquivo();
        System.out.println("+------------------------------------------------------------------------------+");
        System.out.println("| Cadastrando Modalidade:                                                      |");
        System.out.println("+------------------------------------------------------------------------------+");
        Modalidades tmp;
        String nome, descricao, professor;
        char turno, confirmado = 'n';
        try {
            do {
                System.out.println("Digite o nome da modalidade: ");
                nome = in.readLine();
                System.out.println("Escreva a descrição da modalidade: ");
                descricao = in.readLine();
                System.out.println("Escreva o nome do professor: ");
                professor = in.readLine();
                System.out.println("Digite o turno da modalidade: (M/T/N)");
                turno = (char) in.readLine().charAt(0);
                System.out.println("Confirma o cadastro: \nDigite 's' para sim \nDigite 'n' para nao");
                confirmado = (char) in.readLine().charAt(0);
                if (confirmado == 'N' || confirmado == 'n') {
                    System.out.println("Deseja refazer o cadastro: \nDigite 's' para sim \nDigite 'n' para nao");
                    confirmado = (char) in.readLine().charAt(0);
                    if (confirmado == 'S' || confirmado == 's') {
                        confirmado = 'n';
                    } else {
                        confirmado = 'q';
                    }
                }
            } while ((confirmado != 's' && confirmado != 'S') || confirmado == 'q');
            if (confirmado == 'S' || confirmado == 's') {
                tmp = new Modalidades(arq, nome, descricao, professor, turno);
                new Arquivo().incluiArq(tmp);
            }

        } catch (Exception e) {
        }
    }

    /**
     * @Métodos para deletar Métodos que deletam: clientes, Academias e
     * Modalidades
     */
    public static void deletarCliente(Arquivo arquivo, Cliente cliente) {
        char confirmado;
        System.out.println("+------------------------------------------------------------------------------+");
        System.out.print("Digite o código do cliente: ");
        int selecionado = Read.nextInt();
        try {
            long endereço = arquivo.pegaporCodigo(cliente, selecionado);

            RandomAccessFile acesso = arquivo.getAccess(cliente);
            if (endereço < 0) {
                System.out.println("Não existe o registro com o código informado!");
                return;
            }
            acesso.seek(endereço);
            cliente.lerObjeto(acesso);
            System.out.println("Tem certeza que deseja apagar: codigo [" + cliente.getCOD() + "] " + cliente.getNome() + "(s/n)?");
            confirmado = (char) in.readLine().charAt(0);
            if (confirmado == 's' || confirmado == 'S') {
                arquivo.apagaRegistro(cliente, selecionado);
            }
            acesso.close();

        } catch (IOException ex) {
        } catch (Exception ex) {
            Logger.getLogger(Arquivo.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void deletarModalidades(Arquivo arquivo, Modalidades modalidade) {
        char confirmado;
        System.out.println("+------------------------------------------------------------------------------+");
        System.out.print("Digite o código do Modalidade: ");
        int selecionado = Read.nextInt();
        try {
            long endereço = arquivo.pegaporCodigo(modalidade, selecionado);

            RandomAccessFile acesso = arquivo.getAccess(modalidade);
            if (endereço < 0) {
                System.out.println("Não existe o registro com o código informado!");
                return;
            }
            acesso.seek(endereço);
            modalidade.lerObjeto(acesso);
            System.out.println("Tem certeza que deseja apagar: codigo [" + modalidade.getCOD() + "] " + modalidade.getNome() + "(s/n)?");
            confirmado = (char) in.readLine().charAt(0);
            if (confirmado == 's' || confirmado == 'S') {
                arquivo.apagaRegistro(modalidade, selecionado);
            }
            acesso.close();

        } catch (IOException ex) {
        } catch (Exception ex) {
            Logger.getLogger(Arquivo.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * @Métodos para editar Métodos que editam: clientes, Academias e
     * Modalidades
     */
    public void editarCliente(Arquivo arquivo, Cliente cliente) {
        System.out.print("Digite o código do cliente que você quer alterar: ");
        int selecionado = Read.nextInt();
        char confirmado;
        try {
            long endereço = arquivo.pegaporCodigo(cliente, selecionado);
            RandomAccessFile acesso = arquivo.getAccess(cliente);
            if (endereço < 0) {
                System.out.println("Não existe o registro com o código informado!");
                return;
            }
            acesso.seek(endereço);
            cliente.lerObjeto(acesso);
            System.out.println("O que você deseja alterar:");
            System.out.println("Código: 0 --> Nome\nCódigo: 1 --> E-mail\nCódigo: 2 --> Sexo\n"
                    + "Código: 3 --> Login\nCódigo: 4 --> Senha"
                    + "\nCódigo: 5 --> Data de Nascimento\nCódigo: 6 --> Endereço"
                    + "\nCódigo: 7 --> Todos\nCódigo: 8 --> Cancelar");
            short operacao = Read.nextShort();
            switch (operacao) {
                case 0:
                    System.out.print("Digite o outro nome: ");
                    acesso.readInt();
                    acesso.readBoolean();

                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:

            }

            confirmado = (char) in.readLine().charAt(0);
            if (confirmado == 's' || confirmado == 'S') {
                arquivo.apagaRegistro(cliente, selecionado);
            }
            acesso.close();

        } catch (IOException ex) {
        } catch (Exception ex) {
            Logger.getLogger(Arquivo.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * @Método para pesquisar Métodos generico que pesquisa: clientes, Academias
     * e Modalidades por meio de uma chave escolhida
     */
    public void pesquisa() {
        System.out.println("+------------------------------------------------------------------------------+");
        System.out.println("| Realizando pesquisa                                                          |");
        System.out.println("+------------------------------------------------------------------------------+");
        System.out.println("Opções:\n "
                + "|0 -> Cancelar                                         |"
                + "|1 -> Cliente que frequentam a academia<chave>         |"
                + "|2 -> Modalidades  de uma certa Academia<chave>        |"
                + "|3 -> Academias que apresentam esta modalidade<chave>  |");
        System.out.print("Digite a operação: ");
        int operacao = Read.nextInt();
        switch (operacao) {
            case 0:
                System.out.print("Pesquisa Cancelada!!!");
                break;
            case 1:
                Cliente cliente;
                System.out.print("Digite o código da academia: ");
                operacao = Read.nextInt();
                break;
            case 2:
                Modalidades modalidade;
                System.out.print("Digite o código da academia: ");
                operacao = Read.nextInt();
                break;
            case 3:
                Academia academia;
                System.out.print("Digite o código da Modalidade: ");
                operacao = Read.nextInt();
                break;
        }
    }
}
