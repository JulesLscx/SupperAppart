package Controlleur;

import java.sql.Connection;
import java.sql.SQLException;

import Modele.Caution;
import Modele.DAO.DaoCaution;

public class Test {
    public static void main(String[] args) {
        try {
            Connection co = CictOracleDataSource.creerAcces("HR", "iutinfo");
            DaoCaution dao = new DaoCaution();
            Caution c = new Caution("null", "null", "null", "null", "null", "0123456789", "null");
            // dao.create(c);
            dao.delete(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
