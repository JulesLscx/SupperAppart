package Controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Modele.Entrepreneur;
import Modele.DAO.DaoEntrepreuneur;
import Vue.FEN_Accueil;
import Vue.FEN_Entrepreneur;
import Vue.FEN_Erreurs;
import Vue.Ajout.FEN_Ajout_Entrepreneur;

public class GestionEntrepreneur implements ActionListener {
	private FEN_Entrepreneur ai;

	public GestionEntrepreneur(FEN_Entrepreneur ai) {
		this.ai = ai;
		this.enableButtons(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton item = (JButton) e.getSource();
		switch (item.getText()) {
			case "Annuler":
				((FEN_Accueil) this.ai.getTopLevelAncestor()).switchOuverte();
				this.ai.dispose();
				break;
			case "Charger":
				this.displayAll();
				break;
			case "Ajouter":
				FEN_Ajout_Entrepreneur new_fen = new FEN_Ajout_Entrepreneur();
				this.ai.getLayeredPane().add(new_fen);
				new_fen.setVisible(true);
				break;
			case "Modifier":
				FEN_Ajout_Entrepreneur new_fen_edition = new FEN_Ajout_Entrepreneur(
						this.lireLigneTable(this.ai.getTable_entrepreuneur().getSelectedRow()));
				this.ai.getLayeredPane().add(new_fen_edition);
				new_fen_edition.setVisible(true);
				break;
			case "Supprimer":
				this.delete();
				break;
		}
	}

	private void delete() {
		DaoEntrepreuneur dao = new DaoEntrepreuneur();
		int index = this.ai.getTable_entrepreuneur().getSelectedRow();
		try {
			dao.delete(this.lireLigneTable(index));
			this.displayAll();
		} catch (SQLException e) {
			new FEN_Erreurs(e.getMessage(), this.ai.getContentPane());
			e.printStackTrace();
		}
	}

	public Entrepreneur lireLigneTable(int index) {
		String nsiren = (String) ai.getTable_entrepreuneur().getValueAt(index, 0);
		String adresse = (String) ai.getTable_entrepreuneur().getValueAt(index, 1);
		String nom = (String) ai.getTable_entrepreuneur().getValueAt(index, 2);
		String iban = (String) ai.getTable_entrepreuneur().getValueAt(index, 3);
		String secteur_dactivite = (String) ai.getTable_entrepreuneur().getValueAt(index, 4);

		return new Entrepreneur(nsiren, adresse, nom, iban, secteur_dactivite);

	}

	public void ecrireLigneTable(int index, Entrepreneur value) {
		JTable lesCautions;

		lesCautions = ai.getTable_entrepreuneur();

		lesCautions.setValueAt(value.getnSiren(), index, 0);
		lesCautions.setValueAt(value.getAdresse(), index, 1);
		lesCautions.setValueAt(value.getNom(), index, 2);
		lesCautions.setValueAt(value.getIban(), index, 3);
		lesCautions.setValueAt(value.getSecteur_activite(), index, 4);
	}

	public void viderTable(JTable table) {
		for (int i = 0; i < table.getRowCount(); i++) {
			for (int j = 0; j < table.getColumnCount(); j++) {
				table.setValueAt(null, i, j);
			}
		}
	}

	private void displayAll() {
		this.viderTable(this.ai.getTable_entrepreuneur());
		DaoEntrepreuneur daoEntrepreuneur = new DaoEntrepreuneur();
		Collection<Entrepreneur> lesEntrepreuneurs;
		try {
			lesEntrepreuneurs = daoEntrepreuneur.findAll();
			ai.getTable_entrepreuneur().setModel(new DefaultTableModel(
					new String[] {
							"numeroSiren", "adresse", "nom", "iBan", "secteurActivite",
					},
					lesEntrepreuneurs.size()));
			int i = 0;
			for (Entrepreneur c : lesEntrepreuneurs) {
				if (c == null)
					break;
				this.ecrireLigneTable(i, c);
				i++;
			}
		} catch (SQLException e) {
			new FEN_Erreurs(e.getMessage(), ai);
			e.printStackTrace();
		}
	}

	public void enableButtons(boolean b) {
		for (JButton j : this.ai.getChangeableButtons()) {
			j.setEnabled(b);
		}
	}
}