package Vue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Controlleur.GestionRecap;
import Other.MyDefaultTableModel;

public class FEN_Recap extends JInternalFrame {
	private JTable table_Factures;

	public JTable getTable_TravauxImmeuble() {
		return table_Factures;
	}

	private GestionRecap controlleur;
	private JTable table_Paiements;

	public JTable getTable_Paiements() {
		return table_Paiements;
	}

	private JButton btnCharger;

	private JComboBox<String> comboBox_Immeuble;
	private JTextField textField_Annee;

	public FEN_Recap() {
		setBounds(0, 0, 968, 473);
		getContentPane().setLayout(null);

		JButton annuler = new JButton("Annuler");
		annuler.setBounds(85, 395, 119, 23);
		getContentPane().add(annuler);

		JScrollPane sp_Factures = new JScrollPane();
		sp_Factures.setEnabled(false);
		sp_Factures.setBounds(22, 31, 913, 190);
		getContentPane().add(sp_Factures);

		table_Factures = new JTable();
		table_Factures.setModel(new MyDefaultTableModel(
				new Object[][] {
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
				},
				new String[] {
						"N\u00B0facture", "Nature", "Prix", "Montant ind\u00E9ductible", "R\u00E9duction",
						"Ordre ch\u00E8que", "N\u00B0 ch\u00E8que", "Date de paiement", "N\u00B0 SIREN",
				}));
		table_Factures.getColumnModel().getColumn(0).setPreferredWidth(65);
		table_Factures.getColumnModel().getColumn(1).setPreferredWidth(65);
		table_Factures.getColumnModel().getColumn(2).setPreferredWidth(65);
		table_Factures.getColumnModel().getColumn(3).setPreferredWidth(90);
		table_Factures.getColumnModel().getColumn(4).setPreferredWidth(65);
		table_Factures.getColumnModel().getColumn(5).setPreferredWidth(65);
		table_Factures.getColumnModel().getColumn(6).setPreferredWidth(65);
		table_Factures.getColumnModel().getColumn(7).setPreferredWidth(90);
		table_Factures.getColumnModel().getColumn(8).setPreferredWidth(65);
		sp_Factures.setViewportView(table_Factures);

		JScrollPane sp_Paiements = new JScrollPane();
		sp_Paiements.setEnabled(false);
		sp_Paiements.setBounds(22, 268, 499, 88);
		getContentPane().add(sp_Paiements);

		table_Paiements = new JTable();
		table_Paiements.setModel(new MyDefaultTableModel(
				new Object[][] {
						{ null, null, null, null, null },
						{ null, null, null, null, null },
						{ null, null, null, null, null },
						{ null, null, null, null, null },
				},
				new String[] {
						"Identifiant", "Montant", "Date", "Moyen paiement", "Identifiant contrat"
				}));
		table_Paiements.getColumnModel().getColumn(4).setPreferredWidth(95);
		sp_Paiements.setViewportView(table_Paiements);

		JLabel lbl_Factures = new JLabel("Factures");
		lbl_Factures.setBounds(24, 12, 110, 13);
		getContentPane().add(lbl_Factures);

		btnCharger = new JButton("Charger");
		btnCharger.setBounds(255, 395, 119, 23);
		getContentPane().add(btnCharger);

		JLabel lbl_Paiements = new JLabel("Paiements");
		lbl_Paiements.setBounds(22, 250, 95, 13);
		getContentPane().add(lbl_Paiements);

		comboBox_Immeuble = new JComboBox<String>();
		comboBox_Immeuble.setBounds(681, 334, 86, 22);
		getContentPane().add(comboBox_Immeuble);

		JLabel lbl_Filtre_Annee = new JLabel("Annee :");
		lbl_Filtre_Annee.setBounds(681, 269, 95, 13);
		getContentPane().add(lbl_Filtre_Annee);

		textField_Annee = new JTextField();
		textField_Annee.setBounds(681, 284, 86, 20);
		getContentPane().add(textField_Annee);
		textField_Annee.setColumns(10);

		JLabel lbl_Filtre_Immeuble = new JLabel("Immeuble");
		lbl_Filtre_Immeuble.setBounds(681, 318, 95, 13);
		getContentPane().add(lbl_Filtre_Immeuble);
		this.controlleur = new GestionRecap(this);
		annuler.addActionListener(controlleur);
		btnCharger.addActionListener(controlleur);
	}

	public JTable getTable_Factures() {
		return table_Factures;
	}

	public GestionRecap getControlleur() {
		return controlleur;
	}

	public JButton getBtnCharger() {
		return btnCharger;
	}

	public JComboBox<String> getComboBox_Immeuble() {
		return comboBox_Immeuble;
	}

	public JTextField getTextField_Annee() {
		return textField_Annee;
	}
}
