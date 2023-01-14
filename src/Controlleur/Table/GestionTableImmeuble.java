package Controlleur.Table;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Controlleur.GestionImmeuble;

public class GestionTableImmeuble implements ListSelectionListener {
    private JTable table;
    private GestionImmeuble otherControlleur;

    public GestionTableImmeuble(JTable table, GestionImmeuble otherControlleur) {
        this.table = table;
        this.otherControlleur = otherControlleur;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        this.otherControlleur.enableButtons(e.getFirstIndex() != -1);
    }
}
