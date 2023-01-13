package Controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Modele.Caution;
import Modele.DAO.DaoCaution;
import Vue.FEN_Accueil;
import Vue.FEN_Caution;
import Vue.Ajout.FEN_Ajout_Caution;

public class GestionCaution
		implements ActionListener {
	private FEN_Caution ai;

	public GestionCaution(FEN_Caution ai) {
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
				FEN_Ajout_Caution new_fen = new FEN_Ajout_Caution();
				this.ai.getLayeredPane().add(new_fen);
				new_fen.setVisible(true);
				break;
			case "Modifier":
				FEN_Ajout_Caution new_fen_edition = new FEN_Ajout_Caution(
						this.lireLigneTable(this.ai.getTable_Caution().getSelectedRow()));
				this.ai.getLayeredPane().add(new_fen_edition);
				new_fen_edition.setVisible(true);
				break;
			case "Supprimer":
				this.delete();
				break;
		}
	}

	private void delete() {
		DaoCaution dao = new DaoCaution();
		int index = this.ai.getTable_Caution().getSelectedRow();
		try {
			dao.delete(this.lireLigneTable(index));
			this.displayAll();
		} catch (SQLException e) {
			new FEN_Erreurs(e.getMessage(), this.ai.getContentPane());
			e.printStackTrace();
		}
	}

	public Caution lireLigneTable(int index) {
		String id_Caution = (String) ai.getTable_Caution().getValueAt(index, 0);
		String prenom = (String) ai.getTable_Caution().getValueAt(index, 1);
		String nom = (String) ai.getTable_Caution().getValueAt(index, 2);
		String adresse = (String) ai.getTable_Caution().getValueAt(index, 3);
		String email = (String) ai.getTable_Caution().getValueAt(index, 4);
		String telephone = (String) ai.getTable_Caution().getValueAt(index, 5);
		String profession = (String) ai.getTable_Caution().getValueAt(index, 6);

		return new Caution(id_Caution, prenom, nom, adresse, email, telephone, profession);

	}

	public void ecrireLigneTable(int index, Caution value) {
		JTable lesCautions;

		lesCautions = ai.getTable_Caution();

		lesCautions.setValueAt(value.getId_Caution(), index, 0);
		lesCautions.setValueAt(value.getPrenom(), index, 1);
		lesCautions.setValueAt(value.getNom(), index, 2);
		lesCautions.setValueAt(value.getAdresse(), index, 3);
		lesCautions.setValueAt(value.getEmail(), index, 4);
		lesCautions.setValueAt(value.getTelephone(), index, 5);
		lesCautions.setValueAt(value.getProfession(), index, 6);
	}

	public void viderTable(JTable table) {
		for (int i = 0; i < table.getRowCount(); i++) {
			for (int j = 0; j < table.getColumnCount(); j++) {
				table.setValueAt(null, i, j);
			}
		}
	}

	private void displayAll() {
		this.viderTable(this.ai.getTable_Caution());
		DaoCaution daoCaution = new DaoCaution();
		Collection<Caution> lesCautions;
		try {
			lesCautions = daoCaution.findAll();
			ai.getTable_Caution().setModel(new DefaultTableModel(
					new String[] { "IdCaution", "Nom", "Prénom", "Adresse", "Email", "Téléphone", "profession" },
					lesCautions.size()));
			int i = 0;
			for (Caution c : lesCautions) {
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
