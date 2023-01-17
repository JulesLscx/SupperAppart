package Vue;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Controlleur.GestionPaiements;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FEN_Paiements extends JInternalFrame {
	private JTable table_Paiement;
	private GestionPaiements controlleur;
	private JTable table_Contrat;
	private JButton btnModifier;
	private JButton btnSupprimer;
	private JButton btnAjouter;
	private JButton btnAnnuler;
	private JButton btnCharger;

	public FEN_Paiements() {
		setBounds(0, 0, 880, 473);
		getContentPane().setLayout(null);

		btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(75, 400, 119, 23);
		getContentPane().add(btnAjouter);

		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(525, 400, 119, 23);
		getContentPane().add(btnAnnuler);

		JScrollPane spPaiement = new JScrollPane();
		spPaiement.setEnabled(false);
		spPaiement.setBounds(21, 35, 825, 140);
		getContentPane().add(spPaiement);

		table_Paiement = new JTable();
		table_Paiement.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Identifiant", "Montant", "Date", "Moyen Paiement", "Identifiant contrat"
			}
		));
		spPaiement.setViewportView(table_Paiement);

		JScrollPane spContrat = new JScrollPane();
		spContrat.setEnabled(false);
		spContrat.setBounds(21, 240, 825, 84);
		getContentPane().add(spContrat);

		table_Contrat = new JTable();
		table_Contrat.setModel(new DefaultTableModel(
				new Object[][] {
						{ null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null },
				},
				new String[] {
						"N\u00B0 contrat", "Prise effet", "Dur\u00E9e", "Charge", "Loyer", "Date r\u00E9vision",
						"P\u00E9riodicit\u00E9", "Date paiement", "Paiement", "Date EDL", "Montant", "Fin contrat"
				}));
		table_Contrat.getColumnModel().getColumn(0).setPreferredWidth(65);
		table_Contrat.getColumnModel().getColumn(1).setPreferredWidth(65);
		table_Contrat.getColumnModel().getColumn(2).setPreferredWidth(65);
		table_Contrat.getColumnModel().getColumn(3).setPreferredWidth(65);
		table_Contrat.getColumnModel().getColumn(4).setPreferredWidth(65);
		table_Contrat.getColumnModel().getColumn(5).setPreferredWidth(90);
		table_Contrat.getColumnModel().getColumn(6).setPreferredWidth(65);
		table_Contrat.getColumnModel().getColumn(7).setPreferredWidth(90);
		table_Contrat.getColumnModel().getColumn(8).setPreferredWidth(65);
		table_Contrat.getColumnModel().getColumn(11).setPreferredWidth(65);

		spContrat.setViewportView(table_Contrat);

		JLabel lblPaiement = new JLabel("Paiement :");
		lblPaiement.setBounds(21, 12, 75, 13);
		getContentPane().add(lblPaiement);

		JLabel lblContrat = new JLabel("Contrat :");
		lblContrat.setBounds(21, 217, 75, 13);
		getContentPane().add(lblContrat);

		btnModifier = new JButton("Modifier");
		btnModifier.setBounds(225, 400, 119, 23);
		getContentPane().add(btnModifier);

		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(375, 400, 119, 23);
		getContentPane().add(btnSupprimer);

		btnCharger = new JButton("Charger");
		btnCharger.setBounds(675, 400, 119, 23);
		getContentPane().add(btnCharger);

		this.controlleur = new GestionPaiements(this);
		btnAjouter.addActionListener(controlleur);
		btnAnnuler.addActionListener(controlleur);
		btnCharger.addActionListener(controlleur);
		btnSupprimer.addActionListener(controlleur);
		btnModifier.addActionListener(controlleur);

	}

	public JButton[] getChangeableButtons() {
		return new JButton[] { this.btnModifier, this.btnSupprimer };
	}

	public JTable getTable_Paiement() {
		return table_Paiement;
	}

	public GestionPaiements getControlleur() {
		return controlleur;
	}

	public JTable getTable_Contrat() {
		return table_Contrat;
	}
}
