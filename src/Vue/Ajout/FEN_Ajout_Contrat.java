package Vue.Ajout;

import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controlleur.Ajout.GestionAjoutContrat;
import Modele.Caution;
import Modele.Contrat;
import Modele.Entrepreneur;
import Modele.Logement;
import Modele.DAO.DaoCaution;
import Modele.DAO.DaoEntrepreuneur;
import Modele.DAO.DaoLogement;
import Vue.FEN_Erreurs;

public class FEN_Ajout_Contrat extends JInternalFrame {

	/**
	 * Launch the application.
	 */

	private GestionAjoutContrat controlleur;
	private JTextField text_Prise_effet;
	private JTextField text_Loyer;
	private JTextField text_Paiement;
	private JTextField text_Periodicite;
	private JTextField text_Duree;
	private JLabel lbl_Charges;
	private JLabel lbl_Date_Revision;
	private JTextField text_Date_Paiement;
	private JLabel lbl_Date_Paiement;
	private JTextField text_Charges;
	private JLabel lbl_Date_Edl;
	private JTextField text_Date_EDL;
	private JLabel lbl_Num_Siren;
	private JTextField text_Montant_Caution;
	private JTextField text_Fin_Contrat;
	private JLabel lbl_Num_Logement;
	private JTextField text_Date_Revision;
	private JLabel lbl_ID_Caution;
	private JComboBox<String> comboBox_Num_Logement;
	private JComboBox<String> comboBox_Num_Siren;
	private JLabel lbl_Fin_Contrat;
	private JComboBox<String> comboBox_ID_Caution;
	private JTextField text_ID_Contrat;
	private Contrat contrat;

	public FEN_Ajout_Contrat(Contrat toEdit) {
		init();
		this.text_ID_Contrat.setText(toEdit.getId_contrat());
		this.text_ID_Contrat.setEditable(false);
		this.controlleur.ecrireDate(text_Prise_effet, toEdit.getPrise_effet());
		this.text_Loyer.setText(Float.toString(toEdit.getLoyer()));
		this.text_Paiement.setText(String.valueOf(toEdit.getPaiement()));
		this.text_Periodicite.setText(toEdit.getPeriodicite());
		this.text_Duree.setText(Integer.toString(toEdit.getDuree()));
		if (toEdit.getDate_paiement() != null)
			this.controlleur.ecrireDate(text_Date_Paiement, toEdit.getDate_paiement());
		this.text_Charges.setText(Float.toString(toEdit.getCharges()));
		this.text_Date_EDL.setText(toEdit.getDate_edl().toString());
		this.text_Montant_Caution.setText(Float.toString(toEdit.getMontant_caution()));
		if (toEdit.getFin_contrat() != null) {
			this.controlleur.ecrireDate(text_Fin_Contrat, toEdit.getFin_contrat());
		}
		this.text_Date_EDL.setText(toEdit.getDate_edl().toString());
		if (toEdit.getDate_revision() != null) {
			this.controlleur.ecrireDate(text_Date_Revision, toEdit.getDate_revision());
			;
		}
		this.comboBox_Num_Logement.setSelectedItem(toEdit.getNum().getNum());
		if (toEdit.getN_siren() != null)
			this.comboBox_Num_Siren.setSelectedItem(toEdit.getN_siren().getnSiren());
		if (toEdit.getId_caution() != null)
			this.comboBox_ID_Caution.setSelectedItem(toEdit.getId_caution().getId_Caution());
		this.contrat = toEdit;
	}

	/**
	 * Create the frame.
	 */
	public FEN_Ajout_Contrat() {
		init();
	}

