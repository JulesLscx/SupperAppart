package Vue.Ajout;

import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controlleur.Ajout.GestionAjoutPaiements;
import Modele.Contrat;
import Modele.Paiements;
import Modele.DAO.DaoContrat;
import Vue.FEN_Erreurs;

public class FEN_Ajout_Paiements extends JInternalFrame {

	private GestionAjoutPaiements controlleur;
	private JTextField text_Montant;
	private JTextField text_Mode_Paiements;
	private JTextField text_Date;
	private JLabel lbl_ID_Contrat;
	private JComboBox<String> comboBox_ID_Contrat;
	private JTextField text_ID_Paiements;
	private Paiements paiements;

	public FEN_Ajout_Paiements(Paiements toEdit) {
		init();
		this.text_Montant.setText(Float.toString(toEdit.getMontant()));
		this.text_Mode_Paiements.setText(toEdit.getMoyen_paiement());
		this.text_Date.setText(toEdit.getDate().toString());
		this.comboBox_ID_Contrat.setSelectedItem(toEdit.getContrat().getId_contrat());
		this.text_ID_Paiements.setText(toEdit.getId_paiements());
		this.paiements = toEdit;
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

		comboBox_ID_Contrat = new JComboBox<String>();
		comboBox_ID_Contrat.setBounds(330, 34, 121, 19);
		getContentPane().add(comboBox_ID_Contrat);

		text_ID_Paiements = new JTextField();
		text_ID_Paiements.setColumns(10);
		text_ID_Paiements.setBounds(35, 34, 190, 19);
		getContentPane().add(text_ID_Paiements);

		this.controlleur = new GestionAjoutPaiements(this);
		btn_Annuler.addActionListener(controlleur);
		btn_Valider.addActionListener(controlleur);

		this.fillComboContrat();
	}

	private void fillComboContrat() {
		try {
			for (Contrat c : new DaoContrat().findAll()) {
				this.comboBox_ID_Contrat.addItem(c.getId_contrat());
			}
		} catch (SQLException e) {
			new FEN_Erreurs("Impossible de remplir le combo des contrats car problème dans la base de données", this);
		}
	}

	public boolean isPaiementSet() {
		return paiements != null;
	}

	public GestionAjoutPaiements getControlleur() {
		return controlleur;
	}

	public JTextField getText_Montant() {
		return text_Montant;
	}

	public JTextField getText_Mode_Paiements() {
		return text_Mode_Paiements;
	}

	public JTextField getText_Date() {
		return text_Date;
	}

	public JLabel getLbl_ID_Contrat() {
		return lbl_ID_Contrat;
	}

	public JComboBox<String> getComboBox_ID_Contrat() {
		return comboBox_ID_Contrat;
	}

	public JTextField getText_ID_Paiements() {
		return text_ID_Paiements;
	}

}
