package Controlleur.Ajout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;

import Modele.Immeuble;
import Modele.Logement;
import Modele.DAO.DaoImmeuble;
import Modele.DAO.DaoLogement;
import Vue.FEN_Erreurs;
import Vue.Ajout.FEN_Ajout_Logement;

public class GestionAjoutLogement implements ActionListener {
	private FEN_Ajout_Logement ac;

	// private JTableau;
	public GestionAjoutLogement(FEN_Ajout_Logement ai) {
		this.ac = ai;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton item = (JButton) e.getSource();
		switch (item.getText()) {
			case "Annuler":
				this.ac.dispose();
				break;
			case "Valider":
				if (!this.ac.isLogementSet()) {
					this.inserer();
				} else {
					this.modifier();
				}
				break;
		}
	}

	private void modifier() {
		DaoLogement dao = new DaoLogement();
		if (this.ac.getText_Num_Logement().getText().isEmpty() ||
				this.ac.getText_Type_Habitation().getText().isEmpty() ||
				this.ac.getText_Surface().getText().isEmpty() ||
				this.ac.getText_NB_Pieces().getText().isEmpty() ||
				this.ac.getComboBox_ID_Immeuble().getSelectedItem() == null) {
			new FEN_Erreurs("Remplissez tous les champs", this.ac);
			return;
		}
		String num, type_hab;
		float surface;
		int nbpiece;
		Immeuble i;
		DaoImmeuble daoImmeuble = new DaoImmeuble();
		num = this.ac.getText_Num_Logement().getText();
		type_hab = this.ac.getText_Type_Habitation().getText();
		surface = Float.valueOf(this.ac.getText_Surface().getText());
		nbpiece = Integer.valueOf(this.ac.getText_NB_Pieces().getText());
		try {
			i = daoImmeuble.findById(null, (String) this.ac.getComboBox_ID_Immeuble().getSelectedItem());
		} catch (SQLException e1) {
			new FEN_Erreurs(e1.getMessage(), ac);
			return;
		}
		Logement l = null;
		try {
			l = new Logement(num, type_hab, surface, nbpiece, i);
		} catch (Exception e) {
			new FEN_Erreurs(e.getMessage(), ac);
			return;
		}
		try {
			dao.update(l);
			this.ac.dispose();
		} catch (SQLException e) {
			new FEN_Erreurs(e.getMessage(), ac);
			return;
		}
	}

	private void inserer() {
		DaoLogement dao = new DaoLogement();
		if (this.ac.getText_Num_Logement().getText().isEmpty() ||
				this.ac.getText_Type_Habitation().getText().isEmpty() ||
				this.ac.getText_Surface().getText().isEmpty() ||
				this.ac.getText_NB_Pieces().getText().isEmpty() ||
				this.ac.getComboBox_ID_Immeuble().getSelectedItem() == null) {
			new FEN_Erreurs("Remplissez tous les champs", this.ac);
			return;
		}
		String num, type_hab;
		float surface;
		int nbpiece;
		Immeuble i;
		DaoImmeuble daoImmeuble = new DaoImmeuble();
		num = this.ac.getText_Num_Logement().getText();
		type_hab = this.ac.getText_Type_Habitation().getText();
		surface = Float.valueOf(this.ac.getText_Surface().getText());
		nbpiece = Integer.valueOf(this.ac.getText_NB_Pieces().getText());
		try {
			i = daoImmeuble.findById(null, (String) this.ac.getComboBox_ID_Immeuble().getSelectedItem());
		} catch (SQLException e1) {
			new FEN_Erreurs(e1.getMessage(), ac);
			return;
		}
		Logement l = null;
		try {
			l = new Logement(num, type_hab, surface, nbpiece, i);
		} catch (Exception e) {
			new FEN_Erreurs(e.getMessage(), ac);
			return;
		}
		try {
			dao.create(l);
			this.ac.dispose();
		} catch (SQLException e) {
			new FEN_Erreurs(e.getMessage(), ac);
			return;
		}

	}

	public void fillCombo() {
		DaoImmeuble dao = new DaoImmeuble();
		try {
			for (Immeuble i : dao.findAll()) {
				this.ac.getComboBox_ID_Immeuble().addItem(i.getId_immeuble());
			}
		} catch (SQLException e) {
			new FEN_Erreurs(e.getMessage(), ac);
		}
	}
}
