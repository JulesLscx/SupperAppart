package Vue.Ajout;

import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controlleur.Ajout.GestionAjoutLogement;
import Modele.Immeuble;
import Modele.Logement;
import Modele.DAO.DaoImmeuble;
import Vue.FEN_Erreurs;

public class FEN_Ajout_Logement extends JInternalFrame {

	/**
	 * Create the panel.
	 */
	private GestionAjoutLogement controlleur;
	private JTextField text_Surface;
	private JTextField text_Type_Habitation;
	private JTextField text_NB_Pieces;
	private JLabel lbl_Num_Logement;
	private JTextField text_Num_Logement;
	private JComboBox<String> comboBox_ID_Immeuble;
	private Object logement;

	public FEN_Ajout_Logement(Logement toEdit) {
		init();
		this.text_Surface.setText(Float.toString(toEdit.getSurface()));
		this.text_Type_Habitation.setText(toEdit.getType_hab());
		this.text_NB_Pieces.setText(Integer.toString(toEdit.getNbpiece()));
		this.text_Num_Logement.setText(toEdit.getNum());
		this.logement = toEdit;
		this.comboBox_ID_Immeuble.setSelectedItem(toEdit.getImmeuble().getId_immeuble());
	}

	/**
	 * Create the frame.
	 */
	public FEN_Ajout_Logement() {
		init();
	}

	private void init() {
		setBounds(100, 100, 611, 414);
		getContentPane().setLayout(null);

		JLabel lbl_Nb_Pieces = new JLabel("Nombre de pi\u00E8ces");
		lbl_Nb_Pieces.setBounds(330, 62, 190, 13);
		getContentPane().add(lbl_Nb_Pieces);

		JLabel lbl_ID_Immeuble = new JLabel("Identifiant immeuble : ");
		lbl_ID_Immeuble.setBounds(35, 20, 190, 13);
		getContentPane().add(lbl_ID_Immeuble);

		text_Surface = new JTextField();
		text_Surface.setColumns(10);
		text_Surface.setBounds(35, 76, 190, 19);
		getContentPane().add(text_Surface);

		text_Type_Habitation = new JTextField();
		text_Type_Habitation.setColumns(10);
		text_Type_Habitation.setBounds(35, 118, 190, 19);
		getContentPane().add(text_Type_Habitation);

		JLabel lbl_Type_Habitation = new JLabel("Type d'habitation :");
		lbl_Type_Habitation.setBounds(35, 104, 190, 13);
		getContentPane().add(lbl_Type_Habitation);

		JLabel lbl_Surface = new JLabel("Surface :");
		lbl_Surface.setBounds(35, 62, 190, 13);
		getContentPane().add(lbl_Surface);

		text_NB_Pieces = new JTextField();
		text_NB_Pieces.setColumns(10);
		text_NB_Pieces.setBounds(330, 76, 190, 19);
		getContentPane().add(text_NB_Pieces);

		JButton btn_Valider = new JButton("Valider");
		btn_Valider.setBounds(435, 118, 85, 21);
		getContentPane().add(btn_Valider);

		JButton btn_Annuler = new JButton("Annuler");
		btn_Annuler.setBounds(330, 118, 85, 21);
		getContentPane().add(btn_Annuler);

		lbl_Num_Logement = new JLabel("Num\u00E9ro de logement :");
		lbl_Num_Logement.setBounds(330, 20, 190, 13);
		getContentPane().add(lbl_Num_Logement);

		text_Num_Logement = new JTextField();
		text_Num_Logement.setBounds(330, 34, 121, 19);
		getContentPane().add(text_Num_Logement);

		comboBox_ID_Immeuble = new JComboBox<String>();
		comboBox_ID_Immeuble.setBounds(35, 34, 121, 19);
		getContentPane().add(comboBox_ID_Immeuble);

		this.controlleur = new GestionAjoutLogement(this);
		btn_Annuler.addActionListener(controlleur);
		btn_Valider.addActionListener(controlleur);
		this.controlleur.fillCombo();
	}

	public boolean isLogementSet() {
		return this.logement != null;
	}

	public GestionAjoutLogement getControlleur() {
		return controlleur;
	}

	public JTextField getText_Surface() {
		return text_Surface;
	}

	public JTextField getText_Type_Habitation() {
		return text_Type_Habitation;
	}

	public JTextField getText_NB_Pieces() {
		return text_NB_Pieces;
	}

	public JLabel getLbl_Num_Logement() {
		return lbl_Num_Logement;
	}

	public JTextField getText_Num_Logement() {
		return text_Num_Logement;
	}

	public JComboBox<String> getComboBox_ID_Immeuble() {
		return comboBox_ID_Immeuble;
	}

	public Object getLogement() {
		return logement;
	}
}