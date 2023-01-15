package Controlleur.Ajout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;

import Modele.Immeuble;
import Modele.DAO.DaoImmeuble;
import Vue.FEN_Erreurs;
import Vue.Ajout.FEN_Ajout_Immeuble;

public class GestionAjoutImmeuble implements ActionListener {
	private FEN_Ajout_Immeuble ai;

	// private JTableau;
	public GestionAjoutImmeuble(FEN_Ajout_Immeuble ai) {
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
				if (!this.ai.isImmeubleSet()) {
					this.inserer();
				} else {
					this.modifier();
				}
				break;
		}
	}

	private void modifier() {
		DaoImmeuble dao = new DaoImmeuble();
		if (this.ai.getText_Access_Com().getText().isEmpty() ||
				this.ai.getText_CP().getText().isEmpty() ||
				this.ai.getText_Adresse().getText().isEmpty() ||
				this.ai.getText_Copro().getText().isEmpty() ||
				this.ai.getText_ID_Immeuble().getText().isEmpty() ||
				this.ai.getText_Pde_Constr().getText().isEmpty() ||
				this.ai.getText_Ville().getText().isEmpty() ||
				this.ai.getText_Num_batiment().getText().isEmpty()) {
			new FEN_Erreurs("Remplissez tous les champs", this.ai);
			return;
		}
		String id_immeuble, adresse, pde_constr, num_bat, cp, ville, access_com;
		int copro;
		id_immeuble = this.ai.getText_ID_Immeuble().getText();
		adresse = this.ai.getText_Adresse().getText();
		pde_constr = this.ai.getText_Pde_Constr().getText();
		num_bat = this.ai.getText_Num_batiment().getText();
		cp = this.ai.getText_CP().getText();
		ville = this.ai.getText_Ville().getText();
		access_com = this.ai.getText_Access_Com().getText();
		copro = Integer.valueOf(this.ai.getText_Copro().getText());
		Immeuble i = null;
		try {
			i = new Immeuble(id_immeuble, adresse, pde_constr, num_bat, cp, ville, access_com, copro);
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
		DaoImmeuble dao = new DaoImmeuble();
		if (this.ai.getText_Access_Com().getText().isEmpty() ||
				this.ai.getText_CP().getText().isEmpty() ||
				this.ai.getText_Adresse().getText().isEmpty() ||
				this.ai.getText_Copro().getText().isEmpty() ||
				this.ai.getText_ID_Immeuble().getText().isEmpty() ||
				this.ai.getText_Pde_Constr().getText().isEmpty() ||
				this.ai.getText_Ville().getText().isEmpty() ||
				this.ai.getText_Num_batiment().getText().isEmpty()) {
			new FEN_Erreurs("Remplissez tous les champs", this.ai);
			return;
		}
		String id_immeuble, adresse, pde_constr, num_bat, cp, ville, access_com;
		int copro;
		id_immeuble = this.ai.getText_ID_Immeuble().getText();
		adresse = this.ai.getText_Adresse().getText();
		pde_constr = this.ai.getText_Pde_Constr().getText();
		num_bat = this.ai.getText_Num_batiment().getText();
		cp = this.ai.getText_CP().getText();
		ville = this.ai.getText_Ville().getText();
		access_com = this.ai.getText_Access_Com().getText();
		copro = Integer.valueOf(this.ai.getText_Copro().getText());
		Immeuble i = null;
		try {
			i = new Immeuble(id_immeuble, adresse, pde_constr, num_bat, cp, ville, access_com, copro);
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
