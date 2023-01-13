package Controlleur;

import java.awt.Container;

import javax.swing.JOptionPane;

public class FEN_Erreurs {

    public FEN_Erreurs(String message, Container contentPane) {
        JOptionPane.showMessageDialog(contentPane, message, "Erreur", JOptionPane.ERROR_MESSAGE);
    }

}
