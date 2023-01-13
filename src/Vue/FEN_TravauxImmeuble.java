package Vue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Controlleur.GestionTravauxImmeuble;

public class FEN_TravauxImmeuble extends JInternalFrame {
	private JTable table_TravauxImmeuble;
	private GestionTravauxImmeuble controlleur;
	private JTable table_Entrepreneur;

	public FEN_TravauxImmeuble() {
		setBounds(0, 0, 968, 473);
		getContentPane().setLayout(null);

		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(129, 409, 89, 23);
		getContentPane().add(btnValider);

		JButton annuler = new JButton("Annuler");
		annuler.setBounds(659, 409, 89, 23);
		getContentPane().add(annuler);

		JScrollPane spFactureImmeuble = new JScrollPane();
		spFactureImmeuble.setEnabled(false);
		spFactureImmeuble.setBounds(22, 31, 913, 190);
		getContentPane().add(spFactureImmeuble);

		table_TravauxImmeuble = new JTable();
		table_TravauxImmeuble.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Date intervention", "Nature", "Facture", "Prix", "Num\u00E9ro facture", "Montant indeductible", "R\u00E9duction", "Ordre ch\u00E8que", "Num\u00E9ro ch\u00E8que", "Date paiement"
			}
		));
		table_TravauxImmeuble.getColumnModel().getColumn(4).setPreferredWidth(119);
		spFactureImmeuble.setViewportView(table_TravauxImmeuble);
		
		JScrollPane spEntrepreneur = new JScrollPane();
		spEntrepreneur.setEnabled(false);
		spEntrepreneur.setBounds(22, 268, 438, 66);
		getContentPane().add(spEntrepreneur);
		
		table_Entrepreneur = new JTable();
		table_Entrepreneur.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"n\u00B0 siret", "Adresse", "Nom", "IBAN", "Secteur d'activit\u00E9"
			}
		));
		table_Entrepreneur.getColumnModel().getColumn(4).setPreferredWidth(95);
		spEntrepreneur.setViewportView(table_Entrepreneur);

		
		JLabel lblFactureImmeuble = new JLabel("Facture immeuble");
		lblFactureImmeuble.setBounds(22, 10, 95, 13);
		getContentPane().add(lblFactureImmeuble);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setBounds(310, 409, 89, 23);
		getContentPane().add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(490, 410, 89, 23);
		getContentPane().add(btnSupprimer);
		
		JLabel lblEntrepreneur = new JLabel("Entrepreneur");
		lblEntrepreneur.setBounds(22, 245, 95, 13);
		getContentPane().add(lblEntrepreneur);
		this.controlleur = new GestionTravauxImmeuble(this);
		btnValider.addActionListener(controlleur);
		annuler.addActionListener(controlleur);
	}
}
