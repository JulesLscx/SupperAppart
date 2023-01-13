package Vue.Ajout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controlleur.Ajout.GestionAjoutFacture;
import Modele.Factures_Charges;

public class FEN_Ajout_Facture extends JInternalFrame {

	/**
	 * Launch the application.
	 */

	private GestionAjoutFacture controlleur;
	private JTextField text_Total;
	private JTextField text_Prix_U_R;
	private JTextField text_Date_Facture;
	private JTextField text_Cout_Fixe;
	private JLabel lbl_Type_Facture;
	private JTextField text_Prix_U_C;
	private JLabel lbl_Prix_U_C;
	private JLabel lbl_Date_Facture;
	private JComboBox comboBox_ID_Immeuble;
	private JComboBox comboBox_Type_Facture;
	private JTextField text_Num_Facture;

	public FEN_Ajout_Facture(Factures_Charges toEdit) {
		init();
		this.text_Total.setText(Float.toString(toEdit.getTotal()));
		this.text_Prix_U_R.setText(Float.toString(toEdit.getPrix_unite_releve()));
		this.text_Date_Facture.setText(toEdit.getDateF().toString());
		this.text_Cout_Fixe.setText(Float.toString(toEdit.getCf()));
		this.text_Prix_U_C.setText(Float.toString(toEdit.getPrix_unite_constatee()));
		// this.comboBox_ID_Immeuble.setText(toEdit.getImmeuble());
		// this.comboBox_Type_Facture.setText(toEdit.getTypeF().getTypeF());
		this.text_Num_Facture.setText(toEdit.getNumF());
	}

	/**
	 * Create the frame.
	 */
	public FEN_Ajout_Facture() {
		init();
	}

	private void init() {
		setBounds(100, 100, 611, 414);
		getContentPane().setLayout(null);

		JLabel lbl_Cout_Fixe = new JLabel("Co\u00FBt fixe :");
		lbl_Cout_Fixe.setBounds(330, 62, 190, 13);
		getContentPane().add(lbl_Cout_Fixe);

		JLabel lbl_Num_Facture = new JLabel("Num\u00E9ro facture :");
		lbl_Num_Facture.setBounds(35, 20, 190, 13);
		getContentPane().add(lbl_Num_Facture);

		text_Total = new JTextField();
		text_Total.setColumns(10);
		text_Total.setBounds(35, 76, 190, 19);
		getContentPane().add(text_Total);

		JLabel lbl_ID_Immeuble = new JLabel("Identifiant immeuble :");
		lbl_ID_Immeuble.setBounds(35, 146, 190, 13);
		getContentPane().add(lbl_ID_Immeuble);

		text_Prix_U_R = new JTextField();
		text_Prix_U_R.setColumns(10);
		text_Prix_U_R.setBounds(35, 118, 190, 19);
		getContentPane().add(text_Prix_U_R);

		JLabel lbl_Prix_U_R = new JLabel("Prix unit\u00E9 relev\u00E9 :");
		lbl_Prix_U_R.setBounds(35, 104, 190, 13);
		getContentPane().add(lbl_Prix_U_R);

		text_Date_Facture = new JTextField();
		text_Date_Facture.setColumns(10);
		text_Date_Facture.setBounds(330, 34, 190, 19);
		getContentPane().add(text_Date_Facture);

		JLabel lbl_Total = new JLabel("Total :");
		lbl_Total.setBounds(35, 62, 190, 13);
		getContentPane().add(lbl_Total);

		text_Cout_Fixe = new JTextField();
		text_Cout_Fixe.setColumns(10);
		text_Cout_Fixe.setBounds(330, 76, 190, 19);
		getContentPane().add(text_Cout_Fixe);

		lbl_Type_Facture = new JLabel("Type de facture :");
		lbl_Type_Facture.setBounds(330, 146, 190, 13);
		getContentPane().add(lbl_Type_Facture);

		text_Prix_U_C = new JTextField();
		text_Prix_U_C.setColumns(10);
		text_Prix_U_C.setBounds(330, 118, 190, 19);
		getContentPane().add(text_Prix_U_C);

		lbl_Prix_U_C = new JLabel("Prix unit\u00E9 constat\u00E9e :");
		lbl_Prix_U_C.setBounds(330, 104, 190, 13);
		getContentPane().add(lbl_Prix_U_C);

		JButton btn_Valider = new JButton("Valider");
		btn_Valider.setBounds(140, 190, 85, 21);
		getContentPane().add(btn_Valider);

		JButton btn_Annuler = new JButton("Annuler");
		btn_Annuler.setBounds(35, 190, 85, 21);
		getContentPane().add(btn_Annuler);

		lbl_Date_Facture = new JLabel("Date facture :");
		lbl_Date_Facture.setBounds(330, 20, 190, 13);
		getContentPane().add(lbl_Date_Facture);

		comboBox_ID_Immeuble = new JComboBox();
		comboBox_ID_Immeuble.setBounds(35, 160, 121, 19);
		getContentPane().add(comboBox_ID_Immeuble);

		comboBox_Type_Facture = new JComboBox();
		comboBox_Type_Facture.setBounds(330, 160, 121, 19);
		getContentPane().add(comboBox_Type_Facture);

		text_Num_Facture = new JTextField();
		text_Num_Facture.setColumns(10);
		text_Num_Facture.setBounds(35, 34, 190, 19);
		getContentPane().add(text_Num_Facture);
	}

}
