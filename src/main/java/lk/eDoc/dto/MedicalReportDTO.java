package lk.eDoc.dto;

import java.util.Date;

public class MedicalReportDTO {


    private
    int mediID;

    private String drug;


    private Boolean morning;


    private Boolean noon;


    private Boolean eve;

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

    private
    AppointmentDTO appointmentDTO;


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


    public AppointmentDTO getAppointmentDTO() {
        return appointmentDTO;
    }

    public void setAppointmentDTO(AppointmentDTO appointmentDTO) {
        this.appointmentDTO = appointmentDTO;
    }


    public MedicalReportDTO() {
    }

    public MedicalReportDTO(String drug, Boolean morning, Boolean noon, Boolean eve, Boolean night, int qty, String date, int days, String meal) {
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

    @Override
    public String toString() {
        return "MedicalReportDTO{" +
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
                ", appointmentDTO=" + appointmentDTO +
                '}';
    }
}
