package entity;

import java.io.Serializable;

public class Contact implements Serializable {  // Refresh Contact
    private int uid;
    private String uname;
    private String email;
    private int age;
    private int online;
    private String peerIp;
    private int peerPort;
    private boolean isSender;

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setOnline(int online) {
        this.online = online;
    }

    public void setPeerIp(String peerIp) {
        this.peerIp = peerIp;
    }

    public void setPeerPort(int peerPort) {
        this.peerPort = peerPort;
    }

    public void setSender(boolean sender) {
        this.isSender = sender;
    }

    public int getUid() {
        return uid;
    }

    public String getUname() {
        return uname;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public int getOnline() {
        return online;
    }

    public String getPeerIp() {
        return peerIp;
    }

    public int getPeerPort() {
        return peerPort;
    }

    public boolean isSender() {
        return isSender;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", online=" + online +
                ", peerIp='" + peerIp + '\'' +
                ", peerPort=" + peerPort +
                ", isSender=" + isSender +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        Contact other = (Contact) o;
        if (uid != other.uid)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + uid;
        return result;
    }
}
