package Controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Vue.FEN_Connexion;

public class GestionConnexion implements ActionListener {
    private FEN_Connexion connexion;

    public GestionConnexion(FEN_Connexion connexion) {
        this.connexion = connexion;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton tmp_btn = (JButton) e.getSource();
        switch (tmp_btn.getText()) {
            case "Connecter":
                this.connecter();
                break;
            case "Annuler":
                connexion.dispose();
                break;
            default:
                return;
        }
    }

    private void connecter() {
        try {
            System.out.println(connexion.getPassword());
            System.out.println(connexion.getValeurChLogin());
            CictOracleDataSource.creerAcces(connexion.getValeurChLogin(), connexion.getPassword());
            connexion.connection();
        } catch (SQLException e) {
            JOptionPane err = new JOptionPane();
            err.setMessageType(JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(err, "Login ou mot de passe incorrect");
        }
    }

}
