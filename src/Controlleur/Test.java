package Controlleur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Modele.Caution;
import Modele.DAO.DaoCaution;
import Modele.DAO.DaoImmeuble;
import Modele.DAO.DaoLocataire;

public class Test {
    public static void main(String[] args) {
        try {
            CictOracleDataSource.creerAcces("hr", "iutinfo");
            DaoLocataire dao = new DaoLocataire();
            System.out.println(dao.findByLogement("01"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
