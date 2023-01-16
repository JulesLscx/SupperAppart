package Controlleur.Ajout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;

import javax.print.attribute.standard.MediaSize.Other;
import javax.swing.JButton;

import Modele.Caution;
import Modele.Contrat;
import Modele.Entrepreneur;
import Modele.Logement;
import Modele.DAO.DaoContrat;
import Modele.DAO.DaoEntrepreuneur;
import Modele.DAO.DaoLogement;
import Vue.FEN_Erreurs;
import Vue.Ajout.FEN_Ajout_Contrat;
import Other.ProjectUtils;

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
			case "Valider":
				if (!this.ac.isContratSet()) {
					this.inserer();
				} else {
					this.modifier();
				}
				break;
		}
	}

	private void modifier() {
		DaoContrat dao = new DaoContrat();
		if (this.ac.getText_Charges().getText().isEmpty() ||
				this.ac.getText_Loyer().getText().isEmpty() ||
				this.ac.getText_Duree().getText().isEmpty() ||
				this.ac.getText_ID_Contrat().getText().isEmpty() ||
				this.ac.getComboBox_Num_Logement().getSelectedIndex() == -1 ||
				this.ac.getText_Prise_effet().getText().isEmpty()) {
			new FEN_Erreurs("Remplissez les champs obligatoires", this.ac);
			return;
		}

		String id_contrat = this.ac.getText_ID_Contrat().getText();
		Date prise_effet = ProjectUtils.conversionDate(this.ac.getText_Prise_effet().getText());
		int duree = Integer.valueOf(this.ac.getText_Duree().getText());
		float charges = Float.valueOf(this.ac.getText_Charges().getText());
		float loyer = Float.valueOf(this.ac.getText_Loyer().getText());
		Date date_revision = ProjectUtils.conversionDate(this.ac.getText_Date_Revision().getText());
		String periodicite = this.ac.getText_Periodicite().getText();
		Date date_paiement = ProjectUtils.conversionDate(this.ac.getText_Date_Paiement().getText());
		String paiement = this.ac.getText_Paiement().getText();
		Date date_edl = ProjectUtils.conversionDate(this.ac.getText_Date_EDL().getText());
		float montant_caution = Float.valueOf(this.ac.getText_Montant_Caution().getText());
		Date fin_contrat = ProjectUtils.conversionDate(this.ac.getText_Fin_Contrat().getText());
		DaoLogement daoL = new DaoLogement();
		Logement num = daoL.findById(null, (String) this.ac.getComboBox_Num_Logement().getSelectedItem());
		if (this.ac.getComboBox_Num_Siren().getSelectedObjects() == null) {
			Entrepreneur n_siren = null;
		} else {
			DaoEntrepreuneur daoE = new DaoEntrepreuneur();
			Entrepreneur n_siren = daoE.findById(null, (String) this.ac.getComboBox_Num_Siren().getSelectedItem());
		}
		Caution id_caution;
		Contrat c = null;
		try {
			c = new Contrat(id_Caution, prenom, nom, adresse, email, telephone, profession);
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
		DaoContrat dao = new DaoContrat();
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
		Contrat c = null;
		try {
			c = new Contrat(id_Caution, prenom, nom, adresse, email, telephone, profession);
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
