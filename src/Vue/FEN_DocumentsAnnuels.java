package Vue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Controlleur.GestionDocumentsAnnuels;

public class FEN_DocumentsAnnuels extends JInternalFrame {
	private JTable table_DocumentsAnnuels;
	private GestionDocumentsAnnuels controlleur;

	public FEN_DocumentsAnnuels() {

		setBounds(0, 0, 880, 473);
		getContentPane().setLayout(null);

		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(469, 395, 119, 23);
		getContentPane().add(btnSupprimer);

		JButton annuler = new JButton("Annuler");
		annuler.setBounds(681, 395, 119, 23);
		getContentPane().add(annuler);

		JScrollPane spFactureExistante = new JScrollPane();
		spFactureExistante.setEnabled(false);
		spFactureExistante.setBounds(46, 29, 779, 358);
		getContentPane().add(spFactureExistante);

		table_DocumentsAnnuels = new JTable();
		table_DocumentsAnnuels.setModel(new DefaultTableModel(
				new Object[][] {
						{ null, null, null, null, },
						{ null, null, null, null, },
						{ null, null, null, null, },
						{ null, null, null, null, },
						{ null, null, null, null, },
						{ null, null, null, null, },
						{ null, null, null, null, },
						{ null, null, null, null, },
						{ null, null, null, null, },
						{ null, null, null, null, },
						{ null, null, null, null, },
						{ null, null, null, null, },
						{ null, null, null, null, },
						{ null, null, null, null, },
						{ null, null, null, null, },
						{ null, null, null, null, },
						{ null, null, null, null, },
						{ null, null, null, null, },
						{ null, null, null, null, },
						{ null, null, null, null, },
				},
				new String[] {
						"Annee", "Certificat", "Ramonage", "Locataire",
				}));
		this.controlleur = new GestionDocumentsAnnuels(this);
		btnSupprimer.addActionListener(controlleur);
		annuler.addActionListener(controlleur);
		spFactureExistante.setViewportView(table_DocumentsAnnuels);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setBounds(272, 395, 119, 23);
		getContentPane().add(btnModifier);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(76, 396, 119, 23);
		getContentPane().add(btnAjouter);

	}

}
