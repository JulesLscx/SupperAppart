package Controlleur.Table;

import java.sql.SQLException;
import java.util.Collection;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Controlleur.GestionLogement;
import Modele.Immeuble;
import Modele.Locataire;
import Modele.Logement;
import Modele.DAO.DaoLocataire;
import Vue.FEN_Erreurs;

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
            this.displayLocataire(l.getNum());

        }

    }

    public void displayLocataire(String num) {
        this.viderTable(table_Locataire);
        DaoLocataire daoLocataire = new DaoLocataire();
        Collection<Locataire> lesLocataires;
        try {
            lesLocataires = daoLocataire.findByLogement(num);
            table_Locataire.setModel(new DefaultTableModel(
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
            new FEN_Erreurs(e.getMessage(), table_Immeuble);
        }
    }

    public void ecrireLocataire(int index, Locataire value) {
        table_Locataire.setValueAt(value.getnLocataire(), index, 0);
        table_Locataire.setValueAt(value.getPrenom(), index, 1);
        table_Locataire.setValueAt(value.getNom(), index, 2);
        table_Locataire.setValueAt(value.getEmail(), index, 3);
        table_Locataire.setValueAt(value.getTel(), index, 4);
        table_Locataire.setValueAt(value.getGenre(), index, 5);
    }

    public void viderTable(JTable table) {
        for (int i = 0; i < table.getRowCount(); i++) {
            for (int j = 0; j < table.getColumnCount(); j++) {
                table.setValueAt(null, i, j);
            }
        }
    }
}