package Controlleur.Ajout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Vue.Ajout.FEN_Ajout_AssuranceImmeuble;

public class GestionAjoutAssuranceImmeuble implements ActionListener {
	private FEN_Ajout_AssuranceImmeuble aai;

	// private JTableau;
	public GestionAjoutAssuranceImmeuble(FEN_Ajout_AssuranceImmeuble aai) {
		this.aai = aai;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton item = (JButton) e.getSource();
		switch (item.getText()) {
			case "Annuler":
				this.aai.dispose();
				break;
		}
	}
}
