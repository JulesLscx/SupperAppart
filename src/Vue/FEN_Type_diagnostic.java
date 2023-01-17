package Vue;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Controlleur.GestionTypeDiagnostic;

public class FEN_Type_diagnostic extends JInternalFrame {
	private JTextField nom, duree, id_type;
	private JTable table_TypeFacture;
	private GestionTypeDiagnostic controlleur;

	public FEN_Type_diagnostic() {
		setBounds(0, 0, 880, 473);
		getContentPane().setLayout(null);

		nom = new JTextField();
		nom.setBounds(168, 112, 180, 32);
		getContentPane().add(nom);
		nom.setColumns(10);

		duree = new JTextField();
		duree.setBounds(168, 206, 180, 32);
		getContentPane().add(duree);
		duree.setColumns(10);

		id_type = new JTextField();
		id_type.setBounds(168, 300, 180, 32);
		getContentPane().add(id_type);
		id_type.setColumns(10);

		JLabel lblnom = new JLabel("Nom Diagnostics: ");
		lblnom.setBounds(168, 92, 110, 20);
		getContentPane().add(lblnom);

		JLabel lblduree = new JLabel("Duree Diagnostics: ");
		lblduree.setBounds(168, 186, 110, 20);
		getContentPane().add(lblduree);

		JLabel lblid_type = new JLabel("Identifiant: ");
		lblid_type.setBounds(168, 280, 80, 20);
		getContentPane().add(lblid_type);

		JButton valider = new JButton("Valider");
		valider.setBounds(400, 405, 119, 23);
		getContentPane().add(valider);

		JButton annuler = new JButton("Annuler");
		annuler.setBounds(700, 405, 119, 23);
		getContentPane().add(annuler);
		
		JButton btnCharger = new JButton("Charger");
		btnCharger.setBounds(550, 405, 119, 23);
		getContentPane().add(btnCharger);

		JScrollPane spFactureExistante = new JScrollPane();
		spFactureExistante.setEnabled(false);
		spFactureExistante.setBounds(450, 35, 340, 358);
		getContentPane().add(spFactureExistante);

		table_TypeFacture = new JTable();
		table_TypeFacture.setModel(new DefaultTableModel(
				new Object[][] {
						{ null, null, null, },
						{ null, null, null, },
						{ null, null, null, },
						{ null, null, null, },
						{ null, null, null, },
						{ null, null, null, },
						{ null, null, null, },
						{ null, null, null, },
						{ null, null, null, },
						{ null, null, null, },
						{ null, null, null, },
						{ null, null, null, },
						{ null, null, null, },
						{ null, null, null, },
						{ null, null, null, },
						{ null, null, null, },
						{ null, null, null, },
						{ null, null, null, },
						{ null, null, null, },
						{ null, null, null, },
						{ null, null, null, },
						{ null, null, null, },
						{ null, null, null, },
						{ null, null, null, },
						{ null, null, null, },

				},
				new String[] {
						"Periodicite", "Type", "Unite",
				}));
		spFactureExistante.setViewportView(table_TypeFacture);
		this.controlleur = new GestionTypeDiagnostic(this);
		valider.addActionListener(controlleur);
		annuler.addActionListener(controlleur);
	}

}
