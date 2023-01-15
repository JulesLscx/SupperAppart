package Vue;

import java.awt.EventQueue;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import Controlleur.GestionTypeFacture;
import Controlleur.Table.GestionTable_TypeF;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FEN_TypeFacture extends JInternalFrame {
	private JTextField periodicite, type, unite;
	private JTable table_TypeFacture;

	public JTable getTable_TypeFacture() {
		return table_TypeFacture;
	}

	private GestionTypeFacture controlleur;
	private JButton btnCharger, btn_ajouter, annuler, btnModifer, btnSupprimer;
	private GestionTable_TypeF controlleurTable;

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

		JLabel lblPeriode = new JLabel("Périodicité: ");
		lblPeriode.setBounds(168, 92, 80, 20);
		getContentPane().add(lblPeriode);

		JLabel lblType = new JLabel("Type: ");
		lblType.setBounds(168, 186, 80, 20);
		getContentPane().add(lblType);

		JLabel lblUnite = new JLabel("Unit�: ");
		lblUnite.setBounds(168, 280, 80, 20);
		getContentPane().add(lblUnite);

		this.btn_ajouter = new JButton("Ajouter");
		btn_ajouter.setBounds(567, 409, 89, 23);
		getContentPane().add(btn_ajouter);

		this.annuler = new JButton("Annuler");
		annuler.setBounds(698, 409, 89, 23);
		getContentPane().add(annuler);

		this.btnCharger = new JButton("Charger");
		btnCharger.setBounds(498, 409, 89, 23);
		getContentPane().add(btnCharger);

		this.btnModifer = new JButton("Modifier");
		btnModifer.setBounds(398, 409, 89, 23);
		getContentPane().add(btnModifer);

		this.btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(298, 409, 89, 23);
		getContentPane().add(btnSupprimer);

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
						"Périodicité", "Type", "Unité",
				}));
		spFactureExistante.setViewportView(table_TypeFacture);
		this.controlleur = new GestionTypeFacture(this);
		btn_ajouter.addActionListener(controlleur);
		annuler.addActionListener(controlleur);
		btnCharger.addActionListener(controlleur);
		btnModifer.addActionListener(controlleur);
		btnSupprimer.addActionListener(controlleur);

		this.controlleurTable = new GestionTable_TypeF(controlleur);
		this.getTable_TypeFacture().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.getTable_TypeFacture().getSelectionModel().addListSelectionListener(controlleurTable);

	}

	public JButton[] getChangeableButtons() {
		return new JButton[] { this.btnSupprimer, this.btnModifer };
	}

}
