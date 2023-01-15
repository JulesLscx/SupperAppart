package Controlleur.Ajout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;

import Modele.Type_Fac;
import Modele.DAO.DaoType_Fac;
import Vue.FEN_Erreurs;
import Vue.Ajout.FEN_Ajout_TypeFacture;

public class GestionAjoutTypeFacture implements ActionListener {
	private FEN_Ajout_TypeFacture ac;

	// private JTableau;
	public GestionAjoutTypeFacture(FEN_Ajout_TypeFacture ac) {
		this.ac = ac;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton item = (JButton) e.getSource();
		switch (item.getText()) {
			case "Annuler":
				this.ac.dispose();
				break;
			case "Valider":
				if (!this.ac.isType_FacSet()) {
					this.inserer();
				} else {
					this.modifier();
				}
				break;
		}
	}

	private void modifier() {
		DaoType_Fac dao = new DaoType_Fac();
		if (this.ac.getText_Type_fac().getText().isEmpty() ||
				this.ac.getText_Periodicite().getText().isEmpty() ||
				this.ac.getText_Unite().getText().isEmpty()) {
			new FEN_Erreurs("Remplissez tous les champs", this.ac);
			return;
		}
		String typeF, periodicite, unite;
		typeF = this.ac.getText_Type_fac().getText();
		periodicite = this.ac.getText_Periodicite().getText();
		unite = this.ac.getText_Unite().getText();
		Type_Fac c = null;
		try {
			c = new Type_Fac(typeF, periodicite, unite);
		} catch (Exception e) {
			new FEN_Erreurs(e.getMessage(), ac);
			return;
		}
		try {
			dao.update(c);
			this.ac.dispose();
		} catch (SQLException e) {
			new FEN_Erreurs(e.getMessage(), ac);
			return;
		}
	}

	private void inserer() {
		DaoType_Fac dao = new DaoType_Fac();
		if (this.ac.getText_Type_fac().getText().isEmpty() ||
				this.ac.getText_Periodicite().getText().isEmpty() ||
				this.ac.getText_Unite().getText().isEmpty()) {
			new FEN_Erreurs("Remplissez tous les champs", this.ac);
			return;
		}
		String typeF, periodicite, unite;
		typeF = this.ac.getText_Type_fac().getText();
		periodicite = this.ac.getText_Periodicite().getText();
		unite = this.ac.getText_Unite().getText();
		Type_Fac c = null;
		try {
			c = new Type_Fac(typeF, periodicite, unite);
		} catch (Exception e) {
			new FEN_Erreurs(e.getMessage(), ac);
			return;
		}
		try {
			dao.create(c);
			this.ac.dispose();
		} catch (SQLException e) {
			new FEN_Erreurs(e.getMessage(), ac);
			return;
		}

	}
}
