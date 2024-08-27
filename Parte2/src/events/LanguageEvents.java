package events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;

import entities.LanguagesOb;
import screens.Login;
import screens.Languages;


public class LanguageEvents implements ActionListener{

    private static final int ptLangCode = 1;
    private static final int enLangCode = 2;

    private Languages languagesScreen;
    private JButton btn_ptbr;
    private JButton btn_enus;

    private LanguagesOb chosenLang;

    private Connection conn;
    
    public LanguageEvents(Languages languagesScreen, JButton btn_ptbr, JButton btn_enus, Connection conn) {
        this.languagesScreen = languagesScreen;
        this.btn_ptbr = btn_ptbr;
        this.btn_enus = btn_enus;
        this.conn = conn;
    }

    public void actionPerformed(ActionEvent ev) {

        if(ev.getSource() == btn_ptbr) {
            chosenLang = new LanguagesOb(ptLangCode);
            new Login(conn, chosenLang);
            languagesScreen.dispose();
        }

        if(ev.getSource() == btn_enus) {
            chosenLang = new LanguagesOb(enLangCode);
            new Login(conn, chosenLang);
            languagesScreen.dispose();
        }

    }

}
