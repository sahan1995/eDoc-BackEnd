package lk.eDoc.entity;

import javax.persistence.*;
import java.sql.Time;

@Entity
public class PrivatePrictice {
    @Id
    private
    String PPID;
    private String name;
    @Column(nullable = false)
    private String country;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String lane;
    @Column(nullable = false)
    private String code;
    @Column(nullable = false)
    private String tel;
    @Column(nullable = false)
    private Double lat;
    @Column(nullable = false)
    private Double lng;

    private
    Time openTime;

    private
    Time closeTime;

    @OneToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinColumn(name = "DID", referencedColumnName = "DID")
    private
    Doctor doctor;

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

    public PrivatePrictice(String PPID, String name, String country, String city, String lane, String code, String tel, Double lat, Double lng, Time openTime, Time closeTime) {
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

    public PrivatePrictice() {
    }

    @Override
    public String toString() {
        return "PrivatePrictice{" +
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

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}