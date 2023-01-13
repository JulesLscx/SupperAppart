package Vue;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

import Controlleur.GestionContrat;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class FEN_Ajout_Contrat extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	private JTextField idContrat, charges, duree, priseEffet, datePaiement, periodicite, loyer, dateRevision;
	private JTextField finContrat, montantCaution, paiement, dateEDL;

	private GestionContrat controlleur;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JLabel lblCharge;
	private JLabel lblDateRvision;
	private JTextField textField_8;
	private JLabel lblDatePaiement;
	private JTextField textField_9;
	private JLabel lblDateEdl;
	private JTextField textField_10;
	private JLabel lblFinContrat;
	private JTextField textField_11;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FEN_Ajout_Contrat frame = new FEN_Ajout_Contrat();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FEN_Ajout_Contrat() {
		setBounds(100, 100, 611, 414);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Durée :");
		lblNewLabel.setBounds(36, 67, 96, 13);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(36, 36, 190, 19);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblIdentifiantContrat = new JLabel("Identifiant contrat : ");
		lblIdentifiantContrat.setBounds(36, 24, 96, 13);
		getContentPane().add(lblIdentifiantContrat);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(36, 79, 190, 19);
		getContentPane().add(textField_1);
		
		JLabel lblLoyer = new JLabel("Loyer :");
		lblLoyer.setBounds(36, 108, 96, 13);
		getContentPane().add(lblLoyer);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(36, 168, 190, 19);
		getContentPane().add(textField_2);
		
		JLabel lblPriodicit = new JLabel("Périodicité :");
		lblPriodicit.setBounds(36, 156, 96, 13);
		getContentPane().add(lblPriodicit);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(36, 124, 190, 19);
		getContentPane().add(textField_3);
		
		JLabel lblPaiement = new JLabel("Paiement :");
		lblPaiement.setBounds(36, 197, 96, 13);
		getContentPane().add(lblPaiement);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(36, 254, 190, 19);
		getContentPane().add(textField_4);
		
		JLabel lblMontantCaution = new JLabel("Montant caution :");
		lblMontantCaution.setBounds(36, 241, 96, 13);
		getContentPane().add(lblMontantCaution);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(36, 209, 190, 19);
		getContentPane().add(textField_5);
		
		JLabel lblIdentifiantContrat_1 = new JLabel("Prise effet :");
		lblIdentifiantContrat_1.setBounds(323, 24, 96, 13);
		getContentPane().add(lblIdentifiantContrat_1);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(323, 36, 190, 19);
		getContentPane().add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(323, 79, 190, 19);
		getContentPane().add(textField_7);
		
		lblCharge = new JLabel("Charges :");
		lblCharge.setBounds(323, 67, 96, 13);
		getContentPane().add(lblCharge);
		
		lblDateRvision = new JLabel("Date révision :");
		lblDateRvision.setBounds(323, 108, 96, 13);
		getContentPane().add(lblDateRvision);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(323, 124, 190, 19);
		getContentPane().add(textField_8);
		
		lblDatePaiement = new JLabel("Date paiement :");
		lblDatePaiement.setBounds(323, 156, 96, 13);
		getContentPane().add(lblDatePaiement);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(323, 168, 190, 19);
		getContentPane().add(textField_9);
		
		lblDateEdl = new JLabel("Date EDL :");
		lblDateEdl.setBounds(323, 197, 96, 13);
		getContentPane().add(lblDateEdl);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(323, 209, 190, 19);
		getContentPane().add(textField_10);
		
		lblFinContrat = new JLabel("Fin contrat :");
		lblFinContrat.setBounds(323, 241, 96, 13);
		getContentPane().add(lblFinContrat);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(323, 254, 190, 19);
		getContentPane().add(textField_11);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.setBounds(36, 325, 85, 21);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Locataire :");
		lblNewLabel_1.setBounds(36, 283, 85, 13);
		getContentPane().add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(36, 298, 121, 21);
		getContentPane().add(comboBox);
		
		

	}
}
	
