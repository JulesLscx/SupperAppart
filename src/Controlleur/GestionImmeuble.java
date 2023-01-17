package Controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JTable;

import Modele.Immeuble;
import Modele.DAO.DaoImmeuble;
import Other.MyDefaultTableModel;
import Vue.FEN_Accueil;
import Vue.FEN_Erreurs;
import Vue.FEN_Immeuble;
import Vue.Ajout.FEN_Ajout_Immeuble;

public class GestionImmeuble implements ActionListener {
	private FEN_Immeuble ai;

	public GestionImmeuble(FEN_Immeuble ai) {
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
				this.enableButtons(true);
				break;
			case "Ajouter":
				FEN_Ajout_Immeuble new_fen = new FEN_Ajout_Immeuble();
				this.ai.getLayeredPane().add(new_fen);
				new_fen.setVisible(true);
				break;
			case "Modifier":
				FEN_Ajout_Immeuble new_fen_edition = new FEN_Ajout_Immeuble(
						this.lireLigneTable(this.ai.getTable_Immeuble().getSelectedRow()));
				this.ai.getLayeredPane().add(new_fen_edition);
				new_fen_edition.setVisible(true);
				break;
			case "Supprimer":
				this.delete();
				break;
		}
	}

	private void delete() {
		DaoImmeuble dao = new DaoImmeuble();
		int index = this.ai.getTable_Immeuble().getSelectedRow();
		try {
			dao.delete(this.lireLigneTable(index));
			this.displayAll();
		} catch (SQLException e) {
			new FEN_Erreurs(e.getMessage(), this.ai.getContentPane());
			e.printStackTrace();
		}
	}

	public Immeuble lireLigneTable(int index) {
		String id_immeuble = (String) ai.getTable_Immeuble().getValueAt(index, 0);
		String adresse = (String) ai.getTable_Immeuble().getValueAt(index, 1);
		String pde_constr = (String) ai.getTable_Immeuble().getValueAt(index, 2);
		String num_bat = (String) ai.getTable_Immeuble().getValueAt(index, 3);
		String cp = (String) ai.getTable_Immeuble().getValueAt(index, 4);
		String ville = (String) ai.getTable_Immeuble().getValueAt(index, 5);
		String acces_com = (String) ai.getTable_Immeuble().getValueAt(index, 7);
		String cpr = (String) ai.getTable_Immeuble().getValueAt(index, 6);
		int copro = Integer.valueOf(cpr);

		return new Immeuble(id_immeuble, adresse, pde_constr, num_bat, cp, ville, acces_com, copro);

	}

	public void ecrireLigneTable(int index, Immeuble value) {
		JTable lesImmeubles;

		lesImmeubles = ai.getTable_Immeuble();

		lesImmeubles.setValueAt(value.getId_immeuble(), index, 0);
		lesImmeubles.setValueAt(value.getAdresse(), index, 1);
		lesImmeubles.setValueAt(value.getPde_constr(), index, 2);
		lesImmeubles.setValueAt(value.getNum_bat(), index, 3);
		lesImmeubles.setValueAt(value.getCp(), index, 4);
		lesImmeubles.setValueAt(value.getVille(), index, 5);
		lesImmeubles.setValueAt(value.getAccess_com(), index, 7);
		lesImmeubles.setValueAt(String.valueOf(value.getCopro()), index, 6);
	}

	public void viderTable(JTable table) {
		for (int i = 0; i < table.getRowCount(); i++) {
			for (int j = 0; j < table.getColumnCount(); j++) {
				table.setValueAt(null, i, j);
			}
		}
	}

	private void displayAll() {
		this.viderTable(this.ai.getTable_Immeuble());
		DaoImmeuble daoImmeuble = new DaoImmeuble();
		Collection<Immeuble> lesImmeubles;
		try {
			lesImmeubles = daoImmeuble.findAll();
			ai.getTable_Immeuble().setModel(new MyDefaultTableModel(
					new String[] {
							"Id_immeuble", "Adresse", "Pde de construction", "N°", "Code Postal", "Ville", "Copro",
							"Accessoire communs"
					},
					lesImmeubles.size()));
			int i = 0;
			for (Immeuble c : lesImmeubles) {
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