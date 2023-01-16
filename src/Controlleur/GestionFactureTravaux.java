package Controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Vue.FEN_Accueil;
import Vue.FEN_Facture_Travaux_Logement;

public class GestionFactureTravaux implements ActionListener {
	private FEN_Facture_Travaux_Logement ai;

	public GestionFactureTravaux(FEN_Facture_Travaux_Logement ai) {
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