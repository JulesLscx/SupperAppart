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

public class FEN_Paiements extends JInternalFrame implements ActionListener {
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
		btnAjouter.setBounds(90, 400, 119, 23);
		getContentPane().add(btnAjouter);

		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(601, 400, 119, 23);
		getContentPane().add(btnAnnuler);

		JScrollPane spPaiement = new JScrollPane();
		spPaiement.setEnabled(false);
		spPaiement.setBounds(21, 35, 825, 140);
		getContentPane().add(spPaiement);

		table_Paiement = new JTable();
		table_Paiement.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Numero", "Type Habitation", "Locataire", "Surface", "Nombre piece", "Immeuble"
			}
		));
		spPaiement.setViewportView(table_Paiement);
		
		JScrollPane spContrat = new JScrollPane();
		spContrat.setEnabled(false);
		spContrat.setBounds(21, 240, 825, 84);
		getContentPane().add(spContrat);
		
		table_Contrat = new JTable();
		table_Contrat.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"N\u00B0 contrat", "Prise effet", "Dur\u00E9e", "Charge", "Loyer", "Date r\u00E9vision", "P\u00E9riodicit\u00E9", "Date paiement", "Paiement", "Date EDL", "Montant", "Fin contrat"
			}
		));
		table_Contrat.getColumnModel().getColumn(0).setPreferredWidth(65);
		table_Contrat.getColumnModel().getColumn(1).setPreferredWidth(65);
		table_Contrat.getColumnModel().getColumn(2).setPreferredWidth(65);
		table_Contrat.getColumnModel().getColumn(3).setPreferredWidth(65);
		table_Contrat.getColumnModel().getColumn(4).setPreferredWidth(65);
		table_Contrat.getColumnModel().getColumn(5).setPreferredWidth(90);
		table_Contrat.getColumnModel().getColumn(6).setPreferredWidth(65);
		table_Contrat.getColumnModel().getColumn(7).setPreferredWidth(90);
		table_Contrat.getColumnModel().getColumn(8).setPreferredWidth(65);
		table_Contrat.getColumnModel().getColumn(11).setPreferredWidth(65);
		
		spContrat.setViewportView(table_Contrat);
		
		JLabel lblPaiement = new JLabel("Paiement :");
		lblPaiement.setBounds(21, 12, 75, 13);
		getContentPane().add(lblPaiement);
		
		JLabel lblContrat = new JLabel("Contrat :");
		lblContrat.setBounds(21, 217, 75, 13);
		getContentPane().add(lblContrat);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setBounds(250, 400, 119, 23);
		getContentPane().add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(this);
		btnSupprimer.setBounds(422, 400, 119, 23);
		getContentPane().add(btnSupprimer);

		this.controlleur = new GestionPaiements(this);
		btnAjouter.addActionListener(controlleur);
		btnAnnuler.addActionListener(controlleur);

	}
	public void actionPerformed(ActionEvent e) {
	}
}
