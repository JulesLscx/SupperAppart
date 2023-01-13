package Controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Vue.FEN_Accueil;
import Vue.FEN_Logement;

public class GestionLogement implements ActionListener {
	private FEN_Logement AI;

	public GestionLogement(FEN_Logement AI) {
		this.AI = AI;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton item = (JButton) e.getSource();
		switch (item.getText()) {
			case "Annuler":
				((FEN_Accueil) this.AI.getTopLevelAncestor()).switchOuverte();
				this.AI.dispose();
				break;
		}
	}
}