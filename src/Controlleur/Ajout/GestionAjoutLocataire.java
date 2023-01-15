package Controlleur.Ajout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;

import Modele.Locataire;
import Modele.DAO.DaoLocataire;
import Vue.FEN_Erreurs;
import Vue.Ajout.FEN_Ajout_Locataire;

public class GestionAjoutLocataire implements ActionListener {
	private FEN_Ajout_Locataire ai;

	// private JTableau;
	public GestionAjoutLocataire(FEN_Ajout_Locataire ai) {
		this.ai = ai;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton item = (JButton) e.getSource();
		switch (item.getText()) {
			case "Annuler":
				this.ai.dispose();
				break;
			case "Valider":
				if (!this.ai.isLocataireSet()) {
					this.inserer();
				} else {
					this.modifier();
				}
				break;
		}
	}

	private void modifier() {
		DaoLocataire dao = new DaoLocataire();
		if (this.ai.getText_Nom().getText().isEmpty() ||
				this.ai.getText_Prenom().getText().isEmpty() ||
				this.ai.getText_Genre().getSelectedIndex() == -1 ||
				this.ai.getText_Email().getText().isEmpty() ||
				this.ai.getText_Telephone().getText().isEmpty()) {
			new FEN_Erreurs("Remplissez tous les champs", this.ai);
			return;
		}
		String nLocataire, nom, prenom, email, tel;
		char genre;
		nom = this.ai.getText_Nom().getText();
		prenom = this.ai.getText_Prenom().getText();
		email = this.ai.getText_Email().getText();
		genre = (char) this.ai.getText_Genre().getSelectedItem();
		tel = this.ai.getText_Telephone().getText();
		nLocataire = this.ai.getText_Num_Locataire().getText();

		Locataire i = null;
		try {
			i = new Locataire(nLocataire, nom, prenom, email, tel, genre);
		} catch (Exception e) {
			new FEN_Erreurs(e.getMessage(), ai);
			return;
		}
		try {
			dao.update(i);
			this.ai.dispose();
		} catch (SQLException e) {
			new FEN_Erreurs(e.getMessage(), ai);
			return;
		}
	}

	private void inserer() {
		DaoLocataire dao = new DaoLocataire();
		if (this.ai.getText_Nom().getText().isEmpty() ||
				this.ai.getText_Num_Locataire().getText().isEmpty() ||
				this.ai.getText_Prenom().getText().isEmpty() ||
				this.ai.getText_Genre().getSelectedIndex() == -1 ||
				this.ai.getText_Email().getText().isEmpty() ||
				this.ai.getText_Telephone().getText().isEmpty()) {
			new FEN_Erreurs("Remplissez tous les champs", this.ai);
			return;
		}
		String nLocataire, nom, prenom, email, tel;
		char genre;
		nom = this.ai.getText_Nom().getText();
		prenom = this.ai.getText_Prenom().getText();
		email = this.ai.getText_Email().getText();
		genre = (char) this.ai.getText_Genre().getSelectedItem();
		tel = this.ai.getText_Telephone().getText();
		nLocataire = this.ai.getText_Num_Locataire().getText();

		Locataire i = null;
		try {
			i = new Locataire(nLocataire, nom, prenom, email, tel, genre);
		} catch (Exception e) {
			new FEN_Erreurs(e.getMessage(), ai);
			return;
		}
		try {
			dao.create(i);
			this.ai.dispose();
		} catch (SQLException e) {
			new FEN_Erreurs(e.getMessage(), ai);
			return;
		}

	}
}
