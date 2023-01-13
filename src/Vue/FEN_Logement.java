package Vue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Controlleur.GestionLogement;

public class FEN_Logement extends JInternalFrame {
	private JTable table_TypeFacture;
	private JTable table_Immeuble;
	private JTable table_Locataire;
	private GestionLogement controlleur;
	

	public FEN_Logement() {
		setBounds(0, 0, 1247, 504);
		getContentPane().setLayout(null);

		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(181, 409, 89, 23);
		getContentPane().add(btnValider);

		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(869, 409, 89, 23);
		getContentPane().add(btnAnnuler);

		JScrollPane spLogement = new JScrollPane();
		spLogement.setEnabled(false);
		spLogement.setBounds(25, 31, 537, 145);
		getContentPane().add(spLogement);

		table_TypeFacture = new JTable();
		table_TypeFacture.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Num\u00E9ro", "Type Habitation", "Locataire", "Surface", "nbPiece", "Immeuble"
			}
		));
		spLogement.setViewportView(table_TypeFacture);
		
		JScrollPane spImmeuble = new JScrollPane();
		spImmeuble.setEnabled(false);
		spImmeuble.setBounds(25, 220, 930, 160);
		getContentPane().add(spImmeuble);

		table_Immeuble = new JTable();
		table_Immeuble.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Identifiant", "Adresse", "P\u00E9riode de construction", "Num\u00E9ro", "CP", "Ville", "Copropri\u00E9taire", "Accessoire commun"
			}
		));
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
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Num\u00E9ro locataire", "nom", "prenom", "dateFact", "telephone", "genre", "Logement", "Contrat"
			}
		));
		spLocataire.setViewportView(table_Locataire);
		
		JLabel lblLogement = new JLabel("Logement");
		lblLogement.setBounds(25, 10, 45, 13);
		getContentPane().add(lblLogement);
		
		JLabel lblImmeuble = new JLabel("Immeuble");
		lblImmeuble.setBounds(25, 197, 69, 13);
		getContentPane().add(lblImmeuble);
		
		JLabel lblLocataire = new JLabel("Locataire");
		lblLocataire.setBounds(620, 10, 69, 13);
		getContentPane().add(lblLocataire);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(647, 409, 89, 23);
		getContentPane().add(btnSupprimer);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setBounds(383, 410, 89, 23);
		getContentPane().add(btnModifier);

		this.controlleur = new GestionLogement(this);
		btnValider.addActionListener(controlleur);
		btnAnnuler.addActionListener(controlleur);
	}
}
