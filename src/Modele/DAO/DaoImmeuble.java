package Modele.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import Modele.Immeuble;
import Modele.DAO.Requete.Requete;

public class DaoImmeuble extends DaoModele<Immeuble> {

    @Override
    public void create(Immeuble tupple) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(Immeuble tupple) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(Immeuble tupple) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public Collection<Immeuble> findAll() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected Immeuble creerInstance(ResultSet curseur) throws SQLException {
        Immeuble result = null;
        String id_immeuble, adresse, pde_constr, num_bat, cp, ville, access_com;
        int copro;
        id_immeuble = curseur.getNString(1);
        adresse = curseur.getNString(2);
        pde_constr = curseur.getNString(3);
        num_bat = curseur.getNString(4);
        cp = curseur.getNString(5);
        ville = curseur.getNString(6);
        access_com = curseur.getNString(7);
        copro = curseur.getInt(8);
        result = new Immeuble(id_immeuble, adresse, pde_constr, num_bat, cp, ville, access_com, copro);
        return result;
    }

    @Override
    public int miseAJour(Requete<Immeuble> req, Immeuble donnee) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Immeuble> find(Requete<Immeuble> req, Immeuble donnee) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Immeuble findById(Requete<Immeuble> req, String... id) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

}
