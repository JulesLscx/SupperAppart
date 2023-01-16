import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.SQLException;

import Controlleur.CictOracleDataSource;
import oracle.jdbc.OracleTypes;

public class ProjectUtils {
    public static Date conversionDate(String date) throws SQLException {
        String sql = "{? = call CONVERSIONDATE(?)}";
        CallableStatement prSt = CictOracleDataSource.getLaConnection().prepareCall(sql);
        prSt.registerOutParameter(1, OracleTypes.DATE);
        prSt.setString(2, date);
        prSt.execute();
        Date dateContrat = prSt.getDate(1);
        return dateContrat;
    }
}
