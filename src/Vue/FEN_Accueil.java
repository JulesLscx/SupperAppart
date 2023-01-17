package Vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import Controlleur.GestionPrincipale;

@SuppressWarnings("serial")
public class FEN_Accueil extends JFrame {
	private Boolean ouverte;
	private GestionPrincipale controlleur;
	private boolean estConnecte;
	private JMenu mnContrats;
	private JMenu mnLocataires;
	private JMenu mnDiagnostics;
	private JMenu mnHabitat;
	private JMenu mnFactures;
	private JMenu mnRecap;
	// private JMenu mnPages;
	private JMenuItem mtm_deconnecter;
	private JMenuItem mtm_connecter;
	private JMenuItem mntmEntrepreneurs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FEN_Accueil frame = new FEN_Accueil();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FEN_Accueil() {
		ouverte = false;
		this.controlleur = new GestionPrincipale(this);

		setBounds(0, 0, 1280, 720);
		getContentPane().setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		// mnPages = new JMenu("Pages");
		// menuBar.add(mnPages);

		// JMenuItem mntmDashBoard = new JMenuItem("Accueil");
		// mntmDashBoard.addActionListener(controlleur);
		// mnPages.add(mntmDashBoard);

		// JMenuItem mntmModifier = new JMenuItem("Modifier la base");
		// mntmModifier.addActionListener(controlleur);
		// mnPages.add(mntmModifier);
		// mntmModifier.setEnabled(false);

		// JMenuItem mntmContacts = new JMenuItem("Contacts");
		// mntmContacts.addActionListener(controlleur);
		// mnPages.add(mntmContacts);

		mnFactures = new JMenu("Factures");
		mnFactures.addActionListener(controlleur);
		menuBar.add(mnFactures);

		JMenuItem mtnFac_Charges = new JMenuItem("Factures charges");
		mtnFac_Charges.addActionListener(controlleur);
		mnFactures.add(mtnFac_Charges);

		JMenuItem mntmFacture_Immeuble = new JMenuItem("Facture Travaux Immeuble");
		mntmFacture_Immeuble.addActionListener(controlleur);
		mnFactures.add(mntmFacture_Immeuble);

		JMenuItem mntmFacture_Travaux = new JMenuItem("Facture Travaux Logement");
		mntmFacture_Travaux.addActionListener(controlleur);
		mnFactures.add(mntmFacture_Travaux);

		JMenuItem mntmType_Facture = new JMenuItem("Type Facture");
		mntmType_Facture.addActionListener(controlleur);
		mnFactures.add(mntmType_Facture);

		JMenuItem mntmCoef = new JMenuItem("Répartition charges");
		mntmCoef.addActionListener(controlleur);
		mnFactures.add(mntmCoef);

		mnRecap = new JMenu("Déclaration");
		menuBar.add(mnRecap);

		JMenuItem mntmRecap = new JMenuItem("Récapitulatif par année");
		mntmRecap.addActionListener(controlleur);
		mnRecap.add(mntmRecap);

		mnHabitat = new JMenu("Habitat");
		mnHabitat.addActionListener(controlleur);
		menuBar.add(mnHabitat);

		JMenuItem mntmLogements = new JMenuItem("Logements");
		mntmLogements.addActionListener(controlleur);
		mnHabitat.add(mntmLogements);

		JMenuItem mntmImmeuble = new JMenuItem("Immeubles");
		mntmImmeuble.addActionListener(controlleur);
		mnHabitat.add(mntmImmeuble);

		JMenuItem mntmAssurance_Immeuble = new JMenuItem("Assurance Immeuble");
		mntmAssurance_Immeuble.addActionListener(controlleur);
		mnHabitat.add(mntmAssurance_Immeuble);

		mnDiagnostics = new JMenu("Diagnostics");
		mnHabitat.add(mnDiagnostics);

		JMenuItem mntmDiagnostics = new JMenuItem("Diagnostics");
		mntmDiagnostics.addActionListener(controlleur);
		mnDiagnostics.add(mntmDiagnostics);

		JMenuItem mntmType_Diagnostics = new JMenuItem("Type Diagnostics");
		mntmType_Diagnostics.addActionListener(controlleur);
		mnDiagnostics.add(mntmType_Diagnostics);

		mnLocataires = new JMenu("Locataires");
		mnLocataires.addActionListener(controlleur);
		menuBar.add(mnLocataires);

		JMenuItem mntmLocataires = new JMenuItem("Locataires");
		mntmLocataires.addActionListener(controlleur);
		mnLocataires.add(mntmLocataires);

		JMenuItem mntmDocuments = new JMenuItem("Documents Annuels");
		mntmDocuments.addActionListener(controlleur);
		mnLocataires.add(mntmDocuments);

		mnContrats = new JMenu("Contrats");
		mnContrats.addActionListener(controlleur);
		menuBar.add(mnContrats);

		JMenuItem mntmContrats = new JMenuItem("Contrats");
		mntmContrats.addActionListener(controlleur);
		mnContrats.add(mntmContrats);

		JMenuItem mntmPaiements = new JMenuItem("Paiements");
		mntmPaiements.addActionListener(controlleur);
		mnContrats.add(mntmPaiements);

		JMenuItem mntmCautions = new JMenuItem("Cautions");
		mntmCautions.addActionListener(controlleur);
		mnContrats.add(mntmCautions);

		JMenuItem mntmRegularisation = new JMenuItem("Regularisation");
		mntmRegularisation.addActionListener(controlleur);
		mnContrats.add(mntmRegularisation);

		mntmEntrepreneurs = new JMenuItem("Entrepreneurs");
		mntmEntrepreneurs.addActionListener(controlleur);
		menuBar.add(mntmEntrepreneurs);

		JMenu men_connexion = new JMenu("Connexion");
		menuBar.add(men_connexion);

		mtm_deconnecter = new JMenuItem("D\u00E9connecter");
		mtm_deconnecter.addActionListener(this.controlleur);
		men_connexion.add(mtm_deconnecter);

		mtm_connecter = new JMenuItem("Connecter");
		mtm_connecter.addActionListener(this.controlleur);
		men_connexion.add(mtm_connecter);

		JPanel tables = new JPanel();
		tables.setBounds(10, 10, 1246, 641);
		getContentPane().add(tables);
		tables.setLayout(new BorderLayout(0, 0));

		this.activerItems(false);
	}

	public void switchOuverte() {
		ouverte = !ouverte;
	}

	public boolean getOuverte() {
		return ouverte;
	}

	public void activerItems(boolean b) {
		this.setEstConnecte(b);
		this.mnDiagnostics.setEnabled(estConnecte);
		this.mnContrats.setEnabled(estConnecte);
		this.mnFactures.setEnabled(estConnecte);
		this.mnHabitat.setEnabled(estConnecte);
		this.mnRecap.setEnabled(estConnecte);
		this.mnLocataires.setEnabled(estConnecte);
		this.mntmEntrepreneurs.setEnabled(estConnecte);
		System.out.println("test");
	}

	public boolean isConnecte() {
		return estConnecte;
	}

	public void setEstConnecte(boolean estConnecte) {
		this.estConnecte = estConnecte;
	}

}
