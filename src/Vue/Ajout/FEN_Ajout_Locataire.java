package Vue.Ajout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controlleur.Ajout.GestionAjoutLocataire;
import Modele.Locataire;

public class FEN_Ajout_Locataire extends JInternalFrame {

	/**
	 * Launch the application.
	 */

	private GestionAjoutLocataire controlleur;
	private JTextField text_Nom;
	private JComboBox<Character> text_Genre;
	private JTextField text_Email;
	private JTextField text_Prenom;
	private JTextField text_Telephone;
	private JLabel lblDatePaiement;
	private JLabel lbl_Num_Logement;
	private JTextField text_Num_Locataire;
	private Locataire locataire;

	public FEN_Ajout_Locataire(Locataire toEdit) {
		init();
		this.text_Nom.setText(toEdit.getNom());
		this.text_Genre.setSelectedItem(toEdit.getGenre());
		this.text_Email.setText(toEdit.getEmail());
		this.text_Prenom.setText(toEdit.getPrenom());
		this.text_Telephone.setText(toEdit.getTel());
		this.text_Num_Locataire.setText(toEdit.getnLocataire());
		this.locataire = toEdit;
	}

	/**
	 * Create the frame.
	 */
	public FEN_Ajout_Locataire() {
		init();
	}

	private void init() {
		setBounds(100, 100, 611, 414);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Pr\u00E9nom :");
		lblNewLabel.setBounds(330, 62, 190, 13);
		getContentPane().add(lblNewLabel);

		JLabel lbl_Num_Locataire = new JLabel("Num\u00E9ro de locataire :");
		lbl_Num_Locataire.setBounds(35, 20, 190, 13);
		getContentPane().add(lbl_Num_Locataire);

		text_Nom = new JTextField();
		text_Nom.setColumns(10);
		text_Nom.setBounds(35, 76, 190, 19);
		getContentPane().add(text_Nom);

		JLabel lblLoyer = new JLabel("Genre :");
		lblLoyer.setBounds(35, 146, 190, 13);
		getContentPane().add(lblLoyer);

		text_Genre = new JComboBox<Character>();
		text_Genre.addItem('M');
		text_Genre.addItem('F');
		text_Genre.addItem('A');
		text_Genre.setBounds(35, 160, 190, 19);
		getContentPane().add(text_Genre);

		text_Email = new JTextField();
		text_Email.setColumns(10);
		text_Email.setBounds(35, 118, 190, 19);
		getContentPane().add(text_Email);

		JLabel lblPaiement = new JLabel("Email :");
		lblPaiement.setBounds(35, 104, 190, 13);
		getContentPane().add(lblPaiement);

		JLabel lblIdentifiantContrat_1 = new JLabel("Nom :");
		lblIdentifiantContrat_1.setBounds(35, 62, 190, 13);
		getContentPane().add(lblIdentifiantContrat_1);

		text_Prenom = new JTextField();
		text_Prenom.setColumns(10);
		text_Prenom.setBounds(330, 76, 190, 19);
		getContentPane().add(text_Prenom);

		text_Telephone = new JTextField();
		text_Telephone.setColumns(10);
		text_Telephone.setBounds(330, 118, 190, 19);
		getContentPane().add(text_Telephone);

		lblDatePaiement = new JLabel("T\u00E9l\u00E9phone :");
		lblDatePaiement.setBounds(330, 104, 190, 13);
		getContentPane().add(lblDatePaiement);

		JButton btn_Valider = new JButton("Valider");
		btn_Valider.setBounds(435, 160, 85, 21);
		getContentPane().add(btn_Valider);

		JButton btn_Annuler = new JButton("Annuler");
		btn_Annuler.setBounds(330, 160, 85, 21);
		getContentPane().add(btn_Annuler);

		lbl_Num_Logement = new JLabel("Num\u00E9ro de logement :");
		lbl_Num_Logement.setBounds(330, 20, 190, 13);
		getContentPane().add(lbl_Num_Logement);

		text_Num_Locataire = new JTextField();
		text_Num_Locataire.setColumns(10);
		text_Num_Locataire.setBounds(35, 34, 190, 19);
		getContentPane().add(text_Num_Locataire);

		this.controlleur = new GestionAjoutLocataire(this);
		btn_Annuler.addActionListener(controlleur);
		btn_Valider.addActionListener(controlleur);
	}

	public boolean isLocataireSet() {
		return this.locataire != null;
	}

	public GestionAjoutLocataire getControlleur() {
		return controlleur;
	}

	public JTextField getText_Nom() {
		return text_Nom;
	}

	public JComboBox<Character> getText_Genre() {
		return text_Genre;
	}

	public JTextField getText_Email() {
		return text_Email;
	}

	public JTextField getText_Prenom() {
		return text_Prenom;
	}

	public JTextField getText_Telephone() {
		return text_Telephone;
	}

	public JLabel getLblDatePaiement() {
		return lblDatePaiement;
	}

	public JLabel getLbl_Num_Logement() {
		return lbl_Num_Logement;
	}

	public JTextField getText_Num_Locataire() {
		return text_Num_Locataire;
	}

	public Locataire getLocataire() {
		return locataire;
	}
}