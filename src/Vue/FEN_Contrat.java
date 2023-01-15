package Vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controlleur.GestionContrat;

public class FEN_Contrat extends JInternalFrame {
	private JTable table_Contrat;
	private GestionContrat controlleur;
	private JTable table_Locataire;
	private JTable table_Paiment;
	private JTable table_Logement;
	private JTable table_Caution;
	private JButton btnAnnuler;
	private JButton btnModifier;
	private JButton btnAjouter;
	private JButton btnSupprimer;
	private JButton btn_charger;

	public FEN_Contrat() {
		setBounds(0, 0, 1026, 509);
		getContentPane().setLayout(null);

		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(713, 411, 119, 23);
		getContentPane().add(btnAnnuler);

		JScrollPane spContrat = new JScrollPane();
		spContrat.setEnabled(false);
		spContrat.setBounds(28, 25, 618, 203);
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
						"Fin contrat", "Logement", "Entrepreuneur", "Caution"
				}));
		spContrat.setViewportView(table_Contrat);

		btnModifier = new JButton("Modifier");
		btnModifier.setBounds(342, 411, 119, 23);
		getContentPane().add(btnModifier);

		btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(177, 411, 119, 23);
		getContentPane().add(btnAjouter);

		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(527, 411, 119, 23);
		getContentPane().add(btnSupprimer);

		btn_charger = new JButton("Charger");
		btn_charger.setBounds(787, 411, 119, 23);
		getContentPane().add(btn_charger);

		JLabel lblContrat = new JLabel("Contrats");
		lblContrat.setBounds(28, 10, 84, 13);
		getContentPane().add(lblContrat);

		JLabel lblPaiement = new JLabel("Paiement");
		lblPaiement.setBounds(688, 27, 84, 13);
		getContentPane().add(lblPaiement);

		JScrollPane spLocataire = new JScrollPane();
		spLocataire.setEnabled(false);
		spLocataire.setBounds(28, 264, 343, 79);
		getContentPane().add(spLocataire);

		table_Locataire = new JTable();
		table_Locataire.setModel(new DefaultTableModel(
				new Object[][] {
						{ null, null, null, null },
						{ null, null, null, null },
						{ null, null, null, null },
				},
				new String[] {
						"Num\u00E9ro locataire", "Nom", "Pr\u00E9nom", "T\u00E9l\u00E9phone"
				}));
		table_Locataire.getColumnModel().getColumn(0).setPreferredWidth(99);
		table_Locataire.getColumnModel().getColumn(1).setPreferredWidth(55);
		table_Locataire.getColumnModel().getColumn(2).setPreferredWidth(67);
		spLocataire.setViewportView(table_Locataire);

		JLabel lblLocataire_1 = new JLabel("Locataire");
		lblLocataire_1.setBounds(28, 248, 84, 13);
		getContentPane().add(lblLocataire_1);

		JScrollPane spPaiement = new JScrollPane();
		spPaiement.setEnabled(false);
		spPaiement.setBounds(689, 39, 260, 79);
		getContentPane().add(spPaiement);

		table_Paiment = new JTable();
		table_Paiment.setModel(new DefaultTableModel(
				new Object[][] {
						{ null, null, null },
						{ null, null, null },
				},
				new String[] {
						"Montant", "Date paiement", "Moyen de paiement"
				}));
		table_Paiment.getColumnModel().getColumn(1).setPreferredWidth(87);
		table_Paiment.getColumnModel().getColumn(2).setPreferredWidth(106);
		spPaiement.setViewportView(table_Paiment);

		JLabel lblLogement = new JLabel("Logement");
		lblLogement.setBounds(428, 248, 67, 13);
		getContentPane().add(lblLogement);

		JScrollPane spLogement = new JScrollPane();
		spLogement.setEnabled(false);
		spLogement.setBounds(428, 264, 458, 68);
		getContentPane().add(spLogement);

		table_Logement = new JTable();
		table_Logement.setModel(new DefaultTableModel(
				new Object[][] {
						{ null, null, null, null },
						{ null, null, null, null },
						{ null, null, null, null },
				},
				new String[] {
						"Num\u00E9ro habitation", "Type d'habitation", "Surface", "Nombre de pi\u00E8ce"
				}));
		table_Logement.getColumnModel().getColumn(0).setPreferredWidth(98);
		table_Logement.getColumnModel().getColumn(1).setPreferredWidth(93);
		spLogement.setViewportView(table_Logement);

		JLabel lblCaution = new JLabel("Caution");
		lblCaution.setBounds(668, 138, 45, 13);
		getContentPane().add(lblCaution);

		JScrollPane spCaution = new JScrollPane();
		spCaution.setEnabled(false);
		spCaution.setBounds(667, 156, 321, 79);
		getContentPane().add(spCaution);

		table_Caution = new JTable();
		table_Caution.setModel(new DefaultTableModel(
				new Object[][] {
						{ null, null, null, null, null, null },
						{ null, null, null, null, null, null },
				},
				new String[] {
						"Nnm\u00E9ro caution", "Nom ", "Pr\u00E9nom", "Adresse", "T\u00E9l\u00E9phone", "Profession"
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

	public JTable getTable_Paiment() {
		return table_Paiment;
	}

	public JTable getTable_Logement() {
		return table_Logement;
	}

	public JTable getTable_Caution() {
		return table_Caution;
	}

	public JButton[] getChangeableButtons() {
		return new JButton[] { this.btnModifier, btnSupprimer };
	}
}
