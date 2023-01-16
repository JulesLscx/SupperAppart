package Modele.DAO;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import Controlleur.CictOracleDataSource;
import Modele.Immeuble;
import Modele.Logement;
import Modele.DAO.Requete.Requete;
import oracle.jdbc.OracleTypes;

public class DaoLogement extends DaoModele<Logement> {

    @Override
    public void create(Logement tupple) throws SQLException {
        PreparedStatement prSt = CictOracleDataSource.getLaConnection()
                .prepareCall("call INSERTLOGEMENT(?,?,?,?,?)");
        prSt.setNString(2, tupple.getType_hab());
        prSt.setFloat(3, tupple.getSurface());
        prSt.setInt(4, tupple.getNbpiece());
        prSt.setNString(5, tupple.getImmeuble().getId_immeuble());
        prSt.setNString(1, tupple.getNum());
        prSt.execute();
        prSt.close();
    }

    @Override
    public void update(Logement tupple) throws SQLException {
        String req = "Update Logement set type_hab = ?, surface = ?, nbPiece = ?, id_immeuble = ? where num = ?";
        PreparedStatement prSt = CictOracleDataSource.getLaConnection().prepareStatement(req);
        prSt.setNString(1, tupple.getType_hab());
        prSt.setFloat(2, tupple.getSurface());
        prSt.setInt(3, tupple.getNbpiece());
        prSt.setNString(4, tupple.getImmeuble().getId_immeuble());
        prSt.setNString(5, tupple.getNum());
        prSt.execute();
        prSt.close();

    }

    @Override
    public void delete(Logement tupple) throws SQLException {
        PreparedStatement st = CictOracleDataSource.getLaConnection()
                .prepareStatement("DELETE FROM Logement WHERE num = ?");
        st.setString(1, tupple.getNum());
        st.executeUpdate();
        st.close();

    }

    @Override
    public Collection<Logement> findAll() throws SQLException {
        PreparedStatement prSt = CictOracleDataSource.getLaConnection().prepareStatement("select * from Logement");
        return super.select(prSt);
    }

    @Override
    protected Logement creerInstance(ResultSet curseur) throws SQLException {
        DaoImmeuble daoI = new DaoImmeuble();
        String num, type_hab;
        float surface;
        int nbpiece;
        Immeuble immeuble;
        num = curseur.getNString(1);
        type_hab = curseur.getNString(2);
        surface = curseur.getFloat(3);
        nbpiece = curseur.getInt(4);
        immeuble = daoI.findById(null, curseur.getNString(5));
        return new Logement(num, type_hab, surface, nbpiece, immeuble);
    }

    @Override
    public int miseAJour(Requete<Logement> req, Logement donnee) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Logement> find(Requete<Logement> req, Logement donnee) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Logement findById(Requete<Logement> req, String... id) throws SQLException {
        PreparedStatement prSt = CictOracleDataSource.getLaConnection()
                .prepareStatement("Select * from Logement where num = ?");
        prSt.setNString(1, id[0]);
        prSt.execute();
        ResultSet rs = prSt.getResultSet();
        rs.next();
        Logement l = creerInstance(rs);
        rs.close();
        prSt.close();
        return l;
    }

    public Collection<Logement> findByImmeuble(String id_immeuble) throws SQLException {
        String sql = "{? = call LOGEMENT_IMMEUBLE(?)}";
        ResultSet rs;
        CallableStatement prSt = CictOracleDataSource.getLaConnection().prepareCall(sql);
        prSt.registerOutParameter(1, OracleTypes.CURSOR);
        prSt.setString(2, id_immeuble);
        prSt.execute();
        rs = (ResultSet) prSt.getObject(1);
        Collection<Logement> lesLogements = new ArrayList<Logement>();
        while (rs.next()) {
            lesLogements.add(creerInstance(rs));
        }
        rs.close();
        prSt.close();
        return lesLogements;
    }

}
