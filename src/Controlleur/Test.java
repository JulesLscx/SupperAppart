package Controlleur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Modele.Caution;
import Modele.DAO.DaoCaution;
import Modele.DAO.DaoImmeuble;

public class Test {
    public static void main(String[] args) {
        try {
            CictOracleDataSource.creerAcces("hr", "iutinfo");
            DaoImmeuble dao = new DaoImmeuble();
            System.out.println(dao.findById(null, "10B"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
