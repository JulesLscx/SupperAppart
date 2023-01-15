package Controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Modele.Type_Fac;
import Modele.DAO.DaoType_Fac;
import Vue.FEN_Accueil;
import Vue.FEN_Erreurs;
import Vue.FEN_TypeFacture;
import Vue.Ajout.FEN_Ajout_TypeFacture;

public class GestionTypeFacture implements ActionListener {
	private FEN_TypeFacture ai;

	public GestionTypeFacture(FEN_TypeFacture ai) {
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
				FEN_Ajout_TypeFacture new_fen = new FEN_Ajout_TypeFacture();
				this.ai.getLayeredPane().add(new_fen);
				new_fen.setVisible(true);
				break;
			case "Modifier":
				FEN_Ajout_TypeFacture new_fen_edition = new FEN_Ajout_TypeFacture(
						this.lireLigneTable(this.ai.getTable_TypeFacture().getSelectedRow()));
				this.ai.getLayeredPane().add(new_fen_edition);
				new_fen_edition.setVisible(true);
				break;
			case "Supprimer":
				this.delete();
				break;
		}
	}

	private void delete() {
		DaoType_Fac dao = new DaoType_Fac();
		int index = this.ai.getTable_TypeFacture().getSelectedRow();
		try {
			dao.delete(this.lireLigneTable(index));
			this.displayAll();
		} catch (SQLException e) {
			new FEN_Erreurs(e.getMessage(), this.ai.getContentPane());
			e.printStackTrace();
		}
	}

	public Type_Fac lireLigneTable(int index) {
		String typeF = (String) ai.getTable_TypeFacture().getValueAt(index, 0);
		String periodicite = (String) ai.getTable_TypeFacture().getValueAt(index, 1);
		String unite = (String) ai.getTable_TypeFacture().getValueAt(index, 2);

		return new Type_Fac(typeF, periodicite, unite);

	}

	public void ecrireLigneTable(int index, Type_Fac value) {
		JTable lesCautions;

		lesCautions = ai.getTable_TypeFacture();

		lesCautions.setValueAt(value.getTypeF(), index, 0);
		lesCautions.setValueAt(value.getPeriodicite(), index, 1);
		lesCautions.setValueAt(value.getUnite(), index, 2);
	}

	public void viderTable(JTable table) {
		for (int i = 0; i < table.getRowCount(); i++) {
			for (int j = 0; j < table.getColumnCount(); j++) {
				table.setValueAt(null, i, j);
			}
		}
	}

	private void displayAll() {
		this.viderTable(this.ai.getTable_TypeFacture());
		DaoType_Fac DaoType_Fac = new DaoType_Fac();
		Collection<Type_Fac> lesCautions;
		try {
			lesCautions = DaoType_Fac.findAll();
			ai.getTable_TypeFacture().setModel(new DefaultTableModel(
					new String[] { "Type Facture", "Périodicité", "Unité" },
					lesCautions.size()));
			int i = 0;
			for (Type_Fac c : lesCautions) {
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