package Vue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import Controlleur.GestionContacts;

@SuppressWarnings("serial")
public class FEN_Contacts extends JInternalFrame {
	private Boolean ouverte;
	private JTable table;
	private GestionContacts controlleur;

	public FEN_Contacts() {
		ouverte = false;
		this.controlleur = new GestionContacts(this);
		setBounds(0, 0, 1280, 720);
		getContentPane().setLayout(null);

		// JMenuBar menuBar = new JMenuBar();
		// setJMenuBar(menuBar);

		// JMenu mnPages = new JMenu("Pages");
		// mnPages.addActionListener(controlleur);
		// menuBar.add(mnPages);

		// JMenuItem mntmDashBoard = new JMenuItem("Accueil");
		// mntmDashBoard.addActionListener(this);
		// mnPages.add(mntmDashBoard);

		// JMenuItem mntmDonnee = new JMenuItem("Donnee");
		// mntmDonnee.addActionListener(controlleur);
		// mnPages.add(mntmDonnee);

		// JMenuItem mntmModifier = new JMenuItem("Modifier la base");
		// mntmModifier.addActionListener(controlleur);
		// mnPages.add(mntmModifier);

		// JMenuItem mntmContacts = new JMenuItem("Contacts");
		// mntmContacts.addActionListener(controlleur);
		// mnPages.add(mntmContacts);
		// mntmContacts.setEnabled(false);

		// JMenu mnTableau = new JMenu("Tableau");
		// mnTableau.addActionListener(controlleur);
		// menuBar.add(mnTableau);
		// mnTableau.setEnabled(false);

		// JMenu mnFactures = new JMenu("Factures");
		// mnFactures.addActionListener(controlleur);
		// mnTableau.add(mnFactures);

		// JMenuItem mntmFacture_Immeuble = new JMenuItem("Facture Immeuble");
		// mntmFacture_Immeuble.addActionListener(controlleur);
		// mnFactures.add(mntmFacture_Immeuble);

		// JMenuItem mntmFacture_Travaux = new JMenuItem("Facture Travaux");
		// mntmFacture_Travaux.addActionListener(controlleur);
		// mnFactures.add(mntmFacture_Travaux);

		// JMenuItem mntmType_Facture = new JMenuItem("Type Facture");
		// mntmType_Facture.addActionListener(controlleur);
		// mnFactures.add(mntmType_Facture);

		// JMenu mnHabitacle = new JMenu("Habitacle");
		// mnHabitacle.addActionListener(controlleur);
		// mnTableau.add(mnHabitacle);

		// JMenuItem mntmLogements = new JMenuItem("Logements");
		// mntmLogements.addActionListener(controlleur);
		// mnHabitacle.add(mntmLogements);

		// JMenuItem mntmImmeuble = new JMenuItem("Immeubles");
		// mntmImmeuble.addActionListener(controlleur);
		// mnHabitacle.add(mntmImmeuble);

		// JMenuItem mntmAssurance_Immeuble = new JMenuItem("Assurance Immeuble");
		// mntmAssurance_Immeuble.addActionListener(controlleur);
		// mnHabitacle.add(mntmAssurance_Immeuble);

		// JMenu mnDiagnostics = new JMenu("Diagnostics");
		// mnHabitacle.add(mnDiagnostics);

		// JMenuItem mntmDiagnostics = new JMenuItem("Diagnostics");
		// mntmDiagnostics.addActionListener(controlleur);
		// mnDiagnostics.add(mntmDiagnostics);

		// JMenuItem mntmType_Diagnostics = new JMenuItem("Type Diagnostics");
		// mntmType_Diagnostics.addActionListener(controlleur);
		// mnDiagnostics.add(mntmType_Diagnostics);

		// JMenu mnLocataires = new JMenu("Locataires");
		// mnLocataires.addActionListener(controlleur);
		// mnTableau.add(mnLocataires);

		// JMenuItem mntmLocataires = new JMenuItem("Locataires");
		// mntmLocataires.addActionListener(controlleur);
		// mnLocataires.add(mntmLocataires);

		// JMenuItem mntmDocuments = new JMenuItem("Documents Annuels");
		// mntmDocuments.addActionListener(controlleur);
		// mnLocataires.add(mntmDocuments);

		// JMenu mnContrats = new JMenu("Contrats");
		// mnContrats.addActionListener(controlleur);
		// mnTableau.add(mnContrats);

		// JMenuItem mntmContrats = new JMenuItem("Contrats");
		// mntmContrats.addActionListener(controlleur);
		// mnContrats.add(mntmContrats);

		// JMenuItem mntmPaiements = new JMenuItem("Paiements");
		// mntmPaiements.addActionListener(controlleur);
		// mnContrats.add(mntmPaiements);

		// JMenuItem mntmCautions = new JMenuItem("Cautions");
		// mntmCautions.addActionListener(controlleur);
		// mnContrats.add(mntmCautions);

		// JMenuItem mntmRegularisation = new JMenuItem("Regularisation");
		// mntmRegularisation.addActionListener(this);
		// mnContrats.add(mntmRegularisation);

		// JMenuItem mntmEntrepreneurs = new JMenuItem("Entrepreneurs");
		// mntmEntrepreneurs.addActionListener(this);
		// mnTableau.add(mntmEntrepreneurs);

		// JMenu mnAction = new JMenu("Action");
		// mnAction.addActionListener(this);
		// menuBar.add(mnAction);

		// JMenuItem mntmAjouter = new JMenuItem("Ajouter Contacts");
		// mntmAjouter.addActionListener(this);
		// mnAction.add(mntmAjouter);

		// JMenuItem mntmSupprimer = new JMenuItem("Supprimer Contacts");
		// mntmSupprimer.addActionListener(this);
		// mnAction.add(mntmSupprimer);

		JScrollPane spFactureExistante = new JScrollPane();
		spFactureExistante.setEnabled(false);
		spFactureExistante.setBounds(10, 10, 798, 641);
		getContentPane().add(spFactureExistante);

		JTable table_contacts = new JTable();
		table_contacts.setModel(new DefaultTableModel(
				new Object[][] {
						{ null, null, null, null, },
						{ null, null, null, null, },
						{ null, null, null, null, },
						{ null, null, null, null, },
						{ null, null, null, null, },
						{ null, null, null, null, },
						{ null, null, null, null, },
						{ null, null, null, null, },
						{ null, null, null, null, },
						{ null, null, null, null, },
						{ null, null, null, null, },
						{ null, null, null, null, },
						{ null, null, null, null, },
						{ null, null, null, null, },
						{ null, null, null, null, },
						{ null, null, null, null, },
						{ null, null, null, null, },
						{ null, null, null, null, },
						{ null, null, null, null, },
						{ null, null, null, null, },
						{ null, null, null, null, },
						{ null, null, null, null, },
						{ null, null, null, null, },
						{ null, null, null, null, },
						{ null, null, null, null, },
						{ null, null, null, null, },
						{ null, null, null, null, },
						{ null, null, null, null, },
						{ null, null, null, null, },
						{ null, null, null, null, },
						{ null, null, null, null, },
						{ null, null, null, null, },
						{ null, null, null, null, },
						{ null, null, null, null, },
				},
				new String[] {
						"Libelle", "Telephone", "Email", "Adresse",
				}));
		spFactureExistante.setViewportView(table_contacts);

		JTextArea descriptif = new JTextArea();
		descriptif.setBounds(818, 281, 412, 370);
		getContentPane().add(descriptif);

		JPanel photo = new JPanel();
		photo.setBounds(818, 29, 412, 252);
		getContentPane().add(photo);

	}

}
