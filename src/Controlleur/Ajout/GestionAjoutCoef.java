package Controlleur.Ajout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;

import Modele.Coef;
import Modele.Logement;
import Modele.Type_Fac;
import Modele.DAO.DaoCoef;
import Modele.DAO.DaoLogement;
import Modele.DAO.DaoType_Fac;
import Vue.FEN_Erreurs;
import Vue.Ajout.FEN_Ajout_Coefficient;

public class GestionAjoutCoef implements ActionListener {

    private FEN_Ajout_Coefficient ac;

    public GestionAjoutCoef(FEN_Ajout_Coefficient ac) {
        this.ac = ac;
        this.fillLogement();
        this.fillTypeF();
    }

    private void fillLogement() {
        try {
            for (Logement l : new DaoLogement().findAll()) {
                this.ac.getText_Num_Logement().addItem(l.getNum());
            }
        } catch (SQLException e) {
            new FEN_Erreurs("Impossible de remplir le combo de logement", ac);
            e.printStackTrace();
        }
    }

    private void fillTypeF() {
        try {
            for (Type_Fac l : new DaoType_Fac().findAll()) {
                this.ac.getText_Type_Fac().addItem(l.getTypeF());
            }
        } catch (SQLException e) {
            new FEN_Erreurs("Impossible de remplir le combo de type factures", ac);
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton item = (JButton) e.getSource();
        switch (item.getText()) {
            case "Annuler":
                this.ac.dispose();
                break;
            case "Valider":
                if (!this.ac.isCoefSet()) {
                    this.inserer();
                } else {
                    this.modifier();
                }
                break;
        }
    }

    private void modifier() {
        DaoCoef dao = new DaoCoef();
        if (this.ac.getText_Num_Logement().getSelectedItem() == null ||
                this.ac.getText_Num_Logement().getSelectedItem() == null ||
                this.ac.getText_Coefficient().getText().isEmpty()) {
            new FEN_Erreurs("Remplissez tous les champs", this.ac);
            return;
        }
        Logement l;
        Type_Fac tf;
        try {
            l = new DaoLogement().findById(null, (String) this.ac.getText_Num_Logement().getSelectedItem());
            tf = new DaoType_Fac().findById(null, (String) this.ac.getText_Type_Fac().getSelectedItem());
        } catch (SQLException e1) {
            new FEN_Erreurs("Impossible de charger le Logement ou le type de factures", ac);
            e1.printStackTrace();
            return;
        }
        Float coef = Float.valueOf(this.ac.getText_Coefficient().getText());
        Coef c = null;
        try {
            c = new Coef(l, tf, coef);
        } catch (Exception e) {
            new FEN_Erreurs(e.getMessage(), ac);
            return;
        }
        try {
            dao.update(c);
            this.ac.dispose();
        } catch (SQLException e) {
            new FEN_Erreurs(e.getMessage(), ac);
            return;
        }
    }

    private void inserer() {
        DaoCoef dao = new DaoCoef();
        if (this.ac.getText_Num_Logement().getSelectedItem() == null ||
                this.ac.getText_Num_Logement().getSelectedItem() == null ||
                this.ac.getText_Coefficient().getText().isEmpty()) {
            new FEN_Erreurs("Remplissez tous les champs", this.ac);
            return;
        }
        Logement l;
        Type_Fac tf;
        try {
            l = new DaoLogement().findById(null, (String) this.ac.getText_Num_Logement().getSelectedItem());
            tf = new DaoType_Fac().findById(null, (String) this.ac.getText_Type_Fac().getSelectedItem());
        } catch (SQLException e1) {
            new FEN_Erreurs("Impossible de charger le Logement ou le type de factures", ac);
            e1.printStackTrace();
            return;
        }
        Float coef = Float.valueOf(this.ac.getText_Coefficient().getText());
        Coef c = null;
        try {
            c = new Coef(l, tf, coef);
        } catch (Exception e) {
            new FEN_Erreurs(e.getMessage(), ac);
            return;
        }
        try {
            dao.create(c);
            this.ac.dispose();
        } catch (SQLException e) {
            new FEN_Erreurs(e.getMessage(), ac);
            return;
        }

    }

}
