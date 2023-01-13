package Controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Vue.FEN_Accueil;
import Vue.FEN_Regularisation;

public class GestionRegularisation implements ActionListener {
	private FEN_Regularisation ai;

	public GestionRegularisation(FEN_Regularisation ai) {
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