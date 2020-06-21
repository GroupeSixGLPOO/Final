package server;

import entity.LogInfo;

import java.net.InetAddress;
import java.net.Socket;
import java.sql.ResultSet;

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

                Socket server = new Socket("localhost", 10000);

                InetAddress inet = InetAddress.getLocalHost();
                String ip = inet.getHostAddress();
//                System.out.println("ip: "+inet.getHostAddress());

                sqlString = "update contacts set online=1 where uid=" + uid + " and password='" + password + "'";

                System.out.println(sqlString);
                DBAccessHelper.getDAO().execute(sqlString);

                sqlString = "update contacts set peerip='"+ip+"' where uid=" + uid + " and password='" + password + "'";
                DBAccessHelper.getDAO().execute(sqlString);
            }

        }catch (Exception e){
            // TODO: handle exception
            e.printStackTrace();
        }
        return isOK;
    }

}
