package entity;

import java.io.Serializable;

public class RegisterInfo implements Serializable {
    private String uname;
    private int age;
    private String email;
    private String password;

    public void setUname(String uname) {
        this.uname = uname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUname() {
        return uname;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "RegInfo [age=" + age + ", uname=" + uname + ", email=" + email + ", password=" + password + "]";
    }
}
