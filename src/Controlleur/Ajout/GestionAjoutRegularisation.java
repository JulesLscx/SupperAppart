package Controlleur.Ajout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Vue.Ajout.FEN_Ajout_Regularisation;

public class GestionAjoutRegularisation implements ActionListener {
	private FEN_Ajout_Regularisation ar;

	// private JTableau;
	public GestionAjoutRegularisation(FEN_Ajout_Regularisation ar) {
		this.ar = ar;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton item = (JButton) e.getSource();
		switch (item.getText()) {
			case "Annuler":
				this.ar.dispose();
				break;
		}
	}
}
