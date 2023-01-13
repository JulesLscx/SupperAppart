package Controlleur.Ajout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Vue.Ajout.FEN_Ajout_Contrat;

public class GestionAjoutContrat implements ActionListener {
	private FEN_Ajout_Contrat ac;

	// private JTableau;
	public GestionAjoutContrat(FEN_Ajout_Contrat ac) {
		this.ac = ac;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton item = (JButton) e.getSource();
		switch (item.getText()) {
			case "Annuler":
				this.ac.dispose();
				break;
		}
	}
}
