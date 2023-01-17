package Vue;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import Controlleur.GestionCoef;
import Controlleur.Table.GestionCautionTable;

public class FEN_Coefficient extends JInternalFrame {
	private JTable table_Coefficient;
	private GestionCoef controlleur;
	private JButton btnModifier;
	private JButton btnSupprimer;
	private GestionCautionTable gestionTable;
	private JComboBox<String> comboBox_logement;

	public JComboBox<String> getComboBox_logement() {
		return comboBox_logement;
	}

	public JTable getTable_Coefficient() {
		return table_Coefficient;
	}

	public FEN_Coefficient() {
		setBounds(0, 0, 880, 473);
		getContentPane().setLayout(null);

		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(75, 380, 119, 23);
		getContentPane().add(btnAjouter);

		JButton annuler = new JButton("Annuler");
		annuler.setBounds(675, 380, 119, 23);
		getContentPane().add(annuler);

		JScrollPane sp_Coefficient = new JScrollPane();
		sp_Coefficient.setEnabled(false);
		sp_Coefficient.setBounds(43, 63, 587, 241);
		getContentPane().add(sp_Coefficient);

		table_Coefficient = new JTable();
		table_Coefficient.setModel(new DefaultTableModel(
				new Object[][] {
						{ null, null, null },
						{ null, null, null },
						{ null, null, null },
						{ null, null, null },
						{ null, null, null },
						{ null, null, null },
						{ null, null, null },
						{ null, null, null },
						{ null, null, null },
						{ null, null, null },
						{ null, null, null },
						{ null, null, null },
						{ null, null, null },
						{ null, null, null },
						{ null, null, null },
						{ null, null, null },
						{ null, null, null },
						{ null, null, null },
						{ null, null, null },
				},
				new String[] {
						"N\u00B0 logement", "Type de facture", "Coefficient"
				}) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		sp_Coefficient.setViewportView(table_Coefficient);

		btnModifier = new JButton("Modifier");
		btnModifier.setBounds(225, 380, 119, 23);
		getContentPane().add(btnModifier);

		JButton btnCharger = new JButton("Charger");
		btnCharger.setBounds(525, 380, 119, 23);
		getContentPane().add(btnCharger);

		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(375, 380, 119, 23);
		getContentPane().add(btnSupprimer);

		JLabel lbl_Coefficient = new JLabel("Coefficient");
		lbl_Coefficient.setBounds(45, 40, 119, 13);
		getContentPane().add(lbl_Coefficient);

		this.controlleur = new GestionCoef(this);
		btnAjouter.addActionListener(controlleur);
		annuler.addActionListener(controlleur);
		btnCharger.addActionListener(controlleur);
		btnModifier.addActionListener(controlleur);
		btnAjouter.addActionListener(controlleur);
		btnSupprimer.addActionListener(controlleur);

		// this.gestionTable = new GestionCautionTable(table_Coefficient, controlleur);
		this.table_Coefficient.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		comboBox_logement = new JComboBox<String>();
		comboBox_logement.setBounds(675, 170, 153, 22);
		getContentPane().add(comboBox_logement);

		JLabel lbl_combobox_Logement = new JLabel("Selectionner Logement");
		lbl_combobox_Logement.setBounds(675, 145, 49, 14);
		getContentPane().add(lbl_combobox_Logement);
		this.table_Coefficient.getSelectionModel().addListSelectionListener(this.gestionTable);

	}

	public List<JButton> getChangeableButtons() {
		List<JButton> result = new LinkedList<>();
		result.add(btnModifier);
		result.add(btnSupprimer);
		return result;
	}

	public GestionCoef getControlleur() {
		return controlleur;
	}

	public JButton getBtnModifier() {
		return btnModifier;
	}

	public JButton getBtnSupprimer() {
		return btnSupprimer;
	}

	public GestionCautionTable getGestionTable() {
		return gestionTable;
	}
}
