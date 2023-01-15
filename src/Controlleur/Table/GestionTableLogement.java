package Controlleur.Table;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Controlleur.GestionLogement;

public class GestionTableLogement implements ListSelectionListener {

    private GestionLogement otherControlleur;

    public GestionTableLogement(GestionLogement otherControlleur) {
        this.otherControlleur = otherControlleur;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        this.otherControlleur.enableButtons(e.getFirstIndex() != -1);
    }

}
