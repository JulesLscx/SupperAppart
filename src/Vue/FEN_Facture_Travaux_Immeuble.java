package Vue;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controlleur.GestionTravauxImmeuble;

public class FEN_Facture_Travaux_Immeuble extends JInternalFrame {
	private JTable table_TravauxImmeuble;

	public JTable getTable_TravauxImmeuble() {
		return table_TravauxImmeuble;
	}

	private GestionTravauxImmeuble controlleur;
	private JTable table_Entrepreneur;
	private JButton btnSupprimer;
	private JButton btnModifier;
	private JButton btnCharger;

	public FEN_Facture_Travaux_Immeuble() {
		setBounds(0, 0, 968, 473);
		getContentPane().setLayout(null);

		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(110, 409, 119, 23);
		getContentPane().add(btnAjouter);

		JButton annuler = new JButton("Annuler");
		annuler.setBounds(750, 409, 119, 23);
		getContentPane().add(annuler);

		JScrollPane spFactureImmeuble = new JScrollPane();
		spFactureImmeuble.setEnabled(false);
		spFactureImmeuble.setBounds(22, 31, 913, 190);
		getContentPane().add(spFactureImmeuble);

		table_TravauxImmeuble = new JTable();
		table_TravauxImmeuble.setModel(new DefaultTableModel(
				new Object[][] {
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
				},
				new String[] {
						"Date intervention", "Nature", "Facture", "Prix", "Num\u00E9ro facture", "Montant indeductible",
						"R\u00E9duction", "Ordre ch\u00E8que", "Num\u00E9ro ch\u00E8que", "Date paiement"
				}));
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
				"N\u00B0SIREN", "Adresse", "Nom", "IBAN", "Secteur d'activit\u00E9"
			}
		));
		table_Entrepreneur.getColumnModel().getColumn(4).setPreferredWidth(95);
		spEntrepreneur.setViewportView(table_Entrepreneur);

		JLabel lblFactureImmeuble = new JLabel("Facture immeuble");
		lblFactureImmeuble.setBounds(22, 10, 110, 13);
		getContentPane().add(lblFactureImmeuble);

		btnModifier = new JButton("Modifier");
		btnModifier.setBounds(270, 409, 119, 23);
		getContentPane().add(btnModifier);

		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(430, 410, 119, 23);
		getContentPane().add(btnSupprimer);

		btnCharger = new JButton("Charger");
		btnCharger.setBounds(590, 410, 119, 23);
		getContentPane().add(btnCharger);

		JLabel lblEntrepreneur = new JLabel("Entrepreneur");
		lblEntrepreneur.setBounds(22, 245, 95, 13);
		getContentPane().add(lblEntrepreneur);
		this.controlleur = new GestionTravauxImmeuble(this);
		btnAjouter.addActionListener(controlleur);
		annuler.addActionListener(controlleur);
		btnModifier.addActionListener(controlleur);
		btnSupprimer.addActionListener(controlleur);
		btnCharger.addActionListener(controlleur);
	}

	public JButton[] getChangeableButtons() {
		return new JButton[] { btnModifier, btnSupprimer };
	}
}