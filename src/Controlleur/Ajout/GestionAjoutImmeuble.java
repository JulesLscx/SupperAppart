package Controlleur.Ajout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Vue.Ajout.FEN_Ajout_Immeuble;

public class GestionAjoutImmeuble implements ActionListener {
	private FEN_Ajout_Immeuble ai;

	// private JTableau;
	public GestionAjoutImmeuble(FEN_Ajout_Immeuble ai) {
		this.ai = ai;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton item = (JButton) e.getSource();
		switch (item.getText()) {
			case "Annuler":
				this.ai.dispose();
				break;
		}
	}
}
