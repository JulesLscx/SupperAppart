package Vue.Ajout;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controlleur.Ajout.GestionAjoutRegularisation;
import Modele.Regularisation;

public class FEN_Ajout_Regularisation extends JInternalFrame {

	/**
	 * Launch the application.
	 */

	private GestionAjoutRegularisation controlleur;
	private JTextField text_Date_Regu;
	private JTextField text_Montant;
	private JLabel lbl_Type_Fac;
	private JComboBox comboBox_Type_Fac;
	private JComboBox comboBox_ID_Contrat;

	public FEN_Ajout_Regularisation(Regularisation toEdit) {
		init();
		this.text_Date_Regu.setText(toEdit.getDateR().toString());
		this.text_Montant.setText(Float.toString(toEdit.getMontant()));
		// this.comboBox_Type_Fac.setToolTipText(toEdit.getTypeF());
		// this.comboBox_ID_Contrat.setToolTipText(toEdit.getContrat());
	}

	/**
	 * Create the frame.
	 */
	public FEN_Ajout_Regularisation() {
		init();
	}

	private void init() {
		setBounds(100, 100, 611, 414);
		getContentPane().setLayout(null);

		JLabel lbl_Montant = new JLabel("Montant :");
		lbl_Montant.setBounds(330, 62, 190, 13);
		getContentPane().add(lbl_Montant);

		JLabel lbl_ID_Contrat = new JLabel("Identifiant contrat : ");
		lbl_ID_Contrat.setBounds(35, 20, 190, 13);
		getContentPane().add(lbl_ID_Contrat);

		text_Date_Regu = new JTextField();
		text_Date_Regu.setColumns(10);
		text_Date_Regu.setBounds(35, 76, 190, 19);
		getContentPane().add(text_Date_Regu);

		JLabel lbl_Date_Regu = new JLabel("Date r\u00E9gularisation :");
		lbl_Date_Regu.setBounds(35, 62, 190, 13);
		getContentPane().add(lbl_Date_Regu);

		text_Montant = new JTextField();
		text_Montant.setColumns(10);
		text_Montant.setBounds(330, 76, 190, 19);
		getContentPane().add(text_Montant);

		JButton btn_Valider = new JButton("Valider");
		btn_Valider.setBounds(140, 106, 85, 21);
		getContentPane().add(btn_Valider);

		JButton btn_Annuler = new JButton("Annuler");
		btn_Annuler.setBounds(35, 106, 85, 21);
		getContentPane().add(btn_Annuler);

		lbl_Type_Fac = new JLabel("Type de facture :");
		lbl_Type_Fac.setBounds(330, 20, 190, 13);
		getContentPane().add(lbl_Type_Fac);

		comboBox_Type_Fac = new JComboBox();
		comboBox_Type_Fac.setBounds(330, 34, 121, 19);
		getContentPane().add(comboBox_Type_Fac);

		comboBox_ID_Contrat = new JComboBox();
		comboBox_ID_Contrat.setBounds(35, 34, 121, 19);
		getContentPane().add(comboBox_ID_Contrat);
	}

}
