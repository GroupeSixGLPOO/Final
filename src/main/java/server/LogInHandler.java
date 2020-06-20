package server;

import entity.LogInfo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LogInHandler {
    public LogInHandler() {

    }

    public boolean ConfirmInformation(LogInfo logInfo) {
        boolean isOK = false;
        try {
            int uid = logInfo.getUid();
            String password = logInfo.getPassword();

            String sqlString =
                    "select count(0) from contacts where uid=" + uid + " and password='" + password + "'";
            System.out.println(sqlString);

            ResultSet rs = DBAccessHelper.getDAO().executeQuery(sqlString);

            if (rs.next()) {
                if (1 == rs.getInt(1))
                    isOK = true;

            }
            if (isOK) { //If uid and password are OK, LOGIN_SUCCESS

                sqlString = "update contacts set online=1 where uid=" + uid + " and password='" + password + "'";

                System.out.println(sqlString);
                DBAccessHelper.getDAO().execute(sqlString);
            }

        }catch (Exception e){
            // TODO: handle exception
            e.printStackTrace();
        }
        return isOK;
    }

}
