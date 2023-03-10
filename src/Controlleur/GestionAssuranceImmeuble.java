package Controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Vue.FEN_Accueil;
import Vue.FEN_AssuranceImmeuble;

public class GestionAssuranceImmeuble implements ActionListener {
	private FEN_AssuranceImmeuble ai;

	public GestionAssuranceImmeuble(FEN_AssuranceImmeuble ai) {
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
