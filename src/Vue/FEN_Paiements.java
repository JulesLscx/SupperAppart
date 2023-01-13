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

import Controlleur.GestionPaiements;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FEN_Paiements extends JInternalFrame {
	private JTable table_Paiement;
	private GestionPaiements controlleur;
	private JTable table_Contrat;

	/**
	 * Launch the application.
	 * public static void main(String[] args) {
	 * EventQueue.invokeLater(new Runnable() {
	 * public void run() {
	 * try {
	 * Facture frame = new Facture();
	 * frame.setVisible(true);
	 * } catch (Exception e) {
	 * e.printStackTrace();
	 * }
	 * }
	 * });
	 * }
	 * 
	 * /**
	 * Create the frame.
	 */
	public FEN_Paiements() {
		setBounds(0, 0, 880, 473);
		getContentPane().setLayout(null);

		JButton btnAjouter = new JButton("Ajouter ");
		btnAjouter.setBounds(90, 409, 89, 23);
		getContentPane().add(btnAjouter);

		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(601, 409, 89, 23);
		getContentPane().add(btnAnnuler);

		JScrollPane spPaiement = new JScrollPane();
		spPaiement.setEnabled(false);
		spPaiement.setBounds(21, 35, 802, 140);
		getContentPane().add(spPaiement);

		table_Paiement = new JTable();
		table_Paiement.setModel(new DefaultTableModel(
				new Object[][] {
						{ null, null, null, null, null, null, },
						{ null, null, null, null, null, null, },
						{ null, null, null, null, null, null, },
						{ null, null, null, null, null, null, },
						{ null, null, null, null, null, null, },
						{ null, null, null, null, null, null, },
						{ null, null, null, null, null, null, },
						{ null, null, null, null, null, null, },
						{ null, null, null, null, null, null, },
						{ null, null, null, null, null, null, },
						{ null, null, null, null, null, null, },
						{ null, null, null, null, null, null, },
						{ null, null, null, null, null, null, },
						{ null, null, null, null, null, null, },
						{ null, null, null, null, null, null, },
						{ null, null, null, null, null, null, },
						{ null, null, null, null, null, null, },
						{ null, null, null, null, null, null, },
						{ null, null, null, null, null, null, },
						{ null, null, null, null, null, null, },

				},
				new String[] {
						"Num�ro", "Type Habitation", "Locataire", "Surface", "nbPiece", "Immeuble",
				}));
		spPaiement.setViewportView(table_Paiement);
		
		JScrollPane spContrat = new JScrollPane();
		spContrat.setEnabled(false);
		spContrat.setBounds(21, 240, 741, 84);
		getContentPane().add(spContrat);
		
		table_Contrat = new JTable();
		table_Contrat.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Num\u00E9ro contrat", "Prise effet", "Dur\u00E9e", "Charge", "Loyer", "Date r\u00E9vision", "P\u00E9riodicit\u00E9", "Date paiement", "Paiement", "Date EDL", "Montant", "Fin contrat"
			}
		));
		
		spContrat.setViewportView(table_Contrat);
		
		JLabel lblPaiement = new JLabel("Paiement");
		lblPaiement.setBounds(21, 12, 45, 13);
		getContentPane().add(lblPaiement);
		
		JLabel lblContrat = new JLabel("Contrat");
		lblContrat.setBounds(21, 217, 45, 13);
		getContentPane().add(lblContrat);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setBounds(250, 410, 89, 23);
		getContentPane().add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(422, 410, 89, 23);
		getContentPane().add(btnSupprimer);

		this.controlleur = new GestionPaiements(this);
		btnAjouter.addActionListener(controlleur);
		btnAnnuler.addActionListener(controlleur);

	}
}
