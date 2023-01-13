package Controlleur.Table;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Controlleur.GestionCaution;

public class GestionCautionTable implements ListSelectionListener {

    private JTable table;
    private GestionCaution otherControlleur;

    public GestionCautionTable(JTable table, GestionCaution otherControlleur) {
        this.table = table;
        this.otherControlleur = otherControlleur;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        this.otherControlleur.enableButtons(e.getFirstIndex() != -1);
    }

}
