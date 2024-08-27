package screens;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.Locale;
import java.util.ResourceBundle;

public class TelaExemplo extends JFrame implements ActionListener{

    private JButton bt;
    private JTextField tx;
    private JLabel rt;
    private ResourceBundle bn = null;

    public TelaExemplo() {

        int op = Integer.parseInt(JOptionPane.showInputDialog("Idioma - Language - Langue - Lingua\n\n1 - Português\n2 - English\n3 - Française\n4 - Italiano"));

        switch(op) {
            case 1:
                bn = ResourceBundle.getBundle("lang.main", new Locale("pt", "BR"));
                break;
            case 2:
                bn = ResourceBundle.getBundle("lang.main", Locale.US);
                break;
            case 3:
                bn = ResourceBundle.getBundle("lang.main", Locale.FRANCE);
                break;
            case 4:
                bn = ResourceBundle.getBundle("lang.main", Locale.ITALY);
                break;
        }

        Container cx = getContentPane();
        cx.setLayout(new FlowLayout());

        bt = new JButton(bn.getString("tela1.botao.calcular"));
        rt = new JLabel(bn.getString("tela1.rotulo.valor") + ":");
        tx = new JTextField(10);

        cx.add(rt);
        cx.add(tx);
        cx.add(bt);

        bt.addActionListener(this);

        setTitle(bn.getString("tela1.titulo"));
        setSize(350, 100);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if(tx.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, bn.getString("mensagem.valor.nulo"), bn.getString("tela1.erro.titulo"), JOptionPane.ERROR_MESSAGE);
        } else {
            int n = Integer.parseInt(tx.getText());
            n = n * n;
            tx.setText("" + n);
        }
    }


}
