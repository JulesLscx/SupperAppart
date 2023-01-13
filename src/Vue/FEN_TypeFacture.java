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

import Controlleur.GestionTypeFacture;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FEN_TypeFacture extends JInternalFrame {
	private JTextField periodicite, type, unite;
	private JTable table_TypeFacture;
	private GestionTypeFacture controlleur;

	public FEN_TypeFacture() {
		setBounds(0, 0, 880, 473);
		getContentPane().setLayout(null);

		periodicite = new JTextField();
		periodicite.setBounds(168, 112, 180, 32);
		getContentPane().add(periodicite);
		periodicite.setColumns(10);

		type = new JTextField();
		type.setBounds(168, 206, 180, 32);
		getContentPane().add(type);
		type.setColumns(10);

		unite = new JTextField();
		unite.setBounds(168, 300, 180, 32);
		getContentPane().add(unite);
		unite.setColumns(10);

		JLabel lblPeriode = new JLabel("P�riodicit�: ");
		lblPeriode.setBounds(168, 92, 80, 20);
		getContentPane().add(lblPeriode);

		JLabel lblType = new JLabel("Type: ");
		lblType.setBounds(168, 186, 80, 20);
		getContentPane().add(lblType);

		JLabel lblUnite = new JLabel("Unit�: ");
		lblUnite.setBounds(168, 280, 80, 20);
		getContentPane().add(lblUnite);

		JButton valider = new JButton("Valider");
		valider.setBounds(567, 409, 89, 23);
		getContentPane().add(valider);

		JButton annuler = new JButton("Annuler");
		annuler.setBounds(698, 409, 89, 23);
		getContentPane().add(annuler);

		JScrollPane spFactureExistante = new JScrollPane();
		spFactureExistante.setEnabled(false);
		spFactureExistante.setBounds(514, 31, 340, 358);
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
						"P�riodicit�", "Type", "Unit�",
				}));
		spFactureExistante.setViewportView(table_TypeFacture);
		this.controlleur = new GestionTypeFacture(this);
		valider.addActionListener(controlleur);
		annuler.addActionListener(controlleur);
	}

}
