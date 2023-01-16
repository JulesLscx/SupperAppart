package Modele.DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import Controlleur.CictOracleDataSource;
import Modele.Contrat;
import Modele.Paiements;
import Modele.DAO.Requete.Requete;

public class DaoPaiement extends DaoModele<Paiements> {

    @Override
    public void create(Paiements tupple) throws SQLException {
        PreparedStatement prSt = CictOracleDataSource.getLaConnection()
                .prepareCall("call INSERTPAIEMENTS(?,?,?,?,?)");
        prSt.setNString(1, tupple.getId_paiements());
        prSt.setFloat(2, tupple.getMontant());
        prSt.setDate(3, tupple.getDate());
        prSt.setNString(4, tupple.getMoyen_paiement());
        prSt.setNString(5, tupple.getContrat().getId_contrat());
        prSt.execute();
        prSt.close();
    }

    @Override
    public void update(Paiements tupple) throws SQLException {
        String req = "Update Paiements set montant = ?, datep = ?, moyen_paiement = ?, id_contrat = ? where id_Paiements = ?";
        PreparedStatement prSt = CictOracleDataSource.getLaConnection().prepareStatement(req);

        prSt.setFloat(1, tupple.getMontant());
        prSt.setDate(2, tupple.getDate());
        prSt.setNString(3, tupple.getMoyen_paiement());
        prSt.setNString(4, tupple.getContrat().getId_contrat());
        prSt.setNString(5, tupple.getId_paiements());
        prSt.execute();
        prSt.close();

    }

    @Override
    public void delete(Paiements tupple) throws SQLException {
        PreparedStatement st = CictOracleDataSource.getLaConnection()
                .prepareStatement("DELETE FROM Paiements WHERE ID_Paiements = ?");
        st.setString(1, tupple.getId_paiements());
        st.executeUpdate();
        st.close();
    }

    @Override
    public Collection<Paiements> findAll() throws SQLException {
        PreparedStatement prSt = CictOracleDataSource.getLaConnection().prepareStatement("select * from Paiements");
        return super.select(prSt);
    }

    @Override
    protected Paiements creerInstance(ResultSet curseur) throws SQLException {
        Paiements result = null;
        String id_paiements = curseur.getNString(1);
        float montant = curseur.getFloat(2);
        Date date = curseur.getDate(3);
        String moyen_paiement = curseur.getString(4);
        DaoContrat dao = new DaoContrat();
        Contrat contrat = dao.findById(null, curseur.getString(5));
        result = new Paiements(id_paiements, montant, date, moyen_paiement, contrat);
        return result;
    }

    @Override
    public int miseAJour(Requete<Paiements> req, Paiements donnee) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Paiements> find(Requete<Paiements> req, Paiements donnee) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Paiements findById(Requete<Paiements> req, String... id) throws SQLException {
        PreparedStatement prSt = CictOracleDataSource.getLaConnection()
                .prepareStatement("Select * from Paiements where id_Paiements = ?");
        prSt.setNString(1, id[0]);
        prSt.execute();
        ResultSet rs = prSt.getResultSet();
        rs.next();
        Paiements result = creerInstance(rs);
        rs.close();
        prSt.close();
        return result;
    }
}
