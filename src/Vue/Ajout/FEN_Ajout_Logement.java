package Vue.Ajout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controlleur.Ajout.GestionAjoutLogement;
import Modele.Logement;

public class FEN_Ajout_Logement extends JInternalFrame {

	/**
	 * Create the panel.
	 */
	private GestionAjoutLogement controlleur;
	private JTextField text_Surface;
	private JTextField text_Type_Habitation;
	private JTextField text_NB_Pieces;
	private JLabel lbl_Num_Logement;
	private JComboBox comboBox_Num_Logement;
	private JComboBox comboBox_ID_Immeuble;

	public FEN_Ajout_Logement(Logement toEdit) {
		init();
		this.text_Surface.setText(Float.toString(toEdit.getSurface()));
		this.text_Type_Habitation.setText(toEdit.getType_hab());
		this.text_NB_Pieces.setText(Integer.toString(toEdit.getNbpiece()));
		// this.comboBox_Num_Logement.setToolTipText(toEdit.getNum());
		// this.comboBox_ID_Immeuble.setToolTipText(toEdit.getImmeuble().getId_immeuble());
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

		comboBox_Num_Logement = new JComboBox();
		comboBox_Num_Logement.setBounds(330, 34, 121, 19);
		getContentPane().add(comboBox_Num_Logement);

		comboBox_ID_Immeuble = new JComboBox();
		comboBox_ID_Immeuble.setBounds(35, 34, 121, 19);
		getContentPane().add(comboBox_ID_Immeuble);
	}
}