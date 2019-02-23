package lk.eDoc.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


public class MedicalReport implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private
    int mediID;

    private
    String drug;

    @Column(nullable = false)
    private Boolean morning;

    @Column(nullable = false)
    private Boolean noon;

    @Column(nullable = false)
    private Boolean eve;

    @Column(nullable = false)
    private Boolean night;

    private int qty;


    private
    String date;

    private int days;

    private String meal;

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }



    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AppCode",referencedColumnName = "AppCode")
    private
    Appointment appointment;

    @OneToOne(mappedBy = "medicalReport",fetch = FetchType.LAZY)
    private Order order;

    public int getMediID() {
        return mediID;
    }

    public void setMediID(int mediID) {
        this.mediID = mediID;
    }

    public String getDrug() {
        return drug;
    }

    public void setDrug(String drug) {
        this.drug = drug;
    }

    public Boolean getMorning() {
        return morning;
    }

    public void setMorning(Boolean morning) {
        this.morning = morning;
    }

    public Boolean getNoon() {
        return noon;
    }

    public void setNoon(Boolean noon) {
        this.noon = noon;
    }

    public Boolean getEve() {
        return eve;
    }

    public void setEve(Boolean eve) {
        this.eve = eve;
    }

    public Boolean getNight() {
        return night;
    }

    public void setNight(Boolean night) {
        this.night = night;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }


    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }


    public MedicalReport(String drug, Boolean morning, Boolean noon, Boolean eve, Boolean night, int qty, String date, int days, String meal) {
        this.drug = drug;
        this.morning = morning;
        this.noon = noon;
        this.eve = eve;
        this.night = night;
        this.qty = qty;
        this.date = date;
        this.days = days;
        this.meal = meal;


    }

    public MedicalReport() {
    }

    @Override
    public String toString() {
        return "MedicalReport{" +
                "mediID='" + mediID + '\'' +
                ", drug='" + drug + '\'' +
                ", morning=" + morning +
                ", noon=" + noon +
                ", eve=" + eve +
                ", night=" + night +
                ", qty=" + qty +
                ", date=" + date +
                ", days=" + days +
                ", meal='" + meal + '\'' +
                ", appointment=" + appointment +
                ", order=" + order +
                '}';
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
