package lk.eDoc.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class User {

    @Id
    private
    String uname;
    @Lob
    private
    String password;
    private String role;
    private String ID;

    public User(String uname, String password, String role, String ID) {
        this.setUname(uname);
        this.setPassword(password);
        this.setRole(role);
        this.setID(ID);
    }

    public User() {
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "User{" +
                "uname='" + uname + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", ID='" + ID + '\'' +
                '}';
    }
}
