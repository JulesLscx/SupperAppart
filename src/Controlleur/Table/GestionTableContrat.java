package Controlleur.Table;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Controlleur.GestionContrat;

public class GestionTableContrat implements ListSelectionListener {
    private GestionContrat controlleur;

    public GestionTableContrat(GestionContrat controlleur) {
        this.controlleur = controlleur;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        controlleur.enableButtons(e.getFirstIndex() != -1);
    }

}
