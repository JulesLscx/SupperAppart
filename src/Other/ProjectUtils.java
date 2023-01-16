package Other;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.SQLException;

import Controlleur.CictOracleDataSource;
import oracle.jdbc.OracleTypes;

public class ProjectUtils {
    public static Date conversionDate(String date) {
        if (date == null || !date.matches("\\d\\d/\\d\\d/\\d\\d\\d\\d")) {
            return null;
        }
        Date dateContrat = null;
        try {
            String sql = "{? = call CONVERSIONDATE(?)}";
            CallableStatement prSt = CictOracleDataSource.getLaConnection().prepareCall(sql);
            prSt.registerOutParameter(1, OracleTypes.DATE);
            prSt.setString(2, date);
            prSt.execute();
            dateContrat = prSt.getDate(1);
        } catch (SQLException e) {
        }

        return dateContrat;
    }
}
