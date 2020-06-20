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
                ListContactsMouseClicked(evt);
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


        if(ListContacts.getSelectedIndex()==0)
            return;

        Contact bfContact,gfContact;
        //获取gf实体的信息
        gfContact=(Contact)
                ListContacts.getSelectedValue();

        Contact tmpContact = new Contact();
        tmpContact.setUid(this.currUID);

        int idx = this.contactsModel.indexOf(tmpContact);

        bfContact=(Contact)contactsModel.elementAt(idx);

        ChatBox chatBox= getChatBox(bfContact,gfContact);
//						new ChatBox(bfContact,gfContact);
        gfContact.setSender(false);
        chatBox.setVisible(true);


    }



//    public void refreshContact(boolean isInit){
//        // TODO Auto-generated method stub
//        // TODO add your handling code here:
//        ContactHandler contactHandler = new ContactHandler();
//        Vector<Contact> allContacts = (Vector<Contact>)contactHandler.ReturnContacts();
//
//        int size = allContacts.size();
//        //注意：实例化 contactsModel！！！
//
//        /**************************************************/
//        DefaultListModel oldModel = contactsModel;
//        contactsModel = new DefaultListModel();
//        contactsModel.setSize(size); // Copy data from vector allContacts to list contactsModel
//        /******************************************/
//
//        int onidx = 1, offidx = size - 1;
//        Contact contact = null;
//        Contact oldContact = null;
//        int tmpUid;
//
//        for (int i = 0; i < size; i++) {
//            contact = allContacts.elementAt(i);
//            tmpUid=contact.getUid();
//
//            if(!isInit){
//
//                oldContact=
//                        getContactByuid(tmpUid, oldModel);
//                contact.setSender(
//                        oldContact.isSender());
//            }
//            if(tmpUid == currUID){
//                //将自己置于首行0号位置
//                contactsModel.setElementAt(contact, 0);
//                continue;
//            }
//
//            if(contact.getOnline() == 1){
//                contactsModel.setElementAt(contact, onidx);
//                onidx++;
//                //好友在线,将实体与索引存入contactsModel中，onidx索引递增。
//            }
//            else{
//                //最后，将排好序的contactsModel放入ListContacts中。
//                //<span style="font-size: 18px; font-family: Arial, Helvetica, sans-serif; background-color: rgb(255, 255, 255);">  </span>
//                contactsModel.setElementAt(contact, offidx);
//                offidx--;
//            }
//        }
//
//        //refresh 之后，将contactsModel中内容放到公共存储区中
//        // After refreshing, put the contents of contactsModel (HashTable) into the public storage area
//        SystemRegistry.getSysReg().put("contactsModel", contactsModel);
//        System.out.println(contactsModel);
//
//    }

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

//    public void PutBoxRegistry(){
//        try {
//            ChatInfo chatInfo = new ChatInfo();
//            // 类方法setSysReg调用getSysReg()方法返回一个唯一的sysReg对象，sysReg是类型为<String,Object>的HashTable容器
//            // 将对象sysReg中String为“boxRegistry”的内容赋予boxRegistry
//            Hashtable<Contact, ChatBox> boxRegistry = (Hashtable<Contact, ChatBox>) SystemRegistry.getSysReg().get("boxRegistry");
//            // 将String为“contactsModel”的内容赋予contactModel
//            DefaultListModel contactsModel = (DefaultListModel) SystemRegistry.getSysReg().get("contactsModel");
//
//            int senderId = chatInfo.getSenderId();
//            int receiverId = chatInfo.getReceiverId();
//
//            Contact gfContact = getContactByuid(senderId, contactsModel);
//            gfContact.setSender(true);
//
//            Contact bfContact = getContactByuid(receiverId, contactsModel);
//            ChatBox chatBox = boxRegistry.get(gfContact);
//
//            if (chatBox == null) {
//                chatBox = new ChatBox(bfContact, gfContact);
//                boxRegistry.put(gfContact, chatBox);
//            }
//            chatBox.appendMsg(chatInfo.getContent());
//            System.out.println(chatInfo);
//            System.out.println("****************************Chat Online************************");
//        }catch (Exception e) {
//            // TODO: handle exception
//            e.printStackTrace();
//        }
//    }

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
