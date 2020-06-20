package client;

import entity.ChatInfo;
import entity.Contact;

import javax.swing.*;
import java.awt.*;
import java.sql.Date;

public class ChatBox extends javax.swing.JFrame{
    private Contact bfContact, gfContact;
    //GEN-BEGIN:variables
    // Variables declaration - do not modify
    private javax.swing.JButton btnSend;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtChat;
    private javax.swing.JTextArea txtHist;
    // End of variables declaration//GEN-END:variables


    public ChatBox(Contact bfContact, Contact gfContact) {
        initComponents();
        this.bfContact = bfContact;
        this.gfContact = gfContact;
        setDefaultCloseOperation(HIDE_ON_CLOSE);

        setTitle(bfContact.getUname() + "is chatting with"
                + gfContact.getUname());
    }

    public void initComponents(){

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtHist = new javax.swing.JTextArea();
        txtChat = new javax.swing.JTextField();
        btnSend = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtHist.setColumns(20);
        txtHist.setRows(5);
        jScrollPane1.setViewportView(txtHist);

        txtChat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtChatActionPerformed(evt);
            }
        });

        btnSend.setText("send");
        btnSend.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSendMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
                jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout
                .setHorizontalGroup(jPanel1Layout
                        .createParallelGroup(
                                javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(
                                jPanel1Layout
                                        .createSequentialGroup()
                                        .addGap(91, 91, 91)
                                        .addGroup(
                                                jPanel1Layout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addGroup(
                                                                jPanel1Layout
                                                                        .createSequentialGroup()
                                                                        .addComponent(
                                                                                txtChat,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                476,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(
                                                                                btnSend,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))
                                                        .addComponent(
                                                                jScrollPane1,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                584,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addContainerGap(179, Short.MAX_VALUE)));
        jPanel1Layout
                .setVerticalGroup(jPanel1Layout
                        .createParallelGroup(
                                javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(
                                jPanel1Layout
                                        .createSequentialGroup()
                                        .addComponent(
                                                jScrollPane1,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                281,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(
                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(
                                                jPanel1Layout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(
                                                                txtChat,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                47,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(
                                                                btnSend,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                48,
                                                                Short.MAX_VALUE))
                                        .addContainerGap()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
                getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                        .addComponent(jPanel1,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(71, Short.MAX_VALUE)));

        pack();
    }

    private void btnSendMouseClicked(java.awt.event.MouseEvent evt) {
        if((txtChat.getText()).equals("")){
            JOptionPane.showMessageDialog(this,"Please enter text!");
        }
        ChatInfo chatInfo = new ChatInfo();
        Date now = new Date(System.currentTimeMillis());
        String sentTime = now.toString();

        chatInfo.setSendTime(sentTime);
        System.out.println(sentTime);
    }

    public void appendMsg(String msg) {
        this.txtHist.append(msg);

    }

    private void txtChatActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new ChatBox().setVisible(true);
            }
        });
    }

}
