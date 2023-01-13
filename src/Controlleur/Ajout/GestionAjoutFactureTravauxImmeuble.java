package Controlleur.Ajout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Vue.Ajout.FEN_Ajout_FactureTravauxImmeuble;

public class GestionAjoutFactureTravauxImmeuble implements ActionListener {
	private FEN_Ajout_FactureTravauxImmeuble afti;

	// private JTableau;
	public GestionAjoutFactureTravauxImmeuble(FEN_Ajout_FactureTravauxImmeuble afti) {
		this.afti = afti;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton item = (JButton) e.getSource();
		switch (item.getText()) {
			case "Annuler":
				this.afti.dispose();
				break;
		}
	}
}
