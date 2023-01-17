package Vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JTable;

import Modele.DAO.DaoRegularisation;
import Other.MyDefaultTableModel;

public class GestionDuRegul implements ActionListener {

    private FEN_Du_Regul ai;

    public GestionDuRegul(FEN_Du_Regul ai) {
        this.ai = ai;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton item = (JButton) e.getSource();
        switch (item.getText()) {
            case "Annuler":
                this.ai.dispose();
                break;
            case "Charger":
                if (this.ai.getTextAnnee().getText().isEmpty()) {
                    new FEN_Erreurs("Le champs année est obligatoire", ai);
                } else {
                    this.display(Integer.parseInt(this.ai.getTextAnnee().getText()));
                }
                break;
        }
    }

    private void display(int annee) {
        JTable t = this.ai.getTable_du();
        DaoRegularisation dao = new DaoRegularisation();
        try {
            int i = 0;
            float montant;
            Collection<String> toIterate = dao.getContratsFromRegulByYear(annee);
            t.setModel(new MyDefaultTableModel(
                    new String[] {
                            "Id_contrat", "Du"
                    }, toIterate.size()));
            for (String s : toIterate) {
                montant = dao.getDu(annee, s);
                t.setValueAt(s, i, 0);
                t.setValueAt(montant, i, 1);
                i++;
            }
        } catch (SQLException e) {
            new FEN_Erreurs("Impossible de charger les contrats concernés veuillez réessayer", ai);
            return;
        }
    }

}