package Controlleur.Ajout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Vue.Ajout.FEN_Ajout_FactureTravauxLogement;

public class GestionAjoutFactureTravauxLogement implements ActionListener {
	private FEN_Ajout_FactureTravauxLogement aftl;

	// private JTableau;
	public GestionAjoutFactureTravauxLogement(FEN_Ajout_FactureTravauxLogement aftl) {
		this.aftl = aftl;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton item = (JButton) e.getSource();
		switch (item.getText()) {
			case "Annuler":
				this.aftl.dispose();
				break;
		}
	}
}
