package server;

import entity.RegisterInfo;
import java.sql.ResultSet;

public class RegisterHandler {

    public RegisterHandler() {
    }

    public int InsertInfo(RegisterInfo registerInfo){
        int uid = assignUID();
        insertNew(uid,registerInfo);
        return uid;
    }


    public boolean validated(String email) {
        // TODO Auto-generated method stub
        boolean isValid = false;
        try {
            String sqlString = "select count(0) from contacts "
                    +" where email='"+email+"'";
            System.out.println(sqlString);
            ResultSet rs=
                    DBAccessHelper.getDAO().executeQuery(sqlString);
            int count = 0;
            if(rs.next()) { //If it doesn't find the same email adresse, rs.next() == true
                count = rs.getInt(1);
            }
            if(count == 0) {
                isValid = true;
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return isValid;
    }

    private void insertNew(int uid, RegisterInfo registerInfo) { //Insert new contact
        // TODO Auto-generated method stub
        String sqlString=	"insert into contacts "+
                "(uid,uname,age,email,password) "+
                "values("+uid+",'"+registerInfo.getUname()+
                "',"+registerInfo.getAge()+
                ",'"+registerInfo.getEmail()+
                "','"+registerInfo.getPassword()+"')";
        System.out.println(sqlString);
        DBAccessHelper.getDAO().execute(sqlString);
    }


    private int assignUID() {
        // TODO Auto-generated method stub

        int uid=10000;
        try {

            String sqlString="select max(uid) from  contacts";
            ResultSet rs = DBAccessHelper.getDAO().executeQuery(sqlString);
            if(rs.next()){ //If we are in the last line
                int maxid = rs.getInt(1);
                if(maxid > uid)
                    uid = maxid;
            }
            uid++; //New id = max id + 1

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return uid;
    }
}
