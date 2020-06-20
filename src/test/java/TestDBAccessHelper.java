import org.junit.Test;
import server.DBAccessHelper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TestDBAccessHelper {
    @Test
    public void testDBA(){
        try {

            String sqlString = "select * from contacts";
            System.out.println(sqlString);

            ResultSet rs = DBAccessHelper.getDAO().executeQuery(sqlString);

            while (rs.next()) {
                System.out.print("  uid\t" + rs.getInt(1) + "       ");
                System.out.print("  uname:\t  " + rs.getString(2) + "    ");
                System.out.print("  email:\t" + rs.getString(3) + "    ");
                System.out.print("  age:\t" + rs.getString(4) + "    ");
                System.out.println("  online:\t" + rs.getString(5) + "    ");

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
