package lk.eDoc.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pharmacy {

    @Id
    private
    String phyCode;

    private String phyName;

    @Column(unique = true)
    private
    String phyLicenCode;

    private String country;

    private String city;

    private String lane;

    private String code;

    private String ownerName;

    private String lat;

    private String lng;

    @Column(unique = true)
    private
    String uname;

    private String password;


    @OneToMany(mappedBy = "pharmacy",cascade = CascadeType.REMOVE,fetch = FetchType.LAZY )
    private
    List<Order> orders = new ArrayList<>();

    public String getPhyCode() {
        return phyCode;
    }

    public void setPhyCode(String phyCode) {
        this.phyCode = phyCode;
    }

    public String getPhyName() {
        return phyName;
    }

    public void setPhyName(String phyName) {
        this.phyName = phyName;
    }

    public String getPhyLicenCode() {
        return phyLicenCode;
    }

    public void setPhyLicenCode(String phyLicenCode) {
        this.phyLicenCode = phyLicenCode;
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

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
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

    public Pharmacy(String phyCode, String phyName, String phyLicenCode, String country, String city, String lane, String code, String ownerName, String lat, String lng, String uname, String password) {
        this.phyCode = phyCode;
        this.phyName = phyName;
        this.phyLicenCode = phyLicenCode;
        this.country = country;
        this.city = city;
        this.lane = lane;
        this.code = code;
        this.ownerName = ownerName;
        this.lat = lat;
        this.lng = lng;
        this.uname = uname;
        this.password = password;
    }

    public Pharmacy() {
    }

    @Override
    public String toString() {
        return "Pharmacy{" +
                "phyCode='" + phyCode + '\'' +
                ", phyName='" + phyName + '\'' +
                ", phyLicenCode='" + phyLicenCode + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", lane='" + lane + '\'' +
                ", code='" + code + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                ", uname='" + uname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
