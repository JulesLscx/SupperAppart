package Controlleur.Ajout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;

import javax.swing.JButton;

import Modele.Factures_Charges;
import Modele.Immeuble;
import Modele.Type_Fac;
import Modele.DAO.DaoFacture;
import Modele.DAO.DaoImmeuble;
import Modele.DAO.DaoType_Fac;
import Other.ProjectUtils;
import Vue.FEN_Erreurs;
import Vue.Ajout.FEN_Ajout_Facture;

public class GestionAjoutFacture implements ActionListener {
	private FEN_Ajout_Facture ac;

	// private JTableau;
	public GestionAjoutFacture(FEN_Ajout_Facture af) {
		this.ac = af;
		this.fillComboImmeuble();
		this.fillComboTypeF();
	}

	private void fillComboTypeF() {
		try {
			for (Type_Fac i : new DaoType_Fac().findAll()) {
				this.ac.getComboBox_Type_Facture().addItem(i.getTypeF());
			}
		} catch (SQLException e) {
			new FEN_Erreurs("Impossible de remplir le combo", ac);
			e.printStackTrace();
		}
	}

	private void fillComboImmeuble() {
		try {
			for (Immeuble i : new DaoImmeuble().findAll()) {
				this.ac.getComboBox_ID_Immeuble().addItem(i.getId_immeuble());
			}
		} catch (SQLException e) {
			new FEN_Erreurs("Impossible de remplir le combo", ac);
			e.printStackTrace();
		}
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
		DaoFacture dao = new DaoFacture();
		if (this.ac.getText_Num_Facture().getText().isEmpty() ||
				this.ac.getText_Date_Facture().getText().isEmpty() ||
				this.ac.getText_Total().getText().isEmpty() ||
				this.ac.getComboBox_ID_Immeuble().getSelectedIndex() == -1 ||
				this.ac.getComboBox_Type_Facture().getSelectedIndex() == -1) {
			new FEN_Erreurs("Remplissez tous les champs", this.ac);
			return;
		}
		String numF = ac.getText_Num_Facture().getText();
		Date dateF = ProjectUtils.conversionDate(ac.getText_Date_Facture().getText());
		Float total = Float.parseFloat(ac.getText_Total().getText());
		Float cf = 0F;
		if (!ac.getText_Cout_Fixe().getText().isEmpty())
			cf = Float.parseFloat(ac.getText_Cout_Fixe().getText());
		Float prix_unite_relev = 0F;
		if (!ac.getText_Prix_U_R().getText().isEmpty())
			prix_unite_relev = Float.parseFloat(ac.getText_Prix_U_R().getText());
		Float prix_unite_const = 0F;
		if (!ac.getText_Prix_U_C().getText().isEmpty())
			prix_unite_const = Float.parseFloat(ac.getText_Prix_U_C().getText());
		Type_Fac typeF = null;
		Immeuble immeuble = null;
		try {
			typeF = new DaoType_Fac().findById(null, (String) ac.getComboBox_Type_Facture().getSelectedItem());
			immeuble = new DaoImmeuble().findById(null, (String) ac.getComboBox_ID_Immeuble().getSelectedItem());
		} catch (SQLException e1) {
			new FEN_Erreurs("Erreur provenant de l'immeuble ou du type", ac);
			e1.printStackTrace();
		}
		Factures_Charges c = null;
		try {
			c = new Factures_Charges(numF, dateF, total, cf, prix_unite_relev, prix_unite_const, typeF, immeuble);
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
		DaoFacture dao = new DaoFacture();
		if (this.ac.getText_Num_Facture().getText().isEmpty() ||
				this.ac.getText_Date_Facture().getText().isEmpty() ||
				this.ac.getText_Total().getText().isEmpty() ||
				this.ac.getComboBox_ID_Immeuble().getSelectedIndex() == -1 ||
				this.ac.getComboBox_Type_Facture().getSelectedIndex() == -1) {
			new FEN_Erreurs("Remplissez tous les champs", this.ac);
			return;
		}
		String numF = ac.getText_Num_Facture().getText();
		Date dateF = ProjectUtils.conversionDate(ac.getText_Date_Facture().getText());
		Float total = Float.parseFloat(ac.getText_Total().getText());
		Float cf = 0F;
		if (!ac.getText_Cout_Fixe().getText().isEmpty())
			cf = Float.parseFloat(ac.getText_Cout_Fixe().getText());
		Float prix_unite_relev = 0F;
		if (!ac.getText_Prix_U_R().getText().isEmpty())
			prix_unite_relev = Float.parseFloat(ac.getText_Prix_U_R().getText());
		Float prix_unite_const = 0F;
		if (!ac.getText_Prix_U_C().getText().isEmpty())
			prix_unite_const = Float.parseFloat(ac.getText_Prix_U_C().getText());
		Type_Fac typeF = null;
		Immeuble immeuble = null;
		try {
			typeF = new DaoType_Fac().findById(null, (String) ac.getComboBox_Type_Facture().getSelectedItem());
			immeuble = new DaoImmeuble().findById(null, (String) ac.getComboBox_ID_Immeuble().getSelectedItem());
		} catch (SQLException e1) {
			new FEN_Erreurs("Erreur provenant de l'immeuble ou du type", ac);
			e1.printStackTrace();
		}
		Factures_Charges c = null;
		try {
			c = new Factures_Charges(numF, dateF, total, cf, prix_unite_relev, prix_unite_const, typeF, immeuble);
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
