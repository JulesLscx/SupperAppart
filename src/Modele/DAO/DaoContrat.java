package Modele.DAO;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import Controlleur.CictOracleDataSource;
import Modele.Caution;
import Modele.Contrat;
import Modele.Entrepreneur;
import Modele.Logement;
import Modele.DAO.Requete.Requete;
import oracle.jdbc.OracleTypes;

public class DaoContrat extends DaoModele<Contrat> {

    @Override
    public void create(Contrat tupple) throws SQLException {
        PreparedStatement prSt = CictOracleDataSource.getLaConnection().prepareStatement("""
                            INSERT INTO CONTRAT(ID_CONTRAT,PRISE_EFFET,DURÉE,
                        CHARGES,
                        LOYER,
                        DATE_REVISION,
                        PÉRIODICITÉ,
                        DATE_PAIEMENT,
                        PAIEMENT,
                        DATE_EDL,
                        MONTANT_CAUTION,
                        FIN_CONTRAT,
                        NUM,
                        N_SIREN,
                        ID_CAUTION)
                VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)""");
        prSt.setNString(1, tupple.getId_contrat());
        prSt.setDate(2, tupple.getPrise_effet());
        prSt.setInt(3, tupple.getDuree());
        prSt.setFloat(4, tupple.getCharges());
        prSt.setFloat(5, tupple.getLoyer());
        if (tupple.getDate_revision() != null) {
            prSt.setDate(6, tupple.getDate_revision());
        } else {
            prSt.setNull(6, OracleTypes.DATE);
        }
        if (tupple.getPeriodicite() != null) {
            prSt.setNString(7, tupple.getPeriodicite());
        } else {
            prSt.setNull(7, OracleTypes.VARCHAR);
        }
        if (tupple.getDate_paiement() != null) {
            prSt.setDate(8, tupple.getDate_paiement());
        } else {
            prSt.setNull(8, OracleTypes.DATE);
        }
        prSt.setFloat(9, tupple.getPaiement());
        if (tupple.getDate_edl() != null) {
            prSt.setDate(10, tupple.getDate_edl());
        } else {
            prSt.setNull(10, OracleTypes.DATE);
        }
        prSt.setFloat(11, tupple.getMontant_caution());
        if (tupple.getFin_contrat() != null) {
            prSt.setDate(12, tupple.getFin_contrat());
        } else {
            prSt.setNull(12, OracleTypes.DATE);
        }
        prSt.setNString(13, tupple.getNum().getNum());
        if (tupple.getN_siren() == null) {
            prSt.setNull(14, OracleTypes.VARCHAR);
        } else {
            prSt.setNString(14, tupple.getN_siren().getnSiren());
        }
        if (tupple.getId_caution() == null) {
            prSt.setNull(15, OracleTypes.VARCHAR);
        } else {
            prSt.setNString(15, tupple.getId_caution().getId_Caution());
        }

        prSt.executeUpdate();
    }

    @Override
    public void update(Contrat tupple) throws SQLException {
        String req = """
                Update contrat set prise_effet = ?,
                 durée = ?, charges = ?, loyer = ?,
                  date_revision = ?, périodicité = ?,
                   date_paiement = ?, paiement = ?,
                    date_edl = ?, montant_caution = ?,
                     fin_contrat = ?, num = ?, n_siren = ?,
                      id_caution = ? where id_contrat = ?
                """;
        PreparedStatement prSt = CictOracleDataSource.getLaConnection().prepareStatement(req);
        prSt.setNString(15, tupple.getId_contrat());
        prSt.setDate(1, tupple.getPrise_effet());
        prSt.setInt(2, tupple.getDuree());
        prSt.setFloat(3, tupple.getCharges());
        prSt.setFloat(4, tupple.getLoyer());
        if (tupple.getDate_revision() != null) {
            prSt.setDate(5, tupple.getDate_revision());
        } else {
            prSt.setNull(5, OracleTypes.DATE);
        }
        if (tupple.getPeriodicite() != null) {
            prSt.setNString(6, tupple.getPeriodicite());
        } else {
            prSt.setNull(6, OracleTypes.VARCHAR);
        }
        if (tupple.getDate_paiement() != null) {
            prSt.setDate(7, tupple.getDate_paiement());
        } else {
            prSt.setNull(7, OracleTypes.DATE);
        }
        prSt.setFloat(8, tupple.getPaiement());
        if (tupple.getDate_edl() != null) {
            prSt.setDate(9, tupple.getDate_edl());
        } else {
            prSt.setNull(9, OracleTypes.DATE);
        }
        prSt.setFloat(10, tupple.getMontant_caution());
        if (tupple.getFin_contrat() != null) {
            prSt.setDate(11, tupple.getFin_contrat());
        } else {
            prSt.setNull(11, OracleTypes.DATE);
        }
        prSt.setNString(12, tupple.getNum().getNum());
        if (tupple.getN_siren() == null) {
            prSt.setNull(13, OracleTypes.VARCHAR);
        } else {
            prSt.setNString(13, tupple.getN_siren().getnSiren());
        }
        if (tupple.getId_caution() == null) {
            prSt.setNull(14, OracleTypes.VARCHAR);
        } else {
            prSt.setNString(14, tupple.getId_caution().getId_Caution());
        }

        prSt.executeUpdate();

    }

