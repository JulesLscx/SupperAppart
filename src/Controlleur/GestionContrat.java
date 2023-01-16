package Controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Modele.Contrat;
import Modele.DAO.DaoContrat;
import Vue.FEN_Accueil;
import Vue.FEN_Contrat;
import Vue.FEN_Erreurs;
import Vue.Ajout.FEN_Ajout_Contrat;

public class GestionContrat implements ActionListener {
	private FEN_Contrat ai;

	public GestionContrat(FEN_Contrat ai) {
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
				FEN_Ajout_Contrat new_fen = new FEN_Ajout_Contrat();
				this.ai.getLayeredPane().add(new_fen);
				new_fen.setVisible(true);
				break;
			case "Modifier":
				// FEN_Ajout_Contrat new_fen_edition = new FEN_Ajout_Contrat(
				// this.lireLigneTable(this.ai.getTable_Contrat().getSelectedRow()));
				// this.ai.getLayeredPane().add(new_fen_edition);
				// new_fen_edition.setVisible(true);
				break;
			case "Supprimer":
				this.delete();
				break;
		}
	}

	private void delete() {
		DaoContrat dao = new DaoContrat();
		int index = this.ai.getTable_Contrat().getSelectedRow();
		try {
			dao.delete(this.lireLigneTable(index));
			this.displayAll();
		} catch (SQLException e) {
			new FEN_Erreurs(e.getMessage(), this.ai.getContentPane());
			e.printStackTrace();
		}
	}

	public Contrat lireLigneTable(int index) {
		String id_Contrat = (String) ai.getTable_Contrat().getValueAt(index, 0);
		DaoContrat dao = new DaoContrat();
		try {
			return dao.findById(null, id_Contrat);
		} catch (SQLException e) {
			new FEN_Erreurs(e.getMessage(), ai);
			e.printStackTrace();
		}
		return null;
	}

	public void ecrireLigneTable(int index, Contrat value) {
		JTable lesContrats;

		lesContrats = ai.getTable_Contrat();

		lesContrats.setValueAt(value.getId_contrat(), index, 0);
		lesContrats.setValueAt(value.getPrise_effet(), index, 1);
		lesContrats.setValueAt(value.getDuree(), index, 2);
		lesContrats.setValueAt(value.getCharges(), index, 3);
		lesContrats.setValueAt(value.getLoyer(), index, 4);
		lesContrats.setValueAt(value.getDate_revision(), index, 5);
		lesContrats.setValueAt(value.getPeriodicite(), index, 6);
		lesContrats.setValueAt(value.getDate_paiement(), index, 7);
		lesContrats.setValueAt(value.getPaiement(), index, 8);
		lesContrats.setValueAt(value.getDate_edl(), index, 9);
		lesContrats.setValueAt(value.getMontant_caution(), index, 10);
		lesContrats.setValueAt(value.getFin_contrat(), index, 11);
		lesContrats.setValueAt(value.getNum().getNum(), index, 12);
		if (value.getN_siren() != null) {
			lesContrats.setValueAt(value.getN_siren().getnSiren(), index, 13);
		}
		if (value.getId_caution() != null) {
			lesContrats.setValueAt(value.getId_caution().getId_Caution(), index, 14);
		}
	}

	public void viderTable(JTable table) {
		for (int i = 0; i < table.getRowCount(); i++) {
			for (int j = 0; j < table.getColumnCount(); j++) {
				table.setValueAt(null, i, j);
			}
		}
	}

	private void displayAll() {
		this.viderTable(this.ai.getTable_Contrat());
		DaoContrat daoContrat = new DaoContrat();
		Collection<Contrat> lesContrats;
		try {
			lesContrats = daoContrat.findAll();
			ai.getTable_Contrat().setModel(new DefaultTableModel(
					new String[] { "Num\u00E9ro contrat", "Prise effet", "Dur\u00E9e", "Charge", "Loyer",
							"Date r\u00E9vision",
							"P\u00E9riodicit\u00E9", "Date paiement", "Paiement", "Date EDL", "Montant caution",
							"Fin contrat", "Logement", "Entrepreuneur",
							"Caution" },
					lesContrats.size()));
			int i = 0;
			for (Contrat c : lesContrats) {
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
