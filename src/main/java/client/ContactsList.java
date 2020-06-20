package client;

import entity.Contact;

import javax.swing.*;
import java.awt.*;

public class ContactsList implements ListCellRenderer {
    public ContactsList() {
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value,
                                                  int index, boolean isSelected, boolean cellHasFocus) {
        JLabel cellComp = new JLabel();
        ImageIcon offIcon=new ImageIcon("images/offline.png");
        ImageIcon onIcon=new ImageIcon("images/online.png");

        // 设置标题栏，前景色，背景色
        if(value instanceof Contact){
            Contact contact = (Contact)value;
            int uid = contact.getUid();
            String uname = contact.getUname();
            String lableText = "<"+uid+"> "+uname;
            if(isSelected){
                cellComp.setIcon(onIcon);
                cellComp.setForeground(list.getSelectionForeground());
                cellComp.setBackground(list.getSelectionBackground());
            }
            if(contact.getOnline()==1){        // On met vert si user est en ligne, sinon, on met rouge
                cellComp.setIcon(onIcon);
                cellComp.setForeground(Color.GREEN);
                cellComp.setBackground(list.getBackground());
            }else{
                cellComp.setIcon(offIcon);
                cellComp.setForeground(Color.RED);
                cellComp.setBackground(list.getBackground());
            }

            if (contact.isSender()) {
                lableText=lableText+"<Incoming msgs...> ";
                cellComp.setForeground(Color.BLUE);

            }
            if(isSelected){

                cellComp.setForeground(list.getSelectionForeground());
                cellComp.setBackground(list.getSelectionBackground());
            }

            cellComp.setText(lableText);
        }

        // TODO Auto-generated method stub
        cellComp.setOpaque(true);
        return cellComp;
    }
}
