package client;

import entity.Contact;
import server.ContactHandler;
import server.LogOffHandler;

import javax.swing.*;
import java.util.Vector;

public class MainForm extends javax.swing.JFrame{

    //GEN-BEGIN:variables
    // Variables declaration - do not modify
    private javax.swing.JList ListContacts;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    // Define Model
    private DefaultListModel contactsModel;
    //

    /** Creates new form NetFORM */
    private int logUID;


    public MainForm( int uid){

        this.logUID = uid;
        initComponents();

        setTitle(""+uid);

        ListContacts.setCellRenderer(new ContactsList());

    }

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ListContacts = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        ListContacts.setModel(new javax.swing.AbstractListModel() {

//            ContactHandler contactHandler = new ContactHandler();
//            Vector<Contact> allContacts = (Vector<Contact>)contactHandler.ReturnContacts();
            DefaultListModel contactmodel = refreshContact(true);
            public int getSize() {
                return contactmodel.size();
            }

            public Object getElementAt(int i) {
                return contactmodel.get(i);
            }
        });
        ////////////////////////////////////////////////////
        ListContacts.setSelectionBackground(new java.awt.Color(51, 51, 255));
        ////////////////////////////////////////////////////
        ListContacts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if(!ListContacts.getValueIsAdjusting()){
                    ListContactsMouseClicked(evt);
                }

            }
        });


        jScrollPane1.setViewportView(ListContacts);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
                getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING).addComponent(
                jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 527,
                Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                layout.createSequentialGroup()
                        .addContainerGap(55, Short.MAX_VALUE)
                        .addComponent(jScrollPane1,
                                javax.swing.GroupLayout.PREFERRED_SIZE, 402,
                                javax.swing.GroupLayout.PREFERRED_SIZE)));

        pack();
    }

    private void ListContactsMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:


        if(ListContacts.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(this,"You cannot chat with yourself, please choose another contact");
            return;
        }

          System.out.println(ListContacts.getSelectedValue());

        Contact bfContact,gfContact;

        gfContact=(Contact)
                ListContacts.getSelectedValue();

//        System.out.println(gfContact.getUid());

//        System.out.println("contactsModel "+contactsModel.elementAt(0));

        bfContact=(Contact)contactsModel.elementAt(0);

        ChatBox chatBox = new ChatBox(bfContact,gfContact);
        gfContact.setSender(false);
        chatBox.setVisible(true);


    }

    public DefaultListModel refreshContact(boolean isInit){
        // TODO Auto-generated method stub
        // TODO add your handling code here:
        ContactHandler contactHandler = new ContactHandler();
        Vector<Contact> allContacts = (Vector<Contact>)contactHandler.ReturnContacts();

        int size = allContacts.size();
        System.out.println("Size = "+size);
        //注意：实例化 contactsModel！！！

        /**************************************************/
        DefaultListModel oldModel = contactsModel;
        contactsModel = new DefaultListModel();
        contactsModel.setSize(size); // Copy data from vector allContacts to list contactsModel
        /******************************************/

        int onidx = 1, offidx = size - 1;
        Contact contact = null;
        Contact oldContact = null;
        int tmpUid;

        int i = 0;

        do{
            contact = allContacts.elementAt(i);
            tmpUid=contact.getUid();

            if(!isInit){

                oldContact=
                        getContactByuid(tmpUid, oldModel);
                contact.setSender(
                        oldContact.isSender());
            }

            if(tmpUid == this.logUID){

                contactsModel.setElementAt(contact, 0);

            }else if(contact.getOnline() == 1){
                contactsModel.setElementAt(contact, onidx);
                onidx++;

            }
            else{

                contactsModel.setElementAt(contact, offidx);
                offidx--;
            }
            i++;
        }while(i < size);


        // After refreshing, return contactsModel
        return contactsModel;
    }



    private Contact getContactByuid(int uid,DefaultListModel Model){

        // Find the index in the list through the parameter uid to find the corresponding entity object contact
        Contact resultContact = null;
        Contact tmpContact = new Contact();
        tmpContact.setUid(uid);
        int idx = Model.indexOf(tmpContact);
        resultContact = (Contact)Model.elementAt(idx);
        return resultContact;
    }


    private void formWindowClosing(java.awt.event.WindowEvent evt) {
        // TODO add your handling code here:
        LogOffHandler logOffHandler = new LogOffHandler();
        logOffHandler.LogOff(this.logUID);

    }
}
