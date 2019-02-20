package lk.eDoc.dto;

public class LoginDetailDTO {
    private String ID;
    private String fname;
    private String lname;
    private String role;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LoginDetailDTO(String ID, String fname, String lname, String role) {
        this.ID = ID;
        this.fname = fname;
        this.lname = lname;
        this.role = role;
    }

    public LoginDetailDTO() {

    }

    @Override
    public String toString() {
        return "LoginDetailDTO{" +
                "ID='" + ID + '\'' +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
