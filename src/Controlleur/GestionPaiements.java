package Controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Modele.Contrat;
import Modele.Paiements;
import Modele.DAO.DaoContrat;
import Modele.DAO.DaoPaiement;
import Vue.FEN_Accueil;
import Vue.FEN_Erreurs;
import Vue.FEN_Paiements;
import Vue.Ajout.FEN_Ajout_Paiements;

public class GestionPaiements implements ActionListener {
	private FEN_Paiements ai;

	public GestionPaiements(FEN_Paiements ai) {
		this.ai = ai;
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
				FEN_Ajout_Paiements new_fen = new FEN_Ajout_Paiements();
				this.ai.getLayeredPane().add(new_fen);
				new_fen.setVisible(true);
				break;
			case "Modifier":
				FEN_Ajout_Paiements new_fen_edition = new FEN_Ajout_Paiements(
						this.lireLigneTable(this.ai.getTable_Paiement().getSelectedRow()));
				this.ai.getLayeredPane().add(new_fen_edition);
				new_fen_edition.setVisible(true);
				break;
			case "Supprimer":
				this.delete();
				break;
		}
	}

	private void delete() {
		DaoPaiement dao = new DaoPaiement();
		int index = this.ai.getTable_Paiement().getSelectedRow();
		try {
			dao.delete(this.lireLigneTable(index));
			this.displayAll();
		} catch (SQLException e) {
			new FEN_Erreurs(e.getMessage(), this.ai.getContentPane());
			e.printStackTrace();
		}
	}

	public Paiements lireLigneTable(int index) {
		String id_paiement = (String) ai.getTable_Paiement().getValueAt(index, 0);
		Float montant = (Float) ai.getTable_Paiement().getValueAt(index, 1);
		Date date = (Date) ai.getTable_Paiement().getValueAt(index, 2);
		String moyen_paiement = (String) ai.getTable_Paiement().getValueAt(index, 3);
		DaoContrat dao = new DaoContrat();
		Contrat contrat = null;
		try {
			contrat = dao.findById(null, (String) ai.getTable_Paiement().getValueAt(index, 4));
		} catch (SQLException e) {
			new FEN_Erreurs("Impossible de charger le contrat lié au paiement " + id_paiement, ai);
		}

		return new Paiements(id_paiement, montant, date, moyen_paiement, contrat);

	}

	public void ecrireLigneTable(int index, Paiements value) {
		JTable lesCautions;

		lesCautions = ai.getTable_Paiement();

		lesCautions.setValueAt(value.getId_paiements(), index, 0);
		lesCautions.setValueAt(value.getMontant(), index, 1);
		lesCautions.setValueAt(value.getDate(), index, 2);
		lesCautions.setValueAt(value.getMoyen_paiement(), index, 3);
		lesCautions.setValueAt(value.getContrat().getId_contrat(), index, 4);
	}

	public void viderTable(JTable table) {
		for (int i = 0; i < table.getRowCount(); i++) {
			for (int j = 0; j < table.getColumnCount(); j++) {
				table.setValueAt(null, i, j);
			}
		}
	}

	private void displayAll() {
		this.viderTable(this.ai.getTable_Paiement());
		DaoPaiement daoCaution = new DaoPaiement();
		Collection<Paiements> lesCautions;
		try {
			lesCautions = daoCaution.findAll();
			ai.getTable_Paiement().setModel(new DefaultTableModel(
					new String[] { "Id", "Montant", "Date", "Moyen Paiement",
							"id_contrat" },
					lesCautions.size()));
			int i = 0;
			for (Paiements c : lesCautions) {
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