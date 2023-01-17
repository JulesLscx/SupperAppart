package Vue.Ajout;

import java.sql.SQLException;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controlleur.Ajout.GestionAjoutFactureTravauxImmeuble;
import Modele.Entrepreneur;
import Modele.Facture_Travaux_Immeuble;
import Modele.Immeuble;
import Modele.DAO.DaoEntrepreuneur;
import Modele.DAO.DaoImmeuble;
import Vue.FEN_Erreurs;

public class FEN_Ajout_FactureTravauxImmeuble extends JInternalFrame {

	/**
	 * Launch the application.
	 */

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
	private JComboBox<String> comboBox_Entrepreneur;
	private JComboBox<String> comboBox_ID_Immeuble;
	private JTextField text_Num_Fac;
	private Facture_Travaux_Immeuble fac;

	public FEN_Ajout_FactureTravauxImmeuble(Facture_Travaux_Immeuble toEdit) {
		init();
		this.text_Num_Cheque.setText(toEdit.getNumero_du_cheque());
		this.text_Reduction.setText(Float.toString(toEdit.getReduction()));
		this.text_Prix.setText(Float.toString(toEdit.getPrix()));
		this.text_Ordre_Cheque.setText(toEdit.getOrdre_du_cheque());
		this.text_Montant_Indeductible.setText(Float.toString(toEdit.getMontant_indeductible()));
		this.text_Date_Paiement.setText(toEdit.getDate_de_paiement().toString());
		this.text_Nature.setText(toEdit.getNature());
		this.comboBox_Entrepreneur.setSelectedItem(toEdit.getEntrepreneur().getnSiren());
		this.comboBox_ID_Immeuble.setSelectedItem(toEdit.getImmeuble().getId_immeuble());
		this.text_Num_Fac.setText(toEdit.getNum_fac());
		this.fac = toEdit;
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

		comboBox_Entrepreneur = new JComboBox<String>();
		comboBox_Entrepreneur.setBounds(330, 202, 121, 19);
		getContentPane().add(comboBox_Entrepreneur);

		comboBox_ID_Immeuble = new JComboBox<String>();
		comboBox_ID_Immeuble.setBounds(35, 202, 121, 19);
		getContentPane().add(comboBox_ID_Immeuble);

		text_Num_Fac = new JTextField();
		text_Num_Fac.setColumns(10);
		text_Num_Fac.setBounds(35, 34, 190, 19);
		getContentPane().add(text_Num_Fac);
		this.fillEntrepreneur();
		this.fillImmeuble();

		this.controlleur = new GestionAjoutFactureTravauxImmeuble(this);
		btn_Annuler.addActionListener(controlleur);
		btn_Valider.addActionListener(controlleur);
	}

	private void fillEntrepreneur() {
		DaoEntrepreuneur dao = new DaoEntrepreuneur();
		Collection<Entrepreneur> lesEnt = null;
		try {
			lesEnt = dao.findAll();
		} catch (SQLException e1) {
			new FEN_Erreurs(e1.getMessage(), this);
		}
		for (Entrepreneur e : lesEnt) {
			this.comboBox_Entrepreneur.addItem(e.getnSiren());
		}
	}

	private void fillImmeuble() {
		DaoImmeuble dao = new DaoImmeuble();
		Collection<Immeuble> lesEnt = null;
		try {
			lesEnt = dao.findAll();
		} catch (SQLException e1) {
			new FEN_Erreurs(e1.getMessage(), this);
		}
		for (Immeuble i : lesEnt) {
			this.comboBox_ID_Immeuble.addItem(i.getId_immeuble());
		}
	}

	public boolean isFacSet() {
		return this.fac != null;
	}

	public GestionAjoutFactureTravauxImmeuble getControlleur() {
		return controlleur;
	}

	public JTextField getText_Num_Cheque() {
		return text_Num_Cheque;
	}

	public JTextField getText_Reduction() {
		return text_Reduction;
	}

	public JTextField getText_Prix() {
		return text_Prix;
	}

	public JTextField getText_Ordre_Cheque() {
		return text_Ordre_Cheque;
	}

	public JLabel getLbl_Date_Paiement() {
		return lbl_Date_Paiement;
	}

	public JTextField getText_Montant_Indeductible() {
		return text_Montant_Indeductible;
	}

	public JLabel getLbl_Montant_Indeductible() {
		return lbl_Montant_Indeductible;
	}

	public JTextField getText_Date_Paiement() {
		return text_Date_Paiement;
	}

	public JLabel getLbl_Entrepreneur() {
		return lbl_Entrepreneur;
	}

	public JTextField getText_Nature() {
		return text_Nature;
	}

	public JLabel getLbl_Nature() {
		return lbl_Nature;
	}

	public JComboBox<String> getComboBox_Entrepreneur() {
		return comboBox_Entrepreneur;
	}

	public JComboBox<String> getComboBox_ID_Immeuble() {
		return comboBox_ID_Immeuble;
	}

	public JTextField getText_Num_Fac() {
		return text_Num_Fac;
	}

	public Object getFac() {
		return fac;
	}

}