    @Override
    public void delete(Contrat tupple) throws SQLException {
        PreparedStatement st = CictOracleDataSource.getLaConnection()
                .prepareStatement("DELETE FROM Contrat WHERE id_contrat = ?");
        st.setString(1, tupple.getId_contrat());
        st.executeUpdate();
    }

    @Override
    public Collection<Contrat> findAll() throws SQLException {
        PreparedStatement prSt = CictOracleDataSource.getLaConnection().prepareStatement("select * from Contrat");
        return super.select(prSt);
    }

    @Override
    protected Contrat creerInstance(ResultSet curseur) throws SQLException {
        String id_contrat = curseur.getNString(1);
        Date prise_effet = curseur.getDate(2);
        int duree = curseur.getInt(3);
        float charges = curseur.getFloat(4);
        float loyer = curseur.getFloat(5);
        Date date_revision = curseur.getDate(6);
        String periodicite = curseur.getNString(7);
        Date date_paiement = curseur.getDate(8);
        float paiement = curseur.getFloat(9);
        Date date_edl = curseur.getDate(10);
        float montant_caution = curseur.getFloat(11);
        Date fin_contrat = curseur.getDate(12);
        DaoLogement dao1 = new DaoLogement();
        Logement num = dao1.findById(null, curseur.getNString(13));
        Entrepreneur n_siren = null;
        Caution id_caution = null;
        if (curseur.getNString(14) != null) {
            DaoEntrepreuneur dao2 = new DaoEntrepreuneur();
            n_siren = dao2.findById(null, curseur.getNString(14));
        }
        if (curseur.getNString(15) != null) {
            DaoCaution dao3 = new DaoCaution();
            id_caution = dao3.findById(null, curseur.getNString(15));
        }

        Contrat result = new Contrat(id_contrat, prise_effet, duree, charges, loyer, date_revision, periodicite,
                date_paiement, paiement, date_edl, montant_caution, fin_contrat, num, n_siren, id_caution);

        DaoLocataire dao4 = new DaoLocataire();
        result.setSigner(dao4.findByContrat(result.getId_contrat()));
        return result;
    }

    @Override
    public int miseAJour(Requete<Contrat> req, Contrat donnee) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Contrat> find(Requete<Contrat> req, Contrat donnee) throws SQLException {
        PreparedStatement tmp = req.requete();
        req.setParametres(tmp, donnee);
        return super.select(tmp);
    }

    @Override
    public Contrat findById(Requete<Contrat> req, String... id) throws SQLException {
        PreparedStatement pr = CictOracleDataSource.getLaConnection()
                .prepareStatement("select * from contrat where id_contrat = ?");
        pr.setNString(1, id[0]);
        pr.execute();
        ResultSet rs = pr.getResultSet();
        rs.next();
        return creerInstance(rs);
    }

    public Collection<Contrat> findByLocataire(String nLocataire) throws SQLException {
        String sql = "{? = call BEAUX_LOCATAIRE(?)}";
        ResultSet rs;
        CallableStatement prSt = CictOracleDataSource.getLaConnection().prepareCall(sql);
        prSt.registerOutParameter(1, OracleTypes.CURSOR);
        prSt.setString(2, nLocataire);
        prSt.execute();
        rs = (ResultSet) prSt.getObject(1);
        Collection<Contrat> lesLocataires = new ArrayList<Contrat>();
        while (rs.next()) {
            lesLocataires.add(creerInstance(rs));
        }
        return lesLocataires;
    }
}
