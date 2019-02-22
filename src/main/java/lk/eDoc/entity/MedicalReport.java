package lk.eDoc.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class MedicalReport implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private
    int mediID;

    private
    String drug;

    @Column(nullable = false)
    private int morning;

    @Column(nullable = false)
    private int noon;

    @Column(nullable = false)
    private int eve;

    @Column(nullable = false)
    private int night;

    private int qty;

    @Temporal(TemporalType.DATE)
    private
    Date date;

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

    public int getMorning() {
        return morning;
    }

    public void setMorning(int morning) {
        this.morning = morning;
    }

    public int getNoon() {
        return noon;
    }

    public void setNoon(int noon) {
        this.noon = noon;
    }

    public int getEve() {
        return eve;
    }

    public void setEve(int eve) {
        this.eve = eve;
    }

    public int getNight() {
        return night;
    }

    public void setNight(int night) {
        this.night = night;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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


    public MedicalReport(String drug, int morning, int noon, int eve, int night, int qty, Date date, int days, String meal) {
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
