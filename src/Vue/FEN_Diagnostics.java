package Vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Controlleur.GestionDiagnostics;

public class FEN_Diagnostics extends JInternalFrame {
	private JTable table_Diagnostic;
	private GestionDiagnostics controlleur;

	public FEN_Diagnostics() {
		setBounds(0, 0, 880, 473);
		getContentPane().setLayout(null);

		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModifier.setBounds(225, 400, 119, 23);
		getContentPane().add(btnModifier);

		JButton annuler = new JButton("Annuler");
		annuler.setBounds(675, 400, 119, 23);
		getContentPane().add(annuler);

		JScrollPane spFactureExistante = new JScrollPane();
		spFactureExistante.setEnabled(false);
		spFactureExistante.setBounds(49, 22, 794, 358);
		getContentPane().add(spFactureExistante);

		table_Diagnostic = new JTable();
		table_Diagnostic.setModel(new DefaultTableModel(
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
				},
				new String[] {
						"Reference", "Date Diagnostic", "Diagnostic", "Type", "Logement", }));
		spFactureExistante.setViewportView(table_Diagnostic);
		
		JButton Ajout_1 = new JButton("Ajouter");
		Ajout_1.setBounds(75, 400, 119, 23);
		getContentPane().add(Ajout_1);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(375, 400, 119, 23);
		getContentPane().add(btnSupprimer);
		
		JButton btnCharger = new JButton("Charger");
		btnCharger.setBounds(525, 400, 119, 23);
		getContentPane().add(btnCharger);

		this.controlleur = new GestionDiagnostics(this);
		btnModifier.addActionListener(controlleur);
		annuler.addActionListener(controlleur);

	}
}
