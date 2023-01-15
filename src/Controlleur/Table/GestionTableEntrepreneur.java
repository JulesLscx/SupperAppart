package Controlleur.Table;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Controlleur.GestionEntrepreneur;

public class GestionTableEntrepreneur implements ListSelectionListener {

    private JTable table;
    private GestionEntrepreneur otherControlleur;

    public GestionTableEntrepreneur(JTable table, GestionEntrepreneur otherControlleur) {
        this.table = table;
        this.otherControlleur = otherControlleur;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        this.otherControlleur.enableButtons(e.getFirstIndex() != -1);
    }

}