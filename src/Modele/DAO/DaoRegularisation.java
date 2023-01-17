package Modele.DAO;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import org.apache.poi.hssf.record.chart.DatRecord;

import Controlleur.CictOracleDataSource;
import Modele.Contrat;
import Modele.Regularisation;
import Modele.Type_Fac;
import Modele.DAO.Requete.Requete;
import oracle.jdbc.OracleTypes;

public class DaoRegularisation extends DaoModele<Regularisation> {

    @Override
    public void create(Regularisation tupple) throws SQLException {
        // PreparedStatement prSt = CictOracleDataSource.getLaConnection()
        // .prepareCall("call INSERTRegularisation(?,?,?,?,?,?,?)");
        // prSt.setNString(1, tupple.getId_Regularisation());
        // prSt.setNString(2, tupple.getPrenom());
        // prSt.setNString(3, tupple.getNom());
        // prSt.setNString(4, tupple.getAdresse());
        // prSt.setNString(5, tupple.getEmail());
        // prSt.setNString(6, tupple.getTelephone());
        // prSt.setNString(7, tupple.getProfession());
        // prSt.execute();
        // prSt.close();
    }

    @Override
    public void update(Regularisation tupple) throws SQLException {
        String req = "Update Regularisation set prénom = ? where id_contrat = ? and dateR = ? and TypeF = ?";
        PreparedStatement prSt = CictOracleDataSource.getLaConnection().prepareStatement(req);
        prSt.setFloat(1, tupple.getMontant());
        prSt.setString(2, tupple.getContrat().getId_contrat());
        prSt.setString(3, tupple.getTypeF().getTypeF());
        prSt.setDate(4, tupple.getDateR());
        prSt.execute();
        prSt.close();

    }

    @Override
    public void delete(Regularisation tupple) throws SQLException {
        PreparedStatement st = CictOracleDataSource.getLaConnection()
                .prepareStatement("DELETE FROM Regularisation WHERE id_contrat = ?, typef = ?, dater = ? ");
        st.setString(1, tupple.getContrat().getId_contrat());
        st.setString(2, tupple.getTypeF().getTypeF());
        st.setDate(3, tupple.getDateR());
        st.executeUpdate();
        st.close();
    }

    @Override
    public Collection<Regularisation> findAll() throws SQLException {
        PreparedStatement prSt = CictOracleDataSource.getLaConnection()
                .prepareStatement("select * from Regularisation");
        return super.select(prSt);
    }

    @Override
    protected Regularisation creerInstance(ResultSet curseur) throws SQLException {
        Regularisation result = null;
        Contrat contrat = null;
        Type_Fac type = null;
        DaoType_Fac daoF = new DaoType_Fac();
        DaoContrat daoC = new DaoContrat();
        Date date = curseur.getDate(3);
        Float montant = curseur.getFloat(4);
        contrat = daoC.findById(null, curseur.getString(1));
        type = daoF.findById(null, curseur.getString(2));
        result = new Regularisation(contrat, type, date, montant);
        return result;
    }

    @Override
    public int miseAJour(Requete<Regularisation> req, Regularisation donnee) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Regularisation> find(Requete<Regularisation> req, Regularisation donnee) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Regularisation findById(Requete<Regularisation> req, String... id) throws SQLException {
        PreparedStatement prSt = CictOracleDataSource.getLaConnection()
                .prepareStatement("Select * from Regularisation where id_contrat = ?, typeF = ?, dateR = ?");
        prSt.setNString(1, id[0]);
        prSt.setNString(2, id[1]);
        prSt.setDate(3, Date.valueOf(id[2]));
        prSt.execute();
        ResultSet rs = prSt.getResultSet();
        rs.next();
        Regularisation c = creerInstance(rs);
        rs.close();
        prSt.close();
        return c;
    }

    public Regularisation simulate(String num, String typeF, Date date) throws SQLException {
        DaoContrat dao = new DaoContrat();
        Contrat c = dao.findByLogement(num);
        Type_Fac type = new DaoType_Fac().findById(null, typeF);
        Calendar laDate = Calendar.getInstance();
        if (date != null) {
            laDate.setTime(date);
        }
        int annee = laDate.get(Calendar.YEAR);
        int mois = laDate.get(Calendar.MONTH);
        int jour = laDate.get(Calendar.DATE);
        String dateBeforeConversion = annee + "-" + mois + "-" + jour;
        Date forInstert = Date.valueOf(dateBeforeConversion);
        Float montant;

        String sql = "{? = call CALCUL_CHARGE_COEF(?,?,?)}";
        CallableStatement prSt = CictOracleDataSource.getLaConnection().prepareCall(sql);
        prSt.registerOutParameter(1, OracleTypes.NUMBER);
        prSt.setString(2, num);
        prSt.setString(3, typeF);
        prSt.setInt(4, annee);
        prSt.execute();
        montant = prSt.getFloat(1);

        return new Regularisation(c, type, forInstert, montant);
    }
}
