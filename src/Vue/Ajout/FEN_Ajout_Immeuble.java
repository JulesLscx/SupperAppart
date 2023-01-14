package Vue.Ajout;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controlleur.Ajout.GestionAjoutImmeuble;
import Modele.Immeuble;

public class FEN_Ajout_Immeuble extends JInternalFrame {

	/**
	 * Launch the application.
	 */

	private GestionAjoutImmeuble controlleur;
	private JTextField text_Access_Com;
	private JTextField text_Ville;
	private JTextField text_Pde_Constr;
	private JLabel lbl_Copro;
	private JTextField text_CP;
	private JLabel lbl_CP;
	private JTextField text_Copro;
	private JLabel lbl_Adresse;
	private JTextField text_ID_Immeuble;
	private JTextField text_Adresse;
	private Immeuble toEdit;
	private JTextField text_Num_batiment;

	public FEN_Ajout_Immeuble(Immeuble toEdit) {
		init();
		this.text_Access_Com.setText(toEdit.getAccess_com());
		this.text_Ville.setText(toEdit.getVille());
		this.text_Pde_Constr.setText(toEdit.getPde_constr());
		this.text_CP.setText(toEdit.getCp());
		this.text_Copro.setText(Integer.toString(toEdit.getCopro()));
		this.text_ID_Immeuble.setText(toEdit.getId_immeuble());
		this.text_Num_batiment.setText(toEdit.getNum_bat());
		this.text_Adresse.setText(toEdit.getAdresse());
		this.toEdit = toEdit;
	}

	/**
	 * Create the frame.
	 */
	public FEN_Ajout_Immeuble() {
		init();
	}

	private void init() {
		setBounds(100, 100, 611, 414);
		getContentPane().setLayout(null);

		JLabel lbl_Pde_Constr = new JLabel("P\u00E9riode de construction :");
		lbl_Pde_Constr.setBounds(330, 62, 190, 13);
		getContentPane().add(lbl_Pde_Constr);

		JLabel lbl_ID_Immeuble = new JLabel("Identifiant immeuble : ");
		lbl_ID_Immeuble.setBounds(35, 20, 190, 13);
		getContentPane().add(lbl_ID_Immeuble);

		JLabel lbl_Access_Com = new JLabel("Accessoires communs :");
		lbl_Access_Com.setBounds(35, 146, 190, 13);
		getContentPane().add(lbl_Access_Com);

		text_Access_Com = new JTextField();
		text_Access_Com.setColumns(10);
		text_Access_Com.setBounds(35, 160, 190, 19);
		getContentPane().add(text_Access_Com);

		text_Ville = new JTextField();
		text_Ville.setColumns(10);
		text_Ville.setBounds(35, 118, 190, 19);
		getContentPane().add(text_Ville);

		JLabel lbl_Ville = new JLabel("Ville :");
		lbl_Ville.setBounds(35, 104, 190, 13);
		getContentPane().add(lbl_Ville);

		JLabel lbl_Num_batiment = new JLabel("Num\u00E9ro batiment :");
		lbl_Num_batiment.setBounds(35, 62, 190, 13);
		getContentPane().add(lbl_Num_batiment);

		text_Pde_Constr = new JTextField();
		text_Pde_Constr.setColumns(10);
		text_Pde_Constr.setBounds(330, 76, 190, 19);
		getContentPane().add(text_Pde_Constr);

		lbl_Copro = new JLabel("Co-propri\u00E9t\u00E9 :");
		lbl_Copro.setBounds(330, 146, 190, 13);
		getContentPane().add(lbl_Copro);

		text_CP = new JTextField();
		text_CP.setColumns(10);
		text_CP.setBounds(330, 118, 190, 19);
		getContentPane().add(text_CP);

		lbl_CP = new JLabel("Code Postal :");
		lbl_CP.setBounds(330, 104, 190, 13);
		getContentPane().add(lbl_CP);

		text_Copro = new JTextField();
		text_Copro.setColumns(10);
		text_Copro.setBounds(330, 160, 190, 19);
		getContentPane().add(text_Copro);

		JButton btn_Valider = new JButton("Valider");
		btn_Valider.setBounds(140, 190, 85, 21);
		getContentPane().add(btn_Valider);

		JButton btn_Annuler = new JButton("Annuler");
		btn_Annuler.setBounds(35, 190, 85, 21);
		getContentPane().add(btn_Annuler);

		lbl_Adresse = new JLabel("Adresse :");
		lbl_Adresse.setBounds(330, 20, 190, 13);
		getContentPane().add(lbl_Adresse);

		text_ID_Immeuble = new JTextField();
		text_ID_Immeuble.setBounds(35, 34, 121, 19);
		getContentPane().add(text_ID_Immeuble);

		text_Adresse = new JTextField();
		text_Adresse.setColumns(10);
		text_Adresse.setBounds(330, 34, 190, 19);
		getContentPane().add(text_Adresse);

		text_Num_batiment = new JTextField();
		text_Num_batiment.setBounds(35, 76, 121, 19);
		getContentPane().add(text_Num_batiment);

		this.controlleur = new GestionAjoutImmeuble(this);
		btn_Annuler.addActionListener(controlleur);
		btn_Valider.addActionListener(controlleur);
	}

	public boolean isImmeubleSet() {
		return this.toEdit != null;
	}

	public GestionAjoutImmeuble getControlleur() {
		return controlleur;
	}

	public JTextField getText_Access_Com() {
		return text_Access_Com;
	}

	public JTextField getText_Ville() {
		return text_Ville;
	}

	public JTextField getText_Pde_Constr() {
		return text_Pde_Constr;
	}

	public JLabel getLbl_Copro() {
		return lbl_Copro;
	}

	public JTextField getText_CP() {
		return text_CP;
	}

	public JLabel getLbl_CP() {
		return lbl_CP;
	}

	public JTextField getText_Copro() {
		return text_Copro;
	}

	public JLabel getLbl_Adresse() {
		return lbl_Adresse;
	}

	public JTextField getText_ID_Immeuble() {
		return text_ID_Immeuble;
	}

	public JTextField getText_Adresse() {
		return text_Adresse;
	}

	public Immeuble getToEdit() {
		return toEdit;
	}

	public JTextField getText_Num_batiment() {
		return text_Num_batiment;
	}
}