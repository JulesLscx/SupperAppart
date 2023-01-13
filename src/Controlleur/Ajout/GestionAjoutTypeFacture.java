package Controlleur.Ajout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Vue.Ajout.FEN_Ajout_TypeFacture;

public class GestionAjoutTypeFacture implements ActionListener {
	private FEN_Ajout_TypeFacture atf;

	// private JTableau;
	public GestionAjoutTypeFacture(FEN_Ajout_TypeFacture atf) {
		this.atf = atf;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton item = (JButton) e.getSource();
		switch (item.getText()) {
			case "Annuler":
				this.atf.dispose();
				break;
		}
	}
}
