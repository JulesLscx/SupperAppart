package Vue.Ajout;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controlleur.Ajout.GestionAjoutTypeFacture;
import Modele.Type_Fac;

public class FEN_Ajout_TypeFacture extends JInternalFrame {

	/**
	 * Launch the application.
	 */

	private GestionAjoutTypeFacture controlleur;
	private JTextField text_Unite;
	private JTextField text_Periodicite;
	private JLabel lbl_Periodicite;
	private JTextField text_Type_fac;
	private JButton btn_Annuler;
	private JButton btn_Valider;
	private Type_Fac typeF;

	public FEN_Ajout_TypeFacture(Type_Fac toEdit) {
		init();
		this.text_Unite.setText(toEdit.getUnite());
		this.text_Periodicite.setText(toEdit.getPeriodicite());
		this.text_Type_fac.setText(toEdit.getTypeF());
		this.typeF = toEdit;
	}

	/**
	 * Create the frame.
	 */
	public FEN_Ajout_TypeFacture() {
		init();
	}

	private void init() {
		setBounds(100, 100, 611, 414);
		getContentPane().setLayout(null);

		JLabel lbl_Type_Fac = new JLabel("Type de facture :");
		lbl_Type_Fac.setBounds(35, 20, 190, 13);
		getContentPane().add(lbl_Type_Fac);

		text_Unite = new JTextField();
		text_Unite.setColumns(10);
		text_Unite.setBounds(35, 76, 190, 19);
		getContentPane().add(text_Unite);

		JLabel lbl_Unite = new JLabel("Unité :");
		lbl_Unite.setBounds(35, 62, 190, 13);
		getContentPane().add(lbl_Unite);

		text_Periodicite = new JTextField();
		text_Periodicite.setColumns(10);
		text_Periodicite.setBounds(330, 34, 190, 19);
		getContentPane().add(text_Periodicite);

		btn_Valider = new JButton("Valider");
		btn_Valider.setBounds(435, 76, 85, 21);
		getContentPane().add(btn_Valider);

		btn_Annuler = new JButton("Annuler");
		btn_Annuler.setBounds(330, 76, 85, 21);
		getContentPane().add(btn_Annuler);

		lbl_Periodicite = new JLabel("Périodicité :");
		lbl_Periodicite.setBounds(330, 20, 190, 13);
		getContentPane().add(lbl_Periodicite);

		text_Type_fac = new JTextField();
		text_Type_fac.setColumns(10);
		text_Type_fac.setBounds(35, 34, 190, 19);
		getContentPane().add(text_Type_fac);

		this.controlleur = new GestionAjoutTypeFacture(this);
		btn_Valider.addActionListener(controlleur);
		btn_Annuler.addActionListener(controlleur);
	}

	public boolean isType_FacSet() {
		return this.typeF != null;
	}

	public GestionAjoutTypeFacture getControlleur() {
		return controlleur;
	}

	public JTextField getText_Unite() {
		return text_Unite;
	}

	public JTextField getText_Periodicite() {
		return text_Periodicite;
	}

	public JLabel getLbl_Periodicite() {
		return lbl_Periodicite;
	}

	public JTextField getText_Type_fac() {
		return text_Type_fac;
	}

	public JButton getBtn_Annuler() {
		return btn_Annuler;
	}

	public JButton getBtn_Valider() {
		return btn_Valider;
	}

	public Type_Fac getTypeF() {
		return typeF;
	}

}
