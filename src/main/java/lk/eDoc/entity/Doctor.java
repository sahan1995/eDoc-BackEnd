package lk.eDoc.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NamedQuery(name = Doctor.query,query =  "select d from Doctor d ORDER BY d.DID DESC" +"")

public class Doctor  {

    @Transient
    public static final String query="Doctor.getLastID";

    @Id
    private String DID;

    private String fname;

    private String mname;

    private String lname;

    private String gender;
    @Temporal(TemporalType.DATE)

    private
    Date dob;
    @Column(unique = true)
    private
    String NIC;

    private String country;

    private String city;

    private String lane;

    private String code;

    private Double lat;

    private Double lng;

    private String profilePic;

    private String university;

    private String degree;
    @Column(nullable = false)
    private String specilizedIn;
    private String hostipal;
    @Column(unique = true)
    private
    String govDID;
//    @Column(unique = true)
//
//    private
//    String uname;
//
//    private String password;

    @Column(nullable = false)
    private BigDecimal webFee;
    @Column(nullable = false)
    private BigDecimal ppFee;
    @Column(nullable = false)
    private BigDecimal toHomeFee;

    @Lob
    private String aboutMe;

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    @OneToMany(mappedBy = "doctor",fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private
    List<DoctorTel> doctorTels = new ArrayList<>();

    @OneToOne(mappedBy = "doctor",cascade = {CascadeType.PERSIST,CascadeType.REMOVE},fetch = FetchType.EAGER)
    private
    PrivatePrictice privatePrictice;

    @OneToMany(mappedBy = "doctor",fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST})
    private
    List<Appointment> appointments  = new ArrayList<>();

    @OneToMany(mappedBy = "doctor",fetch = FetchType.LAZY)
    private
    List<PatientFamDoc> patientFamDocs = new ArrayList<>();


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "patientSymptomsOFdoctor",
            joinColumns = {@JoinColumn( name = "DID",referencedColumnName = "DID")},
            inverseJoinColumns = {@JoinColumn(name = "ID",referencedColumnName = "ID")}
    )
    private
    List<PatientSymptoms> patientSymptoms = new ArrayList<>();


    public String getDID() {
        return DID;
    }


    public void setDID(String DID) {
        this.DID = DID;
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

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getSpecilizedIn() {
        return specilizedIn;
    }

    public void setSpecilizedIn(String specilizedIn) {
        this.specilizedIn = specilizedIn;
    }

    public String getHostipal() {
        return hostipal;
    }

    public void setHostipal(String hostipal) {
        this.hostipal = hostipal;
    }

    public String getGovDID() {
        return govDID;
    }

    public void setGovDID(String govDID) {
        this.govDID = govDID;
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

    public BigDecimal getWebFee() {
        return webFee;
    }

    public void setWebFee(BigDecimal webFee) {
        this.webFee = webFee;
    }

    public BigDecimal getPpFee() {
        return ppFee;
    }

    public void setPpFee(BigDecimal ppFee) {
        this.ppFee = ppFee;
    }

    public BigDecimal getToHomeFee() {
        return toHomeFee;
    }

    public void setToHomeFee(BigDecimal toHomeFee) {
        this.toHomeFee = toHomeFee;
    }

    public Doctor(String DID, String fname, String mname, String lname, String gender, Date dob, String NIC, String country, String city, String lane, String code, Double lat, Double lng, String profilePic, String university, String degree, String specilizedIn, String hostipal, String govDID, BigDecimal webFee, BigDecimal ppFee, BigDecimal toHomeFee,String aboutMe) {
        this.DID = DID;
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
        this.university = university;
        this.degree = degree;
        this.specilizedIn = specilizedIn;
        this.hostipal = hostipal;
        this.govDID = govDID;
        this.webFee = webFee;
        this.ppFee = ppFee;
        this.toHomeFee = toHomeFee;
        this.aboutMe = aboutMe;
    }

    public Doctor() {
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "DID='" + DID + '\'' +
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
                ", university='" + university + '\'' +
                ", degree='" + degree + '\'' +
                ", specilizedIn='" + specilizedIn + '\'' +
                ", hostipal='" + hostipal + '\'' +
                ", govDID='" + govDID + '\'' +
//                ", uname='" + uname + '\'' +
//                ", password='" + password + '\'' +
                ", webFee=" + webFee +
                ", ppFee=" + ppFee +
                ", toHomeFee=" + toHomeFee +
                '}';
    }

    public List<DoctorTel> getDoctorTels() {
        return doctorTels;
    }

    public void setDoctorTels(List<DoctorTel> doctorTels) {
        this.doctorTels = doctorTels;
    }

    public PrivatePrictice getPrivatePrictice() {
        return privatePrictice;
    }

    public void setPrivatePrictice(PrivatePrictice privatePrictice) {
        this.privatePrictice = privatePrictice;
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
