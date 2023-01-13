package Vue;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AjouterContacts extends JInternalFrame implements ActionListener {
	private JTextField nomContact;
	private JTextField prenomContact;
	private JTextField telephoneContact;
	private JTextField emailContact;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjouterContacts frame = new AjouterContacts();
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
	public AjouterContacts() {
		setBounds(0, 0, 443, 595);
		getContentPane().setLayout(null);

		JLabel lblnomContacts = new JLabel("Nom du contact");
		lblnomContacts.setBounds(71, 31, 130, 23);
		getContentPane().add(lblnomContacts);

		nomContact = new JTextField();
		nomContact.setBounds(71, 54, 286, 44);
		getContentPane().add(nomContact);
		nomContact.setColumns(10);

		prenomContact = new JTextField();
		prenomContact.setColumns(10);
		prenomContact.setBounds(71, 152, 286, 44);
		getContentPane().add(prenomContact);

		JLabel lblprenomContacts = new JLabel("Prenom Contact");
		lblprenomContacts.setBounds(71, 129, 130, 23);
		getContentPane().add(lblprenomContacts);

		telephoneContact = new JTextField();
		telephoneContact.setColumns(10);
		telephoneContact.setBounds(71, 249, 286, 44);
		getContentPane().add(telephoneContact);

		JLabel lbltelephoneContact = new JLabel("Telephone Contact");
		lbltelephoneContact.setBounds(71, 226, 130, 23);
		getContentPane().add(lbltelephoneContact);

		emailContact = new JTextField();
		emailContact.setColumns(10);
		emailContact.setBounds(71, 347, 286, 44);
		getContentPane().add(emailContact);

		JLabel lblemailContact = new JLabel("Email Contact");
		lblemailContact.setBounds(71, 324, 130, 23);
		getContentPane().add(lblemailContact);

		JButton btnPhoto = new JButton("Photo");
		btnPhoto.setBounds(10, 436, 120, 120);
		getContentPane().add(btnPhoto);

		JLabel lblPhoto = new JLabel("Photo");
		lblPhoto.setBounds(10, 413, 39, 23);
		getContentPane().add(lblPhoto);

		JLabel lblDescriptif = new JLabel("Descriptif");
		lblDescriptif.setBounds(296, 413, 39, 23);
		getContentPane().add(lblDescriptif);

		JButton btnDescriptif = new JButton("Descriptif");
		btnDescriptif.setBounds(296, 436, 120, 120);
		getContentPane().add(btnDescriptif);

		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(152, 480, 120, 32);
		getContentPane().add(btnValider);

		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(this);
		btnAnnuler.setBounds(152, 524, 120, 32);
		getContentPane().add(btnAnnuler);

	}

	public void actionPerformed(ActionEvent e) {
		JButton item = (JButton) e.getSource();
		switch (item.getText()) {
			case "Annuler":
				((FEN_Accueil) this.getTopLevelAncestor()).switchOuverte();
				this.dispose();
				break;
		}
	}
}
