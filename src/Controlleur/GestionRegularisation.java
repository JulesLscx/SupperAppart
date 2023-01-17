package Controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Modele.Coef;
import Modele.Contrat;
import Modele.Regularisation;
import Modele.Type_Fac;
import Modele.DAO.DaoCoef;
import Modele.DAO.DaoContrat;
import Modele.DAO.DaoRegularisation;
import Modele.DAO.DaoType_Fac;
import Other.ProjectUtils;
import Vue.FEN_Accueil;
import Vue.FEN_Erreurs;
import Vue.FEN_Regularisation;
import Vue.Ajout.FEN_Ajout_Regularisation;

public class GestionRegularisation implements ActionListener {
	private FEN_Regularisation ai;

	public GestionRegularisation(FEN_Regularisation ai) {
		this.ai = ai;
		this.ai.validationEnable(false);
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
				this.displayAll(null, this.ai.getTable_Base_Regu());
				break;
			case "Ajouter":
				FEN_Ajout_Regularisation new_fen = new FEN_Ajout_Regularisation();
				this.ai.getLayeredPane().add(new_fen);
				new_fen.setVisible(true);
				break;
			case "Générer":
				int annee = Integer.valueOf(this.ai.getTextField_Annee_Regu().getText());
				this.simulate(annee);
				this.ai.validationEnable(true);
				break;
			case "Valider":
				this.pushAll();
				this.ai.validationEnable(true);
				break;
			case "Supprimer":
				this.delete();
				break;
		}
	}

	private void pushAll() {
		DaoRegularisation dao = new DaoRegularisation();
		for (int i = 0; i < this.ai.getTable_Generation_Regu().getRowCount(); i++) {
			if (this.ai.getTable_Generation_Regu().getValueAt(i, 3) instanceof Float
					|| (String) this.ai.getTable_Generation_Regu().getValueAt(i, 3) != "") {
				try {
					dao.create(lireLigneTable(i, this.ai.getTable_Generation_Regu()));
				} catch (SQLException e) {
					new FEN_Erreurs("Ligne " + i + " non ajouté dû à une erreur de lecture", ai);
					e.printStackTrace();
				}
			}
		}
	}

	private void simulate(int annee) {
		Collection<Coef> lesCoefs;
		try {
			lesCoefs = new DaoCoef().findAllUsable();
		} catch (SQLException e1) {
			new FEN_Erreurs("Erreur lors du chargement des coefficients", ai);
			return;
		}
		Collection<Regularisation> lesReguls = new LinkedList<Regularisation>();
		DaoRegularisation dao = new DaoRegularisation();
		Date laDate = ProjectUtils.conversionDate("01/01/" + annee);
		Regularisation r;
		for (Coef c : lesCoefs) {
			try {
				r = dao.simulate(c.getNum().getNum(), c.getTf().getTypeF(), laDate);
				lesReguls.add(r);
			} catch (SQLException e) {
				new FEN_Erreurs(e.getMessage(), ai);
				e.printStackTrace();
			}
		}
		this.displayAll(lesReguls, this.ai.getTable_Generation_Regu());
	}

	private void delete() {
		DaoRegularisation dao = new DaoRegularisation();
		int index = this.ai.getTable_Base_Regu().getSelectedRow();
		try {
			dao.delete(this.lireLigneTable(index, this.ai.getTable_Base_Regu()));
			this.displayAll(null, this.ai.getTable_Base_Regu());
		} catch (SQLException e) {
			new FEN_Erreurs(e.getMessage(), this.ai.getContentPane());
			e.printStackTrace();
		}
	}

	public Regularisation lireLigneTable(int index, JTable table) {
		Contrat id_contrat;
		try {
			id_contrat = new DaoContrat().findById(null,
					(String) table.getValueAt(index, 0));
		} catch (SQLException e) {
			new FEN_Erreurs("Impossible de trouver le contrat lié", ai);
			e.printStackTrace();
			return null;
		}
		Type_Fac tf;
		try {
			tf = new DaoType_Fac().findById(null, (String) table.getValueAt(index, 1));
		} catch (SQLException e) {
			new FEN_Erreurs("Impossible de trouver le type de facture lié", ai);
			e.printStackTrace();
			return null;
		}
		Date datr;
		try {
			datr = (Date) table.getValueAt(index, 2);
		} catch (Exception e) {
			datr = ProjectUtils.conversionDate((String) table.getValueAt(index, 2));
		}
		Float montant;
		try {
			montant = (Float) table.getValueAt(index, 3);
		} catch (Exception e) {
			montant = Float.valueOf((String) table.getValueAt(index, 3));
		}

		return new Regularisation(id_contrat, tf, datr, montant);

	}

	public void ecrireLigneTable(int index, Regularisation value, JTable table) {
		table.setValueAt(value.getContrat().getId_contrat(), index, 0);
		table.setValueAt(value.getTypeF().getTypeF(), index, 1);
		table.setValueAt(value.getDateR(), index, 2);
		table.setValueAt(value.getMontant(), index, 3);
	}

	public void viderTable(JTable table) {
		for (int i = 0; i < table.getRowCount(); i++) {
			for (int j = 0; j < table.getColumnCount(); j++) {
				table.setValueAt(null, i, j);
			}
		}
	}

	private void displayAll(Collection<Regularisation> col, JTable table) {
		try {
			Collection<Regularisation> lesRegularisations;
			if (col == null) {
				this.viderTable(this.ai.getTable_Base_Regu());
				DaoRegularisation daoRegularisation = new DaoRegularisation();
				lesRegularisations = daoRegularisation.findAll();
			} else {
				lesRegularisations = col;
			}

			table.setModel(new DefaultTableModel(
					new String[] { "Contrat", "Type facture", "Date regularisation",
							"Montant" },
					lesRegularisations.size()));
			int i = 0;
			for (Regularisation c : lesRegularisations) {
				if (c == null)
					break;
				this.ecrireLigneTable(i, c, table);
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