package Vue;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import Controlleur.GestionLogement;
import Controlleur.Table.GestionTableLogement;

public class FEN_Logement extends JInternalFrame {
	private JTable table_Logement;

	public JTable getTable_Logement() {
		return table_Logement;
	}

	private JTable table_Immeuble;
	private JTable table_Locataire;
	private GestionLogement controlleur;
	private JButton btnAjouter;
	private JButton btnCharger;
	private JButton btnModifier;
	private JButton btnSupprimer;
	private GestionTableLogement gestionTable;

	public FEN_Logement() {
		setBounds(0, 0, 1247, 504);
		getContentPane().setLayout(null);

		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(869, 409, 119, 23);
		getContentPane().add(btnAnnuler);

		JScrollPane spLogement = new JScrollPane();
		spLogement.setEnabled(false);
		spLogement.setBounds(25, 31, 537, 145);
		getContentPane().add(spLogement);

		table_Logement = new JTable();
		table_Logement.setModel(new DefaultTableModel(
				new Object[][] {
						{ null, null, null, null, null },
						{ null, null, null, null, null },
						{ null, null, null, null, null },
						{ null, null, null, null, null },
						{ null, null, null, null, null },
						{ null, null, null, null, null },
						{ null, null, null, null, null },
						{ null, null, null, null, null },
						{ null, null, null, null, null },
						{ null, null, null, null, null },
						{ null, null, null, null, null },
						{ null, null, null, null, null },
						{ null, null, null, null, null },
						{ null, null, null, null, null },
						{ null, null, null, null, null },
						{ null, null, null, null, null },
						{ null, null, null, null, null },
						{ null, null, null, null, null },
						{ null, null, null, null, null },
						{ null, null, null, null, null },
				},
				new String[] {
						"Num\u00E9ro", "Type Habitation", "Surface", "nbPiece", "Immeuble"
				}));
		spLogement.setViewportView(table_Logement);

		JScrollPane spImmeuble = new JScrollPane();
		spImmeuble.setEnabled(false);
		spImmeuble.setBounds(25, 220, 930, 160);
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

		JScrollPane spLocataire = new JScrollPane();
		spLocataire.setEnabled(false);
		spLocataire.setBounds(620, 31, 560, 104);
		getContentPane().add(spLocataire);

		table_Locataire = new JTable();
		table_Locataire.setModel(new DefaultTableModel(
				new Object[][] {
						{ null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null },
				},
				new String[] {
						"Num\u00E9ro locataire", "nom", "prenom", "dateFact", "telephone", "genre", "Logement",
						"Contrat"
				}));
		spLocataire.setViewportView(table_Locataire);

		JLabel lblLogement = new JLabel("Logement");
		lblLogement.setBounds(25, 10, 90, 13);
		getContentPane().add(lblLogement);

		JLabel lblImmeuble = new JLabel("Immeuble");
		lblImmeuble.setBounds(25, 197, 69, 13);
		getContentPane().add(lblImmeuble);

		JLabel lblLocataire = new JLabel("Locataire");
		lblLocataire.setBounds(620, 10, 69, 13);
		getContentPane().add(lblLocataire);

		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(647, 409, 119, 23);
		getContentPane().add(btnSupprimer);

		btnModifier = new JButton("Modifier");
		btnModifier.setBounds(383, 410, 119, 23);
		getContentPane().add(btnModifier);

		btnCharger = new JButton("Charger");
		btnCharger.setBounds(283, 410, 119, 23);
		getContentPane().add(btnCharger);

		btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(183, 410, 119, 23);
		getContentPane().add(btnAjouter);

		this.controlleur = new GestionLogement(this);
		btnSupprimer.addActionListener(controlleur);
		btnAnnuler.addActionListener(controlleur);
		btnCharger.addActionListener(controlleur);
		btnAjouter.addActionListener(controlleur);
		btnModifier.addActionListener(controlleur);

		this.gestionTable = new GestionTableLogement(this.controlleur, table_Immeuble, table_Locataire);
		this.getTable_Logement().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.getTable_Logement().getSelectionModel().addListSelectionListener(gestionTable);
	}

	public JButton[] getChangeableButtons() {
		return new JButton[] { this.btnSupprimer, this.btnModifier };
	}
}
