package Controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Modele.Locataire;
import Modele.DAO.DaoLocataire;
import Vue.FEN_Accueil;
import Vue.FEN_Locataire;

public class GestionLocataire implements ActionListener {
	private FEN_Locataire ai;

	public GestionLocataire(FEN_Locataire ai) {
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
				if (this.ai.isCheck()) {
					this.displayCurrents();
				} else {
					this.displayAll();
				}

				break;
		}
	}

	private void displayCurrents() {
		this.viderTable(this.ai.getTable_Locataire());
		DaoLocataire daoLocataire = new DaoLocataire();
		Collection<Locataire> lesLocataires;
		try {
			lesLocataires = daoLocataire.findCurrentLoc();
			ai.getTable_Locataire().setModel(new DefaultTableModel(
					new String[] { "nLocataire", "nom", "prenom",
							"email", "telephone", "genre" },
					lesLocataires.size()));
			int i = 0;
			for (Locataire c : lesLocataires) {
				if (c == null)
					break;
				this.ecrireLigneTable(i, c);
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Locataire lireLigneTable(int index) {
		String nLocataire = (String) ai.getTable_Locataire().getValueAt(index, 0);
		String prenom = (String) ai.getTable_Locataire().getValueAt(index, 1);
		String nom = (String) ai.getTable_Locataire().getValueAt(index, 2);
		String email = (String) ai.getTable_Locataire().getValueAt(index, 3);
		String telephone = (String) ai.getTable_Locataire().getValueAt(index, 4);
		char genre = (char) ai.getTable_Locataire().getValueAt(index, 5);

		return new Locataire(nLocataire, nom, prenom, email, telephone, genre);

	}

	public void ecrireLigneTable(int index, Locataire value) {
		JTable lesLocataires;

		lesLocataires = ai.getTable_Locataire();

		lesLocataires.setValueAt(value.getnLocataire(), index, 0);
		lesLocataires.setValueAt(value.getPrenom(), index, 1);
		lesLocataires.setValueAt(value.getNom(), index, 2);
		lesLocataires.setValueAt(value.getEmail(), index, 3);
		lesLocataires.setValueAt(value.getTel(), index, 4);
		lesLocataires.setValueAt(value.getGenre(), index, 5);
	}

	public void viderTable(JTable table) {
		for (int i = 0; i < table.getRowCount(); i++) {
			for (int j = 0; j < table.getColumnCount(); j++) {
				table.setValueAt(null, i, j);
			}
		}
	}

	private void displayAll() {
		this.viderTable(this.ai.getTable_Locataire());
		DaoLocataire daoLocataire = new DaoLocataire();
		Collection<Locataire> lesLocataires;
		try {
			lesLocataires = daoLocataire.findAll();
			ai.getTable_Locataire().setModel(new DefaultTableModel(
					new String[] { "nLocataire", "nom", "prenom",
							"email", "telephone", "genre" },
					lesLocataires.size()));
			int i = 0;
			for (Locataire c : lesLocataires) {
				if (c == null)
					break;
				this.ecrireLigneTable(i, c);
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}