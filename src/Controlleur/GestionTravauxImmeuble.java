package Controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Vue.FEN_Accueil;
import Vue.FEN_Facture_Travaux_Immeuble;

public class GestionTravauxImmeuble implements ActionListener {
	private FEN_Facture_Travaux_Immeuble ai;

	public GestionTravauxImmeuble(FEN_Facture_Travaux_Immeuble ai) {
		this.ai = ai;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton item = (JButton) e.getSource();
		switch (item.getText()) {
			case "Annuler":
				((FEN_Accueil) this.ai.getTopLevelAncestor()).switchOuverte();
				this.ai.dispose();
				break;
		}
	}
}