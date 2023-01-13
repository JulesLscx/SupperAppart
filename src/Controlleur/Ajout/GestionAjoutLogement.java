package Controlleur.Ajout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Vue.Ajout.FEN_Ajout_Logement;

public class GestionAjoutLogement implements ActionListener {
	private FEN_Ajout_Logement al;

	// private JTableau;
	public GestionAjoutLogement(FEN_Ajout_Logement al) {
		this.al = al;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton item = (JButton) e.getSource();
		switch (item.getText()) {
			case "Annuler":
				this.al.dispose();
				break;
		}
	}
}
