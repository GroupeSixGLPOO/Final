package client;

import entity.ChatInfo;
import entity.Contact;
import server.ContactHandler;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Hashtable;
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
    private int currUID;
    private Hashtable<Contact,ChatBox> boxRegistry;


    public MainForm( int uid){
        initComponents();

        this.currUID = uid;
        this.boxRegistry=new Hashtable<Contact,ChatBox>();

//        SystemRegistry.getSysReg().put("boxRegistry",this.boxRegistry);
//        System.out.println(boxRegistry);
        setTitle(""+uid);

        ListContacts.setCellRenderer(new ContactsList());



//        refreshContact(true);


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

            ContactHandler contactHandler = new ContactHandler();
            Vector<Contact> allContacts = (Vector<Contact>)contactHandler.ReturnContacts();

            public int getSize() {
                return allContacts.size();
            }

            public Object getElementAt(int i) {
                return allContacts.get(i);
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

//
//        if(ListContacts.getSelectedIndex()==0)
//            return;
          System.out.println(ListContacts.getSelectedValue());
//        Contact bfContact,gfContact;
//        //获取gf实体的信息
//        gfContact=(Contact)
//                ListContacts.getSelectedValue();
//
//        Contact tmpContact = new Contact();
//        tmpContact.setUid(this.currUID);
//
//        int idx = this.contactsModel.indexOf(tmpContact);
//
//        bfContact=(Contact)contactsModel.elementAt(idx);
//
//        ChatBox chatBox= getChatBox(bfContact,gfContact);
////						new ChatBox(bfContact,gfContact);
//        gfContact.setSender(false);
//        chatBox.setVisible(true);


    }



    private Contact getContactByuid(int uid,DefaultListModel Model){
        // 通过参数uid找到列表中索引从而找到相应的实体对象contact
        // Find the index in the list through the parameter uid to find the corresponding entity object contact
        Contact resultContact = null;
        Contact tmpContact = new Contact();
        tmpContact.setUid(uid);
        int idx = Model.indexOf(tmpContact);
        resultContact = (Contact)Model.elementAt(idx);
        return resultContact;
    }



    private ChatBox getChatBox(Contact bfContact,Contact gfContact){

        ChatBox chatBox = null;
        try {

            chatBox = boxRegistry.get(gfContact); // 给实体chatBox赋公共存储区boxRegistry中gfContacts实体的信息
            if(chatBox == null)
            { // 给实体chatBox赋公共存储区boxRegistry中gfContacts实体的信息
                chatBox = new ChatBox(bfContact,gfContact);
                //记录其他人的窗口！！！
                boxRegistry.put(gfContact,chatBox);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return chatBox;
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {
        // TODO add your handling code here:

    }
}
