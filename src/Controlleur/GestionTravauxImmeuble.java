package Controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Modele.Entrepreneur;
import Modele.Facture_Travaux_Immeuble;
import Modele.Immeuble;
import Modele.DAO.DaoEntrepreuneur;
import Modele.DAO.DaoFacture_Travaux_Immeuble;
import Modele.DAO.DaoImmeuble;
import Vue.FEN_Accueil;
import Vue.FEN_Erreurs;
import Vue.FEN_Facture_Travaux_Immeuble;
import Vue.Ajout.FEN_Ajout_FactureTravauxImmeuble;

public class GestionTravauxImmeuble implements ActionListener {
	private FEN_Facture_Travaux_Immeuble ai;

	public GestionTravauxImmeuble(FEN_Facture_Travaux_Immeuble ai) {
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
				FEN_Ajout_FactureTravauxImmeuble new_fen = new FEN_Ajout_FactureTravauxImmeuble();
				this.ai.getLayeredPane().add(new_fen);
				new_fen.setVisible(true);
				break;
			case "Modifier":
				FEN_Ajout_FactureTravauxImmeuble new_fen_edition = new FEN_Ajout_FactureTravauxImmeuble(
						this.lireLigneTable(this.ai.getTable_TravauxImmeuble().getSelectedRow()));
				this.ai.getLayeredPane().add(new_fen_edition);
				new_fen_edition.setVisible(true);
				break;
			case "Supprimer":
				this.delete();
				break;
		}
	}

	private void delete() {
		DaoFacture_Travaux_Immeuble dao = new DaoFacture_Travaux_Immeuble();
		int index = this.ai.getTable_TravauxImmeuble().getSelectedRow();
		try {
			dao.delete(this.lireLigneTable(index));
			this.displayAll();
		} catch (SQLException e) {
			new FEN_Erreurs(e.getMessage(), this.ai.getContentPane());
			e.printStackTrace();
		}
	}

	public Facture_Travaux_Immeuble lireLigneTable(int index) {
		String num_fac = (String) ai.getTable_TravauxImmeuble().getValueAt(index, 0);
		String nature = (String) ai.getTable_TravauxImmeuble().getValueAt(index, 1);
		Float prix = (Float) ai.getTable_TravauxImmeuble().getValueAt(index, 2);
		Float montant_indeductible = (Float) ai.getTable_TravauxImmeuble().getValueAt(index, 3);
		Float reduction = (Float) ai.getTable_TravauxImmeuble().getValueAt(index, 4);
		String ordre_du_cheque = (String) ai.getTable_TravauxImmeuble().getValueAt(index, 5);
		String numero_de_cheque = (String) ai.getTable_TravauxImmeuble().getValueAt(index, 6);
		Date date_de_paiement = Date.valueOf((String) ai.getTable_TravauxImmeuble().getValueAt(index, 7));
		DaoEntrepreuneur dao = new DaoEntrepreuneur();
		Entrepreneur n_siren = null;
		try {
			n_siren = dao.findById(null, (String) ai.getTable_TravauxImmeuble().getValueAt(index, 8));
		} catch (SQLException e) {
			new FEN_Erreurs("Impossible de trouver l'entrepreuneur veuillez réessayer", ai);
		}

		DaoImmeuble daoI = new DaoImmeuble();
		Immeuble num = null;
		try {
			num = daoI.findById(null, (String) ai.getTable_TravauxImmeuble().getValueAt(index, 9));
		} catch (SQLException e) {
			new FEN_Erreurs("Impossible de trouver l'immeuble veuillez réessayer", ai);
		}

		return new Facture_Travaux_Immeuble(num_fac, nature, prix, montant_indeductible, reduction, ordre_du_cheque,
				numero_de_cheque,
				date_de_paiement, num, n_siren);

	}

	public void ecrireLigneTable(int index, Facture_Travaux_Immeuble value) {
		JTable lesFacs;

		lesFacs = ai.getTable_TravauxImmeuble();

		lesFacs.setValueAt(value.getNum_fac(), index, 0);
		lesFacs.setValueAt(value.getNature(), index, 1);
		lesFacs.setValueAt(value.getPrix(), index, 2);
		lesFacs.setValueAt(value.getMontant_indeductible(), index, 3);
		lesFacs.setValueAt(value.getReduction(), index, 4);
		lesFacs.setValueAt(value.getOrdre_du_cheque(), index, 5);
		lesFacs.setValueAt(value.getNumero_du_cheque(), index, 6);
		lesFacs.setValueAt(value.getDate_de_paiement(), index, 7);
		lesFacs.setValueAt(value.getEntrepreneur().getnSiren(), index, 8);
		lesFacs.setValueAt(value.getImmeuble().getId_immeuble(), index, 9);
	}

	public void viderTable(JTable table) {
		for (int i = 0; i < table.getRowCount(); i++) {
			for (int j = 0; j < table.getColumnCount(); j++) {
				table.setValueAt(null, i, j);
			}
		}
	}

	private void displayAll() {
		this.viderTable(this.ai.getTable_TravauxImmeuble());
		DaoFacture_Travaux_Immeuble dao = new DaoFacture_Travaux_Immeuble();
		Collection<Facture_Travaux_Immeuble> lesFacs;
		try {
			lesFacs = dao.findAll();
			ai.getTable_TravauxImmeuble().setModel(new DefaultTableModel(
					new String[] { "N° facture", "Nature", "Prix", "Montant indéductible", "Réduction",
							"Ordre du chèque", "N° chèque", "N° siren", "Immeuble" },
					lesFacs.size()));
			int i = 0;
			for (Facture_Travaux_Immeuble c : lesFacs) {
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