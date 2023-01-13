package Vue.Ajout;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controlleur.Ajout.GestionAjoutFactureTravauxImmeuble;
import Modele.Facture_Travaux_Immeuble;

public class FEN_Ajout_FactureTravauxImmeuble extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	private JTextField idContrat, charges, duree, priseEffet, datePaiement, periodicite, loyer, dateRevision;
	private JTextField finContrat, montantCaution, paiement, dateEDL;

	private GestionAjoutFactureTravauxImmeuble controlleur;
	private JTextField text_Num_Cheque;
	private JTextField text_Reduction;
	private JTextField text_Prix;
	private JTextField text_Ordre_Cheque;
	private JLabel lbl_Date_Paiement;
	private JTextField text_Montant_Indeductible;
	private JLabel lbl_Montant_Indeductible;
	private JTextField text_Date_Paiement;
	private JLabel lbl_Entrepreneur;
	private JTextField text_Nature;
	private JLabel lbl_Nature;
	private JComboBox comboBox_Entrepreneur;
	private JComboBox comboBox_ID_Immeuble;
	private JTextField text_Num_Fac;

	public FEN_Ajout_FactureTravauxImmeuble(Facture_Travaux_Immeuble toEdit) {
		init();
		this.text_Num_Cheque.setText(toEdit.getNumero_du_cheque());
		this.text_Reduction.setText(Float.toString(toEdit.getReduction()));
		this.text_Prix.setText(Float.toString(toEdit.getPrix()));
		this.text_Ordre_Cheque.setText(toEdit.getOrdre_du_cheque());
		this.text_Montant_Indeductible.setText(Float.toString(toEdit.getMontant_indeductible()));
		this.text_Date_Paiement.setText(toEdit.getDate_de_paiement().toString());
		this.text_Nature.setText(toEdit.getNature());
		// this.comboBox_Entrepreneur.setToolTipText(toEdit.getEntrepreneur());
		// this.comboBox_ID_Immeuble.(toEdit.getImmeuble());
		this.text_Num_Fac.setText(toEdit.getNum_fac());
	}

	/**
	 * Create the frame.
	 */
	public FEN_Ajout_FactureTravauxImmeuble() {
		init();
	}

	private void init() {
		setBounds(100, 100, 611, 414);
		getContentPane().setLayout(null);

		JLabel lbl_Ordre_Cheque = new JLabel("Ordre du ch\u00E8que :");
		lbl_Ordre_Cheque.setBounds(330, 62, 190, 13);
		getContentPane().add(lbl_Ordre_Cheque);

		JLabel lbl_Num_Fac = new JLabel("N\u00B0 Facture :");
		lbl_Num_Fac.setBounds(35, 20, 190, 13);
		getContentPane().add(lbl_Num_Fac);

		text_Num_Cheque = new JTextField();
		text_Num_Cheque.setColumns(10);
		text_Num_Cheque.setBounds(35, 76, 190, 19);
		getContentPane().add(text_Num_Cheque);

		JLabel lbl_Reduction = new JLabel("R\u00E9duction :");
		lbl_Reduction.setBounds(35, 146, 190, 13);
		getContentPane().add(lbl_Reduction);

		text_Reduction = new JTextField();
		text_Reduction.setColumns(10);
		text_Reduction.setBounds(35, 160, 190, 19);
		getContentPane().add(text_Reduction);

		JLabel lbl_ID_Immeuble = new JLabel("Identifiant immeuble :");
		lbl_ID_Immeuble.setBounds(35, 188, 190, 13);
		getContentPane().add(lbl_ID_Immeuble);

		text_Prix = new JTextField();
		text_Prix.setColumns(10);
		text_Prix.setBounds(35, 118, 190, 19);
		getContentPane().add(text_Prix);

		JLabel lbl_Prix = new JLabel("Prix :");
		lbl_Prix.setBounds(35, 104, 190, 13);
		getContentPane().add(lbl_Prix);

		JLabel lbl_Num_Cheque = new JLabel("N\u00B0 Ch\u00E8que :");
		lbl_Num_Cheque.setBounds(35, 62, 190, 13);
		getContentPane().add(lbl_Num_Cheque);

		text_Ordre_Cheque = new JTextField();
		text_Ordre_Cheque.setColumns(10);
		text_Ordre_Cheque.setBounds(330, 76, 190, 19);
		getContentPane().add(text_Ordre_Cheque);

		lbl_Date_Paiement = new JLabel("Date de paiement :");
		lbl_Date_Paiement.setBounds(330, 146, 190, 13);
		getContentPane().add(lbl_Date_Paiement);

		text_Montant_Indeductible = new JTextField();
		text_Montant_Indeductible.setColumns(10);
		text_Montant_Indeductible.setBounds(330, 118, 190, 19);
		getContentPane().add(text_Montant_Indeductible);

		lbl_Montant_Indeductible = new JLabel("Montant ind\u00E9ductible :");
		lbl_Montant_Indeductible.setBounds(330, 104, 190, 13);
		getContentPane().add(lbl_Montant_Indeductible);

		text_Date_Paiement = new JTextField();
		text_Date_Paiement.setColumns(10);
		text_Date_Paiement.setBounds(330, 160, 190, 19);
		getContentPane().add(text_Date_Paiement);

		lbl_Entrepreneur = new JLabel("Entrepreneur :");
		lbl_Entrepreneur.setBounds(330, 188, 190, 13);
		getContentPane().add(lbl_Entrepreneur);

		text_Nature = new JTextField();
		text_Nature.setColumns(10);
		text_Nature.setBounds(330, 34, 190, 19);
		getContentPane().add(text_Nature);

		JButton btn_Valider = new JButton("Valider");
		btn_Valider.setBounds(140, 230, 85, 21);
		getContentPane().add(btn_Valider);

		JButton btn_Annuler = new JButton("Annuler");
		btn_Annuler.setBounds(35, 230, 85, 21);
		getContentPane().add(btn_Annuler);

		lbl_Nature = new JLabel("Nature :");
		lbl_Nature.setBounds(330, 20, 190, 13);
		getContentPane().add(lbl_Nature);

		comboBox_Entrepreneur = new JComboBox();
		comboBox_Entrepreneur.setBounds(330, 202, 121, 19);
		getContentPane().add(comboBox_Entrepreneur);

		comboBox_ID_Immeuble = new JComboBox();
		comboBox_ID_Immeuble.setBounds(35, 202, 121, 19);
		getContentPane().add(comboBox_ID_Immeuble);

		text_Num_Fac = new JTextField();
		text_Num_Fac.setColumns(10);
		text_Num_Fac.setBounds(35, 34, 190, 19);
		getContentPane().add(text_Num_Fac);
	}

}
