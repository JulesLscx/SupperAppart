package Vue.Ajout;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controlleur.Ajout.GestionAjoutCaution;
import Controlleur.Ajout.GestionAjoutCoef;
import Modele.Caution;
import Modele.Coef;

public class FEN_Ajout_Coefficient extends JInternalFrame {

	/**
	 * Launch the application.
	 */

	private GestionAjoutCoef controlleur;
	private JTextField text_Type_Fac;
	private JLabel lbl_Type_Fac;
	private JTextField text_Num_Logement;
	private Coef caution;
	private JTextField text_Coefficient;

	/**
	 * Create the frame.
	 */
	public FEN_Ajout_Coefficient() {
		init();
	}

	public FEN_Ajout_Coefficient(Coef toEdit) {
		init();
		this.caution = toEdit;
		this.text_Num_Logement.setText(toEdit.getNum().getNum());
		this.text_Type_Fac.setText(toEdit.getTf().getTypeF());
		this.text_Coefficient.setText(toEdit.getCoefficient().toString());
	}

	private void init() {
		setBounds(100, 100, 611, 180);
		getContentPane().setLayout(null);

		JLabel lbl_Num_Logement = new JLabel("N° logement :");
		lbl_Num_Logement.setBounds(35, 20, 190, 13);
		getContentPane().add(lbl_Num_Logement);

		text_Type_Fac = new JTextField();
		text_Type_Fac.setColumns(10);
		text_Type_Fac.setBounds(330, 34, 190, 19);
		getContentPane().add(text_Type_Fac);

		JLabel lbl_Coefficient = new JLabel("Coefficient :");
		lbl_Coefficient.setBounds(35, 62, 190, 13);
		getContentPane().add(lbl_Coefficient);

		JButton btn_Valider = new JButton("Valider");
		btn_Valider.setBounds(435, 76, 85, 21);
		getContentPane().add(btn_Valider);

		JButton btn_Annuler = new JButton("Annuler");
		btn_Annuler.setBounds(330, 76, 85, 21);
		getContentPane().add(btn_Annuler);

		lbl_Type_Fac = new JLabel("Type de facture :");
		lbl_Type_Fac.setBounds(330, 20, 190, 13);
		getContentPane().add(lbl_Type_Fac);

		text_Num_Logement = new JTextField();
		text_Num_Logement.setColumns(10);
		text_Num_Logement.setBounds(35, 34, 190, 19);
		getContentPane().add(text_Num_Logement);

		text_Coefficient = new JTextField();
		text_Coefficient.setColumns(10);
		text_Coefficient.setBounds(35, 76, 190, 19);
		getContentPane().add(text_Coefficient);

		controlleur = new GestionAjoutCoef(this);
		btn_Valider.addActionListener(controlleur);
		btn_Annuler.addActionListener(controlleur);
	}

	public GestionAjoutCoef getControlleur() {
		return controlleur;
	}

	public void setControlleur(GestionAjoutCoef controlleur) {
		this.controlleur = controlleur;
	}

	public JTextField getText_Coefficient() {
		return text_Coefficient;
	}

	public void setText_Coefficient(JTextField text_Coefficient) {
		this.text_Coefficient = text_Coefficient;
	}

	public JTextField getText_Type_Fac() {
		return text_Type_Fac;
	}

	public void setText_Type_Fac(JTextField text_Type_Fac) {
		this.text_Type_Fac = text_Type_Fac;
	}

	public JLabel getLbl_Nom() {
		return lbl_Type_Fac;
	}

	public void setLbl_Nom(JLabel lbl_Nom) {
		this.lbl_Type_Fac = lbl_Nom;
	}

	public JTextField getText_Num_Logement() {
		return text_Num_Logement;
	}

	public void setText_Num_Logement(JTextField text_Num_Logement) {
		this.text_Num_Logement = text_Num_Logement;
	}

	public boolean isCoefSet() {
		return this.caution != null;
	}
}