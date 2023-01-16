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
	private JTable table_TypeFacture;
	private JTable table_Facture;

	public JTable getTable_TypeFacture() {
		return table_TypeFacture;
	}

	private GestionTypeFacture controlleur;
	private JButton btnCharger, btn_ajouter, annuler, btnModifer, btnSupprimer;
	private GestionTable_TypeF controlleurTable;

	public FEN_TypeFacture() {
		setBounds(0, 0, 880, 515);
		getContentPane().setLayout(null);

		this.btn_ajouter = new JButton("Ajouter");
		btn_ajouter.setBounds(59, 434, 119, 23);
		getContentPane().add(btn_ajouter);

		this.annuler = new JButton("Annuler");
		annuler.setBounds(695, 434, 119, 23);
		getContentPane().add(annuler);

		this.btnCharger = new JButton("Charger");
		btnCharger.setBounds(525, 434, 119, 23);
		getContentPane().add(btnCharger);

		this.btnModifer = new JButton("Modifier");
		btnModifer.setBounds(204, 434, 119, 23);
		getContentPane().add(btnModifer);

		this.btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(364, 434, 119, 23);
		getContentPane().add(btnSupprimer);

		JScrollPane spTypeFactureExistante = new JScrollPane();
		spTypeFactureExistante.setEnabled(false);
		spTypeFactureExistante.setBounds(24, 201, 271, 186);
		getContentPane().add(spTypeFactureExistante);

		table_TypeFacture = new JTable();
		table_TypeFacture.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"P\u00E9riodicit\u00E9", "Type", "Unit\u00E9"
			}
		));
		spTypeFactureExistante.setViewportView(table_TypeFacture);
		
		JScrollPane spFactureExistante = new JScrollPane();
		spFactureExistante.setEnabled(false);
		spFactureExistante.setBounds(24, 31, 637, 136);
		getContentPane().add(spFactureExistante);

		table_Facture = new JTable();
		table_Facture.setModel(new DefaultTableModel(
				new Object[][] {
						{ null, null, null, null, null, null, null, },
						{ null, null, null, null, null, null, null, },
						{ null, null, null, null, null, null, null, },
						{ null, null, null, null, null, null, null, },
						{ null, null, null, null, null, null, null, },
						{ null, null, null, null, null, null, null, },
						{ null, null, null, null, null, null, null, },
						{ null, null, null, null, null, null, null, },
						{ null, null, null, null, null, null, null, },
						{ null, null, null, null, null, null, null, },
						{ null, null, null, null, null, null, null, },
						{ null, null, null, null, null, null, null, },
						{ null, null, null, null, null, null, null, },
						{ null, null, null, null, null, null, null, },
						{ null, null, null, null, null, null, null, },
						{ null, null, null, null, null, null, null, },
						{ null, null, null, null, null, null, null, },
						{ null, null, null, null, null, null, null, },
						{ null, null, null, null, null, null, null, },
				},
				new String[] {
						"NFacture", "Montant", "Prix", "Date", "CoutFixe", "PrixConstate", "Total",
				}));
		spFactureExistante.setViewportView(table_Facture);
		
		
		this.controlleur = new GestionTypeFacture(this);
		btn_ajouter.addActionListener(controlleur);
		annuler.addActionListener(controlleur);
		btnCharger.addActionListener(controlleur);
		btnModifer.addActionListener(controlleur);
		btnSupprimer.addActionListener(controlleur);

		this.controlleurTable = new GestionTable_TypeF(controlleur);
		this.getTable_TypeFacture().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JLabel lblTypeFacture = new JLabel("Type de facture");
		lblTypeFacture.setBounds(22, 178, 107, 13);
		getContentPane().add(lblTypeFacture);
		
		JLabel lblFacture = new JLabel("Facture");
		lblFacture.setBounds(23, 10, 107, 13);
		getContentPane().add(lblFacture);
		this.getTable_TypeFacture().getSelectionModel().addListSelectionListener(controlleurTable);

	}

	public JButton[] getChangeableButtons() {
		return new JButton[] { this.btnSupprimer, this.btnModifer };
	}
}
