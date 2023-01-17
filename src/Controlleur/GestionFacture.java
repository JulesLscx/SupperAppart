package Controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JTable;

import Modele.Factures_Charges;
import Modele.Immeuble;
import Modele.Type_Fac;
import Modele.DAO.DaoFacture;
import Modele.DAO.DaoImmeuble;
import Modele.DAO.DaoType_Fac;
import Other.MyDefaultTableModel;
import Vue.FEN_Accueil;
import Vue.FEN_Erreurs;
import Vue.FEN_Facture;
import Vue.Ajout.FEN_Ajout_Facture;

public class GestionFacture implements ActionListener {
	private FEN_Facture ai;

	public GestionFacture(FEN_Facture ai) {
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
				FEN_Ajout_Facture new_fen = new FEN_Ajout_Facture();
				this.ai.getLayeredPane().add(new_fen);
				new_fen.setVisible(true);
				break;
			case "Modifier":
				FEN_Ajout_Facture new_fen_edition = new FEN_Ajout_Facture(
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
		DaoFacture dao = new DaoFacture();
		int index = this.ai.getTable_Facture().getSelectedRow();
		try {
			dao.delete(this.lireLigneTable(index));
			this.displayAll();
		} catch (SQLException e) {
			new FEN_Erreurs(e.getMessage(), this.ai.getContentPane());
			e.printStackTrace();
		}
	}

	public Factures_Charges lireLigneTable(int index) {
		JTable t = this.ai.getTable_Facture();
		String numF = (String) t.getValueAt(index, 0);
		Date dateF = (Date) t.getValueAt(index, 1);
		float total = (Float) t.getValueAt(index, 2);
		float cf = (Float) t.getValueAt(index, 3);
		float prix_unite_releve = (Float) t.getValueAt(index, 4);
		float prix_unite_constatee = (Float) t.getValueAt(index, 5);
		Type_Fac typeF = null;
		Immeuble immeuble = null;
		try {
			typeF = new DaoType_Fac().findById(null, (String) t.getValueAt(index, 6));
			immeuble = new DaoImmeuble().findById(null, (String) t.getValueAt(index, 7));
		} catch (SQLException e) {
			new FEN_Erreurs("Impossible de charger l'immeuble ou l'id du contrat", ai);
			e.printStackTrace();
		}

		return new Factures_Charges(numF, dateF, total, cf, prix_unite_releve, prix_unite_constatee, typeF, immeuble);

	}

	public void ecrireLigneTable(int index, Factures_Charges value) {
		JTable lesFactures_Chargess;

		lesFactures_Chargess = ai.getTable_Facture();

		lesFactures_Chargess.setValueAt(value.getNumF(), index, 0);
		lesFactures_Chargess.setValueAt(value.getDateF(), index, 1);
		lesFactures_Chargess.setValueAt(value.getTotal(), index, 2);
		lesFactures_Chargess.setValueAt(value.getCf(), index, 3);
		lesFactures_Chargess.setValueAt(value.getPrix_unite_releve(), index, 4);
		lesFactures_Chargess.setValueAt(value.getPrix_unite_constatee(), index, 5);
		lesFactures_Chargess.setValueAt(value.getTypeF().getTypeF(), index, 6);
		lesFactures_Chargess.setValueAt(value.getImmeuble().getId_immeuble(), index, 7);
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
		DaoFacture daoFactures_Charges = new DaoFacture();
		Collection<Factures_Charges> lesFactures_Chargess;
		try {
			lesFactures_Chargess = daoFactures_Charges.findAll();
			ai.getTable_Facture().setModel(new MyDefaultTableModel(
					new String[] { "NFacture", "Date", "Total", "Cout fixe", "Prix U. Releve", "Prix U. Constate",
							"Type Facture",
							"Immeuble" },
					lesFactures_Chargess.size()));
			int i = 0;
			for (Factures_Charges c : lesFactures_Chargess) {
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