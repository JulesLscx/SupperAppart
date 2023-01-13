package Vue.Ajout;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controlleur.Ajout.GestionAjoutEntrepreneur;
import Modele.Entrepreneur;

public class FEN_Ajout_Entrepreneur extends JInternalFrame {

	/**
	 * Launch the application.
	 */

	private GestionAjoutEntrepreneur controlleur;
	private JTextField text_Adresse;
	private JTextField text_Secteur_Activite;
	private JTextField text_N_SIREN;
	private JTextField text_IBAN;
	private JLabel lbl_N_SIREN;
	private JTextField text_Nom;

	public FEN_Ajout_Entrepreneur(Entrepreneur toEdit) {
		init();
		this.text_Adresse.setText(toEdit.getAdresse());
		this.text_Secteur_Activite.setText(toEdit.getSecteur_activite());
		this.text_N_SIREN.setText(toEdit.getnSiren());
		this.text_IBAN.setText(toEdit.getIban());
		this.text_Nom.setText(toEdit.getNom());
	}

	/**
	 * Create the frame.
	 */
	public FEN_Ajout_Entrepreneur() {
		init();
	}

	private void init() {
		setBounds(100, 100, 611, 414);
		getContentPane().setLayout(null);

		JLabel lbl_IBAN = new JLabel("IBAN :");
		lbl_IBAN.setBounds(330, 62, 190, 13);
		getContentPane().add(lbl_IBAN);

		JLabel lbl_Nom = new JLabel("Nom");
		lbl_Nom.setBounds(35, 20, 190, 13);
		getContentPane().add(lbl_Nom);

		text_Adresse = new JTextField();
		text_Adresse.setColumns(10);
		text_Adresse.setBounds(35, 76, 190, 19);
		getContentPane().add(text_Adresse);

		text_Secteur_Activite = new JTextField();
		text_Secteur_Activite.setColumns(10);
		text_Secteur_Activite.setBounds(35, 118, 190, 19);
		getContentPane().add(text_Secteur_Activite);

		JLabel lbl_Secteur_Activite = new JLabel("Secteur d'activit\u00E9 :");
		lbl_Secteur_Activite.setBounds(35, 104, 190, 13);
		getContentPane().add(lbl_Secteur_Activite);

		text_N_SIREN = new JTextField();
		text_N_SIREN.setColumns(10);
		text_N_SIREN.setBounds(330, 34, 190, 19);
		getContentPane().add(text_N_SIREN);

		JLabel lbl_Adresse = new JLabel("Adresse :");
		lbl_Adresse.setBounds(35, 62, 190, 13);
		getContentPane().add(lbl_Adresse);

		text_IBAN = new JTextField();
		text_IBAN.setColumns(10);
		text_IBAN.setBounds(330, 76, 190, 19);
		getContentPane().add(text_IBAN);

		JButton btn_Valider = new JButton("Valider");
		btn_Valider.setBounds(435, 118, 85, 21);
		getContentPane().add(btn_Valider);

		JButton btn_Annuler = new JButton("Annuler");
		btn_Annuler.setBounds(330, 118, 85, 21);
		getContentPane().add(btn_Annuler);

		lbl_N_SIREN = new JLabel("N\u00B0SIREN :");
		lbl_N_SIREN.setBounds(330, 20, 190, 13);
		getContentPane().add(lbl_N_SIREN);

		text_Nom = new JTextField();
		text_Nom.setColumns(10);
		text_Nom.setBounds(35, 34, 190, 19);
		getContentPane().add(text_Nom);
	}

}