	private void init() {
		setBounds(100, 100, 611, 414);
		getContentPane().setLayout(null);

		JLabel lbl_Duree = new JLabel("Duree : *");
		lbl_Duree.setBounds(330, 62, 190, 13);
		getContentPane().add(lbl_Duree);

		JLabel lbl_ID_Contrat = new JLabel("Identifiant contrat : * ");
		lbl_ID_Contrat.setBounds(35, 20, 190, 13);
		getContentPane().add(lbl_ID_Contrat);

		text_Prise_effet = new JTextField();
		text_Prise_effet.setColumns(10);
		text_Prise_effet.setBounds(35, 76, 190, 19);
		getContentPane().add(text_Prise_effet);

		JLabel lbl_Loyer = new JLabel("Loyer : *");
		lbl_Loyer.setBounds(35, 146, 190, 13);
		getContentPane().add(lbl_Loyer);

		text_Loyer = new JTextField();
		text_Loyer.setColumns(10);
		text_Loyer.setBounds(35, 160, 190, 19);
		getContentPane().add(text_Loyer);

		JLabel lbl_Periodicite = new JLabel("Periodicite : *");
		lbl_Periodicite.setBounds(35, 188, 190, 13);
		getContentPane().add(lbl_Periodicite);

		text_Paiement = new JTextField();
		text_Paiement.setColumns(10);
		text_Paiement.setBounds(35, 118, 190, 19);
		getContentPane().add(text_Paiement);

		JLabel lbl_Paiement = new JLabel("Paiement : *");
		lbl_Paiement.setBounds(35, 104, 190, 13);
		getContentPane().add(lbl_Paiement);

		JLabel lbl_Montant_Caution = new JLabel("Montant caution : *");
		lbl_Montant_Caution.setBounds(330, 230, 190, 13);
		getContentPane().add(lbl_Montant_Caution);

		text_Periodicite = new JTextField();
		text_Periodicite.setColumns(10);
		text_Periodicite.setBounds(35, 202, 190, 19);
		getContentPane().add(text_Periodicite);

		JLabel lbl_Prise_Effet = new JLabel("Prise effet : *");
		lbl_Prise_Effet.setBounds(35, 62, 190, 13);
		getContentPane().add(lbl_Prise_Effet);

		text_Duree = new JTextField();
		text_Duree.setColumns(10);
		text_Duree.setBounds(330, 76, 190, 19);
		getContentPane().add(text_Duree);

		lbl_Charges = new JLabel("Charges : *");
		lbl_Charges.setBounds(330, 146, 190, 13);
		getContentPane().add(lbl_Charges);

		lbl_Date_Revision = new JLabel("Date revision :");
		lbl_Date_Revision.setBounds(330, 272, 190, 13);
		getContentPane().add(lbl_Date_Revision);

		text_Date_Paiement = new JTextField();
		text_Date_Paiement.setColumns(10);
		text_Date_Paiement.setBounds(330, 118, 190, 19);
		getContentPane().add(text_Date_Paiement);

		lbl_Date_Paiement = new JLabel("Date paiement : *");
		lbl_Date_Paiement.setBounds(330, 104, 190, 13);
		getContentPane().add(lbl_Date_Paiement);

		text_Charges = new JTextField();
		text_Charges.setColumns(10);
		text_Charges.setBounds(330, 160, 190, 19);
		getContentPane().add(text_Charges);

		lbl_Date_Edl = new JLabel("Date EDL :");
		lbl_Date_Edl.setBounds(330, 188, 190, 13);
		getContentPane().add(lbl_Date_Edl);

		text_Date_EDL = new JTextField();
		text_Date_EDL.setColumns(10);
		text_Date_EDL.setBounds(330, 202, 190, 19);
		getContentPane().add(text_Date_EDL);

		lbl_Num_Siren = new JLabel("N\u00B0Siren :");
		lbl_Num_Siren.setBounds(35, 272, 190, 13);
		getContentPane().add(lbl_Num_Siren);

		text_Montant_Caution = new JTextField();
		text_Montant_Caution.setColumns(10);
		text_Montant_Caution.setBounds(330, 244, 190, 19);
		getContentPane().add(text_Montant_Caution);

		JButton btn_Valider = new JButton("Valider");
		btn_Valider.setBounds(435, 328, 85, 21);
		getContentPane().add(btn_Valider);

		JButton btn_Annuler = new JButton("Annuler");
		btn_Annuler.setBounds(330, 328, 85, 21);
		getContentPane().add(btn_Annuler);

		text_Fin_Contrat = new JTextField();
		text_Fin_Contrat.setColumns(10);
		text_Fin_Contrat.setBounds(35, 328, 190, 19);
		getContentPane().add(text_Fin_Contrat);

		lbl_Num_Logement = new JLabel("Num\u00E9ro de logement :");
		lbl_Num_Logement.setBounds(330, 20, 190, 13);
		getContentPane().add(lbl_Num_Logement);

		text_Date_Revision = new JTextField();
		text_Date_Revision.setColumns(10);
		text_Date_Revision.setBounds(330, 286, 190, 19);
		getContentPane().add(text_Date_Revision);

		lbl_ID_Caution = new JLabel("ID de caution :");
		lbl_ID_Caution.setBounds(35, 230, 190, 13);
		getContentPane().add(lbl_ID_Caution);

		comboBox_Num_Logement = new JComboBox<String>();
		comboBox_Num_Logement.setBounds(330, 34, 121, 19);
		getContentPane().add(comboBox_Num_Logement);

		comboBox_Num_Siren = new JComboBox<String>();
		comboBox_Num_Siren.setBounds(35, 286, 121, 19);
		getContentPane().add(comboBox_Num_Siren);

		lbl_Fin_Contrat = new JLabel("Fin contrat :");
		lbl_Fin_Contrat.setBounds(35, 314, 190, 13);
		getContentPane().add(lbl_Fin_Contrat);

		comboBox_ID_Caution = new JComboBox<String>();
		comboBox_ID_Caution.setBounds(35, 244, 121, 19);
		getContentPane().add(comboBox_ID_Caution);

		text_ID_Contrat = new JTextField();
		text_ID_Contrat.setColumns(10);
		text_ID_Contrat.setBounds(35, 34, 190, 19);
		getContentPane().add(text_ID_Contrat);
		getContentPane().add(text_ID_Contrat);
		this.controlleur = new GestionAjoutContrat(this);
		btn_Annuler.addActionListener(controlleur);
		btn_Valider.addActionListener(controlleur);
		this.fillComboCaution();
		this.fillComboEntrepreuneur();
		this.fillComboLogement();
	}

