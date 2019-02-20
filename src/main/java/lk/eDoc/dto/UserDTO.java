package lk.eDoc.dto;

public class UserDTO {
    private
    String uname;
    private
    String password;
    private String role;
    private String ID;

    public UserDTO(String uname, String password, String role, String ID) {
        this.setUname(uname);
        this.setPassword(password);
        this.setRole(role);
        this.setID(ID);
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
