package lk.eDoc.dto;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PatientDTO {



    private String ID;

    private String fname;

    private String mname;

    private String lname;

    private String gender;

    private Date dob;

    private String country;

    private String city;

    private String lane;

    private String code;

    private double lat;

    private double lng;

    private String profilePic;

    private String uname;

    private String password;

    private String role;

    private String identy;

    private String email;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "PatientDTO{" +
                "ID='" + ID + '\'' +
                ", fname='" + fname + '\'' +
                ", mname='" + mname + '\'' +
                ", lname='" + lname + '\'' +
                ", gender='" + gender + '\'' +
                ", dob=" + dob +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", lane='" + lane + '\'' +
                ", code='" + code + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                ", profilePic='" + profilePic + '\'' +
                ", uname='" + uname + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", identy='" + identy + '\'' +
                '}';
    }

    private List<PatientTelDTO> patientTelDTOList = new ArrayList<>();


    public String getPID() {
        return ID;
    }

    public void setPID(String ID) {
        this.ID = ID;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getIdenty() {
        return identy;
    }

    public void setIdenty(String identy) {
        this.identy = identy;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLane() {
        return lane;
    }

    public void setLane(String lane) {
        this.lane = lane;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
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

    public PatientDTO(String ID, String fname, String mname, String lname, String gender, Date dob, String identy, String country, String city, String lane, String code, double lat, double lng, String profilePic,String email) {
        this.ID = ID;
        this.fname = fname;
        this.mname = mname;
        this.lname = lname;
        this.gender = gender;
        this.dob = dob;
        this.identy = identy;
        this.country = country;
        this.city = city;
        this.lane = lane;
        this.code = code;
        this.lat = lat;
        this.lng = lng;
        this.profilePic = profilePic;
        this.email=email;
    }


    public PatientDTO() {
    }

    public List<PatientTelDTO> getPatientTelDTOList() {
        return patientTelDTOList;
    }

    public void setPatientTelDTOList(List<PatientTelDTO> patientTelDTOList) {
        this.patientTelDTOList = patientTelDTOList;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}
