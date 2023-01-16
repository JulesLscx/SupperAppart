package Modele.DAO;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import Controlleur.CictOracleDataSource;
import Modele.Entrepreneur;
import Modele.Facture_Travaux_Logement;
import Modele.Logement;
import Modele.DAO.Requete.Requete;
import oracle.jdbc.OracleTypes;

public class DaoFacture_Travaux_Logement extends DaoModele<Facture_Travaux_Logement> {
    @Override
    public void create(Facture_Travaux_Logement tupple) throws SQLException {
        PreparedStatement prSt = CictOracleDataSource.getLaConnection()
                .prepareCall("call INSERTFACTURETRAVAUX(?,?,?,?,?,?,?)");
        prSt.setNString(1, tupple.getNum_fac());
        prSt.setNString(2, tupple.getNature());
        prSt.setFloat(3, tupple.getPrix());
        prSt.setFloat(4, tupple.getMontant_indeductible());
        prSt.setFloat(5, tupple.getReduction());
        prSt.setNString(6, tupple.getOrdre_du_cheque());
        prSt.setNString(7, tupple.getNumero_du_cheque());
        prSt.setDate(8, tupple.getDate_de_paiement());
        prSt.setNString(10, tupple.getLogement().getNum());
        prSt.setNString(9, tupple.getEntrepreneur().getnSiren());
        prSt.execute();
    }

    @Override
    public void update(Facture_Travaux_Logement tupple) throws SQLException {
        String req = "Update Facture_travaux set nature = ?, prix = ?, montant_indeductible = ?, réduction = ?, ordre_du_chèque = ?, numéro_de_chèque = ?, date_de_paiement = ?, num = ?, n_siren = ? where num_fac = ?";
        PreparedStatement prSt = CictOracleDataSource.getLaConnection().prepareStatement(req);

        prSt.setNString(10, tupple.getNum_fac());
        prSt.setNString(1, tupple.getNature());
        prSt.setFloat(2, tupple.getPrix());
        prSt.setFloat(3, tupple.getMontant_indeductible());
        prSt.setFloat(4, tupple.getReduction());
        prSt.setNString(5, tupple.getOrdre_du_cheque());
        prSt.setNString(6, tupple.getNumero_du_cheque());
        prSt.setDate(7, tupple.getDate_de_paiement());
        prSt.setNString(8, tupple.getLogement().getNum());
        prSt.setNString(9, tupple.getEntrepreneur().getnSiren());
        prSt.execute();

    }

    @Override
    public void delete(Facture_Travaux_Logement tupple) throws SQLException {
        PreparedStatement st = CictOracleDataSource.getLaConnection()
                .prepareStatement("DELETE FROM Facture_Travaux WHERE num_fac = ?");
        st.setString(1, tupple.getNum_fac());
        st.executeUpdate();
    }

    @Override
    public Collection<Facture_Travaux_Logement> findAll() throws SQLException {
        PreparedStatement prSt = CictOracleDataSource.getLaConnection()
                .prepareStatement("select * from Facture_travaux");
        return super.select(prSt);
    }

    @Override
    protected Facture_Travaux_Logement creerInstance(ResultSet curseur) throws SQLException {
        Facture_Travaux_Logement result = null;
        String num_fac, nature, ordre_du_cheque, numero_du_cheque;
        Date date_de_paiement;
        float prix, montant_indeductible, reduction;
        Entrepreneur entrepreneur;
        Logement logement;
        num_fac = curseur.getNString(1);
        nature = curseur.getNString(2);
        prix = curseur.getFloat(3);
        montant_indeductible = curseur.getFloat(4);
        reduction = curseur.getFloat(5);
        ordre_du_cheque = curseur.getNString(6);
        numero_du_cheque = curseur.getNString(7);
        date_de_paiement = curseur.getDate(8);
        DaoLogement dao = new DaoLogement();
        logement = dao.findById(null, curseur.getNString(10));
        DaoEntrepreuneur daoE = new DaoEntrepreuneur();
        entrepreneur = daoE.findById(null, curseur.getNString(9));
        result = new Facture_Travaux_Logement(num_fac, nature, prix, montant_indeductible, reduction, ordre_du_cheque,
                numero_du_cheque, date_de_paiement, logement, entrepreneur);
        return result;
    }

    @Override
    public int miseAJour(Requete<Facture_Travaux_Logement> req, Facture_Travaux_Logement donnee) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Facture_Travaux_Logement> find(Requete<Facture_Travaux_Logement> req,
            Facture_Travaux_Logement donnee) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Facture_Travaux_Logement findById(Requete<Facture_Travaux_Logement> req, String... id) throws SQLException {
        PreparedStatement prSt = CictOracleDataSource.getLaConnection()
                .prepareStatement("Select * from Facture_travaux where num_fac = ?");
        prSt.setNString(1, id[0]);
        prSt.execute();
        ResultSet rs = prSt.getResultSet();
        rs.next();
        return creerInstance(rs);
    }

    public List<Facture_Travaux_Logement> findByAnnee(int annee) throws SQLException {
        List<Facture_Travaux_Logement> result = new LinkedList<Facture_Travaux_Logement>();
        String sql = "{? = call TOTALTRAVAUXLOG(?)}";
        ResultSet rs;
        CallableStatement prSt = CictOracleDataSource.getLaConnection().prepareCall(sql);
        prSt.registerOutParameter(1, OracleTypes.CURSOR);
        prSt.setInt(2, annee);
        prSt.execute();
        rs = (ResultSet) prSt.getObject(1);
        while (rs.next()) {
            result.add(creerInstance(rs));
        }
        return result;
    }

}
