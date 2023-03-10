package Vue;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import Controlleur.GestionCaution;
import Controlleur.Table.GestionCautionTable;

public class FEN_Caution extends JInternalFrame {
	private JTable table_Caution;
	private GestionCaution controlleur;
	private JTable table_Contrat;
	private JButton btnModifier;
	private JButton btnSupprimer;
	private GestionCautionTable gestionTable;

	public JTable getTable_Caution() {
		return table_Caution;
	}

	public FEN_Caution() {
		setBounds(0, 0, 880, 473);
		getContentPane().setLayout(null);

		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(43, 405, 119, 23);
		getContentPane().add(btnAjouter);

		JButton annuler = new JButton("Annuler");
		annuler.setBounds(710, 405, 119, 23);
		getContentPane().add(annuler);

		JScrollPane spCaution = new JScrollPane();
		spCaution.setEnabled(false);
		spCaution.setBounds(33, 31, 807, 163);
		getContentPane().add(spCaution);

		table_Caution = new JTable();
		table_Caution.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Identifiant caution", "Email", "Telephone", "Nom", "Prenom", "Adresse", "Profession"
			}
		));
		spCaution.setViewportView(table_Caution);

		btnModifier = new JButton("Modifier");
		btnModifier.setBounds(205, 405, 119, 23);
		getContentPane().add(btnModifier);
		JButton btnCharger = new JButton("Charger");
		btnCharger.setBounds(547, 405, 119, 23);
		getContentPane().add(btnCharger);

		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(377, 405, 119, 23);
		getContentPane().add(btnSupprimer);

		JScrollPane spContrat = new JScrollPane();
		spContrat.setEnabled(false);
		spContrat.setBounds(33, 228, 807, 163);
		getContentPane().add(spContrat);

		table_Contrat = new JTable();
		table_Contrat.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"N\u00B0 contrat", "Prise effet", "Dur\u00E9e", "Charges", "Loyer", "Date r\u00E9vision", "P\u00E9riodicit\u00E9", "Date paiement", "Paiement", "Date EDL", "Montant", "Fin contrat"
			}
		));
		table_Contrat.getColumnModel().getColumn(0).setPreferredWidth(65);
		table_Contrat.getColumnModel().getColumn(1).setPreferredWidth(65);
		table_Contrat.getColumnModel().getColumn(2).setPreferredWidth(65);
		table_Contrat.getColumnModel().getColumn(3).setPreferredWidth(65);
		table_Contrat.getColumnModel().getColumn(4).setPreferredWidth(65);
		table_Contrat.getColumnModel().getColumn(5).setPreferredWidth(90);
		table_Contrat.getColumnModel().getColumn(6).setPreferredWidth(65);
		table_Contrat.getColumnModel().getColumn(7).setPreferredWidth(90);
		table_Contrat.getColumnModel().getColumn(8).setPreferredWidth(65);
		table_Contrat.getColumnModel().getColumn(9).setPreferredWidth(65);
		table_Contrat.getColumnModel().getColumn(10).setPreferredWidth(65);
		table_Contrat.getColumnModel().getColumn(11).setPreferredWidth(65);
		spContrat.setViewportView(table_Contrat);

		JLabel lblCaution = new JLabel("Caution");
		lblCaution.setBounds(33, 8, 45, 13);
		getContentPane().add(lblCaution);

		JLabel lblContrat = new JLabel("Contrat");
		lblContrat.setBounds(33, 205, 45, 13);
		getContentPane().add(lblContrat);

		this.controlleur = new GestionCaution(this);
		btnAjouter.addActionListener(controlleur);
		annuler.addActionListener(controlleur);
		btnCharger.addActionListener(controlleur);
		btnModifier.addActionListener(controlleur);
		btnAjouter.addActionListener(controlleur);
		btnSupprimer.addActionListener(controlleur);

		this.gestionTable = new GestionCautionTable(table_Caution, controlleur);
		this.table_Caution.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.table_Caution.getSelectionModel().addListSelectionListener(this.gestionTable);

	}

	public List<JButton> getChangeableButtons() {
		List<JButton> result = new LinkedList<>();
		result.add(btnModifier);
		result.add(btnSupprimer);
		return result;
	}
}
