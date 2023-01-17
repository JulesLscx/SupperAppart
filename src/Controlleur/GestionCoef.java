package Controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JTable;

import Modele.Coef;
import Modele.Logement;
import Modele.Type_Fac;
import Modele.DAO.DaoCoef;
import Modele.DAO.DaoLogement;
import Modele.DAO.DaoType_Fac;
import Other.MyDefaultTableModel;
import Vue.FEN_Accueil;
import Vue.FEN_Coefficient;
import Vue.FEN_Erreurs;
import Vue.Ajout.FEN_Ajout_Coefficient;

public class GestionCoef implements ActionListener {

    private FEN_Coefficient ai;

    public GestionCoef(FEN_Coefficient ai) {
        this.ai = ai;
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
                this.displayAll();
                break;
            case "Ajouter":
                FEN_Ajout_Coefficient new_fen = new FEN_Ajout_Coefficient();
                this.ai.getLayeredPane().add(new_fen);
                new_fen.setVisible(true);
                break;
            case "Modifier":
                FEN_Ajout_Coefficient new_fen_edition = new FEN_Ajout_Coefficient(
                        this.lireLigneTable(this.ai.getTable_Coefficient().getSelectedRow()));
                this.ai.getLayeredPane().add(new_fen_edition);
                new_fen_edition.setVisible(true);
                break;
            case "Supprimer":
                this.delete();
                break;
        }
    }

    private void delete() {
        DaoCoef dao = new DaoCoef();
        int index = this.ai.getTable_Coefficient().getSelectedRow();
        try {
            dao.delete(this.lireLigneTable(index));
            this.displayAll();
        } catch (SQLException e) {
            new FEN_Erreurs(e.getMessage(), this.ai.getContentPane());
            e.printStackTrace();
        }
    }

    public Coef lireLigneTable(int index) {
        Logement id_logement;
        try {
            id_logement = new DaoLogement().findById(null, (String) ai.getTable_Coefficient().getValueAt(index, 0));
        } catch (SQLException e2) {
            new FEN_Erreurs("Erreur lors du chargement du logement", ai);
            return null;
        }
        Type_Fac typeF;
        try {
            typeF = new DaoType_Fac().findById(null, (String) ai.getTable_Coefficient().getValueAt(index, 1));
        } catch (SQLException e1) {
            new FEN_Erreurs("Erreur lors du chargement du type de facture", ai);
            return null;
        }
        Float coefficient;
        try {
            coefficient = (Float) ai.getTable_Coefficient().getValueAt(index, 2);
        } catch (Exception e) {
            coefficient = Float.valueOf((String) ai.getTable_Coefficient().getValueAt(index, 2));
        }
        return new Coef(id_logement, typeF, coefficient);

    }

    public void ecrireLigneTable(int index, Coef value) {
        JTable lesCoefs;

        lesCoefs = ai.getTable_Coefficient();
        lesCoefs.setValueAt(value.getNum().getNum(), index, 0);
        lesCoefs.setValueAt(value.getTf().getTypeF(), index, 1);
        lesCoefs.setValueAt(value.getCoefficient(), index, 2);
    }

    public void viderTable(JTable table) {
        for (int i = 0; i < table.getRowCount(); i++) {
            for (int j = 0; j < table.getColumnCount(); j++) {
                table.setValueAt(null, i, j);
            }
        }
    }

    private void displayAll() {
        this.viderTable(this.ai.getTable_Coefficient());
        DaoCoef daoCoef = new DaoCoef();
        Collection<Coef> lesCoefs;
        try {
            lesCoefs = daoCoef.findAll();
            ai.getTable_Coefficient().setModel(new MyDefaultTableModel(
                    new String[] { "Contrat", "Type Facture", "Coefficient" },
                    lesCoefs.size()));
            int i = 0;
            for (Coef c : lesCoefs) {
                if (c == null)
                    break;
                this.ecrireLigneTable(i, c);
                i++;
            }
        } catch (SQLException e) {
            new FEN_Erreurs(e.getMessage(), ai);
            e.printStackTrace();
        }
    }

    public void enableButtons(boolean b) {
        for (JButton j : this.ai.getChangeableButtons()) {
            j.setEnabled(b);
        }
    }

}
