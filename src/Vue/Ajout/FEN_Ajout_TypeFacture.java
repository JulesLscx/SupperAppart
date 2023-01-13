package Vue.Ajout;

import java.awt.EventQueue;

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

	public FEN_Ajout_TypeFacture(Type_Fac toEdit) {
		init();
		this.text_Unite.setText(toEdit.getUnite());
		this.text_Periodicite.setText(toEdit.getPeriodicite());
		this.text_Type_fac.setText(toEdit.getTypeF());
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

		JButton btn_Valider = new JButton("Valider");
		btn_Valider.setBounds(435, 76, 85, 21);
		getContentPane().add(btn_Valider);

		JButton btn_Annuler = new JButton("Annuler");
		btn_Annuler.setBounds(330, 76, 85, 21);
		getContentPane().add(btn_Annuler);

		lbl_Periodicite = new JLabel("Périodicité :");
		lbl_Periodicite.setBounds(330, 20, 190, 13);
		getContentPane().add(lbl_Periodicite);

		text_Type_fac = new JTextField();
		text_Type_fac.setColumns(10);
		text_Type_fac.setBounds(35, 34, 190, 19);
		getContentPane().add(text_Type_fac);
	}

}
