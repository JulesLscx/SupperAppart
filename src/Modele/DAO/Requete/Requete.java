package Modele.DAO.Requete;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface Requete<T> {

	public PreparedStatement requete() throws SQLException;

	public void setParametres(PreparedStatement prSt, String... id) throws SQLException;

	public void setParametres(PreparedStatement prSt, T donnee) throws SQLException;

}
