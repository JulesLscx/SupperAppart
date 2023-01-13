package Vue.Ajout;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
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
	private JComboBox comboBox_ID_Immeuble;
	private JTextField text_Adresse;

	public FEN_Ajout_Immeuble(Immeuble toEdit) {
		init();
		this.text_Access_Com.setText(toEdit.getAccess_com());
		this.text_Ville.setText(toEdit.getVille());
		this.text_Pde_Constr.setText(toEdit.getPde_constr());
		this.text_CP.setText(toEdit.getCp());
		this.text_Copro.setText(Integer.toString(toEdit.getCopro()));
		this.comboBox_ID_Immeuble.setToolTipText(toEdit.getId_immeuble());
		this.text_Adresse.setText(toEdit.getAdresse());
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FEN_Ajout_Immeuble frame = new FEN_Ajout_Immeuble();
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

		comboBox_ID_Immeuble = new JComboBox();
		comboBox_ID_Immeuble.setBounds(35, 34, 121, 19);
		getContentPane().add(comboBox_ID_Immeuble);

		text_Adresse = new JTextField();
		text_Adresse.setColumns(10);
		text_Adresse.setBounds(330, 34, 190, 19);
		getContentPane().add(text_Adresse);

		JComboBox comboBox_Num_batiment = new JComboBox();
		comboBox_Num_batiment.setBounds(35, 76, 121, 19);
		getContentPane().add(comboBox_Num_batiment);
	}
}