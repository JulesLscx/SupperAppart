package Vue;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controlleur.GestionFacture;

public class FEN_Facture extends JInternalFrame {
	private JTable table_Facture;
	private JTable table_Immeuble;
	private GestionFacture controlleur;
	private JTable table_TypeFacture;
	private JButton btnCharger;
	private JButton btnAnnuler;
	private JButton btnValider;
	private JButton btnSupprimer;
	private JButton btnModifier;

	public FEN_Facture() {
		setBounds(0, 0, 880, 473);
		getContentPane().setLayout(null);

		btnValider = new JButton("Ajouter");
		btnValider.setBounds(84, 395, 119, 23);
		getContentPane().add(btnValider);

		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(481, 395, 119, 23);
		getContentPane().add(btnAnnuler);

		btnCharger = new JButton("Charger");
		btnCharger.setBounds(611, 395, 119, 23);
		getContentPane().add(btnCharger);

		JScrollPane spFactureExistante = new JScrollPane();
		spFactureExistante.setEnabled(false);
		spFactureExistante.setBounds(24, 31, 574, 136);
		getContentPane().add(spFactureExistante);

		table_Facture = new JTable();
		table_Facture.setModel(new DefaultTableModel(
				new Object[][] {
						{ null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null },
				},
				new String[] {
						"NFacture", "Date", "Total", "Cout fixe", "Prix U. Releve", "Prix U. Constate", "Type Facture",
						"Immeuble"
				}));
		spFactureExistante.setViewportView(table_Facture);

		JScrollPane spAssuranceImmeuble = new JScrollPane();
		spAssuranceImmeuble.setEnabled(false);
		spAssuranceImmeuble.setBounds(608, 62, 239, 59);
		getContentPane().add(spAssuranceImmeuble);

		table_TypeFacture = new JTable();
		table_TypeFacture.setModel(new DefaultTableModel(
				new Object[][] {
						{ null, null, null },
						{ null, null, null },
				},
				new String[] {
						"P\u00E9riodicit\u00E9", "Type", "Unit\u00E9"
				}));
		spAssuranceImmeuble.setViewportView(table_TypeFacture);

		JScrollPane spImmeuble = new JScrollPane();
		spImmeuble.setEnabled(false);
		spImmeuble.setBounds(26, 221, 818, 128);
		getContentPane().add(spImmeuble);

		table_Immeuble = new JTable();
		table_Immeuble.setModel(new DefaultTableModel(
				new Object[][] {
						{ null, null, null, null, null, null, null, null }
				},
				new String[] {
						"Identifiant", "Adresse", "P\u00E9riode de construction", "Num\u00E9ro", "CP", "Ville",
						"Copropri\u00E9taire", "Accessoire commun"
				}));
		table_Immeuble.getColumnModel().getColumn(2).setPreferredWidth(131);
		table_Immeuble.getColumnModel().getColumn(7).setPreferredWidth(151);
		spImmeuble.setViewportView(table_Immeuble);

		btnModifier = new JButton("Modifier");
		btnModifier.setBounds(214, 396, 119, 23);
		getContentPane().add(btnModifier);

		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(345, 396, 119, 23);
		getContentPane().add(btnSupprimer);

		JLabel lblFacture = new JLabel("Facture");
		lblFacture.setBounds(24, 8, 45, 13);
		getContentPane().add(lblFacture);

		JLabel lblTypeFacture = new JLabel("Type de facture");
		lblTypeFacture.setBounds(608, 33, 104, 13);
		getContentPane().add(lblTypeFacture);

		JLabel lblNewLabel = new JLabel("Immeuble");
		lblNewLabel.setBounds(24, 198, 110, 13);
		getContentPane().add(lblNewLabel);

		this.controlleur = new GestionFacture(this);
		btnValider.addActionListener(controlleur);
		btnAnnuler.addActionListener(controlleur);
		btnCharger.addActionListener(controlleur);
		btnSupprimer.addActionListener(controlleur);
		btnModifier.addActionListener(controlleur);

	}

	public JTable getTable_Facture() {
		return table_Facture;
	}

	public JTable getTable_Immeuble() {
		return table_Immeuble;
	}

	public GestionFacture getControlleur() {
		return controlleur;
	}

	public JTable getTable_TypeFacture() {
		return table_TypeFacture;
	}

	public JButton getBtnCharger() {
		return btnCharger;
	}

	public JButton getBtnAnnuler() {
		return btnAnnuler;
	}

	public JButton getBtnValider() {
		return btnValider;
	}

	public JButton getBtnSupprimer() {
		return btnSupprimer;
	}

	public JButton getBtnModifier() {
		return btnModifier;
	}

	public JButton[] getChangeableButtons() {
		return null;
	}

}
