package Vue;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controlleur.GestionFactureTravaux;

public class FEN_Facture_Travaux_Logement extends JInternalFrame {
	private JTable table_Facture;

	public JTable getTable_Facture() {
		return table_Facture;
	}

	private JTable table_Entrepreneur;

	public JTable getTable_Entrepreneur() {
		return table_Entrepreneur;
	}

	private GestionFactureTravaux controlleur;
	private JButton btnModifier;
	private JButton btnSupprimer;
	private JButton btnAnnuler;
	private JButton btn_Ajouter;
	private JButton btnCharger;

	public FEN_Facture_Travaux_Logement() {
		setBounds(0, 0, 880, 473);
		getContentPane().setLayout(null);

		btn_Ajouter = new JButton("Ajouter");
		btn_Ajouter.setBounds(84, 397, 119, 23);
		getContentPane().add(btn_Ajouter);

		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(547, 397, 119, 23);
		getContentPane().add(btnAnnuler);

		JScrollPane spFactureLogement = new JScrollPane();
		spFactureLogement.setEnabled(false);
		spFactureLogement.setBounds(22, 31, 832, 149);
		getContentPane().add(spFactureLogement);

		table_Facture = new JTable();
		table_Facture.setModel(new DefaultTableModel(
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
						"Date intervention", "Nature", "Facture", "Prix", "N\u00B0 facture", "Montant indeductible",
						"R\u00E9duction", "Ordre ch\u00E8que", "N\u00B0 ch\u00E8que", "Date paiement"
				}));
		table_Facture.getColumnModel().getColumn(0).setPreferredWidth(90);
		table_Facture.getColumnModel().getColumn(2).setPreferredWidth(65);
		table_Facture.getColumnModel().getColumn(3).setPreferredWidth(65);
		table_Facture.getColumnModel().getColumn(4).setPreferredWidth(65);
		table_Facture.getColumnModel().getColumn(5).setPreferredWidth(90);
		table_Facture.getColumnModel().getColumn(6).setPreferredWidth(65);
		table_Facture.getColumnModel().getColumn(8).setPreferredWidth(65);
		spFactureLogement.setViewportView(table_Facture);

		JScrollPane spEntrepreneur = new JScrollPane();
		spEntrepreneur.setEnabled(false);
		spEntrepreneur.setBounds(22, 234, 438, 66);
		getContentPane().add(spEntrepreneur);

		table_Entrepreneur = new JTable();
		table_Entrepreneur.setModel(new DefaultTableModel(
				new Object[][] {
						{ null, null, null, null, null },
						{ null, null, null, null, null },
				},
				new String[] {
						"N\u00B0 SIREN", "Adresse", "Nom", "IBAN", "Secteur d'activit\u00E9"
				}));
		table_Entrepreneur.getColumnModel().getColumn(4).setPreferredWidth(95);
		spEntrepreneur.setViewportView(table_Entrepreneur);

		btnModifier = new JButton("Modifier");
		btnModifier.setBounds(238, 398, 119, 23);
		getContentPane().add(btnModifier);

		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(395, 397, 119, 23);
		getContentPane().add(btnSupprimer);

		btnCharger = new JButton("Charger");
		btnCharger.setBounds(695, 397, 119, 23);
		getContentPane().add(btnCharger);

		JLabel lblFactureLogement = new JLabel("Facture Travaux Logement");
		lblFactureLogement.setBounds(22, 15, 180, 13);
		getContentPane().add(lblFactureLogement);

		JLabel lblEntrepreneur = new JLabel("Entrepreneur");
		lblEntrepreneur.setBounds(22, 214, 126, 13);
		getContentPane().add(lblEntrepreneur);
		this.controlleur = new GestionFactureTravaux(this);
		btn_Ajouter.addActionListener(controlleur);
		btnAnnuler.addActionListener(controlleur);
		btnCharger.addActionListener(controlleur);
		btnModifier.addActionListener(controlleur);
		btnSupprimer.addActionListener(controlleur);
	}

	public JButton[] getChangeableButtons() {
		return new JButton[] { this.btnModifier, this.btnSupprimer };
	}

}
