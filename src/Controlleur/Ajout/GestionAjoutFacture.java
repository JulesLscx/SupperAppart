package Controlleur.Ajout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Vue.Ajout.FEN_Ajout_Facture;

public class GestionAjoutFacture implements ActionListener {
	private FEN_Ajout_Facture af;

	// private JTableau;
	public GestionAjoutFacture(FEN_Ajout_Facture af) {
		this.af = af;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton item = (JButton) e.getSource();
		switch (item.getText()) {
			case "Annuler":
				this.af.dispose();
				break;
		}
	}
}
