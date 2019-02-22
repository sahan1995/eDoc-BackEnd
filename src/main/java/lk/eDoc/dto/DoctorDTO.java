package lk.eDoc.dto;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DoctorDTO {

    private String DID;

    private String fname;

    private String mname;

    private String lname;

    private String gender;

    private
    Date dob;

    private String country;

    private String city;

    private String lane;

    private String code;

    private Double lat;

    private Double lng;

    private String profilePic;

    private String university;

    private String degree;

    private String specilizedIn;
    private String hostipal;

    private String govDID;

    private String uname;

    private String password;

    private BigDecimal webFee;

    private BigDecimal ppFee;

    private BigDecimal toHomeFee;



    private String role;

    private String aboutMe;

    private String videoCallID;

    public String getVideoCallID() {
        return videoCallID;
    }

    public void setVideoCallID(String videoCallID) {
        this.videoCallID = videoCallID;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }


//    private String NICNO;

    @Override
    public String toString() {
        return "DoctorDTO{" +
                "DID='" + DID + '\'' +
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
                ", university='" + university + '\'' +
                ", degree='" + degree + '\'' +
                ", specilizedIn='" + specilizedIn + '\'' +
                ", hostipal='" + hostipal + '\'' +
                ", govDID='" + govDID + '\'' +
                ", uname='" + uname + '\'' +
                ", password='" + password + '\'' +
                ", webFee=" + webFee +
                ", ppFee=" + ppFee +
                ", toHomeFee=" + toHomeFee +
                ", doctorTelDTOS=" + doctorTelDTOS +
                ", role='" + role + '\'' +
                ", identy='" + identy + '\'' +
                '}';
    }

    private String identy;

    private List<DoctorTelDTO> doctorTelDTOS = new ArrayList<>();
    public String getIdenty() {
        return identy;
    }

    public void setIdenty(String identy) {
        this.identy = identy;
    }

//    public String getNICNO() {
//        return NICNO;
//    }
//
//    public void setNICNO(String NICNO) {
//        this.NICNO = NICNO;
//    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

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

    public DoctorDTO(String DID, String fname, String mname, String lname, String gender, Date dob, String identy, String country, String city, String lane, String code, Double lat, Double lng, String profilePic, String university, String degree, String specilizedIn, String hostipal, String govDID, BigDecimal webFee, BigDecimal ppFee, BigDecimal toHomeFee,String aboutMe) {
        this.DID = DID;
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
    public DoctorDTO(String DID, String fname, String mname, String lname, String gender, Date dob, String identy, String country, String city, String lane, String code, Double lat, Double lng, String profilePic, String university, String degree, String specilizedIn, String hostipal, String govDID, BigDecimal webFee, BigDecimal ppFee, BigDecimal toHomeFee,String aboutMe,List<DoctorTelDTO> doctorTelDTOS) {
        this.DID = DID;
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
        this.university = university;
        this.degree = degree;
        this.specilizedIn = specilizedIn;
        this.hostipal = hostipal;
        this.govDID = govDID;
        this.webFee = webFee;
        this.ppFee = ppFee;
        this.toHomeFee = toHomeFee;
        this.aboutMe = aboutMe;
        this.doctorTelDTOS = doctorTelDTOS;
    }


    public DoctorDTO() {
    }

    public List<DoctorTelDTO> getDoctorTelDTOS() {
        return doctorTelDTOS;
    }

    public void setDoctorTelDTOS(List<DoctorTelDTO> doctorTelDTOS) {
        this.doctorTelDTOS = doctorTelDTOS;
    }
}
