package Modele.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import Modele.DAO.Requete.Requete;

public abstract class DaoModele<T> implements DaoT<T> {

    protected abstract T creerInstance(ResultSet curseur) throws SQLException;

    /*
     * @Param La requ�te doit avoir tout les arguments
     * 
     * @Return La liste des resultats de la requete prSt
     */
    public List<T> select(PreparedStatement prSt) throws SQLException {
        List<T> result = new LinkedList<T>();
        ResultSet curseur = prSt.executeQuery();
        T value = null;
        while (curseur.next()) {
            value = creerInstance(curseur);
            result.add(value);
        }
        prSt.close();
        curseur.close();
        return result;
    }

    public abstract int miseAJour(Requete<T> req, T donnee) throws SQLException;

    public abstract List<T> find(Requete<T> req, T donnee) throws SQLException;

    public abstract T findById(Requete<T> req, String... id) throws SQLException;
}
