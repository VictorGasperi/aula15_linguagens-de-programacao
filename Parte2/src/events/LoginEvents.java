package events;

import java.awt.event.*;
import java.sql.Connection;
import java.util.ResourceBundle;

import javax.swing.*;

import entities.Aluno;
import entities.LanguagesOb;
import screens.Login;
import screens.Main;

public class LoginEvents implements ActionListener{

    private Login loginScreen;
    private JTextField user_field;
    private JPasswordField pass_field;
    private JButton confirm_btn;
    private LanguagesOb chosenLang;
    private Connection conn;

    public LoginEvents(Login loginScreen, JTextField user_field, JPasswordField pass_field, JButton confirm_btn, LanguagesOb chosenLang, Connection conn) {
        this.loginScreen = loginScreen;
        this.user_field = user_field;
        this.pass_field = pass_field;
        this.confirm_btn = confirm_btn;
        this.chosenLang = chosenLang;
        this.conn = conn;
    }

    public void actionPerformed(ActionEvent ev) {
        ResourceBundle langSource = chosenLang.getBn_login();

        if(ev.getSource() == confirm_btn) {

            if(user_field.getText().trim().length() == 0 || pass_field.getPassword().length == 0) {
                JOptionPane.showMessageDialog(loginScreen.getContentPane(), langSource.getString("login.alertMsg.content"), langSource.getString("login.alertMsg.title"), JOptionPane.WARNING_MESSAGE);
                return;
            }

            Aluno user = new Aluno(user_field.getText(), new String(pass_field.getPassword()));

            user.carregar(conn);

            if(user.get_id() == 0) {
                JOptionPane.showMessageDialog(loginScreen.getContentPane(), langSource.getString("login.informMsg.content"), langSource.getString("login.informMsg.title"), JOptionPane.INFORMATION_MESSAGE);
                
            } else {
                JOptionPane.showMessageDialog(loginScreen.getContentPane(), langSource.getString("login.successMsg.content"), langSource.getString("login.successMsg.title"), JOptionPane.INFORMATION_MESSAGE);
                new Main(conn, user, loginScreen, chosenLang);
                loginScreen.dispose();
            }

        }

        

    }

    

}
