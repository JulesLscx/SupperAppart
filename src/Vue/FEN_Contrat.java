package Vue;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controlleur.GestionContrat;
import Controlleur.Table.GestionTableContrat;

public class FEN_Contrat extends JInternalFrame {
	private JTable table_Contrat;
	private GestionContrat controlleur;
	private JTable table_Locataire;
	private JTable table_Caution;
	private JButton btnAnnuler;
	private JButton btnModifier;
	private JButton btnAjouter;
	private JButton btnSupprimer;
	private JButton btn_charger;
	private GestionTableContrat gestionTable;

	public FEN_Contrat() {
		setBounds(0, 0, 1150, 650);
		getContentPane().setLayout(null);

		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(658, 520, 119, 23);
		getContentPane().add(btnAnnuler);

		JScrollPane spContrat = new JScrollPane();
		spContrat.setEnabled(false);
		spContrat.setBounds(28, 25, 1080, 274);
		getContentPane().add(spContrat);

		table_Contrat = new JTable();
		table_Contrat.setModel(new DefaultTableModel(
				new Object[][] {
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, "", null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null },
				},
				new String[] {
						"N\u00B0 Contrat", "Prise effet", "Dur\u00E9e", "Charge", "Loyer", "Date r\u00E9vision",
						"P\u00E9riodicit\u00E9", "Date paiement", "Paiement", "Date EDL", "Montant caution",
						"Fin contrat", "Logement", "Entrepreuneur", "Caution"
				}));
		table_Contrat.getColumnModel().getColumn(0).setPreferredWidth(65);
		table_Contrat.getColumnModel().getColumn(1).setPreferredWidth(70);
		table_Contrat.getColumnModel().getColumn(2).setPreferredWidth(65);
		table_Contrat.getColumnModel().getColumn(3).setPreferredWidth(60);
		table_Contrat.getColumnModel().getColumn(4).setPreferredWidth(60);
		table_Contrat.getColumnModel().getColumn(5).setPreferredWidth(90);
		table_Contrat.getColumnModel().getColumn(6).setPreferredWidth(70);
		table_Contrat.getColumnModel().getColumn(7).setPreferredWidth(90);
		table_Contrat.getColumnModel().getColumn(8).setPreferredWidth(65);
		table_Contrat.getColumnModel().getColumn(9).setPreferredWidth(65);
		table_Contrat.getColumnModel().getColumn(10).setPreferredWidth(95);
		table_Contrat.getColumnModel().getColumn(11).setPreferredWidth(65);
		table_Contrat.getColumnModel().getColumn(12).setPreferredWidth(65);
		table_Contrat.getColumnModel().getColumn(13).setPreferredWidth(85);
		table_Contrat.getColumnModel().getColumn(14).setPreferredWidth(65);
		spContrat.setViewportView(table_Contrat);

		btnModifier = new JButton("Modifier");
		btnModifier.setBounds(316, 520, 119, 23);
		getContentPane().add(btnModifier);

		btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(145, 520, 119, 23);
		getContentPane().add(btnAjouter);

		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(487, 520, 119, 23);
		getContentPane().add(btnSupprimer);

		btn_charger = new JButton("Charger");
		btn_charger.setBounds(829, 520, 119, 23);
		getContentPane().add(btn_charger);

		JLabel lblContrat = new JLabel("Contrats");
		lblContrat.setBounds(28, 10, 84, 13);
		getContentPane().add(lblContrat);

		JScrollPane spLocataire = new JScrollPane();
		spLocataire.setEnabled(false);
		spLocataire.setBounds(28, 326, 484, 162);
		getContentPane().add(spLocataire);

		table_Locataire = new JTable();
		table_Locataire.setModel(new DefaultTableModel(
				new Object[][] {
						{ null, null, null, null, null },
						{ null, null, null, null, null },
						{ null, null, null, null, null },
				},
				new String[] {
						"N° locataire", "Nom", "Pr\u00E9nom", "T\u00E9l\u00E9phone", "VEVE"
				}));
		table_Locataire.getColumnModel().getColumn(0).setPreferredWidth(99);
		table_Locataire.getColumnModel().getColumn(1).setPreferredWidth(55);
		table_Locataire.getColumnModel().getColumn(2).setPreferredWidth(67);
		spLocataire.setViewportView(table_Locataire);

		JLabel lblLocataire_1 = new JLabel("Locataire");
		lblLocataire_1.setBounds(28, 310, 84, 13);
		getContentPane().add(lblLocataire_1);

		JLabel lblCaution = new JLabel("Caution");
		lblCaution.setBounds(587, 310, 45, 13);
		getContentPane().add(lblCaution);

		JScrollPane spCaution = new JScrollPane();
		spCaution.setEnabled(false);
		spCaution.setBounds(587, 326, 521, 162);
		getContentPane().add(spCaution);

		table_Caution = new JTable();
		table_Caution.setModel(new DefaultTableModel(
				new Object[][] {
						{ null, null, null, null, null, null },
						{ null, null, null, null, null, null },
				},
				new String[] {
						"N° caution", "Nom ", "Pr\u00E9nom", "Adresse", "T\u00E9l\u00E9phone", "Profession"
				}));
		table_Caution.getColumnModel().getColumn(0).setPreferredWidth(86);
		table_Caution.getColumnModel().getColumn(1).setPreferredWidth(66);
		spCaution.setViewportView(table_Caution);

		this.controlleur = new GestionContrat(this);
		btnAnnuler.addActionListener(controlleur);
		btnAjouter.addActionListener(controlleur);
		btnSupprimer.addActionListener(controlleur);
		btnModifier.addActionListener(controlleur);
		btn_charger.addActionListener(controlleur);

		this.gestionTable = new GestionTableContrat(controlleur, table_Caution, table_Locataire);
		this.getTable_Contrat().getSelectionModel().addListSelectionListener(gestionTable);
	}

	public JTable getTable_Contrat() {
		return table_Contrat;
	}

	public GestionContrat getControlleur() {
		return controlleur;
	}

	public JTable getTable_Locataire() {
		return table_Locataire;
	}

	public JTable getTable_Caution() {
		return table_Caution;
	}

	public JButton[] getChangeableButtons() {
		return new JButton[] { this.btnModifier, btnSupprimer };
	}
}
