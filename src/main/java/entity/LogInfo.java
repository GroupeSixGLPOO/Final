package entity;

import java.io.Serializable;

public class LogInfo implements Serializable {  // Interface log in
    private int uid;
    private String password;

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUid() {
        return uid;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "LogInfo{" +
                "uid=" + uid +
                ", password='" + password + '\'' +
                '}';
    }
}
