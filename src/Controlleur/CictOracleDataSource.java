package Controlleur;

import java.sql.Connection;
import java.sql.SQLException;

import oracle.jdbc.datasource.impl.OracleDataSource;

public class CictOracleDataSource extends OracleDataSource {
	/**
	 * 
	 */
	private static Connection connection;
	private static CictOracleDataSource coo;

	private static final long serialVersionUID = 1L;

	private CictOracleDataSource(String nom, String mdp)
			throws SQLException {
		this.setURL("jdbc:oracle:thin:@localhost" +
				":1521:xe");
		this.setUser(nom);
		this.setPassword(mdp);
	}

	public static Connection getLaConnection() {
		return CictOracleDataSource.connection;
	}

	public static CictOracleDataSource getThis() {
		return CictOracleDataSource.coo;
	}

	public static synchronized Connection creerAcces(String nom, String mdp) throws SQLException {
		if (CictOracleDataSource.connection == null) {
			CictOracleDataSource.coo = new CictOracleDataSource(nom, mdp);
			CictOracleDataSource.connection = coo.getConnection();
		}
		return CictOracleDataSource.connection;
	}

	public void deconnection() {
		try {
			CictOracleDataSource.connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		CictOracleDataSource.connection = null;
	}
}
