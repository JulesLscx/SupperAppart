package Controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JTable;

import Modele.Immeuble;
import Modele.Logement;
import Modele.DAO.DaoImmeuble;
import Modele.DAO.DaoLogement;
import Other.MyDefaultTableModel;
import Vue.FEN_Accueil;
import Vue.FEN_Erreurs;
import Vue.FEN_Logement;
import Vue.Ajout.FEN_Ajout_Logement;

public class GestionLogement implements ActionListener {
	private FEN_Logement ai;

	public GestionLogement(FEN_Logement ai) {
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
				FEN_Ajout_Logement new_fen = new FEN_Ajout_Logement();
				this.ai.getLayeredPane().add(new_fen);
				new_fen.setVisible(true);
				break;
			case "Modifier":
				FEN_Ajout_Logement new_fen_edition = new FEN_Ajout_Logement(
						this.lireLigneTable(this.ai.getTable_Logement().getSelectedRow()));
				this.ai.getLayeredPane().add(new_fen_edition);
				new_fen_edition.setVisible(true);
				break;
			case "Supprimer":
				this.delete();
				break;
		}
	}

	private void delete() {
		DaoLogement dao = new DaoLogement();
		int index = this.ai.getTable_Logement().getSelectedRow();
		try {
			dao.delete(this.lireLigneTable(index));
			this.displayAll();
		} catch (SQLException e) {
			new FEN_Erreurs(e.getMessage(), this.ai.getContentPane());
			e.printStackTrace();
		}
	}

	public Logement lireLigneTable(int index) {
		DaoImmeuble dao = new DaoImmeuble();
		Immeuble i = null;
		try {
			i = dao.findById(null, (String) ai.getTable_Logement().getValueAt(index, 4));
		} catch (SQLException e) {
			new FEN_Erreurs(e.getMessage(), ai);
		}
		String num = (String) ai.getTable_Logement().getValueAt(index, 0);
		String type_hab = (String) ai.getTable_Logement().getValueAt(index, 1);
		float surface = (float) ai.getTable_Logement().getValueAt(index, 2);
		int nbPiece = (int) ai.getTable_Logement().getValueAt(index, 3);

		return new Logement(num, type_hab, surface, nbPiece, i);

	}

	public void ecrireLigneTable(int index, Logement value) {
		JTable lesLogements;

		lesLogements = ai.getTable_Logement();

		lesLogements.setValueAt(value.getNum(), index, 0);
		lesLogements.setValueAt(value.getType_hab(), index, 1);
		lesLogements.setValueAt(value.getSurface(), index, 2);
		lesLogements.setValueAt(value.getNbpiece(), index, 3);
		lesLogements.setValueAt(value.getImmeuble().getId_immeuble(), index, 4);
	}

	public void viderTable(JTable table) {
		for (int i = 0; i < table.getRowCount(); i++) {
			for (int j = 0; j < table.getColumnCount(); j++) {
				table.setValueAt(null, i, j);
			}
		}
	}

	private void displayAll() {
		this.viderTable(this.ai.getTable_Logement());
		DaoLogement daoLogement = new DaoLogement();
		Collection<Logement> lesLogements;
		try {
			lesLogements = daoLogement.findAll();
			ai.getTable_Logement().setModel(new MyDefaultTableModel(
					new String[] {
							"Num\u00E9ro", "Type Habitation", "Surface", "nbPiece", "Immeuble"
					},
					lesLogements.size()));
			int i = 0;
			for (Logement c : lesLogements) {
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