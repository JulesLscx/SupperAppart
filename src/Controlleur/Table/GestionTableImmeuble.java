package Controlleur.Table;

import java.sql.SQLException;
import java.util.Collection;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Controlleur.GestionImmeuble;
import Modele.Immeuble;
import Modele.Logement;
import Modele.DAO.DaoLogement;
import Vue.FEN_Erreurs;

public class GestionTableImmeuble implements ListSelectionListener {
    private JTable table_logement;
    private GestionImmeuble otherControlleur;
    private JTable table_assurances;

    public GestionTableImmeuble(JTable table_logement, JTable table_assurances, GestionImmeuble otherControlleur) {
        this.table_logement = table_logement;
        this.table_assurances = table_assurances;
        this.otherControlleur = otherControlleur;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        this.otherControlleur.enableButtons(e.getFirstIndex() != -1);
        if (e.getFirstIndex() != -1) {
            Immeuble i = otherControlleur.lireLigneTable(e.getFirstIndex());
            otherControlleur.viderTable(table_assurances);
            otherControlleur.viderTable(table_logement);
            displayLogement(i.getId_immeuble());
        }
    }

    public void ecrireLogement(int index, Logement value) {
        table_logement.setValueAt(value.getNum(), index, 0);
        table_logement.setValueAt(value.getType_hab(), index, 1);
        table_logement.setValueAt(value.getSurface(), index, 2);
        table_logement.setValueAt(value.getNbpiece(), index, 3);
        table_logement.setValueAt(value.getImmeuble().getId_immeuble(), index, 4);
    }

    public void displayLogement(String id_immeuble) {
        DaoLogement daoLogement = new DaoLogement();
        Collection<Logement> lesLogements;
        try {
            lesLogements = daoLogement.findByImmeuble(id_immeuble);
            table_logement.setModel(new DefaultTableModel(
                    new String[] {
                            "Num\u00E9ro", "Type Habitation", "Surface", "nbPiece", "Immeuble"
                    },
                    lesLogements.size()));
            int i = 0;
            for (Logement c : lesLogements) {
                if (c == null)
                    break;
                this.ecrireLogement(i, c);
                i++;
            }
        } catch (SQLException e) {
            new FEN_Erreurs(e.getMessage(), table_assurances);
            e.printStackTrace();
        }
    }

    public void displayAssurance() {

    }
}
