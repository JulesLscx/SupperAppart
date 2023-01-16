package Controlleur.Table;

import java.sql.SQLException;
import java.util.Collection;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Controlleur.GestionLocataire;
import Modele.Contrat;
import Modele.Locataire;
import Modele.DAO.DaoContrat;
import Vue.FEN_Erreurs;

public class GestionTableLocataire implements ListSelectionListener {

    private GestionLocataire otherControlleur;
    private JTable tableContrat;

    public GestionTableLocataire(GestionLocataire otherControlleur, JTable tableContrat) {
        this.tableContrat = tableContrat;
        this.otherControlleur = otherControlleur;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        otherControlleur.enableButtons(e.getFirstIndex() != -1);
        if (e.getFirstIndex() != -1) {
            Locataire l = otherControlleur.lireLigneTable(e.getFirstIndex());
            DaoContrat dao = new DaoContrat();
            try {
                Collection<Contrat> lesContrats = dao.findByLocataire(l.getnLocataire());
                this.displayContrats(lesContrats);
            } catch (SQLException e1) {
                new FEN_Erreurs(e1.getMessage(), tableContrat);
                return;
            }
        }

    }

    public void ecrireLigneTable(int index, Contrat value) {
        tableContrat.setValueAt(value.getId_contrat(), index, 0);
        tableContrat.setValueAt(value.getPrise_effet(), index, 1);
        tableContrat.setValueAt(value.getDuree(), index, 2);
        tableContrat.setValueAt(value.getCharges(), index, 3);
        tableContrat.setValueAt(value.getLoyer(), index, 4);
        tableContrat.setValueAt(value.getDate_revision(), index, 5);
        tableContrat.setValueAt(value.getPeriodicite(), index, 6);
        tableContrat.setValueAt(value.getDate_paiement(), index, 7);
        tableContrat.setValueAt(value.getPaiement(), index, 8);
        tableContrat.setValueAt(value.getDate_edl(), index, 9);
        tableContrat.setValueAt(value.getMontant_caution(), index, 10);
        tableContrat.setValueAt(value.getFin_contrat(), index, 11);
        tableContrat.setValueAt(value.getNum().getNum(), index, 12);
        if (value.getN_siren() != null) {
            tableContrat.setValueAt(value.getN_siren().getnSiren(), index, 13);
        }
        if (value.getId_caution() != null) {
            tableContrat.setValueAt(value.getId_caution().getId_Caution(), index, 14);
        }
    }

    public void viderTable(JTable table) {
        for (int i = 0; i < table.getRowCount(); i++) {
            for (int j = 0; j < table.getColumnCount(); j++) {
                table.setValueAt(null, i, j);
            }
        }
    }

    private void displayContrats(Collection<Contrat> lesContrats) {
        this.viderTable(tableContrat);
        tableContrat.setModel(new DefaultTableModel(
                new String[] { "N\u00B0 Contrat", "Prise effet", "Dur\u00E9e", "Charge", "Loyer",
                        "Date r\u00E9vision", "P\u00E9riodicit\u00E9", "Date paiement", "Paiement", "Date EDL",
                        "Montant caution", "Fin contrat", "Logement", "Entrepreuneur", "Caution"
                },
                lesContrats.size()));
        int i = 0;
        for (Contrat c : lesContrats) {
            if (c == null)
                break;
            this.ecrireLigneTable(i, c);
            i++;
        }
    }
}
