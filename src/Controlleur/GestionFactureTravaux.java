package Controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Modele.Facture_Travaux_Logement;
import Modele.DAO.DaoFacture_Travaux_Logement;
import Vue.FEN_Accueil;
import Vue.FEN_Erreurs;
import Vue.FEN_Facture_Travaux_Logement;
import Vue.Ajout.FEN_Ajout_FactureTravauxLogement;

public class GestionFactureTravaux implements ActionListener {
	private FEN_Facture_Travaux_Logement ai;

	public GestionFactureTravaux(FEN_Facture_Travaux_Logement ai) {
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
				FEN_Ajout_FactureTravauxLogement new_fen = new FEN_Ajout_FactureTravauxLogement();
				this.ai.getLayeredPane().add(new_fen);
				new_fen.setVisible(true);
				break;
			case "Modifier":
				FEN_Ajout_FactureTravauxLogement new_fen_edition = new FEN_Ajout_FactureTravauxLogement(
						this.lireLigneTable(this.ai.getTable_Facture().getSelectedRow()));
				this.ai.getLayeredPane().add(new_fen_edition);
				new_fen_edition.setVisible(true);
				break;
			case "Supprimer":
				this.delete();
				break;
		}
	}

	private void delete() {
		DaoFacture_Travaux_Logement dao = new DaoFacture_Travaux_Logement();
		int index = this.ai.getTable_Facture().getSelectedRow();
		try {
			dao.delete(this.lireLigneTable(index));
			this.displayAll();
		} catch (SQLException e) {
			new FEN_Erreurs(e.getMessage(), this.ai.getContentPane());
			e.printStackTrace();
		}
	}

	public Facture_Travaux_Logement lireLigneTable(int index) {
		DaoFacture_Travaux_Logement dao = new DaoFacture_Travaux_Logement();
		try {
			return dao.findById(null, (String) this.ai.getTable_Facture().getValueAt(index, 0));
		} catch (SQLException e) {
			return null;
		}

	}

	public void ecrireLigneTable(int index, Facture_Travaux_Logement value) {
		JTable lesFacs;

		lesFacs = ai.getTable_Facture();

		lesFacs.setValueAt(value.getNum_fac(), index, 0);
		lesFacs.setValueAt(value.getNature(), index, 1);
		lesFacs.setValueAt(value.getPrix(), index, 2);
		lesFacs.setValueAt(value.getMontant_indeductible(), index, 3);
		lesFacs.setValueAt(value.getReduction(), index, 4);
		lesFacs.setValueAt(value.getOrdre_du_cheque(), index, 5);
		lesFacs.setValueAt(value.getNumero_du_cheque(), index, 6);
		lesFacs.setValueAt(value.getDate_de_paiement(), index, 7);
		lesFacs.setValueAt(value.getEntrepreneur().getnSiren(), index, 8);
		lesFacs.setValueAt(value.getLogement().getNum(), index, 9);
	}

	public void viderTable(JTable table) {
		for (int i = 0; i < table.getRowCount(); i++) {
			for (int j = 0; j < table.getColumnCount(); j++) {
				table.setValueAt(null, i, j);
			}
		}
	}

	private void displayAll() {
		this.viderTable(this.ai.getTable_Facture());
		DaoFacture_Travaux_Logement dao = new DaoFacture_Travaux_Logement();
		Collection<Facture_Travaux_Logement> lesFacs;
		try {
			lesFacs = dao.findAll();
			ai.getTable_Facture().setModel(new DefaultTableModel(
					new String[] { "N° facture", "Nature", "Prix", "Montant indéductible", "Réduction",
							"Ordre du chèque", "N° chèque", "Date de paiement", "N° siren", "Logement" },
					lesFacs.size()));
			int i = 0;
			for (Facture_Travaux_Logement c : lesFacs) {
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