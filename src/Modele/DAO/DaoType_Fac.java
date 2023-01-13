package Modele.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import Controlleur.CictOracleDataSource;
import Modele.Type_Fac;
import Modele.DAO.Requete.Requete;

public class DaoType_Fac extends DaoModele<Type_Fac> {

    @Override
    public void create(Type_Fac tupple) throws SQLException {

    }

    @Override
    public void update(Type_Fac tupple) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(Type_Fac tupple) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public Collection<Type_Fac> findAll() throws SQLException {
        PreparedStatement prSt = CictOracleDataSource.getLaConnection().prepareStatement("select * from type_fac");
        return super.select(prSt);
    }

    @Override
    protected Type_Fac creerInstance(ResultSet curseur) throws SQLException {
        Type_Fac result = null;
        String typeF, periodicite, unite;
        typeF = curseur.getNString(1);
        periodicite = curseur.getNString(2);
        unite = curseur.getNString(3);
        result = new Type_Fac(typeF, periodicite, unite);
        return result;
    }

    @Override
    public int miseAJour(Requete<Type_Fac> req, Type_Fac donnee) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Type_Fac> find(Requete<Type_Fac> req, Type_Fac donnee) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Type_Fac findById(Requete<Type_Fac> req, String... id) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

}