package Controlleur.Ajout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Date;

import javax.swing.JButton;

import Modele.Contrat;
import Modele.Paiements;
import Modele.DAO.DaoContrat;
import Modele.DAO.DaoPaiement;
import Other.ProjectUtils;
import Vue.FEN_Erreurs;
import Vue.Ajout.FEN_Ajout_Paiements;

public class GestionAjoutPaiements implements ActionListener {
	private FEN_Ajout_Paiements ac;

	// private JTableau;
	public GestionAjoutPaiements(FEN_Ajout_Paiements ac) {
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
				if (!this.ac.isPaiementSet()) {
					this.inserer();
				} else {
					this.modifier();
				}
				break;
		}
	}

	private void modifier() {
		DaoPaiement dao = new DaoPaiement();
		if (this.ac.getText_ID_Paiements().getText().isEmpty() ||
				this.ac.getText_Date().getText().isEmpty() ||
				this.ac.getText_Mode_Paiements().getText().isEmpty() ||
				this.ac.getText_Montant().getText().isEmpty() ||
				this.ac.getComboBox_ID_Contrat().getSelectedIndex() == -1) {
			new FEN_Erreurs("Remplissez tous les champs", this.ac);
			return;
		}
		String id_paiements = this.ac.getText_ID_Paiements().getText();
		float montant = Float.valueOf(this.ac.getText_Montant().getText());
		Date date = ProjectUtils.conversionDate(this.ac.getText_Date().getText());
		String moyen_paiement = this.ac.getText_Mode_Paiements().getText();
		DaoContrat p = new DaoContrat();
		Contrat contrat = null;
		try {
			contrat = p.findById(null, (String) this.ac.getComboBox_ID_Contrat().getSelectedItem());
		} catch (SQLException e1) {
			new FEN_Erreurs("Erreur de chargement du contrat pour le paiement " + id_paiements, ac);
		}
		Paiements c = null;
		try {
			c = new Paiements(id_paiements, montant, date, moyen_paiement, contrat);
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
		DaoPaiement dao = new DaoPaiement();
		if (this.ac.getText_ID_Paiements().getText().isEmpty() ||
				this.ac.getText_Date().getText().isEmpty() ||
				this.ac.getText_Mode_Paiements().getText().isEmpty() ||
				this.ac.getText_Montant().getText().isEmpty() ||
				this.ac.getComboBox_ID_Contrat().getSelectedIndex() == -1) {
			new FEN_Erreurs("Remplissez tous les champs", this.ac);
			return;
		}
		String id_paiements = this.ac.getText_ID_Paiements().getText();
		float montant = Float.valueOf(this.ac.getText_Montant().getText());
		Date date = ProjectUtils.conversionDate(this.ac.getText_Date().getText());
		String moyen_paiement = this.ac.getText_Mode_Paiements().getText();
		DaoContrat p = new DaoContrat();
		Contrat contrat = null;
		try {
			contrat = p.findById(null, (String) this.ac.getComboBox_ID_Contrat().getSelectedItem());
		} catch (SQLException e1) {
			new FEN_Erreurs("Erreur de chargement du contrat pour le paiement " + id_paiements, ac);
		}
		Paiements c = null;
		try {
			c = new Paiements(id_paiements, montant, date, moyen_paiement, contrat);
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