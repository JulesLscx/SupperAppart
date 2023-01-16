package Controlleur.Table;

import java.sql.SQLException;
import java.util.Collection;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Controlleur.GestionContrat;
import Modele.Caution;
import Modele.Contrat;
import Modele.Locataire;
import Modele.DAO.DaoLocataire;

public class GestionTableContrat implements ListSelectionListener {
    private GestionContrat controlleur;
    private JTable table_caution, table_locataire;

    public GestionTableContrat(GestionContrat controlleur, JTable table_caution, JTable table_locataire) {
        this.controlleur = controlleur;
        this.table_caution = table_caution;
        this.table_locataire = table_locataire;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        controlleur.enableButtons(e.getFirstIndex() != -1);
        if (e.getFirstIndex() != -1) {
            this.controlleur.viderTable(table_caution);
            this.controlleur.viderTable(table_locataire);
            Contrat c = controlleur.lireLigneTable(e.getFirstIndex());
            this.displayLocataires(c.getId_contrat());
            if (c.getId_caution() != null)
                this.displayCaution(c.getId_caution());
        }
    }

    private void displayLocataires(String contrat) {
        DaoLocataire daoLocataire = new DaoLocataire();
        Collection<Locataire> lesLocataires;
        try {
            lesLocataires = daoLocataire.findByContrat(contrat);
            table_locataire.setModel(new DefaultTableModel(
                    new String[] { "nLocataire", "nom", "prenom",
                            "email", "telephone", "genre" },
                    lesLocataires.size()));
            int i = 0;
            for (Locataire c : lesLocataires) {
                if (c == null)
                    break;
                this.ecrireLocataire(i, c);
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void displayCaution(Caution c) {
        table_caution.setValueAt(c.getId_Caution(), 0, 0);
        table_caution.setValueAt(c.getPrenom(), 0, 1);
        table_caution.setValueAt(c.getNom(), 0, 2);
        table_caution.setValueAt(c.getAdresse(), 0, 3);
        table_caution.setValueAt(c.getEmail(), 0, 4);
        table_caution.setValueAt(c.getTelephone(), 0, 5);
        table_caution.setValueAt(c.getProfession(), 0, 6);
    }

    public void ecrireLocataire(int index, Locataire value) {
        table_locataire.setValueAt(value.getnLocataire(), index, 0);
        table_locataire.setValueAt(value.getPrenom(), index, 1);
        table_locataire.setValueAt(value.getNom(), index, 2);
        table_locataire.setValueAt(value.getEmail(), index, 3);
        table_locataire.setValueAt(value.getTel(), index, 4);
        table_locataire.setValueAt(value.getGenre(), index, 5);
    }

}
