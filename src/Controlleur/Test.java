package Controlleur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

import Modele.Caution;
import Modele.DAO.DaoCaution;
import Modele.DAO.DaoContrat;
import Modele.DAO.DaoImmeuble;
import Modele.DAO.DaoLocataire;
import Modele.DAO.DaoRegularisation;
import Other.ProjectUtils;

import java.sql.Date;

public class Test {
    public static void main(String[] args) {
        try {
            CictOracleDataSource.creerAcces("hr", "iutinfo");
            System.out
                    .println(new DaoRegularisation().simulate("01", "Eau", ProjectUtils.conversionDate("20/10/2022")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
