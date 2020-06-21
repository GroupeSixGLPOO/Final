package client;

import entity.RegisterInfo;
import server.RegisterHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegForm extends javax.swing.JFrame{
    // GEN-BEGIN:variables
    // Variables declaration - do not modify
    private javax.swing.JTextField agetxt;
    private javax.swing.JButton btnReset;
    private javax.swing.JTextField emailtxt;
    private javax.swing.JButton btnRegister;
    private javax.swing.JLabel jLabel0;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel;
    private javax.swing.JTextField nametxt;
    private javax.swing.JPasswordField password;
    // End of variables declaration//GEN-END:variables

    private static final long serialVersionUID = 1L;
    // private static final Object regInfo = null;


    public RegForm(){
        setComponent();
    }

    public void setComponent() {
        jPanel = new JPanel();
        nametxt = new JTextField();
        jLabel0 = new JLabel();
        Font font=new Font("Times New Roman",Font.BOLD,18);
        jLabel0.setFont(font);
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        agetxt = new JTextField();
        emailtxt = new JTextField();
        jLabel4 = new JLabel();
        btnRegister = new JButton();
        btnReset = new JButton();
        password = new JPasswordField();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabel0.setText("Welcome to ChatLine, please create your account!");

        jLabel1.setText("Name :");

        jLabel2.setText("Email :");

        jLabel3.setText("Age :");

        jLabel4.setText("Password :");

        btnRegister.setText("Register");
        btnRegister.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btnRegisterMouseClicked(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btnResetMouseClicked(evt);
            }
        });

        GroupLayout jPanelLayout = new GroupLayout(
                jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout
                .setHorizontalGroup(jPanelLayout
                        .createParallelGroup(
                                GroupLayout.Alignment.LEADING)
                        .addGroup(
                                jPanelLayout
                                        .createSequentialGroup()

                                        .addGap(54, 54, 54)
                                        .addGroup(
                                                jPanelLayout
                                                        .createParallelGroup(
                                                                GroupLayout.Alignment.TRAILING,
                                                                false)
                                                        .addGroup(
                                                                jPanelLayout
                                                                        .createSequentialGroup()
                                                                        .addGroup(
                                                                                jPanelLayout
                                                                                        .createParallelGroup(
                                                                                                GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(
                                                                                                jLabel1, //Name
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                67,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(
                                                                                                jLabel2)) //Email
                                                                        .addGap(8,
                                                                                8,
                                                                                8))
                                                        .addGroup(
                                                                jPanelLayout
                                                                        .createSequentialGroup()
                                                                        .addComponent(
                                                                                jLabel4, //Password
                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                        .addPreferredGap(
                                                                                LayoutStyle.ComponentPlacement.RELATED)))
                                        .addGroup(
                                                jPanelLayout
                                                        .createParallelGroup(
                                                                GroupLayout.Alignment.LEADING)
                                                        .addGap(50, 50, 50)
                                                        .addGroup(
                                                                jPanelLayout
                                                                        .createSequentialGroup()
                                                                        .addComponent(
                                                                                jLabel0,
                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                        .addPreferredGap(
                                                                                LayoutStyle.ComponentPlacement.RELATED))
                                                        .addGroup(
                                                                jPanelLayout
                                                                        .createSequentialGroup()
                                                                        .addGroup(
                                                                                jPanelLayout
                                                                                        .createParallelGroup(
                                                                                                GroupLayout.Alignment.LEADING)
                                                                                        .addGroup(
                                                                                                jPanelLayout
                                                                                                        .createSequentialGroup()
                                                                                                        .addComponent(
                                                                                                                nametxt,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                205,
                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                        .addGap(48,
                                                                                                                48,
                                                                                                                48)
                                                                                                        .addComponent(
                                                                                                                jLabel3, //Age
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                46,
                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                        .addGap(15,
                                                                                                                15,
                                                                                                                15)
                                                                                                        .addComponent(
                                                                                                                agetxt,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                126,
                                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                                        .addComponent(
                                                                                                emailtxt,
                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                440,
                                                                                                Short.MAX_VALUE)
                                                                                        .addGroup(
                                                                                                jPanelLayout
                                                                                                        .createSequentialGroup()
                                                                                                        .addComponent(
                                                                                                                btnRegister)
                                                                                                        .addGap(170,
                                                                                                                170,
                                                                                                                170)
                                                                                                        .addComponent(
                                                                                                                btnReset,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                89,
                                                                                                                GroupLayout.PREFERRED_SIZE)))
                                                                        .addGap(88,
                                                                                88,
                                                                                88))
                                                        .addGroup(
                                                                jPanelLayout
                                                                        .createSequentialGroup()
                                                                        .addComponent(
                                                                                password,
                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                513,
                                                                                Short.MAX_VALUE)
                                                                        .addContainerGap()))));
        jPanelLayout
                .setVerticalGroup(jPanelLayout
                        .createParallelGroup(
                                GroupLayout.Alignment.LEADING)
                        .addGroup(
                                jPanelLayout
                                        .createSequentialGroup()
                                        .addGap(44, 44, 44)

                                        .addGroup(
                                                jPanelLayout
                                                        .createParallelGroup(
                                                                GroupLayout.Alignment.BASELINE)
                                                        .addComponent(
                                                                jLabel0,
                                                                GroupLayout.PREFERRED_SIZE,
                                                                40,
                                                                GroupLayout.PREFERRED_SIZE)
                                        )
                                        .addGap(33, 33, 33)
                                        .addGroup(
                                                jPanelLayout
                                                        .createParallelGroup(
                                                                GroupLayout.Alignment.BASELINE)
                                                        .addComponent(
                                                                jLabel1,
                                                                GroupLayout.PREFERRED_SIZE,
                                                                32,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(
                                                                jLabel3,
                                                                GroupLayout.PREFERRED_SIZE,
                                                                34,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(
                                                                agetxt,
                                                                GroupLayout.PREFERRED_SIZE,
                                                                38,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(
                                                                nametxt,
                                                                GroupLayout.PREFERRED_SIZE,
                                                                38,
                                                                GroupLayout.PREFERRED_SIZE))
                                        .addGap(33, 33, 33)
                                        .addGroup(
                                                jPanelLayout
                                                        .createParallelGroup(
                                                                GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel2)
                                                        .addComponent(
                                                                emailtxt,
                                                                GroupLayout.PREFERRED_SIZE,
                                                                40,
                                                                GroupLayout.PREFERRED_SIZE))
                                        .addGap(40, 40, 40)
                                        .addGroup(
                                                jPanelLayout
                                                        .createParallelGroup(
                                                                GroupLayout.Alignment.BASELINE)
                                                        .addComponent(
                                                                password,
                                                                GroupLayout.PREFERRED_SIZE,
                                                                40,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(
                                                                jLabel4,
                                                                GroupLayout.PREFERRED_SIZE,
                                                                29,
                                                                GroupLayout.PREFERRED_SIZE))
                                        .addGap(50, 50, 50)
                                        .addGroup(
                                                jPanelLayout
                                                        .createParallelGroup(
                                                                GroupLayout.Alignment.BASELINE)
                                                        .addComponent(
                                                                btnReset,
                                                                GroupLayout.PREFERRED_SIZE,
                                                                30,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(
                                                                btnRegister,
                                                                GroupLayout.PREFERRED_SIZE,
                                                                30,
                                                                GroupLayout.PREFERRED_SIZE))
                                        .addContainerGap(
                                                GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)));

        GroupLayout layout = new GroupLayout(
                getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(
                GroupLayout.Alignment.LEADING).addGroup(
                layout.createSequentialGroup()
                        .addComponent(jPanel,
                                GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(
                GroupLayout.Alignment.LEADING).addGroup(
                layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel,
                                GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)));

        pack();
    }

    private void btnResetMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        this.agetxt.setText("");
        this.emailtxt.setText("");
        this.nametxt.setText("");
        this.password.setText("");
    }

    // RegisterMouseClick
    public void btnRegisterMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:

        RegisterInfo registerInfo = new RegisterInfo();
        registerInfo.setUname(this.nametxt.getText());
        registerInfo.setEmail(this.emailtxt.getText());
        try{
            int age = Integer.parseInt(this.agetxt.getText());
            registerInfo.setAge(age);
        }catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(this, "Please enter a number in the age field!");
            this.agetxt.setText("");
        }

        String passString = new String(this.password.getPassword());
        registerInfo.setPassword(passString);
        // JOptionPane

        System.out.println(registerInfo);

        RegisterHandler registerHandler = new RegisterHandler();
        if(registerHandler.validated(registerInfo.getEmail())==false){
            JOptionPane.showMessageDialog(this, "Email address already exists!");
        }else{
            int uid = registerHandler.InsertInfo(registerInfo);
            JOptionPane.showMessageDialog(this, "Your uid is "+uid);
        }


    }

//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new RegForm().setVisible(true);
//            }
//        });
//    }
}
