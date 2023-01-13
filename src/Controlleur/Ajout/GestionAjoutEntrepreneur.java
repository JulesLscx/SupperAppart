package Controlleur.Ajout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Vue.Ajout.FEN_Ajout_Entrepreneur;

public class GestionAjoutEntrepreneur implements ActionListener {
	private FEN_Ajout_Entrepreneur ae;

	// private JTableau;
	public GestionAjoutEntrepreneur(FEN_Ajout_Entrepreneur ae) {
		this.ae = ae;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton item = (JButton) e.getSource();
		switch (item.getText()) {
			case "Annuler":
				this.ae.dispose();
				break;
		}
	}
}
