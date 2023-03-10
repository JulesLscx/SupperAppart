package Vue;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import Controlleur.GestionImmeuble;
import Controlleur.Table.GestionTableImmeuble;
import Other.MyDefaultTableModel;

public class FEN_Immeuble extends JInternalFrame {
	private JTable table_Immeuble;
	private GestionImmeuble controlleur;
	private JTable table_AssuranceImmeuble;
	private JTable table_Logement;
	private JButton btnCharger;
	private JButton btnSupprimer;
	private JButton btnModifier;
	private GestionTableImmeuble gestionTable;

	public FEN_Immeuble() {
		setBounds(0, 0, 1048, 515);
		getContentPane().setLayout(null);

		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(53, 421, 119, 23);
		getContentPane().add(btnAjouter);

		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(721, 421, 119, 23);
		getContentPane().add(btnAnnuler);

		JScrollPane spImmeuble = new JScrollPane();
		spImmeuble.setEnabled(false);
		spImmeuble.setBounds(26, 31, 978, 160);
		getContentPane().add(spImmeuble);

		table_Immeuble = new JTable();
		table_Immeuble.setModel(new DefaultTableModel(
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
						{ null, null, null, null, null, null, null, null },
				},
				new String[] {
						"Identifiant", "Adresse", "P\u00E9riode de construction", "Num\u00E9ro", "CP", "Ville",
						"Copropri\u00E9taire", "Accessoire commun"
				}));
		table_Immeuble.getColumnModel().getColumn(2).setPreferredWidth(131);
		table_Immeuble.getColumnModel().getColumn(7).setPreferredWidth(151);
		spImmeuble.setViewportView(table_Immeuble);

		JScrollPane spAssuranceImmeuble = new JScrollPane();
		spAssuranceImmeuble.setEnabled(false);
		spAssuranceImmeuble.setBounds(574, 228, 430, 80);
		getContentPane().add(spAssuranceImmeuble);

		table_AssuranceImmeuble = new JTable();
		table_AssuranceImmeuble.setModel(new MyDefaultTableModel(
				new Object[][] {
						{ null, null, null, null },
						{ null, null, null, null },
						{ null, null, null, null },
				},
				new String[] {
						"Assurance bien", "Assurance juridique", "Annee", "Immeuble"
				}));
		table_AssuranceImmeuble.getColumnModel().getColumn(0).setPreferredWidth(99);
		table_AssuranceImmeuble.getColumnModel().getColumn(1).setPreferredWidth(101);
		spAssuranceImmeuble.setViewportView(table_AssuranceImmeuble);

		JScrollPane spLogement = new JScrollPane();
		spLogement.setEnabled(false);
		spLogement.setBounds(26, 228, 456, 125);
		getContentPane().add(spLogement);

		table_Logement = new JTable();
		table_Logement.setModel(new MyDefaultTableModel(
				new Object[][] {
						{ null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null },
				},
				new String[] {
						"Identifiant", "Adresse", "Pde construction", "Numero", "CP", "Copro", "Accessoires"
				}));
		table_Logement.getColumnModel().getColumn(2).setPreferredWidth(90);
		table_Logement.getColumnModel().getColumn(3).setPreferredWidth(65);
		table_Logement.getColumnModel().getColumn(4).setPreferredWidth(65);
		table_Logement.getColumnModel().getColumn(5).setPreferredWidth(65);
		table_Logement.getColumnModel().getColumn(6).setPreferredWidth(90);
		spLogement.setViewportView(table_Logement);

		JLabel lblImeuble = new JLabel("Immeuble");
		lblImeuble.setBounds(26, 10, 79, 13);
		getContentPane().add(lblImeuble);

		JLabel lblAssurance = new JLabel("Assurance");
		lblAssurance.setBounds(573, 205, 79, 13);
		getContentPane().add(lblAssurance);

		JLabel lblLogement = new JLabel("Logement");
		lblLogement.setBounds(26, 205, 79, 13);
		getContentPane().add(lblLogement);

		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(363, 421, 119, 23);
		getContentPane().add(btnSupprimer);

		btnModifier = new JButton("Modifier");
		btnModifier.setBounds(198, 421, 119, 23);
		getContentPane().add(btnModifier);
		btnCharger = new JButton("Charger");
		btnCharger.setBounds(545, 421, 119, 23);
		getContentPane().add(btnCharger);

		this.controlleur = new GestionImmeuble(this);
		btnAjouter.addActionListener(controlleur);
		btnAnnuler.addActionListener(controlleur);
		btnCharger.addActionListener(controlleur);
		btnModifier.addActionListener(controlleur);
		btnAjouter.addActionListener(controlleur);
		btnSupprimer.addActionListener(controlleur);

		this.gestionTable = new GestionTableImmeuble(table_Logement, table_AssuranceImmeuble, controlleur);
		this.table_Immeuble.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.table_Immeuble.getSelectionModel().addListSelectionListener(gestionTable);

	}

	public JTable getTable_Immeuble() {
		return this.table_Immeuble;
	}

	public JButton[] getChangeableButtons() {
		return new JButton[] { this.btnModifier, this.btnSupprimer };
	}

	public GestionImmeuble getControlleur() {
		return controlleur;
	}

	public JTable getTable_AssuranceImmeuble() {
		return table_AssuranceImmeuble;
	}

	public JTable getTable_Logement() {
		return table_Logement;
	}

	public JButton getBtnCharger() {
		return btnCharger;
	}

	public JButton getBtnSupprimer() {
		return btnSupprimer;
	}

	public JButton getBtnModifier() {
		return btnModifier;
	}

	public GestionTableImmeuble getGestionTable() {
		return gestionTable;
	}
}
