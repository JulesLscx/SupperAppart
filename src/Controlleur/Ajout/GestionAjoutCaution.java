package Controlleur.Ajout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;

import Modele.Caution;
import Modele.DAO.DaoCaution;
import Vue.FEN_Erreurs;
import Vue.Ajout.FEN_Ajout_Caution;

public class GestionAjoutCaution implements ActionListener {
	private FEN_Ajout_Caution ac;

	// private JTableau;
	public GestionAjoutCaution(FEN_Ajout_Caution ac) {
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
				if (!this.ac.isCautionSet()) {
					this.inserer();
				} else {
					this.modifier();
				}
				break;
		}
	}

	private void modifier() {
		DaoCaution dao = new DaoCaution();
		if (this.ac.getText_ID_Caution().getText().isEmpty() ||
				this.ac.getText_Nom().getText().isEmpty() ||
				this.ac.getText_Prenom().getText().isEmpty() ||
				this.ac.getText_Adresse().getText().isEmpty() ||
				this.ac.getText_Telephone().getText().isEmpty() ||
				this.ac.getText_Email().getText().isEmpty() ||
				this.ac.getText_Profession().getText().isEmpty()) {
			new FEN_Erreurs("Remplissez tous les champs", this.ac);
			return;
		}
		String id_Caution, prenom, nom, adresse, email, telephone, profession;
		id_Caution = this.ac.getText_ID_Caution().getText();
		prenom = this.ac.getText_Prenom().getText();
		nom = this.ac.getText_Nom().getText();
		adresse = this.ac.getText_Adresse().getText();
		email = this.ac.getText_Email().getText();
		telephone = this.ac.getText_Telephone().getText();
		profession = this.ac.getText_Profession().getText();
		Caution c = null;
		try {
			c = new Caution(id_Caution, prenom, nom, adresse, email, telephone, profession);
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
		DaoCaution dao = new DaoCaution();
		if (this.ac.getText_ID_Caution().getText().isEmpty() ||
				this.ac.getText_Nom().getText().isEmpty() ||
				this.ac.getText_Prenom().getText().isEmpty() ||
				this.ac.getText_Adresse().getText().isEmpty() ||
				this.ac.getText_Telephone().getText().isEmpty() ||
				this.ac.getText_Email().getText().isEmpty() ||
				this.ac.getText_Profession().getText().isEmpty()) {
			new FEN_Erreurs("Remplissez tous les champs", this.ac);
			return;
		}
		String id_Caution, prenom, nom, adresse, email, telephone, profession;
		id_Caution = this.ac.getText_ID_Caution().getText();
		prenom = this.ac.getText_Prenom().getText();
		nom = this.ac.getText_Nom().getText();
		adresse = this.ac.getText_Adresse().getText();
		email = this.ac.getText_Email().getText();
		telephone = this.ac.getText_Telephone().getText();
		profession = this.ac.getText_Profession().getText();
		Caution c = null;
		try {
			c = new Caution(id_Caution, prenom, nom, adresse, email, telephone, profession);
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
