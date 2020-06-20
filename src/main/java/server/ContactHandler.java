package server;

import entity.Contact;

import java.sql.ResultSet;
import java.util.Vector;

public class ContactHandler {
    public ContactHandler() {
    }

    public Vector<Contact> ReturnContacts(){
        Contact contact = null;
        Vector<Contact> allContacts = new Vector<Contact>();

        try {
            String sqlString = "select * from contacts";

//            System.out.println(sqlString);
            ResultSet rs = DBAccessHelper.getDAO().executeQuery(sqlString);

            while(rs.next()){
                contact =new Contact();
                contact.setUid(rs.getInt(1));
                contact.setUname(rs.getString(2));
                contact.setEmail(rs.getString(3));
                contact.setAge(rs.getInt(4));
                contact.setOnline(rs.getInt(6));  //////////////////////////////

                //初始化，在contact中加ip,port
                contact.setPeerIp(rs.getString(7));
                contact.setPeerPort(rs.getInt(8));
                allContacts.add(contact);
            }
            System.out.println(allContacts);

        }catch(Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return allContacts;
    }
}
