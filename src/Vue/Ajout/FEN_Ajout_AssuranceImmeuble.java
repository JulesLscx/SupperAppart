package Vue.Ajout;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controlleur.Ajout.GestionAjoutAssuranceImmeuble;

public class FEN_Ajout_AssuranceImmeuble extends JInternalFrame {

	private GestionAjoutAssuranceImmeuble controlleur;
	private JTextField text_Certif_Bien;
	private JTextField text_N_Siren;
	private JTextField text_Certif_Juridique;
	private JLabel lbl_Annee;
	private JComboBox<String> comboBox_ID_Immeuble;
	private JTextField text_Annee;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FEN_Ajout_AssuranceImmeuble frame = new FEN_Ajout_AssuranceImmeuble();
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
	public FEN_Ajout_AssuranceImmeuble() {
		setBounds(100, 100, 611, 414);
		getContentPane().setLayout(null);

		JLabel lbl_Certif_Juridique = new JLabel("Certificat juridique :");
		lbl_Certif_Juridique.setBounds(330, 62, 190, 13);
		getContentPane().add(lbl_Certif_Juridique);

		JLabel lbl_ID_Immeuble = new JLabel("Identifiant immeuble : ");
		lbl_ID_Immeuble.setBounds(35, 20, 190, 13);
		getContentPane().add(lbl_ID_Immeuble);

		text_Certif_Bien = new JTextField();
		text_Certif_Bien.setColumns(10);
		text_Certif_Bien.setBounds(35, 76, 190, 19);
		getContentPane().add(text_Certif_Bien);

		text_N_Siren = new JTextField();
		text_N_Siren.setColumns(10);
		text_N_Siren.setBounds(35, 118, 190, 19);
		getContentPane().add(text_N_Siren);

		JLabel lbl_N_SIREN = new JLabel("N\u00B0SIREN :");
		lbl_N_SIREN.setBounds(35, 104, 190, 13);
		getContentPane().add(lbl_N_SIREN);

		JLabel lbl_Certif_Bien = new JLabel("Certificat bien :");
		lbl_Certif_Bien.setBounds(35, 62, 190, 13);
		getContentPane().add(lbl_Certif_Bien);

		text_Certif_Juridique = new JTextField();
		text_Certif_Juridique.setColumns(10);
		text_Certif_Juridique.setBounds(330, 76, 190, 19);
		getContentPane().add(text_Certif_Juridique);

		JButton btn_Valider = new JButton("Valider");
		btn_Valider.setBounds(435, 118, 85, 21);
		getContentPane().add(btn_Valider);

		JButton btn_Annuler = new JButton("Annuler");
		btn_Annuler.setBounds(330, 118, 85, 21);
		getContentPane().add(btn_Annuler);

		lbl_Annee = new JLabel("Ann\u00E9e :");
		lbl_Annee.setBounds(330, 20, 190, 13);
		getContentPane().add(lbl_Annee);

		comboBox_ID_Immeuble = new JComboBox<String>();
		comboBox_ID_Immeuble.setBounds(35, 34, 121, 19);
		getContentPane().add(comboBox_ID_Immeuble);

		text_Annee = new JTextField();
		text_Annee.setColumns(10);
		text_Annee.setBounds(330, 34, 190, 19);
		getContentPane().add(text_Annee);
		controlleur = new GestionAjoutAssuranceImmeuble(this);
		btn_Valider.addActionListener(controlleur);
		btn_Annuler.addActionListener(controlleur);
	}

	public GestionAjoutAssuranceImmeuble getControlleur() {
		return controlleur;
	}

	public void setControlleur(GestionAjoutAssuranceImmeuble controlleur) {
		this.controlleur = controlleur;
	}

	public JTextField getText_Certif_Bien() {
		return text_Certif_Bien;
	}

	public void setText_Certif_Bien(JTextField text_Certif_Bien) {
		this.text_Certif_Bien = text_Certif_Bien;
	}

	public JTextField getText_N_Siren() {
		return text_N_Siren;
	}

	public void setText_N_Siren(JTextField text_N_Siren) {
		this.text_N_Siren = text_N_Siren;
	}

	public JTextField getText_Certif_Juridique() {
		return text_Certif_Juridique;
	}

	public void setText_Certif_Juridique(JTextField text_Certif_Juridique) {
		this.text_Certif_Juridique = text_Certif_Juridique;
	}

	public JLabel getLbl_Annee() {
		return lbl_Annee;
	}

	public void setLbl_Annee(JLabel lbl_Annee) {
		this.lbl_Annee = lbl_Annee;
	}

	public JComboBox<String> getComboBox_ID_Immeuble() {
		return comboBox_ID_Immeuble;
	}

	public void setComboBox_ID_Immeuble(JComboBox<String> comboBox_ID_Immeuble) {
		this.comboBox_ID_Immeuble = comboBox_ID_Immeuble;
	}

	public JTextField getText_Annee() {
		return text_Annee;
	}

	public void setText_Annee(JTextField text_Annee) {
		this.text_Annee = text_Annee;
	}

}
