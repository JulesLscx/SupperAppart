package Vue;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Controlleur.GestionConnexion;

public class FEN_Connexion extends JInternalFrame {
    private JPasswordField passwordField;
    private JTextField loginField;
    private GestionConnexion gestionClic;

    /**
     * Create the frame.
     */
    public FEN_Connexion() {
        gestionClic = new GestionConnexion(this);
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(null);

        JLabel lbl_identifiant = new JLabel("Login :");
        lbl_identifiant.setBounds(0, 0, 220, 54);
        lbl_identifiant.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(lbl_identifiant);

        loginField = new JTextField();
        loginField.setBounds(220, 10, 210, 30);
        getContentPane().add(loginField);
        loginField.setColumns(10);

        JLabel lbl_passwd = new JLabel("Password :");
        lbl_passwd.setBounds(0, 108, 220, 30);
        lbl_passwd.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(lbl_passwd);

        passwordField = new JPasswordField();
        passwordField.setBounds(220, 108, 210, 30);
        getContentPane().add(passwordField);

        JButton btn_connecter = new JButton("Connecter");
        btn_connecter.addActionListener(this.gestionClic);
        btn_connecter.setBounds(10, 216, 200, 30);
        getContentPane().add(btn_connecter);

        JButton btn_annuler = new JButton("Annuler");
        btn_annuler.setBounds(220, 216, 210, 30);
        btn_annuler.addActionListener(this.gestionClic);
        getContentPane().add(btn_annuler);

    }

    public String getValeurChLogin() {
        return this.loginField.getText();
    }

    public String getPassword() {
        char[] passwd = this.passwordField.getPassword();
        String result = String.copyValueOf(passwd);
        return result;
    }

    public void connection() {
        FEN_Accueil parent = (FEN_Accueil) this.getTopLevelAncestor();
        parent.activerItems(true);
        dispose();
    }
}
