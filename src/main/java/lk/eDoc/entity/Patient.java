package lk.eDoc.entity;

import javax.persistence.*;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
        @NamedQuery(name = Patient.query, query = "select p from Patient p ORDER BY p.PID DESC" +"")

public class Patient  {

    @Transient
    public static final String query="Patient.getLastID";

    @Id
    private String PID;

    private String fname;

    private String mname;

    private String lname;

    private String gender;

    private Date dob;
    @Column(unique = true)
    private String NIC;

    private String country;

    private String city;

    private String lane;

    private String code;

    private double lat;

    private double lng;

    private String profilePic;

    @Lob
    private String videoCallID;

    public String getVideoCallID() {
        return videoCallID;
    }

    public void setVideoCallID(String videoCallID) {
        this.videoCallID = videoCallID;
    }

//    public Patient(String PID, String fname, String mname, String lname, String gender, Date dob, String NIC, String country, String city, String lane, String code, double lat, double lng, String profilePic, String videoCallID) {
//        this.PID = PID;
//        this.fname = fname;
//        this.mname = mname;
//        this.lname = lname;
//        this.gender = gender;
//        this.dob = dob;
//        this.NIC = NIC;
//        this.country = country;
//        this.city = city;
//        this.lane = lane;
//        this.code = code;
//        this.lat = lat;
//        this.lng = lng;
//        this.profilePic = profilePic;
//        this.videoCallID = videoCallID;
//    }
//
//    @Transient
//    private String uname;
//    @Transient
//    private String password;

    @OneToMany(mappedBy = "patient",fetch = FetchType.LAZY,cascade = {CascadeType.MERGE,CascadeType.REMOVE})
    private
    List<PatientTel> patientTels = new ArrayList<>();

    @OneToMany(mappedBy = "patient",fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.REMOVE})

    private
    List<Appointment> appointments = new ArrayList<>();

    @OneToMany(mappedBy = "patient",fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private List<PatientFamDoc> patientFamDocs = new ArrayList<>();

    @OneToMany(mappedBy = "patient",fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private
    List<PatientSymptoms> patientSymptoms = new ArrayList<>();


    public String getPID() {
        return PID;
    }

    public void setPID(String PID) {
        this.PID = PID;
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

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
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

//    public String getUname() {
//        return uname;
//    }
//
//    public void setUname(String uname) {
//        this.uname = uname;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }

    public Patient(String PID, String fname, String mname, String lname, String gender, Date dob, String NIC, String country, String city, String lane, String code, double lat, double lng, String profilePic) {
        this.PID = PID;
        this.fname = fname;
        this.mname = mname;
        this.lname = lname;
        this.gender = gender;
        this.dob = dob;
        this.NIC = NIC;
        this.country = country;
        this.city = city;
        this.lane = lane;
        this.code = code;
        this.lat = lat;
        this.lng = lng;
        this.profilePic = profilePic;
    }

    public Patient() {
    }

    @Override
    public String toString() {
        return "Patient{" +
                "PID='" + PID + '\'' +
                ", fname='" + fname + '\'' +
                ", mname='" + mname + '\'' +
                ", lname='" + lname + '\'' +
                ", gender='" + gender + '\'' +
                ", dob=" + dob +
                ", NIC='" + NIC + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", lane='" + lane + '\'' +
                ", code='" + code + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                ", profilePic=" + profilePic +
//                ", uname='" + uname + '\'' +
//                ", password='" + password + '\'' +
                '}';
    }

    public List<PatientTel> getPatientTels() {
        return patientTels;
    }

    public void setPatientTels(List<PatientTel> patientTels) {
        this.patientTels = patientTels;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }


    public List<PatientFamDoc> getPatientFamDocs() {
        return patientFamDocs;
    }

    public void setPatientFamDocs(List<PatientFamDoc> patientFamDocs) {
        this.patientFamDocs = patientFamDocs;
    }

    public List<PatientSymptoms> getPatientSymptoms() {
        return patientSymptoms;
    }

    public void setPatientSymptoms(List<PatientSymptoms> patientSymptoms) {
        this.patientSymptoms = patientSymptoms;
    }
}
