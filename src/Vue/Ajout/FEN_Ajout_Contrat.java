package Vue.Ajout;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controlleur.Ajout.GestionAjoutContrat;
import Modele.Contrat;

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
	private JComboBox comboBox_Num_Logement;
	private JComboBox comboBox_Num_Siren;
	private JLabel lbl_Fin_Contrat;
	private JComboBox comboBox_ID_Caution;
	private JTextField text_ID_Contrat;

	public FEN_Ajout_Contrat(Contrat toEdit) {
		init();
		this.text_ID_Contrat.setText(toEdit.getId_contrat());
		this.text_ID_Contrat.setEditable(false);
		this.text_Prise_effet.setText(toEdit.getPrise_effet().toString());
		this.text_Loyer.setText(Float.toString(toEdit.getLoyer()));
		this.text_Paiement.setText(toEdit.getPaiement());
		this.text_Periodicite.setText(toEdit.getPeriodicite());
		this.text_Duree.setText(Float.toString(toEdit.getDuree()));
		this.text_Date_Paiement.setText(toEdit.getDate_paiement().toString());
		this.text_Charges.setText(Float.toString(toEdit.getCharges()));
		this.text_Date_EDL.setText(toEdit.getDate_edl().toString());
		this.text_Montant_Caution.setText(Float.toString(toEdit.getMontant_caution()));
		this.text_Fin_Contrat.setText(toEdit.getFin_contrat().toString());
		this.text_Date_EDL.setText(toEdit.getDate_edl().toString());
		this.text_Date_Revision.setText(toEdit.getDate_revision().toString());
		// this.comboBox_Num_Logement.setText(toEdit.getNum().getNum());
		// this.comboBox_Num_Siren.setText(toEdit.getN_siren().getnSiren());
		// this.comboBox_ID_Caution.setText(toEdit.getId_caution().getId_Caution());
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

		JLabel lbl_Duree = new JLabel("Dur�e :");
		lbl_Duree.setBounds(330, 62, 190, 13);
		getContentPane().add(lbl_Duree);

		JLabel lbl_ID_Contrat = new JLabel("Identifiant contrat : ");
		lbl_ID_Contrat.setBounds(35, 20, 190, 13);
		getContentPane().add(lbl_ID_Contrat);

		text_Prise_effet = new JTextField();
		text_Prise_effet.setColumns(10);
		text_Prise_effet.setBounds(35, 76, 190, 19);
		getContentPane().add(text_Prise_effet);

		JLabel lbl_Loyer = new JLabel("Loyer :");
		lbl_Loyer.setBounds(35, 146, 190, 13);
		getContentPane().add(lbl_Loyer);

		text_Loyer = new JTextField();
		text_Loyer.setColumns(10);
		text_Loyer.setBounds(35, 160, 190, 19);
		getContentPane().add(text_Loyer);

		JLabel lbl_Periodicite = new JLabel("P�riodicit� :");
		lbl_Periodicite.setBounds(35, 188, 190, 13);
		getContentPane().add(lbl_Periodicite);

		text_Paiement = new JTextField();
		text_Paiement.setColumns(10);
		text_Paiement.setBounds(35, 118, 190, 19);
		getContentPane().add(text_Paiement);

		JLabel lbl_Paiement = new JLabel("Paiement :");
		lbl_Paiement.setBounds(35, 104, 190, 13);
		getContentPane().add(lbl_Paiement);

		JLabel lbl_Montant_Caution = new JLabel("Montant caution :");
		lbl_Montant_Caution.setBounds(330, 230, 190, 13);
		getContentPane().add(lbl_Montant_Caution);

		text_Periodicite = new JTextField();
		text_Periodicite.setColumns(10);
		text_Periodicite.setBounds(35, 202, 190, 19);
		getContentPane().add(text_Periodicite);

		JLabel lbl_Prise_Effet = new JLabel("Prise effet :");
		lbl_Prise_Effet.setBounds(35, 62, 190, 13);
		getContentPane().add(lbl_Prise_Effet);

		text_Duree = new JTextField();
		text_Duree.setColumns(10);
		text_Duree.setBounds(330, 76, 190, 19);
		getContentPane().add(text_Duree);

		lbl_Charges = new JLabel("Charges :");
		lbl_Charges.setBounds(330, 146, 190, 13);
		getContentPane().add(lbl_Charges);

		lbl_Date_Revision = new JLabel("Date r�vision :");
		lbl_Date_Revision.setBounds(330, 272, 190, 13);
		getContentPane().add(lbl_Date_Revision);

		text_Date_Paiement = new JTextField();
		text_Date_Paiement.setColumns(10);
		text_Date_Paiement.setBounds(330, 118, 190, 19);
		getContentPane().add(text_Date_Paiement);

		lbl_Date_Paiement = new JLabel("Date paiement :");
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

		comboBox_Num_Logement = new JComboBox();
		comboBox_Num_Logement.setBounds(330, 34, 121, 19);
		getContentPane().add(comboBox_Num_Logement);

		comboBox_Num_Siren = new JComboBox();
		comboBox_Num_Siren.setBounds(35, 286, 121, 19);
		getContentPane().add(comboBox_Num_Siren);

		lbl_Fin_Contrat = new JLabel("Fin contrat :");
		lbl_Fin_Contrat.setBounds(35, 314, 190, 13);
		getContentPane().add(lbl_Fin_Contrat);

		comboBox_ID_Caution = new JComboBox();
		comboBox_ID_Caution.setBounds(35, 244, 121, 19);
		getContentPane().add(comboBox_ID_Caution);

		text_ID_Contrat = new JTextField();
		text_ID_Contrat.setColumns(10);
		text_ID_Contrat.setBounds(35, 34, 190, 19);
		getContentPane().add(text_ID_Contrat);
	}
}