package Controlleur.Ajout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Vue.AjouterContacts;
import Vue.FEN_Accueil;

public class GestionAjouterContacts implements ActionListener {
	private AjouterContacts ac;

	// private JTableau;
	public GestionAjouterContacts(AjouterContacts ac) {
		this.ac = ac;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton item = (JButton) e.getSource();
		switch (item.getText()) {
			case "Annuler":
				((FEN_Accueil) this.ac.getTopLevelAncestor()).switchOuverte();
				this.ac.dispose();
				break;
		}
	}
}
