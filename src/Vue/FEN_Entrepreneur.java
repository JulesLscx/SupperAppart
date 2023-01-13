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

import Controlleur.GestionEntrepreneur;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FEN_Entrepreneur extends JInternalFrame {
	private JTextField numeroSiren, adresse, nom, iBan, secteurActivite;
	private JTable table_TypeFacture;
	private GestionEntrepreneur controlleur;

	public FEN_Entrepreneur() {
		setBounds(0, 0, 880, 473);
		getContentPane().setLayout(null);

		numeroSiren = new JTextField();
		numeroSiren.setBounds(45, 112, 180, 32);
		getContentPane().add(numeroSiren);
		numeroSiren.setColumns(10);

		adresse = new JTextField();
		adresse.setBounds(315, 112, 180, 32);
		getContentPane().add(adresse);
		adresse.setColumns(10);

		nom = new JTextField();
		nom.setBounds(45, 243, 180, 32);
		getContentPane().add(nom);
		nom.setColumns(10);

		iBan = new JTextField();
		iBan.setBounds(315, 243, 180, 32);
		getContentPane().add(iBan);
		iBan.setColumns(10);

		JLabel lblnumero = new JLabel("Num�ro: ");
		lblnumero.setBounds(45, 92, 80, 20);
		getContentPane().add(lblnumero);

		JLabel lblAdresse = new JLabel("Adresse: ");
		lblAdresse.setBounds(315, 92, 80, 20);
		getContentPane().add(lblAdresse);

		JLabel lblSurface = new JLabel("Surface: ");
		lblSurface.setBounds(45, 224, 80, 20);
		getContentPane().add(lblSurface);

		JLabel lblNom = new JLabel("Nom: ");
		lblNom.setBounds(315, 224, 80, 20);
		getContentPane().add(lblNom);

		JButton valider = new JButton("Valider");
		valider.setBounds(567, 409, 89, 23);
		getContentPane().add(valider);

		JButton annuler = new JButton("Annuler");
		annuler.setBounds(698, 409, 89, 23);
		getContentPane().add(annuler);

		secteurActivite = new JTextField();
		secteurActivite.setBounds(178, 357, 180, 32);
		getContentPane().add(secteurActivite);
		secteurActivite.setColumns(10);

		JLabel lblsecteur = new JLabel("Secteur: ");
		lblsecteur.setBounds(178, 338, 80, 20);
		getContentPane().add(lblsecteur);

		JScrollPane spFactureExistante = new JScrollPane();
		spFactureExistante.setEnabled(false);
		spFactureExistante.setBounds(514, 31, 340, 358);
		getContentPane().add(spFactureExistante);

		table_TypeFacture = new JTable();
		table_TypeFacture.setModel(new DefaultTableModel(
				new Object[][] {
						{ null, null, null, null, null, },
						{ null, null, null, null, null, },
						{ null, null, null, null, null, },
						{ null, null, null, null, null, },
						{ null, null, null, null, null, },
						{ null, null, null, null, null, },
						{ null, null, null, null, null, },
						{ null, null, null, null, null, },
						{ null, null, null, null, null, },
						{ null, null, null, null, null, },
						{ null, null, null, null, null, },
						{ null, null, null, null, null, },
						{ null, null, null, null, null, },
						{ null, null, null, null, null, },
						{ null, null, null, null, null, },
						{ null, null, null, null, null, },
						{ null, null, null, null, null, },
						{ null, null, null, null, null, },
						{ null, null, null, null, null, },
						{ null, null, null, null, null, },
						{ null, null, null, null, null, },
						{ null, null, null, null, null, },
						{ null, null, null, null, null, },
						{ null, null, null, null, null, },

				},
				new String[] {
						"numeroSiren", "adresse", "nom", "iBan", "secteurActivite",
				}));
		spFactureExistante.setViewportView(table_TypeFacture);
		this.controlleur = new GestionEntrepreneur(this);
		valider.addActionListener(controlleur);
		annuler.addActionListener(controlleur);

	}

}
