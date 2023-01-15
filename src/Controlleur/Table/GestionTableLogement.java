package Controlleur.Table;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Controlleur.GestionLogement;
import Modele.Immeuble;
import Modele.Logement;

public class GestionTableLogement implements ListSelectionListener {

    private GestionLogement otherControlleur;
    private JTable table_Locataire;
    private JTable table_Immeuble;

    public GestionTableLogement(GestionLogement controlleur, JTable table_Immeuble, JTable table_Locataire) {
        this.otherControlleur = controlleur;
        this.table_Immeuble = table_Immeuble;
        this.table_Locataire = table_Locataire;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        this.otherControlleur.enableButtons(e.getFirstIndex() != -1);
        if (e.getFirstIndex() != -1) {
            Logement l = this.otherControlleur.lireLigneTable(e.getFirstIndex());
            Immeuble value = l.getImmeuble();
            int index = 0;
            table_Immeuble.setValueAt(value.getId_immeuble(), index, 0);
            table_Immeuble.setValueAt(value.getAdresse(), index, 1);
            table_Immeuble.setValueAt(value.getPde_constr(), index, 2);
            table_Immeuble.setValueAt(value.getNum_bat(), index, 3);
            table_Immeuble.setValueAt(value.getCp(), index, 4);
            table_Immeuble.setValueAt(value.getVille(), index, 5);
            table_Immeuble.setValueAt(value.getAccess_com(), index, 7);
            table_Immeuble.setValueAt(String.valueOf(value.getCopro()), index, 6);
        }
    }

}
