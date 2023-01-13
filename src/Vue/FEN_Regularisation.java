package Vue;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Controlleur.GestionRegularisation;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FEN_Regularisation extends JInternalFrame {
	private JTextField dateRegularisation, montant;
	private JTable table_TypeFacture;
	private GestionRegularisation controlleur;

	public FEN_Regularisation() {
		setBounds(0, 0, 880, 473);
		getContentPane().setLayout(null);

		dateRegularisation = new JTextField();
		dateRegularisation.setBounds(167, 101, 180, 32);
		getContentPane().add(dateRegularisation);
		dateRegularisation.setColumns(10);

		montant = new JTextField();
		montant.setBounds(167, 195, 180, 32);
		getContentPane().add(montant);
		montant.setColumns(10);

		JLabel lbldateRegularisation = new JLabel("Date Regularisation:");
		lbldateRegularisation.setBounds(167, 81, 80, 20);
		getContentPane().add(lbldateRegularisation);

		JLabel lblmontant = new JLabel("Montant: ");
		lblmontant.setBounds(167, 175, 80, 20);
		getContentPane().add(lblmontant);

		JButton valider = new JButton("Valider");
		valider.setBounds(567, 409, 89, 23);
		getContentPane().add(valider);

		JButton annuler = new JButton("Annuler");
		annuler.setBounds(698, 409, 89, 23);
		getContentPane().add(annuler);

		JButton ajouterCo = new JButton("Ajouter");
		ajouterCo.setBounds(167, 282, 89, 23);
		getContentPane().add(ajouterCo);

		JComboBox contrat = new JComboBox();
		contrat.setBounds(167, 302, 180, 32);
		getContentPane().add(contrat);

		JLabel lblContrat = new JLabel("Contrat: ");
		lblContrat.setBounds(267, 282, 80, 20);
		getContentPane().add(lblContrat);

		JScrollPane spFactureExistante = new JScrollPane();
		spFactureExistante.setEnabled(false);
		spFactureExistante.setBounds(514, 31, 340, 358);
		getContentPane().add(spFactureExistante);

		table_TypeFacture = new JTable();
		table_TypeFacture.setModel(new DefaultTableModel(
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
						"Ann�e", "Certificat", "Ramonage", "Locataire",
				}));
		spFactureExistante.setViewportView(table_TypeFacture);
		this.controlleur = new GestionRegularisation(this);
		valider.addActionListener(controlleur);
		annuler.addActionListener(controlleur);
	}

}