	private void fillComboCaution() {
		DaoCaution dao = new DaoCaution();
		try {
			for (Caution c : dao.findAll()) {
				this.getComboBox_ID_Caution().addItem(c.getId_Caution());
			}
			this.getComboBox_ID_Caution().addItem(null);
		} catch (SQLException e) {
			new FEN_Erreurs(e.getMessage(), this);
		}
	}

	private void fillComboEntrepreuneur() {
		DaoEntrepreuneur dao = new DaoEntrepreuneur();
		try {
			for (Entrepreneur c : dao.findAll()) {
				this.getComboBox_Num_Siren().addItem(c.getnSiren());
			}
			this.getComboBox_ID_Caution().addItem(null);
		} catch (SQLException e) {
			new FEN_Erreurs(e.getMessage(), this);
		}
	}

	private void fillComboLogement() {
		DaoLogement dao = new DaoLogement();
		try {
			for (Logement c : dao.findAll()) {
				this.getComboBox_Num_Logement().addItem(c.getNum());
			}
		} catch (SQLException e) {
			new FEN_Erreurs(e.getMessage(), this);
		}
	}

	public GestionAjoutContrat getControlleur() {
		return controlleur;
	}

	public JTextField getText_Prise_effet() {
		return text_Prise_effet;
	}

	public JTextField getText_Loyer() {
		return text_Loyer;
	}

	public JTextField getText_Paiement() {
		return text_Paiement;
	}

	public JTextField getText_Periodicite() {
		return text_Periodicite;
	}

	public JTextField getText_Duree() {
		return text_Duree;
	}

	public JLabel getLbl_Charges() {
		return lbl_Charges;
	}

	public JLabel getLbl_Date_Revision() {
		return lbl_Date_Revision;
	}

	public JTextField getText_Date_Paiement() {
		return text_Date_Paiement;
	}

	public JLabel getLbl_Date_Paiement() {
		return lbl_Date_Paiement;
	}

	public JTextField getText_Charges() {
		return text_Charges;
	}

	public JLabel getLbl_Date_Edl() {
		return lbl_Date_Edl;
	}

	public JTextField getText_Date_EDL() {
		return text_Date_EDL;
	}

	public JLabel getLbl_Num_Siren() {
		return lbl_Num_Siren;
	}

	public JTextField getText_Montant_Caution() {
		return text_Montant_Caution;
	}

	public JTextField getText_Fin_Contrat() {
		return text_Fin_Contrat;
	}

	public JLabel getLbl_Num_Logement() {
		return lbl_Num_Logement;
	}

	public JTextField getText_Date_Revision() {
		return text_Date_Revision;
	}

	public JLabel getLbl_ID_Caution() {
		return lbl_ID_Caution;
	}

	public JComboBox<String> getComboBox_Num_Logement() {
		return comboBox_Num_Logement;
	}

	public JComboBox<String> getComboBox_Num_Siren() {
		return comboBox_Num_Siren;
	}

	public JLabel getLbl_Fin_Contrat() {
		return lbl_Fin_Contrat;
	}

	public JComboBox<String> getComboBox_ID_Caution() {
		return comboBox_ID_Caution;
	}

	public JTextField getText_ID_Contrat() {
		return text_ID_Contrat;
	}

	public boolean isContratSet() {
		return this.contrat != null;
	}
}