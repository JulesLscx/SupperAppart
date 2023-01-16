package Vue;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controlleur.GestionAssuranceImmeuble;

public class FEN_AssuranceImmeuble extends JInternalFrame {
	private JTable table_AssuranceImmeuble;

	public JTable getTable_AssuranceImmeuble() {
		return table_AssuranceImmeuble;
	}

	private JTable table_Immeuble;

	public JTable getImmeuble() {
		return table_Immeuble;
	}

	private GestionAssuranceImmeuble controlleur;
	private JTable table_Entrepreneur;

	public FEN_AssuranceImmeuble() {
		setBounds(0, 0, 992, 496);
		getContentPane().setLayout(null);

		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(119, 423, 119, 23);
		getContentPane().add(btnValider);

		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(542, 423, 119, 23);
		getContentPane().add(btnAnnuler);

		JScrollPane spAssuranceImmeuble = new JScrollPane();
		spAssuranceImmeuble.setEnabled(false);
		spAssuranceImmeuble.setBounds(29, 31, 465, 172);
		getContentPane().add(spAssuranceImmeuble);

		table_AssuranceImmeuble = new JTable();
		table_AssuranceImmeuble.setModel(new DefaultTableModel(
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
						{ null, null, null, null },
				},
				new String[] {
						"Assurance bien", "Assurance juridique", "Ann\u00E9e", "Immeuble"
				}));
		spAssuranceImmeuble.setViewportView(table_AssuranceImmeuble);

		JScrollPane spImmeuble = new JScrollPane();
		spImmeuble.setEnabled(false);
		spImmeuble.setBounds(29, 240, 690, 160);
		getContentPane().add(spImmeuble);

		table_Immeuble = new JTable();
		table_Immeuble.setModel(new DefaultTableModel(
				new Object[][] {
						{ null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null },
				},
				new String[] {
						"Identifiant", "Adresse", "P\u00E9riode de construction", "Num\u00E9ro", "CP", "Ville",
						"Copropri\u00E9taire", "Accessoire commun"
				}));
		table_Immeuble.getColumnModel().getColumn(2).setPreferredWidth(131);
		table_Immeuble.getColumnModel().getColumn(7).setPreferredWidth(151);
		spImmeuble.setViewportView(table_Immeuble);

		JButton btn_Supprimer = new JButton("Supprimer");
		btn_Supprimer.setBounds(386, 423, 119, 23);
		getContentPane().add(btn_Supprimer);

		JButton btnVal = new JButton("Modifier");
		btnVal.setBounds(232, 423, 119, 23);
		getContentPane().add(btnVal);

		JLabel lblNewLabel = new JLabel("Assurance immeuble");
		lblNewLabel.setBounds(29, 8, 140, 13);
		getContentPane().add(lblNewLabel);

		JLabel lblImmeuble = new JLabel("Immeuble");
		lblImmeuble.setBounds(29, 217, 105, 13);
		getContentPane().add(lblImmeuble);

		JLabel lblEntrepreneur = new JLabel("Entrepreneur");
		lblEntrepreneur.setBounds(521, 8, 105, 13);
		getContentPane().add(lblEntrepreneur);

		JScrollPane spEntrepreneur = new JScrollPane();
		spEntrepreneur.setEnabled(false);
		spEntrepreneur.setBounds(521, 31, 438, 66);
		getContentPane().add(spEntrepreneur);

		table_Entrepreneur = new JTable();
		table_Entrepreneur.setModel(new DefaultTableModel(
				new Object[][] {
						{ null, null, null, null, null },
						{ null, null, null, null, null },
				},
				new String[] {
						"n\u00B0 siret", "Adresse", "Nom", "IBAN", "Secteur d'activit\u00E9"
				}));
		table_Entrepreneur.getColumnModel().getColumn(4).setPreferredWidth(95);
		spEntrepreneur.setViewportView(table_Entrepreneur);

		this.controlleur = new GestionAssuranceImmeuble(this);
		btnValider.addActionListener(controlleur);
		btnAnnuler.addActionListener(controlleur);

	}
}