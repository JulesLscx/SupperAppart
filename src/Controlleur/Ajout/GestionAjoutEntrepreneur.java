package Controlleur.Ajout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;

import Modele.Entrepreneur;
import Modele.DAO.DaoEntrepreuneur;
import Vue.FEN_Erreurs;
import Vue.Ajout.FEN_Ajout_Entrepreneur;

public class GestionAjoutEntrepreneur implements ActionListener {
	private FEN_Ajout_Entrepreneur ac;

	// private JTableau;
	public GestionAjoutEntrepreneur(FEN_Ajout_Entrepreneur ac) {
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
				if (!this.ac.isEntrepreuneurSet()) {
					this.inserer();
				} else {
					this.modifier();
				}
				break;
		}
	}

	private void modifier() {
		DaoEntrepreuneur dao = new DaoEntrepreuneur();
		if (this.ac.getText_N_SIREN().getText().isEmpty() ||
				this.ac.getText_Adresse().getText().isEmpty() ||
				this.ac.getText_Nom().getText().isEmpty() ||
				this.ac.getText_IBAN().getText().isEmpty() ||
				this.ac.getText_Secteur_Activite().getText().isEmpty()) {
			new FEN_Erreurs("Remplissez tous les champs", this.ac);
			return;
		}
		String nSiren, adresse, nom, iban, secteur_activite;
		nSiren = this.ac.getText_N_SIREN().getText();
		adresse = this.ac.getText_Adresse().getText();
		nom = this.ac.getText_Nom().getText();
		iban = this.ac.getText_IBAN().getText();
		secteur_activite = this.ac.getText_Secteur_Activite().getText();
		Entrepreneur c = null;
		try {
			c = new Entrepreneur(nSiren, adresse, nom, iban, secteur_activite);
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
		DaoEntrepreuneur dao = new DaoEntrepreuneur();
		if (this.ac.getText_N_SIREN().getText().isEmpty() ||
				this.ac.getText_Adresse().getText().isEmpty() ||
				this.ac.getText_Nom().getText().isEmpty() ||
				this.ac.getText_IBAN().getText().isEmpty() ||
				this.ac.getText_Secteur_Activite().getText().isEmpty()) {
			new FEN_Erreurs("Remplissez tous les champs", this.ac);
			return;
		}
		String nSiren, adresse, nom, iban, secteur_activite;
		nSiren = this.ac.getText_N_SIREN().getText();
		adresse = this.ac.getText_Adresse().getText();
		nom = this.ac.getText_Nom().getText();
		iban = this.ac.getText_IBAN().getText();
		secteur_activite = this.ac.getText_Secteur_Activite().getText();
		Entrepreneur c = null;
		try {
			c = new Entrepreneur(nSiren, adresse, nom, iban, secteur_activite);
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
