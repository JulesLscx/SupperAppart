package Modele.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import java.util.List;

import Controlleur.CictOracleDataSource;
import Modele.Coef;
import Modele.Logement;
import Modele.Type_Fac;
import Modele.DAO.Requete.Requete;

public class DaoCoef extends DaoModele<Coef> {
    @Override
    public void create(Coef tupple) throws SQLException {
        PreparedStatement prSt = CictOracleDataSource.getLaConnection()
                .prepareCall("insert into coef values(?,?,?)");
        prSt.setNString(1, tupple.getNum().getNum());
        prSt.setNString(2, tupple.getTf().getTypeF());
        prSt.setFloat(4, tupple.getCoefficient());
        prSt.execute();
        prSt.close();
    }

    @Override
    public void update(Coef tupple) throws SQLException {
        String req = "Update Coef set coefficient = ? set where num = ?, typeF = ?, ";
        PreparedStatement prSt = CictOracleDataSource.getLaConnection().prepareStatement(req);

        prSt.setNString(3, tupple.getNum().getNum());
        prSt.setNString(1, tupple.getTf().getTypeF());
        prSt.setFloat(2, tupple.getCoefficient());
        prSt.execute();
        prSt.close();

    }

    @Override
    public void delete(Coef tupple) throws SQLException {
        PreparedStatement st = CictOracleDataSource.getLaConnection()
                .prepareStatement("DELETE FROM Coef WHERE num = ? and typef = ?");
        st.setString(1, tupple.getNum().getNum());
        st.setString(1, tupple.getTf().getTypeF());
        st.executeUpdate();
        st.close();
    }

    @Override
    public Collection<Coef> findAll() throws SQLException {
        PreparedStatement prSt = CictOracleDataSource.getLaConnection().prepareStatement("select * from Coef");
        return super.select(prSt);
    }

    @Override
    protected Coef creerInstance(ResultSet curseur) throws SQLException {
        Coef result = null;
        Logement num;
        Type_Fac typefac;
        float coefficient;
        num = new DaoLogement().findById(null, curseur.getNString(1));
        typefac = new DaoType_Fac().findById(null, curseur.getNString(2));
        coefficient = curseur.getFloat(3);
        result = new Coef(num, typefac, coefficient);
        return result;
    }

    @Override
    public int miseAJour(Requete<Coef> req, Coef donnee) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Coef> find(Requete<Coef> req, Coef donnee) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Coef findById(Requete<Coef> req, String... id) throws SQLException {
        PreparedStatement prSt = CictOracleDataSource.getLaConnection()
                .prepareStatement("Select * from Coef where num = ?, typeF = ?");
        prSt.setNString(1, id[0]);
        prSt.setNString(2, id[1]);
        prSt.execute();
        ResultSet rs = prSt.getResultSet();
        rs.next();
        Coef c = creerInstance(rs);
        rs.close();
        prSt.close();
        return c;
    }

    public Collection<Coef> findByLogement(String num) throws SQLException {
        String sql = "select * from coef where num = ?";
        PreparedStatement prSt = CictOracleDataSource.getLaConnection().prepareStatement(sql);
        prSt.setString(1, num);
        return super.select(prSt);
    }

    public Collection<Coef> findAllUsable() throws SQLException {
        String sql = "select * from coef where enlocation(num) = 1";
        PreparedStatement prSt = CictOracleDataSource.getLaConnection().prepareStatement(sql);
        return super.select(prSt);
    }
}
