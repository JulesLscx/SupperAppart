package Controlleur.Ajout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JTextField;

import Modele.Caution;
import Modele.Contrat;
import Modele.Entrepreneur;
import Modele.Logement;
import Modele.DAO.DaoCaution;
import Modele.DAO.DaoContrat;
import Modele.DAO.DaoEntrepreuneur;
import Modele.DAO.DaoLogement;
import Other.ProjectUtils;
import Vue.FEN_Erreurs;
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
		float paiement = Float.valueOf(this.ac.getText_Paiement().getText());
		Date date_edl = ProjectUtils.conversionDate(this.ac.getText_Date_EDL().getText());
		float montant_caution = Float.valueOf(this.ac.getText_Montant_Caution().getText());
		Date fin_contrat = ProjectUtils.conversionDate(this.ac.getText_Fin_Contrat().getText());
		DaoLogement daoL = new DaoLogement();
		Logement num;
		try {
			num = daoL.findById(null, (String) this.ac.getComboBox_Num_Logement().getSelectedItem());
		} catch (SQLException e1) {
			new FEN_Erreurs(e1.getMessage(), ac);
			e1.printStackTrace();
			return;
		}
		Entrepreneur n_siren;
		if (this.ac.getComboBox_Num_Siren().getSelectedItem() == null) {
			n_siren = null;
		} else {
			DaoEntrepreuneur daoE = new DaoEntrepreuneur();
			try {
				n_siren = daoE.findById(null, (String) this.ac.getComboBox_Num_Siren().getSelectedItem());
			} catch (SQLException e) {
				new FEN_Erreurs(e.getMessage(), ac);
				n_siren = null;
				e.printStackTrace();
			}
		}
		Caution id_caution;
		if (this.ac.getComboBox_ID_Caution().getSelectedItem() == null) {
			id_caution = null;
		} else {
			DaoCaution daoC = new DaoCaution();
			try {
				id_caution = daoC.findById(null, (String) this.ac.getComboBox_ID_Caution().getSelectedItem());
			} catch (SQLException e) {
				new FEN_Erreurs(e.getMessage(), ac);
				id_caution = null;
				e.printStackTrace();
			}
		}
		Contrat c = null;
		try {
			c = new Contrat(id_contrat, prise_effet, duree, charges, loyer, date_revision, periodicite, date_paiement,
					paiement, date_edl, montant_caution, fin_contrat, num, n_siren, id_caution);
		} catch (Exception e) {
			new FEN_Erreurs(e.getMessage(), ac);
			e.printStackTrace();
			return;
		}
		try {
			dao.update(c);
			this.ac.dispose();
		} catch (SQLException e) {
			new FEN_Erreurs(e.getMessage(), ac);
			e.printStackTrace();
			return;
		}
	}

	private void inserer() {
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
		float paiement = Float.valueOf(this.ac.getText_Paiement().getText());
		Date date_edl = ProjectUtils.conversionDate(this.ac.getText_Date_EDL().getText());
		float montant_caution = Float.valueOf(this.ac.getText_Montant_Caution().getText());
		Date fin_contrat = ProjectUtils.conversionDate(this.ac.getText_Fin_Contrat().getText());
		DaoLogement daoL = new DaoLogement();
		Logement num;
		try {
			num = daoL.findById(null, (String) this.ac.getComboBox_Num_Logement().getSelectedItem());
		} catch (SQLException e1) {
			new FEN_Erreurs(e1.getMessage(), ac);
			e1.printStackTrace();
			return;
		}
		Entrepreneur n_siren;
		if (this.ac.getComboBox_Num_Siren().getSelectedItem() == null) {
			n_siren = null;
		} else {
			DaoEntrepreuneur daoE = new DaoEntrepreuneur();
			try {
				n_siren = daoE.findById(null, (String) this.ac.getComboBox_Num_Siren().getSelectedItem());
			} catch (SQLException e) {
				new FEN_Erreurs(e.getMessage(), ac);
				e.printStackTrace();
				n_siren = null;
			}
		}
		Caution id_caution;
		if (this.ac.getComboBox_ID_Caution().getSelectedItem() == null) {
			id_caution = null;
		} else {
			DaoCaution daoC = new DaoCaution();
			try {
				id_caution = daoC.findById(null, (String) this.ac.getComboBox_ID_Caution().getSelectedItem());
			} catch (SQLException e) {
				new FEN_Erreurs(e.getMessage(), ac);
				e.printStackTrace();
				id_caution = null;
			}
		}
		Contrat c = null;
		try {
			c = new Contrat(id_contrat, prise_effet, duree, charges, loyer, date_revision, periodicite, date_paiement,
					paiement, date_edl, montant_caution, fin_contrat, num, n_siren, id_caution);
		} catch (Exception e) {
			new FEN_Erreurs(e.getMessage(), ac);
			return;
		}
		try {
			dao.create(c);
			this.ac.dispose();
		} catch (SQLException e) {
			new FEN_Erreurs(e.getMessage(), ac);
			e.printStackTrace();
			return;
		}

	}

	public void ecrireDate(JTextField field, Date laDate) {
		String tmp = laDate.toString();
		String[] letemps = tmp.split("-", 3);
		String result = letemps[2] + "/" + letemps[1] + "/" + letemps[0];
		field.setText(result);
	}
}
