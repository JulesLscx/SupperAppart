package Vue.Ajout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controlleur.Ajout.GestionAjoutPaiements;
import Modele.Paiements;

public class FEN_Ajout_Paiements extends JInternalFrame {

	private GestionAjoutPaiements controlleur;
	private JTextField text_Montant;
	private JTextField text_Mode_Paiements;
	private JTextField text_Date;
	private JLabel lbl_ID_Contrat;
	private JComboBox comboBox_ID_Contrat;
	private JTextField text_ID_Paiements;

	public FEN_Ajout_Paiements(Paiements toEdit) {
		init();
		this.text_Montant.setText(Float.toString(toEdit.getMontant()));
		this.text_Mode_Paiements.setText(toEdit.getMoyen_paiement());
		this.text_Date.setText(toEdit.getDate().toString());
		// this.comboBox_ID_Contrat.setToolTipText(toEdit.getContrat());
		this.text_ID_Paiements.setText(toEdit.getId_paiements());
	}

	/**
	 * Create the frame.
	 */
	public FEN_Ajout_Paiements() {
		init();
	}

	private void init() {
		setBounds(100, 100, 611, 414);
		getContentPane().setLayout(null);

		JLabel lbl_Date = new JLabel("Date :");
		lbl_Date.setBounds(330, 62, 190, 13);
		getContentPane().add(lbl_Date);

		JLabel lbl_ID_Paiements = new JLabel("Identifiant paiements : ");
		lbl_ID_Paiements.setBounds(35, 20, 190, 13);
		getContentPane().add(lbl_ID_Paiements);

		text_Montant = new JTextField();
		text_Montant.setColumns(10);
		text_Montant.setBounds(35, 76, 190, 19);
		getContentPane().add(text_Montant);

		text_Mode_Paiements = new JTextField();
		text_Mode_Paiements.setColumns(10);
		text_Mode_Paiements.setBounds(35, 118, 190, 19);
		getContentPane().add(text_Mode_Paiements);

		JLabel lbl_Mode_Paiements = new JLabel("Moyen de paiement :");
		lbl_Mode_Paiements.setBounds(35, 104, 190, 13);
		getContentPane().add(lbl_Mode_Paiements);

		JLabel lbl_Montant = new JLabel("Montant :");
		lbl_Montant.setBounds(35, 62, 190, 13);
		getContentPane().add(lbl_Montant);

		text_Date = new JTextField();
		text_Date.setColumns(10);
		text_Date.setBounds(330, 76, 190, 19);
		getContentPane().add(text_Date);

		JButton btn_Valider = new JButton("Valider");
		btn_Valider.setBounds(435, 118, 85, 21);
		getContentPane().add(btn_Valider);

		JButton btn_Annuler = new JButton("Annuler");
		btn_Annuler.setBounds(330, 118, 85, 21);
		getContentPane().add(btn_Annuler);

		lbl_ID_Contrat = new JLabel("Identifiant contrat :");
		lbl_ID_Contrat.setBounds(330, 20, 190, 13);
		getContentPane().add(lbl_ID_Contrat);

		comboBox_ID_Contrat = new JComboBox();
		comboBox_ID_Contrat.setBounds(330, 34, 121, 19);
		getContentPane().add(comboBox_ID_Contrat);

		text_ID_Paiements = new JTextField();
		text_ID_Paiements.setColumns(10);
		text_ID_Paiements.setBounds(35, 34, 190, 19);
		getContentPane().add(text_ID_Paiements);
	}

}
