package Controlleur.Ajout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;

import javax.swing.JButton;

import Modele.Entrepreneur;
import Modele.Facture_Travaux_Immeuble;
import Modele.Immeuble;
import Modele.DAO.DaoEntrepreuneur;
import Modele.DAO.DaoFacture_Travaux_Immeuble;
import Modele.DAO.DaoImmeuble;
import Other.ProjectUtils;
import Vue.FEN_Erreurs;
import Vue.Ajout.FEN_Ajout_FactureTravauxImmeuble;

public class GestionAjoutFactureTravauxImmeuble implements ActionListener {
	private FEN_Ajout_FactureTravauxImmeuble ac;

	// private JTableau;
	public GestionAjoutFactureTravauxImmeuble(FEN_Ajout_FactureTravauxImmeuble ac) {
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
				if (!this.ac.isFacSet()) {
					this.inserer();
				} else {
					this.modifier();
				}
				break;
		}
	}

	private void modifier() {
		DaoFacture_Travaux_Immeuble dao = new DaoFacture_Travaux_Immeuble();
		if (this.ac.getText_Num_Fac().getText().isEmpty() ||
				this.ac.getText_Date_Paiement().getText().isEmpty() ||
				this.ac.getText_Montant_Indeductible().getText().isEmpty() ||
				this.ac.getText_Ordre_Cheque().getText().isEmpty() ||
				this.ac.getText_Prix().getText().isEmpty() ||
				this.ac.getText_Num_Cheque().getText().isEmpty() ||
				this.ac.getText_Nature().getText().isEmpty() ||
				this.ac.getText_Reduction().getText().isEmpty() ||
				this.ac.getComboBox_Entrepreneur().getSelectedIndex() == -1 ||
				this.ac.getComboBox_ID_Immeuble().getSelectedIndex() == -1) {
			new FEN_Erreurs("Remplissez tous les champs", this.ac);
			return;
		}
		String num_fac, nature, ordre_du_cheque, numero_du_cheque;
		Date date_de_paiement;
		float prix, montant_indeductible, reduction;
		Entrepreneur entrepreneur = null;
		Immeuble immeuble = null;
		num_fac = this.ac.getText_Num_Fac().getText();
		nature = this.ac.getText_Nature().getText();
		ordre_du_cheque = this.ac.getText_Ordre_Cheque().getText();
		numero_du_cheque = this.ac.getText_Num_Cheque().getText();
		date_de_paiement = ProjectUtils.conversionDate(this.ac.getText_Date_Paiement().getText());
		prix = Float.valueOf(this.ac.getText_Prix().getText());
		montant_indeductible = Float.valueOf(this.ac.getText_Montant_Indeductible().getText());
		reduction = Float.valueOf(this.ac.getText_Reduction().getText());
		DaoEntrepreuneur daoE = new DaoEntrepreuneur();
		Facture_Travaux_Immeuble c;
		try {
			entrepreneur = daoE.findById(null, (String) this.ac.getComboBox_Entrepreneur().getSelectedItem());
			DaoImmeuble daoI = new DaoImmeuble();
			immeuble = daoI.findById(null, (String) this.ac.getComboBox_ID_Immeuble().getSelectedItem());
			c = null;
		} catch (SQLException e1) {
			new FEN_Erreurs(e1.getMessage(), ac);
			e1.printStackTrace();
		}
		try {
			c = new Facture_Travaux_Immeuble(num_fac, nature, prix, montant_indeductible, reduction, ordre_du_cheque,
					numero_du_cheque, date_de_paiement, immeuble, entrepreneur);
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
		DaoFacture_Travaux_Immeuble dao = new DaoFacture_Travaux_Immeuble();
		if (this.ac.getText_Num_Fac().getText().isEmpty() ||
				this.ac.getText_Date_Paiement().getText().isEmpty() ||
				this.ac.getText_Montant_Indeductible().getText().isEmpty() ||
				this.ac.getText_Ordre_Cheque().getText().isEmpty() ||
				this.ac.getText_Prix().getText().isEmpty() ||
				this.ac.getText_Num_Cheque().getText().isEmpty() ||
				this.ac.getText_Nature().getText().isEmpty() ||
				this.ac.getText_Reduction().getText().isEmpty() ||
				this.ac.getComboBox_Entrepreneur().getSelectedIndex() == -1 ||
				this.ac.getComboBox_ID_Immeuble().getSelectedIndex() == -1) {
			new FEN_Erreurs("Remplissez tous les champs", this.ac);
			return;
		}
		String num_fac, nature, ordre_du_cheque, numero_du_cheque;
		Date date_de_paiement;
		float prix, montant_indeductible, reduction;
		Entrepreneur entrepreneur = null;
		Immeuble immeuble = null;
		num_fac = this.ac.getText_Num_Fac().getText();
		nature = this.ac.getText_Nature().getText();
		ordre_du_cheque = this.ac.getText_Ordre_Cheque().getText();
		numero_du_cheque = this.ac.getText_Num_Cheque().getText();
		date_de_paiement = ProjectUtils.conversionDate(this.ac.getText_Date_Paiement().getText());
		prix = Float.valueOf(this.ac.getText_Prix().getText());
		montant_indeductible = Float.valueOf(this.ac.getText_Montant_Indeductible().getText());
		reduction = Float.valueOf(this.ac.getText_Reduction().getText());
		DaoEntrepreuneur daoE = new DaoEntrepreuneur();
		Facture_Travaux_Immeuble c;
		try {
			entrepreneur = daoE.findById(null, (String) this.ac.getComboBox_Entrepreneur().getSelectedItem());
			DaoImmeuble daoI = new DaoImmeuble();
			immeuble = daoI.findById(null, (String) this.ac.getComboBox_ID_Immeuble().getSelectedItem());
			c = null;
		} catch (SQLException e1) {
			new FEN_Erreurs(e1.getMessage(), ac);
			e1.printStackTrace();
		}
		try {
			c = new Facture_Travaux_Immeuble(num_fac, nature, prix, montant_indeductible, reduction, ordre_du_cheque,
					numero_du_cheque, date_de_paiement, immeuble, entrepreneur);
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
