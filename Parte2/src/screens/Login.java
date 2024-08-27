package screens;

import javax.swing.*;
import javax.swing.border.Border;

import entities.LanguagesOb;
import events.LoginEvents;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.util.ResourceBundle;

public class Login extends JFrame {

    private Container contentPane;
    private JPanel northPanel;
    private JPanel centralPanelDiv;
    private JPanel centralPanelGrid;
    private JPanel southPanelDiv;
    private JPanel southPanelGrid;

    private JLabel title_label;

    private JLabel login_label;
    private JTextField login_field;

    private JLabel pass_label;
    private JPasswordField pass_field;

    private JButton confirm_btn;

    private LoginEvents loginEvents;

    public Login(Connection conn, LanguagesOb chosenLang) {
        super(chosenLang.getBn_login().getString("login.titulo"));

        initializeComponents(conn, chosenLang);

        prepareScreen();

        initializeScreen();
    }

    private void initializeScreen() {
        // setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initializeComponents(Connection conn, LanguagesOb chosenLang) {

        
        Font title_font = new Font("Montserrat", Font.BOLD, 18);
        Font notTitle_font = new Font("Montserrat", Font.PLAIN, 15);
        Dimension login_btn_dimention = new Dimension(200, 50);
        Dimension textField_dimension = new Dimension(200, 20);
        Border border_btn = BorderFactory.createLineBorder(Color.WHITE, 1, true);
        ResourceBundle langSource = chosenLang.getBn_login();

        title_label = new JLabel(langSource.getString("login.heading"));
        title_label.setFont(title_font);

        login_label = new JLabel(langSource.getString("login.user"));
        login_label.setFont(notTitle_font);

        login_field = new JTextField();
        login_field.setPreferredSize(textField_dimension);
        login_field.setFont(notTitle_font);

        pass_label = new JLabel(langSource.getString("login.senha"));
        pass_label.setFont(notTitle_font);

        pass_field = new JPasswordField();
        pass_field.setPreferredSize(textField_dimension);

        confirm_btn = new JButton(langSource.getString("login.btn1"));
        confirm_btn.setPreferredSize(login_btn_dimention);
        confirm_btn.setOpaque(true);
        confirm_btn.setFont(notTitle_font);
        confirm_btn.setBorder(border_btn);
        confirm_btn.setBackground(Color.BLUE);
        confirm_btn.setForeground(Color.WHITE);
        confirm_btn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                confirm_btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                confirm_btn.setCursor(Cursor.getDefaultCursor());
            }

            public void mousePressed(MouseEvent e) {
                confirm_btn.setBackground(Color.LIGHT_GRAY);
            }

            public void mouseReleased(MouseEvent e) {
                confirm_btn.setBackground(Color.BLUE);
            }
        });

        loginEvents = new LoginEvents(this, login_field, pass_field, confirm_btn, chosenLang, conn);

        confirm_btn.addActionListener(loginEvents);

    }

    private void prepareScreen() {


        contentPane = this.getContentPane();
        contentPane.setLayout(new BorderLayout());
        // contentPaneDiv = new JPanel(new BorderLayout());
        northPanel = new JPanel(new FlowLayout());
        centralPanelGrid = new JPanel(new GridLayout(2, 2));
        centralPanelDiv = new JPanel(new FlowLayout(FlowLayout.CENTER));
        southPanelGrid = new JPanel(new GridLayout(1, 2, 2, 0));
        southPanelDiv = new JPanel(new FlowLayout(FlowLayout.CENTER));

        northPanel.add(title_label);
        centralPanelGrid.add(login_label);
        centralPanelGrid.add(login_field);
        centralPanelGrid.add(pass_label);
        centralPanelGrid.add(pass_field);
        centralPanelDiv.add(centralPanelGrid);
        southPanelGrid.add(confirm_btn);
        southPanelDiv.add(southPanelGrid);

        contentPane.add(northPanel, BorderLayout.NORTH);
        contentPane.add(centralPanelDiv, BorderLayout.CENTER);
        contentPane.add(southPanelDiv, BorderLayout.SOUTH);
    }

}
