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
        PreparedStatement prSt = CictOracleDataSource.getLaConnection()
                .prepareCall("call INSERTTYPEFACTURE(?,?,?)");
        prSt.setNString(1, tupple.getTypeF());
        prSt.setNString(2, tupple.getPeriodicite());
        prSt.setNString(3, tupple.getUnite());
        prSt.execute();
        prSt.close();
    }

    @Override
    public void update(Type_Fac tupple) throws SQLException {
        String req = "Update Type_Fac set périodicité = ?, unité = ?  where typeF = ?";
        PreparedStatement prSt = CictOracleDataSource.getLaConnection().prepareStatement(req);

        prSt.setNString(1, tupple.getPeriodicite());
        prSt.setNString(2, tupple.getUnite());
        prSt.setNString(3, tupple.getTypeF());
        prSt.execute();
        prSt.close();

    }

    @Override
    public void delete(Type_Fac tupple) throws SQLException {
        PreparedStatement st = CictOracleDataSource.getLaConnection()
                .prepareStatement("DELETE FROM TYPE_FAC WHERE TYPEF = ?");
        st.setString(1, tupple.getTypeF());
        st.executeUpdate();
        st.close();
    }

    @Override
    public Collection<Type_Fac> findAll() throws SQLException {
        PreparedStatement prSt = CictOracleDataSource.getLaConnection().prepareStatement("select * from TYPE_Fac");
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
        PreparedStatement prSt = req.requete();
        req.setParametres(prSt, donnee);
        return super.select(prSt);
    }

    @Override
    public Type_Fac findById(Requete<Type_Fac> req, String... id) throws SQLException {
        PreparedStatement prSt = CictOracleDataSource.getLaConnection()
                .prepareStatement("Select * from Type_fac where typeF = ?");
        prSt.setNString(1, id[0]);
        ResultSet rs = prSt.getResultSet();
        rs.next();
        Type_Fac result = creerInstance(rs);
        rs.close();
        prSt.close();
        return result;
    }

}