package server;

public class LogOffHandler {
    public LogOffHandler() {
    }

    public void LogOff(int uid){
        try {

            String sqlString="update contacts set online = 0 where uid="+uid;
//            System.out.println(sqlString);
            DBAccessHelper.getDAO().execute(sqlString);
            sqlString="update contacts set peerip = null where uid="+uid;
            DBAccessHelper.getDAO().execute(sqlString);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
