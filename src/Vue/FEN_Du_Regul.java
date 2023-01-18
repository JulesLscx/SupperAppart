package Vue;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import Controlleur.GestionDuRegul;
import Other.MyDefaultTableModel;

public class FEN_Du_Regul extends JInternalFrame {
    private JButton btnCharger;
    private JTable table_du;
    private GestionDuRegul controlleur;
    private JTextField textAnnee;
    private JButton annuler;

    public FEN_Du_Regul() {
        setBounds(0, 0, 880, 473);
        getContentPane().setLayout(null);

        annuler = new JButton("Annuler");
        annuler.setBounds(675, 380, 119, 23);
        getContentPane().add(annuler);

        JScrollPane sp_Coefficient = new JScrollPane();
        sp_Coefficient.setEnabled(false);
        sp_Coefficient.setBounds(43, 63, 587, 241);
        getContentPane().add(sp_Coefficient);

        table_du = new JTable();
        table_du.setModel(new MyDefaultTableModel(
                new Object[][] {
                        { null, null, },
                        { null, null, },
                        { null, null, },
                        { null, null, },
                        { null, null, },
                        { null, null, },
                        { null, null, },
                        { null, null, },
                        { null, null, },
                        { null, null, },
                        { null, null, },
                        { null, null, },
                        { null, null, },
                        { null, null, },
                        { null, null, },
                        { null, null, },
                        { null, null, },
                        { null, null, },
                        { null, null, },
                },
                new String[] {
                        "Id_contrat", "Du"
                }));
        sp_Coefficient.setViewportView(table_du);

        btnCharger = new JButton("Charger");
        btnCharger.setBounds(525, 380, 119, 23);
        getContentPane().add(btnCharger);

        JLabel lbl_Coefficient = new JLabel(
                "Coefficient : Une valeur positive signifie que vous devez cette somme au locataire");
        lbl_Coefficient.setBounds(45, 40, 540, 26);

        getContentPane().add(lbl_Coefficient);

        // this.gestionTable = new GestionCautionTable(table_Coefficient, controlleur);
        this.table_du.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        textAnnee = new JTextField();
        textAnnee.setBounds(675, 170, 153, 22);
        getContentPane().add(textAnnee);

        JLabel lbl_combobox_Logement = new JLabel("Année");
        lbl_combobox_Logement.setBounds(675, 145, 150, 14);
        getContentPane().add(lbl_combobox_Logement);

        this.controlleur = new GestionDuRegul(this);
        annuler.addActionListener(controlleur);
        btnCharger.addActionListener(controlleur);

    }

    public JButton getBtnCharger() {
        return btnCharger;
    }

    public JTable getTable_du() {
        return table_du;
    }

    public GestionDuRegul getControlleur() {
        return controlleur;
    }

    public JTextField getTextAnnee() {
        return textAnnee;
    }

    public JButton getAnnuler() {
        return annuler;
    }
}
