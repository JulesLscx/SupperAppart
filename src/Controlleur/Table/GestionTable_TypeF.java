package Controlleur.Table;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Controlleur.GestionTypeFacture;

public class GestionTable_TypeF implements ListSelectionListener {
    private GestionTypeFacture otherControlleur;

    public GestionTable_TypeF(GestionTypeFacture otherControlleur) {
        this.otherControlleur = otherControlleur;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        this.otherControlleur.enableButtons(e.getFirstIndex() != -1);
    }

}
