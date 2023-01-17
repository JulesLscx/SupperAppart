package Vue;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Controlleur.GestionRegularisation;

public class FEN_Regularisation extends JInternalFrame {
	private JTable table_Generation_Regu;
	private GestionRegularisation controlleur;
	private JTextField textField_Annee_Regu;
	private JTable table_Base_Regu;
	private JButton valider;
	private JButton annuler;
	private JButton generer;
	private JButton btncharger;
	private JButton supprimer;
	private JButton ajouter;

	public FEN_Regularisation() {
		setBounds(0, 0, 880, 473);
		getContentPane().setLayout(null);

		JLabel lbl_Annee_Regu = new JLabel("Année de régularisation :");
		lbl_Annee_Regu.setBounds(35, 20, 190, 20);
		getContentPane().add(lbl_Annee_Regu);

		ajouter = new JButton("Ajouter");
		ajouter.setBounds(180, 405, 119, 23);
		getContentPane().add(ajouter);

		annuler = new JButton("Annuler");
		annuler.setBounds(35, 405, 119, 23);
		getContentPane().add(annuler);

		btncharger = new JButton("Charger");
		btncharger.setBounds(480, 405, 119, 23);
		getContentPane().add(btncharger);

		supprimer = new JButton("Supprimer");
		supprimer.setBounds(600, 405, 119, 23);
		getContentPane().add(supprimer);

		valider = new JButton("Valider");
		valider.setBounds(740, 405, 119, 23);
		getContentPane().add(valider);

		JScrollPane Generation_Regu = new JScrollPane();
		Generation_Regu.setEnabled(false);
		Generation_Regu.setBounds(35, 70, 362, 312);
		getContentPane().add(Generation_Regu);

		table_Generation_Regu = new JTable();
		table_Generation_Regu.setModel(new DefaultTableModel(
				new Object[][] {
						{ null, null, null, null },
						{ null, null, null, null },
						{ null, null, null, null },
						{ null, null, null, null },
						{ null, null, null, null },
						{ null, null, null, null },
						{ null, null, null, null },
						{ null, null, null, null },
						{ null, null, null, null },
						{ null, null, null, null },
						{ null, null, null, null },
						{ null, null, null, null },
						{ null, null, null, null },
						{ null, null, null, null },
						{ null, null, null, null },
						{ null, null, null, null },
						{ null, null, null, null },
						{ null, null, null, null },
						{ null, null, null, null },
						{ null, null, null, null },
				},
				new String[] {
						"Contrat", "Type facture", "Date regularisation", "Montant"
				}));
		table_Generation_Regu.getColumnModel().getColumn(0).setPreferredWidth(65);
		table_Generation_Regu.getColumnModel().getColumn(2).setPreferredWidth(95);
		table_Generation_Regu.getColumnModel().getColumn(3).setPreferredWidth(65);
		Generation_Regu.setViewportView(table_Generation_Regu);

		textField_Annee_Regu = new JTextField();
		textField_Annee_Regu.setColumns(10);
		textField_Annee_Regu.setBounds(35, 40, 190, 19);
		getContentPane().add(textField_Annee_Regu);

		generer = new JButton("Générer");
		generer.setBounds(325, 405, 119, 23);
		getContentPane().add(generer);

		JScrollPane Base_Regu = new JScrollPane();
		Base_Regu.setEnabled(false);
		Base_Regu.setBounds(480, 70, 362, 312);
		getContentPane().add(Base_Regu);

		table_Base_Regu = new JTable();
		table_Base_Regu.setModel(new DefaultTableModel(
				new Object[][] {
						{ null, null, null, null },
						{ null, null, null, null },
						{ null, null, null, null },
						{ null, null, null, null },
						{ null, null, null, null },
						{ null, null, null, null },
						{ null, null, null, null },
						{ null, null, null, null },
						{ null, null, null, null },
						{ null, null, null, null },
						{ null, null, null, null },
						{ null, null, null, null },
						{ null, null, null, null },
						{ null, null, null, null },
						{ null, null, null, null },
						{ null, null, null, null },
						{ null, null, null, null },
						{ null, null, null, null },
						{ null, null, null, null },
						{ null, null, null, null },
				},
				new String[] {
						"Contrat", "Type facture", "Date regularisation", "Montant"
				}));
		table_Base_Regu.getColumnModel().getColumn(0).setPreferredWidth(65);
		table_Base_Regu.getColumnModel().getColumn(2).setPreferredWidth(95);
		table_Base_Regu.getColumnModel().getColumn(3).setPreferredWidth(65);
		Base_Regu.setViewportView(table_Base_Regu);
		this.controlleur = new GestionRegularisation(this);
		valider.addActionListener(controlleur);
		annuler.addActionListener(controlleur);
		generer.addActionListener(controlleur);
		supprimer.addActionListener(controlleur);
		btncharger.addActionListener(controlleur);
	}

	public void validationEnable(boolean b) {
		valider.setEnabled(b);
	}

	public JButton[] getChangeableButtons() {
		return new JButton[] { this.supprimer };
	}

	public JTable getTable_Generation_Regu() {
		return table_Generation_Regu;
	}

	public GestionRegularisation getControlleur() {
		return controlleur;
	}

	public JTextField getTextField_Annee_Regu() {
		return textField_Annee_Regu;
	}

	public JTable getTable_Base_Regu() {
		return table_Base_Regu;
	}

	public JButton getValider() {
		return valider;
	}

	public JButton getAnnuler() {
		return annuler;
	}

	public JButton getGenerer() {
		return generer;
	}

	public JButton getBtncharger() {
		return btncharger;
	}

	public JButton getSupprimer() {
		return supprimer;
	}
}