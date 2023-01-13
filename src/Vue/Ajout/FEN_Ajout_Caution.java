package Vue.Ajout;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controlleur.Ajout.GestionAjoutCaution;
import Modele.Caution;

public class FEN_Ajout_Caution extends JInternalFrame {

	/**
	 * Launch the application.
	 */

	private GestionAjoutCaution controlleur;
	private JTextField text_Prenom;
	private JTextField text_Profession;
	private JTextField text_Email;
	private JTextField text_Nom;
	private JTextField text_Adresse;
	private JTextField text_Telephone;
	private JLabel lbl_Telephone;
	private JLabel lbl_Nom;
	private JTextField text_ID_Caution;
	private Caution caution;

	/**
	 * Create the frame.
	 */
	public FEN_Ajout_Caution() {
		init();
	}

	public FEN_Ajout_Caution(Caution toEdit) {
		init();
		this.caution = toEdit;
		this.text_ID_Caution.setText(toEdit.getId_Caution());
		this.text_ID_Caution.setEditable(false);
		this.text_Prenom.setText(toEdit.getPrenom());
		this.text_Profession.setText(toEdit.getProfession());
		this.text_Email.setText(toEdit.getEmail());
		this.text_Nom.setText(toEdit.getNom());
		this.text_Adresse.setText(toEdit.getAdresse());
		this.text_Telephone.setText(toEdit.getTelephone());
	}

	private void init() {
		setBounds(100, 100, 611, 414);
		getContentPane().setLayout(null);

		JLabel lbl_Adresse = new JLabel("Adresse");
		lbl_Adresse.setBounds(330, 62, 190, 13);
		getContentPane().add(lbl_Adresse);

		JLabel lbl_ID_Caution = new JLabel("Identifiant caution : ");
		lbl_ID_Caution.setBounds(35, 20, 190, 13);
		getContentPane().add(lbl_ID_Caution);

		text_Prenom = new JTextField();
		text_Prenom.setColumns(10);
		text_Prenom.setBounds(35, 76, 190, 19);
		getContentPane().add(text_Prenom);

		JLabel lbl_Profession = new JLabel("Profession :");
		lbl_Profession.setBounds(35, 146, 190, 13);
		getContentPane().add(lbl_Profession);

		text_Profession = new JTextField();
		text_Profession.setColumns(10);
		text_Profession.setBounds(35, 160, 190, 19);
		getContentPane().add(text_Profession);

		text_Email = new JTextField();
		text_Email.setColumns(10);
		text_Email.setBounds(35, 118, 190, 19);
		getContentPane().add(text_Email);

		JLabel lbl_Email = new JLabel("Email :");
		lbl_Email.setBounds(35, 104, 190, 13);
		getContentPane().add(lbl_Email);

		text_Nom = new JTextField();
		text_Nom.setColumns(10);
		text_Nom.setBounds(330, 34, 190, 19);
		getContentPane().add(text_Nom);

		JLabel lbl_Prenom = new JLabel("Pr\u00E9nom");
		lbl_Prenom.setBounds(35, 62, 190, 13);
		getContentPane().add(lbl_Prenom);

		text_Adresse = new JTextField();
		text_Adresse.setColumns(10);
		text_Adresse.setBounds(330, 76, 190, 19);
		getContentPane().add(text_Adresse);

		text_Telephone = new JTextField();
		text_Telephone.setColumns(10);
		text_Telephone.setBounds(330, 118, 190, 19);
		getContentPane().add(text_Telephone);

		lbl_Telephone = new JLabel("T\u00E9l\u00E9phone :");
		lbl_Telephone.setBounds(330, 104, 190, 13);
		getContentPane().add(lbl_Telephone);

		JButton btn_Valider = new JButton("Valider");
		btn_Valider.setBounds(435, 160, 85, 21);
		getContentPane().add(btn_Valider);

		JButton btn_Annuler = new JButton("Annuler");
		btn_Annuler.setBounds(330, 160, 85, 21);
		getContentPane().add(btn_Annuler);

		lbl_Nom = new JLabel("Nom :");
		lbl_Nom.setBounds(330, 20, 190, 13);
		getContentPane().add(lbl_Nom);

		text_ID_Caution = new JTextField();
		text_ID_Caution.setColumns(10);
		text_ID_Caution.setBounds(35, 34, 190, 19);
		getContentPane().add(text_ID_Caution);

		controlleur = new GestionAjoutCaution(this);
		btn_Valider.addActionListener(controlleur);
		btn_Annuler.addActionListener(controlleur);
	}

	public GestionAjoutCaution getControlleur() {
		return controlleur;
	}

	public void setControlleur(GestionAjoutCaution controlleur) {
		this.controlleur = controlleur;
	}

	public JTextField getText_Prenom() {
		return text_Prenom;
	}

	public void setText_Prenom(JTextField text_Prenom) {
		this.text_Prenom = text_Prenom;
	}

	public JTextField getText_Profession() {
		return text_Profession;
	}

	public void setText_Profession(JTextField text_Profession) {
		this.text_Profession = text_Profession;
	}

	public JTextField getText_Email() {
		return text_Email;
	}

	public void setText_Email(JTextField text_Email) {
		this.text_Email = text_Email;
	}

	public JTextField getText_Nom() {
		return text_Nom;
	}

	public void setText_Nom(JTextField text_Nom) {
		this.text_Nom = text_Nom;
	}

	public JTextField getText_Adresse() {
		return text_Adresse;
	}

	public void setText_Adresse(JTextField text_Adresse) {
		this.text_Adresse = text_Adresse;
	}

	public JTextField getText_Telephone() {
		return text_Telephone;
	}

	public void setText_Telephone(JTextField text_Telephone) {
		this.text_Telephone = text_Telephone;
	}

	public JLabel getLbl_Telephone() {
		return lbl_Telephone;
	}

	public void setLbl_Telephone(JLabel lbl_Telephone) {
		this.lbl_Telephone = lbl_Telephone;
	}

	public JLabel getLbl_Nom() {
		return lbl_Nom;
	}

	public void setLbl_Nom(JLabel lbl_Nom) {
		this.lbl_Nom = lbl_Nom;
	}

	public JTextField getText_ID_Caution() {
		return text_ID_Caution;
	}

	public void setText_ID_Caution(JTextField text_ID_Caution) {
		this.text_ID_Caution = text_ID_Caution;
	}

	public boolean isCautionSet() {
		return this.caution != null;
	}

}
