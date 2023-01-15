package Modele.DAO;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import Controlleur.CictOracleDataSource;
import Modele.Locataire;
import Modele.DAO.Requete.Requete;
import oracle.jdbc.OracleType;
import oracle.jdbc.OracleTypes;

public class DaoLocataire extends DaoModele<Locataire> {

    @Override
    public void create(Locataire tupple) throws SQLException {
        PreparedStatement prSt = CictOracleDataSource.getLaConnection()
                .prepareCall("call add_locataire(?,?,?,?,?)");
        prSt.setNString(2, tupple.getNom());
        prSt.setNString(3, tupple.getPrenom());
        prSt.setNString(4, tupple.getEmail());
        prSt.setNString(5, tupple.getTel());
        prSt.setString(6, Character.toString(tupple.getGenre()));
        prSt.setNString(1, tupple.getnLocataire());
        prSt.execute();
    }

    @Override
    public void update(Locataire tupple) throws SQLException {
        String req = "Update Locataire set Nom = ?, Prenom = ?, email = ?, tel = ?,genre = ? where nlocataire = ?";
        PreparedStatement prSt = CictOracleDataSource.getLaConnection().prepareStatement(req);
        prSt.setNString(1, tupple.getNom());
        prSt.setNString(2, tupple.getPrenom());
        prSt.setNString(3, tupple.getEmail());
        prSt.setNString(4, tupple.getTel());
        prSt.setString(5, Character.toString(tupple.getGenre()));
        prSt.setNString(6, tupple.getnLocataire());
        prSt.execute();

    }

    @Override
    public void delete(Locataire tupple) throws SQLException {
        PreparedStatement st = CictOracleDataSource.getLaConnection()
                .prepareStatement("DELETE FROM Locataire WHERE NLocataire = ?");
        st.setString(1, tupple.getnLocataire());
        st.executeUpdate();

    }

    @Override
    public Collection<Locataire> findAll() throws SQLException {
        PreparedStatement prSt = CictOracleDataSource.getLaConnection().prepareStatement("select * from locataire");
        return super.select(prSt);
    }

    @Override
    protected Locataire creerInstance(ResultSet curseur) throws SQLException {
        Locataire result = null;
        String nLocataire = curseur.getNString(1);
        String nom = curseur.getNString(2);
        String prenom = curseur.getNString(3);
        String email = curseur.getNString(4);
        String tel = curseur.getNString(5);
        String genre = curseur.getNString(6);
        result = new Locataire(nLocataire, nom, prenom, email, tel, genre.toCharArray()[0]);
        return result;
    }

    @Override
    public int miseAJour(Requete<Locataire> req, Locataire donnee) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Locataire> find(Requete<Locataire> req, Locataire donnee) throws SQLException {
        // TODO
        return null;
    }

    @Override
    public Locataire findById(Requete<Locataire> req, String... id) throws SQLException {
        PreparedStatement st = CictOracleDataSource.getLaConnection()
                .prepareStatement("Select * FROM Locataire WHERE NLocataire = ?");
        st.setString(1, id[0]);
        st.execute();
        ResultSet rs = st.getResultSet();
        rs.next();
        return creerInstance(rs);
    }

    public Collection<Locataire> findCurrentLoc() throws SQLException {
        PreparedStatement prSt = CictOracleDataSource.getLaConnection()
                .prepareStatement("select * from locataire_courants");
        return super.select(prSt);
    }

    public Collection<Locataire> findByLogement(String num) throws SQLException {
        String sql = "{? = call LOCATAIRE_LOGEMENT(?)}";
        ResultSet rs;
        CallableStatement prSt = CictOracleDataSource.getLaConnection().prepareCall(sql);
        prSt.registerOutParameter(1, OracleTypes.CURSOR);
        prSt.setString(2, num);
        prSt.execute();
        rs = (ResultSet) prSt.getObject(1);
        Collection<Locataire> lesLocataires = new ArrayList<Locataire>();
        while (rs.next()) {
            lesLocataires.add(creerInstance(rs));
        }

        return lesLocataires;
    }

    public List<Locataire> findByContrat(String id_contrat) throws SQLException {
        List<Locataire> lesLocataires = new ArrayList<Locataire>();
        String sql = "Select nLocataire from signer where id_contrat = ?";
        PreparedStatement prSt = CictOracleDataSource.getLaConnection().prepareStatement(sql);
        prSt.setNString(1, id_contrat);
        prSt.execute();
        ResultSet rs = prSt.getResultSet();
        while (rs.next()) {
            lesLocataires.add(this.findById(null, rs.getNString(1)));
        }
        return lesLocataires;
    }

}
