package Vue;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controlleur.GestionLocataire;

public class FEN_Locataire extends JInternalFrame {
	private JTable table_Locataire;
	private JTable table_Contrat;
	private GestionLocataire controlleur;
	private JTable table_Documents;
	private JCheckBox filter;
	private JButton btnCharger;
	private JButton btnSpprimer;
	private JButton btnModifier;
	private JButton btn_ajouter;

	public FEN_Locataire() {
		setBounds(0, 0, 880, 504);
		getContentPane().setLayout(null);

		btn_ajouter = new JButton("Ajouter");
		btn_ajouter.setBounds(96, 426, 89, 23);
		getContentPane().add(btn_ajouter);

		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(547, 426, 89, 23);
		getContentPane().add(btnAnnuler);

		JScrollPane spLocataire = new JScrollPane();
		spLocataire.setEnabled(false);
		spLocataire.setBounds(26, 31, 832, 121);
		getContentPane().add(spLocataire);

		table_Locataire = new JTable();
		table_Locataire.setModel(new DefaultTableModel(
				new Object[][] {
						{ null, null, null, null, null, null, },
						{ null, null, null, null, null, null, },
						{ null, null, null, null, null, null, },
						{ null, null, null, null, null, null, },
						{ null, null, null, null, null, null, },
						{ null, null, null, null, null, null, },
						{ null, null, null, null, null, null, },
						{ null, null, null, null, null, null, },
						{ null, null, null, null, null, null, },
						{ null, null, null, null, null, null, },
						{ null, null, null, null, null, null, },
						{ null, null, null, null, null, null, },
						{ null, null, null, null, null, null, },
						{ null, null, null, null, null, null, },
						{ null, null, null, null, null, null, },
						{ null, null, null, null, null, null, },
						{ null, null, null, null, null, null, },
						{ null, null, null, null, null, null, },
						{ null, null, null, null, null, null, },
						{ null, null, null, null, null, null, },
				},
				new String[] {
						"nLocataire", "nom", "prenom", "dateFact", "telephone", "genre", "Logement", "Contrat",
				}));
		spLocataire.setViewportView(table_Locataire);

		JScrollPane spContrat = new JScrollPane();
		spContrat.setEnabled(false);
		spContrat.setBounds(26, 196, 618, 203);
		getContentPane().add(spContrat);

		table_Contrat = new JTable();
		table_Contrat.setModel(new DefaultTableModel(
				new Object[][] {
						{ null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null },
				},
				new String[] {
						"Num\u00E9ro contrat", "Prise effet", "Dur\u00E9e", "Charge", "Loyer", "Date r\u00E9vision",
						"P\u00E9riodicit\u00E9", "Date paiement", "Paiement", "Date EDL", "Montant caution",
						"Fin contrat", "Logement"
				}));
		spContrat.setViewportView(table_Contrat);

		JLabel lblLocataire = new JLabel("Locataire");
		lblLocataire.setBounds(26, 10, 45, 13);
		getContentPane().add(lblLocataire);

		JLabel lblAssurance = new JLabel("Assurance");
		lblAssurance.setBounds(654, 177, 76, 13);
		getContentPane().add(lblAssurance);

		JScrollPane spAssurance = new JScrollPane();
		spAssurance.setEnabled(false);
		spAssurance.setBounds(654, 196, 204, 52);
		getContentPane().add(spAssurance);

		table_Documents = new JTable();
		table_Documents.setModel(new DefaultTableModel(
				new Object[][] {
						{ null, null },
						{ null, null },
				},
				new String[] {
						"Ann\u00E9e", "Certificat"
				}));
		spAssurance.setViewportView(table_Documents);

		JLabel lblContrat = new JLabel("Contrat");
		lblContrat.setBounds(26, 177, 76, 13);
		getContentPane().add(lblContrat);

		btnSpprimer = new JButton("Supprimer");
		btnSpprimer.setBounds(402, 426, 89, 23);
		getContentPane().add(btnSpprimer);

		btnCharger = new JButton("Charger");
		btnCharger.setBounds(500, 426, 89, 23);
		getContentPane().add(btnCharger);

		btnModifier = new JButton("Modifier");
		btnModifier.setBounds(242, 426, 89, 23);
		getContentPane().add(btnModifier);

		filter = new JCheckBox("Locataires Actuels");
		filter.setBounds(242, 376, 300, 23);
		getContentPane().add(filter);
		this.controlleur = new GestionLocataire(this);
		btn_ajouter.addActionListener(controlleur);
		btnCharger.addActionListener(controlleur);
		btnModifier.addActionListener(controlleur);
		btnSpprimer.addActionListener(controlleur);
		btnAnnuler.addActionListener(controlleur);
	}

	public JTable getTable_Locataire() {
		return this.table_Locataire;
	}

	public JButton[] getChangeableButtons() {
		return new JButton[] { this.btnSpprimer, this.btnModifier };
	}

	public boolean isCheck() {
		return this.filter.isSelected();
	}
}
