package lk.eDoc.dto;

import java.sql.Time;

public class PrivatePracticeDTO {



    private String PPID;
    private String name;

    private String country;

    private String city;

    private String lane;

    private String code;

    private String tel;

    private Double lat;

    private Double lng;

    private Time openTime;

    private Time closeTime;

    private DoctorDTO doctorDTO;


    public String getPPID() {
        return PPID;
    }

    public void setPPID(String PPID) {
        this.PPID = PPID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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

    public Time getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Time openTime) {
        this.openTime = openTime;
    }

    public Time getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Time closeTime) {
        this.closeTime = closeTime;
    }

    public DoctorDTO getDoctorDTO() {
        return doctorDTO;
    }

    public void setDoctorDTO(DoctorDTO doctorDTO) {
        this.doctorDTO = doctorDTO;
    }

    public PrivatePracticeDTO(String PPID, String name, String country, String city, String lane, String code, String tel, Double lat, Double lng, Time openTime, Time closeTime) {
        this.PPID = PPID;
        this.name = name;
        this.country = country;
        this.city = city;
        this.lane = lane;
        this.code = code;
        this.tel = tel;
        this.lat = lat;
        this.lng = lng;
        this.openTime = openTime;
        this.closeTime = closeTime;
    }

    @Override
    public String toString() {
        return "PrivatePracticeDTO{" +
                "PPID='" + PPID + '\'' +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", lane='" + lane + '\'' +
                ", code='" + code + '\'' +
                ", tel='" + tel + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                ", openTime=" + openTime +
                ", closeTime=" + closeTime +
                '}';
    }
}
