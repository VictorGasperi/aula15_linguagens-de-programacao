package screens;

import javax.swing.*;

import entities.Aluno;
import entities.LanguagesOb;
import events.MainEvents;
import utils.FetchTableData;

import java.awt.*;
import java.sql.Connection;
import java.util.ResourceBundle;

public class Main extends JFrame{
    
    private JPanel northPanel;
    private JPanel southPanel;

    private JTable table;
    private JScrollPane bar;
    private JPanel tableBackground;

    private JButton ler;
    private JButton salvar;

    private MainEvents eventManager;

    private Login loginScreen;

    private LanguagesOb chosenLang;
    private ResourceBundle langSource;

    public Main(Connection conn, Aluno aluno, Login loginScreen, LanguagesOb chosenLang){
        
        super(chosenLang.getBn_main().getString("main.titulo"));

        this.chosenLang = chosenLang;
        langSource = this.chosenLang.getBn_main();
        
        this.loginScreen = loginScreen; 
        
        initializeComponents(conn, aluno);

        prepareScreen();
        
        initializeScreen();
    }

    private void initializeComponents(Connection conn, Aluno aluno){
        
        setUpTable(conn, aluno);

        ler = new JButton(langSource.getString("main.btn1"));
        ler.setPreferredSize(new Dimension(250, 50));
        ler.setBackground(Color.LIGHT_GRAY);
        ler.setBorder(BorderFactory.createLineBorder(Color.gray));
        ler.setFont(new Font("Arial", Font.BOLD, 18));
        ler.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        salvar = new JButton(langSource.getString("main.btn2"));
        salvar.setPreferredSize(new Dimension(250, 50));
        salvar.setBackground(Color.LIGHT_GRAY);
        salvar.setBorder(BorderFactory.createLineBorder(Color.gray));
        salvar.setFont(new Font("Arial", Font.BOLD, 18));
        salvar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        

        eventManager = new MainEvents(ler, salvar, table, aluno, tableBackground, this, conn);

        ler.addActionListener(eventManager);
        salvar.addActionListener(eventManager);

    }



    public void setUpTable(Connection conn, Aluno aluno) {
        Object[][] tableData = FetchTableData.load(conn, aluno);
        String[] tableColumn = {langSource.getString("main.table.column1"), langSource.getString("main.table.column2"), langSource.getString("main.table.column3"), langSource.getString("main.table.column4"), langSource.getString("main.table.column5")};

        table = new JTable(tableData, tableColumn);
        bar = new JScrollPane(table);
        tableBackground = new JPanel(new GridLayout());
        tableBackground.add(bar);
    }

    private void prepareScreen() {
        
        getContentPane().setLayout(new BorderLayout());

        northPanel = new JPanel(new FlowLayout());
        southPanel = new JPanel(new FlowLayout());

        northPanel.add(tableBackground);
        southPanel.add(ler);
        southPanel.add(salvar);


        getContentPane().add(northPanel, BorderLayout.NORTH);
        getContentPane().add(southPanel, BorderLayout.SOUTH);
    }

    private void initializeScreen() {
        // setSize(800, 600);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // setResizable(false);
        pack();
        setLocationRelativeTo(loginScreen.getContentPane());
        setVisible(true);
    }



    // public Container getContentPane() { NAO PODE USAR ISSO SE NAO DA ERRO
    //     return contentPane;
    // }



    public JPanel getNorthPanel() {
        return northPanel;
    }



    public JPanel getSouthPanel() {
        return southPanel;
    }



    public JTable getTable() {
        return table;
    }



    public JScrollPane getBar() {
        return bar;
    }



    public JPanel getTableBackground() {
        return tableBackground;
    }



    public JButton getLer() {
        return ler;
    }



    public JButton getSalvar() {
        return salvar;
    }

}
