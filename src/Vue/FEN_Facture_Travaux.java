package Vue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Controlleur.GestionFactureTravaux;

public class FEN_Facture_Travaux extends JInternalFrame {
	private JTable table_Facture;
	private JTable table_Entrepreneur;
	private GestionFactureTravaux controlleur;

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
	public FEN_Facture_Travaux() {
		setBounds(0, 0, 880, 473);
		getContentPane().setLayout(null);

		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(84, 397, 119, 23);
		getContentPane().add(btnValider);

		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(547, 397, 119, 23);
		getContentPane().add(btnAnnuler);

		JScrollPane spFactureLogement = new JScrollPane();
		spFactureLogement.setEnabled(false);
		spFactureLogement.setBounds(22, 31, 832, 149);
		getContentPane().add(spFactureLogement);

		table_Facture = new JTable();
		table_Facture.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Date intervention", "Nature", "Facture", "Prix", "Num\u00E9ro facture", "Montant indeductible", "R\u00E9duction", "Ordre ch\u00E8que", "Num\u00E9ro ch\u00E8que", "Date paiement"
			}
		));
		table_Facture.getColumnModel().getColumn(4).setPreferredWidth(119);
		spFactureLogement.setViewportView(table_Facture);
		
		JScrollPane spEntrepreneur = new JScrollPane();
		spEntrepreneur.setEnabled(false);
		spEntrepreneur.setBounds(22, 234, 438, 66);
		getContentPane().add(spEntrepreneur);
		
		table_Entrepreneur = new JTable();
		table_Entrepreneur.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"n\u00B0 siret", "Adresse", "Nom", "IBAN", "Secteur d'activit\u00E9"
			}
		));
		table_Entrepreneur.getColumnModel().getColumn(4).setPreferredWidth(95);
		spEntrepreneur.setViewportView(table_Entrepreneur);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setBounds(238, 398, 119, 23);
		getContentPane().add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(395, 397, 119, 23);
		getContentPane().add(btnSupprimer);
		
		JLabel lblFactureLogement = new JLabel("Facture logement");
		lblFactureLogement.setBounds(22, 10, 110, 13);
		getContentPane().add(lblFactureLogement);
		
		JLabel lblEntrepreneur = new JLabel("Entrepreneur");
		lblEntrepreneur.setBounds(22, 214, 126, 13);
		getContentPane().add(lblEntrepreneur);
		this.controlleur = new GestionFactureTravaux(this);
		btnValider.addActionListener(controlleur);
		btnAnnuler.addActionListener(controlleur);
	}

}
