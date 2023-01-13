package Modele.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import Controlleur.CictOracleDataSource;
import Modele.Caution;
import Modele.DAO.Requete.Requete;

public class DaoCaution extends DaoModele<Caution> {

    @Override
    public void create(Caution tupple) throws SQLException {
        PreparedStatement prSt = CictOracleDataSource.getLaConnection()
                .prepareCall("call INSERTCAUTION(?,?,?,?,?,?,?)");
        prSt.setNString(1, tupple.getId_Caution());
        prSt.setNString(2, tupple.getPrenom());
        prSt.setNString(3, tupple.getNom());
        prSt.setNString(4, tupple.getAdresse());
        prSt.setNString(5, tupple.getEmail());
        prSt.setNString(6, tupple.getTelephone());
        prSt.setNString(7, tupple.getProfession());
        prSt.execute();
    }

    @Override
    public void update(Caution tupple) throws SQLException {
        String req = "Update Caution set prénom = ?, nom = ?, adresse = ?, email = ?, téléphone = ?, profession = ? where id_caution = ?";
        PreparedStatement prSt = CictOracleDataSource.getLaConnection().prepareStatement(req);

        prSt.setNString(1, tupple.getPrenom());
        prSt.setNString(2, tupple.getNom());
        prSt.setNString(3, tupple.getAdresse());
        prSt.setNString(4, tupple.getEmail());
        prSt.setNString(5, tupple.getTelephone());
        prSt.setNString(6, tupple.getProfession());
        prSt.setNString(7, tupple.getId_Caution());
        prSt.execute();

    }

    @Override
    public void delete(Caution tupple) throws SQLException {
        PreparedStatement st = CictOracleDataSource.getLaConnection()
                .prepareStatement("DELETE FROM CAUTION WHERE ID_CAUTION = ?");
        st.setString(1, tupple.getId_Caution());
        st.executeUpdate();
    }

    @Override
    public Collection<Caution> findAll() throws SQLException {
        PreparedStatement prSt = CictOracleDataSource.getLaConnection().prepareStatement("select * from caution");
        return super.select(prSt);
    }

    @Override
    protected Caution creerInstance(ResultSet curseur) throws SQLException {
        Caution result = null;
        String id_Caution, prenom, nom, adresse, email, telephone, profession;
        id_Caution = curseur.getNString(1);
        prenom = curseur.getNString(2);
        nom = curseur.getNString(3);
        adresse = curseur.getNString(4);
        email = curseur.getNString(5);
        telephone = curseur.getNString(6);
        profession = curseur.getNString(7);
        result = new Caution(id_Caution, prenom, nom, adresse, email, telephone, profession);
        return result;
    }

    @Override
    public int miseAJour(Requete<Caution> req, Caution donnee) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Caution> find(Requete<Caution> req, Caution donnee) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Caution findById(Requete<Caution> req, String... id) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

}
