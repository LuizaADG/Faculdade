package trabalhoaciii;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author LuizHG
 */
public class Tabela extends JTable{

    public Tabela(Object[][] os, Object[] os1) {
        super(os, os1);
    }
    
    @Override
    public boolean isCellEditable(int i, int i1) {
            return false;
    }
        
   
}