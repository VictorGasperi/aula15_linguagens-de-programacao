package utils;

import java.util.ArrayList;

import javax.swing.JTable;

public class MapCurrentTable {
    
    public static Object[][] map(JTable table) {

        
        ArrayList<Object[]> result = new ArrayList<Object[]>();

        for (int row = 0; row < table.getRowCount(); row++) {
            Object[] aux = new Object[5];
            for (int col = 0; col < table.getColumnCount(); col++) {
                Object value = table.getValueAt(row, col);
                aux[col] = value;
            }
            result.add(aux);
        }

        return result.toArray(new Object[0][]);
    }

}
