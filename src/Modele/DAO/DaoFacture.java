package Modele.DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import Controlleur.CictOracleDataSource;
import Modele.Factures_Charges;
import Modele.Immeuble;
import Modele.Type_Fac;
import Modele.DAO.Requete.Requete;

public class DaoFacture extends DaoModele<Factures_Charges> {

    @Override
    public void create(Factures_Charges tupple) throws SQLException {
        PreparedStatement prSt = CictOracleDataSource.getLaConnection()
                .prepareCall("call INSERTFactures_Charges(?,?,?,?,?,?,?)");
        prSt.setNString(1, tupple.getNumF());
        prSt.setDate(2, tupple.getDateF());
        prSt.setFloat(3, tupple.getTotal());
        prSt.setFloat(4, tupple.getCf());
        prSt.setFloat(5, tupple.getPrix_unite_releve());
        prSt.setFloat(6, tupple.getPrix_unite_constatee());
        prSt.setNString(7, tupple.getTypeF().getTypeF());
        prSt.setNString(8, tupple.getImmeuble().getId_immeuble());
        prSt.execute();
        prSt.close();
    }

    @Override
    public void update(Factures_Charges tupple) throws SQLException {
        String req = "Update Factures_Charges set dateF = ?, total = ?, cf = ?, prix_unite_releve = ?, prix_unite_constatee = ?, typeF = ?, id_immeuble = ?  where num_fac = ?";
        PreparedStatement prSt = CictOracleDataSource.getLaConnection().prepareStatement(req);

        prSt.setNString(8, tupple.getNumF());
        prSt.setDate(1, tupple.getDateF());
        prSt.setFloat(2, tupple.getTotal());
        prSt.setFloat(3, tupple.getCf());
        prSt.setFloat(4, tupple.getPrix_unite_releve());
        prSt.setFloat(5, tupple.getPrix_unite_constatee());
        prSt.setNString(6, tupple.getTypeF().getTypeF());
        prSt.setNString(7, tupple.getImmeuble().getId_immeuble());
        prSt.execute();
        prSt.close();

    }

    @Override
    public void delete(Factures_Charges tupple) throws SQLException {
        PreparedStatement st = CictOracleDataSource.getLaConnection()
                .prepareStatement("DELETE FROM Factures WHERE numF = ?");
        st.setString(1, tupple.getNumF());
        st.executeUpdate();
    }

    @Override
    public Collection<Factures_Charges> findAll() throws SQLException {
        PreparedStatement prSt = CictOracleDataSource.getLaConnection()
                .prepareStatement("select * from Factures");
        return super.select(prSt);
    }

    @Override
    protected Factures_Charges creerInstance(ResultSet curseur) throws SQLException {
        Factures_Charges result = null;
        String numF = curseur.getString(1);
        Date dateF = curseur.getDate(2);
        float total = curseur.getFloat(3);
        float cf = curseur.getFloat(4);
        float prix_unite_releve = curseur.getFloat(5);
        float prix_unite_constatee = curseur.getFloat(6);
        Type_Fac typeF = new DaoType_Fac().findById(null, curseur.getString(7));
        Immeuble immeuble = new DaoImmeuble().findById(null, curseur.getString(8));

        result = new Factures_Charges(numF, dateF, total, cf, prix_unite_releve, prix_unite_constatee, typeF, immeuble);
        return result;
    }

    @Override
    public int miseAJour(Requete<Factures_Charges> req, Factures_Charges donnee) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Factures_Charges> find(Requete<Factures_Charges> req, Factures_Charges donnee) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Factures_Charges findById(Requete<Factures_Charges> req, String... id) throws SQLException {
        PreparedStatement prSt = CictOracleDataSource.getLaConnection()
                .prepareStatement("Select * from Factures_Charges where num_fac = ?");
        prSt.setNString(1, id[0]);
        prSt.execute();
        ResultSet rs = prSt.getResultSet();
        rs.next();
        Factures_Charges c = creerInstance(rs);
        rs.close();
        prSt.close();
        return c;
    }
}
