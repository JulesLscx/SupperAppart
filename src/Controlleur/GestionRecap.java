package Controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JTable;

import Modele.Facture_Travaux_Immeuble;
import Modele.Facture_Travaux_Logement;
import Modele.Immeuble;
import Modele.Paiements;
import Modele.DAO.DaoFacture_Travaux_Immeuble;
import Modele.DAO.DaoFacture_Travaux_Logement;
import Modele.DAO.DaoImmeuble;
import Modele.DAO.DaoPaiement;
import Other.MyDefaultTableModel;
import Vue.FEN_Erreurs;
import Vue.FEN_Recap;
import Vue.FEN_Accueil;

public class GestionRecap implements ActionListener {

    private FEN_Recap ai;

    public GestionRecap(FEN_Recap ac) {
        this.ai = ac;
        this.fillComboImmeuble();
    }

    private void fillComboImmeuble() {
        try {
            for (Immeuble i : new DaoImmeuble().findAll()) {
                this.ai.getComboBox_Immeuble().addItem(i.getId_immeuble());
            }
        } catch (SQLException e) {
            new FEN_Erreurs("Impossible de remplir le combo", ai);
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton item = (JButton) e.getSource();
        switch (item.getText()) {
            case "Annuler":
                ((FEN_Accueil) this.ai.getTopLevelAncestor()).switchOuverte();
                this.ai.dispose();
                break;
            case "Charger":
                if (this.ai.getTextField_Annee().getText().isEmpty()
                        || this.ai.getComboBox_Immeuble().getSelectedIndex() == -1) {
                    new FEN_Erreurs("Ne laissez aucun des deux champs vides", ai);
                    return;
                }
                this.displayAll(Integer.valueOf(this.ai.getTextField_Annee().getText()),
                        (String) this.ai.getComboBox_Immeuble().getSelectedItem());
                break;
        }
    }

    public void ecrireLigneTablePaiement(int index, Paiements value) {
        JTable lesCautions;

        lesCautions = ai.getTable_Paiements();

        lesCautions.setValueAt(value.getId_paiements(), index, 0);
        lesCautions.setValueAt(value.getMontant(), index, 1);
        lesCautions.setValueAt(value.getDate(), index, 2);
        lesCautions.setValueAt(value.getMoyen_paiement(), index, 3);
        lesCautions.setValueAt(value.getContrat().getId_contrat(), index, 4);
    }

    public void viderTable(JTable table) {
        for (int i = 0; i < table.getRowCount(); i++) {
            for (int j = 0; j < table.getColumnCount(); j++) {
                table.setValueAt(null, i, j);
            }
        }
    }

    private void displayAll(int annee, String id_immeuble) {
        this.displayPaiements(annee, id_immeuble);
        this.displayTravaux(annee, id_immeuble);
    }

    private void displayTravaux(int annee, String id_immeuble) {
        this.viderTable(this.ai.getTable_TravauxImmeuble());
        DaoFacture_Travaux_Immeuble daoT1 = new DaoFacture_Travaux_Immeuble();
        Collection<Facture_Travaux_Immeuble> lesTravaux;
        DaoFacture_Travaux_Logement daoT2 = new DaoFacture_Travaux_Logement();
        Collection<Facture_Travaux_Logement> lesTravaux2;
        float reduc, total;
        reduc = 0;
        total = 0;
        try {
            lesTravaux = daoT1.findByAnnee(annee, id_immeuble);
            lesTravaux2 = daoT2.findByAnnee(annee, id_immeuble);
            ai.getTable_TravauxImmeuble().setModel(new MyDefaultTableModel(
                    new String[] { "N° facture", "Nature", "Prix", "Montant indéductible", "Réduction",
                            "Ordre du chèque", "N° chèque", "Date de paiement",
                            "N° siren" },
                    lesTravaux.size() + lesTravaux2.size() + 1));
            int i = 0;
            for (Facture_Travaux_Immeuble c : lesTravaux) {
                if (c == null)
                    break;
                this.ecrireLigneTableTrav(i, c);
                reduc += c.getReduction();
                total += c.getPrix();
                i++;
            }
            for (Facture_Travaux_Logement c : lesTravaux2) {
                if (c == null)
                    break;
                this.ecrireLigneTableTrav(i, c);
                reduc += c.getReduction();
                total += c.getPrix();
                i++;
            }
            int lastLine = lesTravaux.size() + lesTravaux2.size();
            this.ai.getTable_TravauxImmeuble().setValueAt("Total", lastLine, 0);
            this.ai.getTable_TravauxImmeuble().setValueAt(total, lastLine, 2);
            this.ai.getTable_TravauxImmeuble().setValueAt(reduc, lastLine, 4);
            this.ai.getTable_TravauxImmeuble().setValueAt(total - reduc, lastLine, 3);
        } catch (SQLException e) {
            new FEN_Erreurs(e.getMessage(), ai);
            e.printStackTrace();
        }
    }

    private void ecrireLigneTableTrav(int index, Facture_Travaux_Immeuble value) {
        JTable lesFacs;

        lesFacs = ai.getTable_TravauxImmeuble();

        lesFacs.setValueAt(value.getNum_fac(), index, 0);
        lesFacs.setValueAt(value.getNature(), index, 1);
        lesFacs.setValueAt(value.getPrix(), index, 2);
        lesFacs.setValueAt(value.getMontant_indeductible(), index, 3);
        lesFacs.setValueAt(value.getReduction(), index, 4);
        lesFacs.setValueAt(value.getOrdre_du_cheque(), index, 5);
        lesFacs.setValueAt(value.getNumero_du_cheque(), index, 6);
        lesFacs.setValueAt(value.getDate_de_paiement(), index, 7);
        lesFacs.setValueAt(value.getEntrepreneur().getnSiren(), index, 8);
    }

    private void ecrireLigneTableTrav(int index, Facture_Travaux_Logement value) {
        JTable lesFacs;

        lesFacs = ai.getTable_TravauxImmeuble();

        lesFacs.setValueAt(value.getNum_fac(), index, 0);
        lesFacs.setValueAt(value.getNature(), index, 1);
        lesFacs.setValueAt(value.getPrix(), index, 2);
        lesFacs.setValueAt(value.getMontant_indeductible(), index, 3);
        lesFacs.setValueAt(value.getReduction(), index, 4);
        lesFacs.setValueAt(value.getOrdre_du_cheque(), index, 5);
        lesFacs.setValueAt(value.getNumero_du_cheque(), index, 6);
        lesFacs.setValueAt(value.getDate_de_paiement(), index, 7);
        lesFacs.setValueAt(value.getEntrepreneur().getnSiren(), index, 8);
    }

    private void displayPaiements(int annee, String id_immeuble) {
        this.viderTable(this.ai.getTable_Paiements());
        DaoPaiement daoPaiement = new DaoPaiement();
        Collection<Paiements> lesPaiements = null;
        float sum = 0;
        try {
            lesPaiements = daoPaiement.findByAnnee(annee, id_immeuble);
            ai.getTable_Paiements().setModel(new MyDefaultTableModel(
                    new String[] { "Id", "Montant", "Date", "Moyen Paiement",
                            "id_contrat" },
                    lesPaiements.size() + 1));
            int i = 0;
            for (Paiements c : lesPaiements) {
                if (c == null)
                    break;
                this.ecrireLigneTablePaiement(i, c);
                sum += c.getMontant();
                i++;
            }
        } catch (SQLException e) {
            new FEN_Erreurs(e.getMessage(), ai);
            e.printStackTrace();
        }
        this.ai.getTable_Paiements().setValueAt("Total", lesPaiements.size(), 0);
        this.ai.getTable_Paiements().setValueAt(sum, lesPaiements.size(), 1);
    }

}
