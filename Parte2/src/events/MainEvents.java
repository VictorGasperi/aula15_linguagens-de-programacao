package events;


import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.time.LocalDateTime;

import entities.*;
import screens.Main;
import utils.FetchTableData;
import utils.MapCurrentTable;
import utils.UpdateNotas;

import java.util.Arrays;






public class MainEvents implements ActionListener{
    
    private Main mainScreen;

    private JButton ler;
    private JButton salvar;

    private Aluno aluno;

    private Connection conn;

    public MainEvents(JButton ler, JButton salvar, JTable table, Aluno aluno, JPanel tableBackground, Main mainScreen, Connection conn) {
        this.ler = ler;
        this.salvar = salvar;
        this.aluno = aluno;
        this.mainScreen = mainScreen;
        this.conn = conn;
    }

    public void actionPerformed(ActionEvent ev) {

        if (ev.getSource() == ler) {
            refreshTable();
        }

        if(ev.getSource() == salvar) 
        {
            
            Object[][] currTable = MapCurrentTable.map(mainScreen.getTable());
            Object[][] atDB = FetchTableData.load(conn, aluno);

            for(int row = 0; row < currTable.length; row++) {
                if(!Arrays.deepEquals(currTable[row], atDB[row])) {
                    System.out.println(row);
                    Object[] aux = currTable[row];
                    Bimester bimestre = new Bimester(Integer.parseInt(aux[1].toString()), Double.parseDouble(aux[2].toString()), Integer.parseInt(aux[3].toString()));
                    Timestamp now = Timestamp.valueOf(LocalDateTime.now());
                    
                    UpdateNotas.update(aluno, new Subject(aux[0].toString()), bimestre, now, conn);

                    refreshTable();

                }
            }

        }
        

    }

    private void refreshTable() {
        mainScreen.getBar().removeAll();
        mainScreen.getTableBackground().removeAll();
        mainScreen.getNorthPanel().removeAll();
      
        mainScreen.setUpTable(conn, aluno);
        mainScreen.getNorthPanel().add(mainScreen.getTableBackground());
        mainScreen.add(mainScreen.getNorthPanel());
        
        mainScreen.getBar().revalidate();
        mainScreen.getBar().repaint();

        mainScreen.getTableBackground().revalidate();
        mainScreen.getTableBackground().repaint();

        mainScreen.getNorthPanel().revalidate();
        mainScreen.getNorthPanel().repaint();
    }

}
