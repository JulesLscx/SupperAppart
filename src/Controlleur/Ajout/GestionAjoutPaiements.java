package Controlleur.Ajout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Vue.Ajout.FEN_Ajout_Paiements;

public class GestionAjoutPaiements implements ActionListener {
	private FEN_Ajout_Paiements ap;

	// private JTableau;
	public GestionAjoutPaiements(FEN_Ajout_Paiements ap) {
		this.ap = ap;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton item = (JButton) e.getSource();
		switch (item.getText()) {
			case "Annuler":
				this.ap.dispose();
				break;
		}
	}
}
