package Vue;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import Controlleur.GestionEntrepreneur;
import Controlleur.Table.GestionTableEntrepreneur;

public class FEN_Entrepreneur extends JInternalFrame {
	private JTable table_entrepreuneur;
	private GestionEntrepreneur controlleur;
	private JButton btn_modifier;
	private JButton btn_supprimer;
	private JButton btn_ajouter;
	private JButton btn_charger;
	private JButton annuler;
	private GestionTableEntrepreneur gestionTable;

	public FEN_Entrepreneur() {
		setBounds(0, 0, 880, 473);
		getContentPane().setLayout(null);

		btn_modifier = new JButton("Modifier");
		btn_modifier.setBounds(75, 409, 119, 23);
		getContentPane().add(btn_modifier);

		btn_ajouter = new JButton("Ajouter");
		btn_ajouter.setBounds(225, 409, 119, 23);
		getContentPane().add(btn_ajouter);

		btn_supprimer = new JButton("Supprimer");
		btn_supprimer.setBounds(375, 409, 119, 23);
		getContentPane().add(btn_supprimer);

		btn_charger = new JButton("Charger");
		btn_charger.setBounds(525, 409, 119, 23);
		getContentPane().add(btn_charger);

		annuler = new JButton("Annuler");
		annuler.setBounds(675, 409, 119, 23);
		getContentPane().add(annuler);

		JScrollPane spFactureExistante = new JScrollPane();
		spFactureExistante.setEnabled(false);
		spFactureExistante.setBounds(20, 20, 840, 300);
		getContentPane().add(spFactureExistante);

		table_entrepreuneur = new JTable();
		table_entrepreuneur.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"N\u00B0 SIREN", "Adresse", "Nom", "IBAN", "Secteur activite"
			}
		));
		spFactureExistante.setViewportView(table_entrepreuneur);
		this.controlleur = new GestionEntrepreneur(this);
		btn_ajouter.addActionListener(controlleur);
		annuler.addActionListener(controlleur);
		btn_charger.addActionListener(controlleur);
		btn_supprimer.addActionListener(controlleur);
		btn_modifier.addActionListener(controlleur);

		this.gestionTable = new GestionTableEntrepreneur(table_entrepreuneur, controlleur);
		this.getTable_entrepreuneur().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.getTable_entrepreuneur().getSelectionModel().addListSelectionListener(gestionTable);
	}

	public JButton[] getChangeableButtons() {
		return new JButton[] { this.btn_supprimer, this.btn_modifier };
	}

	public JTable getTable_entrepreuneur() {
		return this.table_entrepreuneur;
	}

}
