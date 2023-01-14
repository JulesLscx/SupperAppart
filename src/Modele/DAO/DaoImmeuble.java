package Modele.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import Controlleur.CictOracleDataSource;
import Modele.Immeuble;
import Modele.DAO.Requete.Requete;

public class DaoImmeuble extends DaoModele<Immeuble> {

    public DaoImmeuble() {
    }

    @Override
    public void create(Immeuble tupple) throws SQLException {
        PreparedStatement prSt = CictOracleDataSource.getLaConnection()
                .prepareCall("call INSERTIMMEUBLE(?,?,?,?,?,?,?,?)");
        prSt.setNString(1, tupple.getId_immeuble());
        prSt.setNString(2, tupple.getAdresse());
        prSt.setNString(3, tupple.getPde_constr());
        prSt.setNString(4, tupple.getNum_bat());
        prSt.setNString(5, tupple.getCp());
        prSt.setNString(6, tupple.getVille());
        prSt.setInt(7, tupple.getCopro());
        prSt.setNString(8, tupple.getAccess_com());
        prSt.execute();
    }

    @Override
    public void update(Immeuble tupple) throws SQLException {
        String req = "Update Immeuble set adresse = ?, pde_constr = ?, num_bat = ?, cp = ?, ville = ?, copro = ?, access_com = ?  where id_immeuble = ?";
        PreparedStatement prSt = CictOracleDataSource.getLaConnection().prepareStatement(req);

        prSt.setNString(1, tupple.getAdresse());
        prSt.setNString(2, tupple.getPde_constr());
        prSt.setNString(3, tupple.getNum_bat());
        prSt.setNString(4, tupple.getCp());
        prSt.setNString(5, tupple.getVille());
        prSt.setInt(6, tupple.getCopro());
        prSt.setNString(7, tupple.getAccess_com());
        prSt.setNString(8, tupple.getId_immeuble());
        prSt.execute();

    }

    @Override
    public void delete(Immeuble tupple) throws SQLException {
        PreparedStatement st = CictOracleDataSource.getLaConnection()
                .prepareStatement("DELETE FROM IMMEUBLE WHERE ID_IMMEUBLE = ?");
        st.setString(1, tupple.getId_immeuble());
        st.executeUpdate();

    }

    @Override
    public Collection<Immeuble> findAll() throws SQLException {
        PreparedStatement prSt = CictOracleDataSource.getLaConnection().prepareStatement("select * from immeuble");
        return super.select(prSt);
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
        access_com = curseur.getNString(8);
        copro = curseur.getInt(7);
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
        PreparedStatement prSt = req.requete();
        req.setParametres(prSt, donnee);
        return super.select(prSt);
    }

    @Override
    public Immeuble findById(Requete<Immeuble> req, String... id) throws SQLException {
        PreparedStatement prSt = req.requete();
        req.setParametres(prSt, id);
        prSt.execute();
        ResultSet rs = prSt.getResultSet();
        rs.next();
        return creerInstance(rs);
    }

}
