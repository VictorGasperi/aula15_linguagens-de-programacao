package screens;

import javax.swing.*;
import javax.swing.border.Border;

import events.LanguageEvents;

import java.awt.*;
import java.sql.Connection;

public class Languages extends JFrame{
    
    private JLabel title;

    private JButton btn_ptbr;
    private JButton btn_enus;

    private LanguageEvents languageEvents;

    public Languages(Connection conn) {
        super("Select language");

        initializeComponents(conn);

        prepareScreen();

        initializeScreen();

    }

    private void initializeScreen() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        // setSize(300, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void prepareScreen() {
        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(title);
        getContentPane().add(btn_ptbr);
        getContentPane().add(btn_enus);
    }

    private void initializeComponents(Connection conn) {
        
        Font title_font = new Font("Montserrat", Font.BOLD, 18);
        Font notTitle_font = new Font("Montserrat", Font.PLAIN, 15);
        Dimension btn_dimention = new Dimension(200, 50);
        Border border_btn = BorderFactory.createLineBorder(Color.WHITE, 1, true);

        title = new JLabel("Select language");
        title.setFont(title_font);

        btn_ptbr = new JButton("Portugês do Brasil");
        btn_ptbr.setPreferredSize(btn_dimention);
        btn_ptbr.setOpaque(true);
        btn_ptbr.setFont(notTitle_font);
        btn_ptbr.setBorder(border_btn);
        btn_ptbr.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));


        btn_enus = new JButton("English");
        btn_enus.setPreferredSize(btn_dimention);
        btn_enus.setOpaque(true);
        btn_enus.setFont(notTitle_font);
        btn_enus.setBorder(border_btn);
        btn_enus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        languageEvents = new LanguageEvents(this, btn_ptbr, btn_enus, conn);
        btn_ptbr.addActionListener(languageEvents);
        btn_enus.addActionListener(languageEvents);

    }

}
