package lk.eDoc.dto;

import java.util.Date;

public class MedicalReportDTO {


    private
    String mediID;

    private
    String drug;


    private int morning;


    private int noon;


    private int eve;

    private int night;

    private int qty;


    private
    Date date;

    private int days;

    private boolean beforemeal;

    private boolean aftermeal;

    private
    AppointmentDTO appointmentDTO;


    public String getMediID() {
        return mediID;
    }

    public void setMediID(String mediID) {
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

    public boolean isBeforemeal() {
        return beforemeal;
    }

    public void setBeforemeal(boolean beforemeal) {
        this.beforemeal = beforemeal;
    }

    public boolean isAftermeal() {
        return aftermeal;
    }

    public void setAftermeal(boolean aftermeal) {
        this.aftermeal = aftermeal;
    }

    public AppointmentDTO getAppointmentDTO() {
        return appointmentDTO;
    }

    public void setAppointmentDTO(AppointmentDTO appointmentDTO) {
        this.appointmentDTO = appointmentDTO;
    }

    public MedicalReportDTO(String mediID, String drug, int morning, int noon, int eve, int night, int qty, Date date, int days, boolean beforemeal, boolean aftermeal) {
        this.mediID = mediID;
        this.drug = drug;
        this.morning = morning;
        this.noon = noon;
        this.eve = eve;
        this.night = night;
        this.qty = qty;
        this.date = date;
        this.days = days;
        this.beforemeal = beforemeal;
        this.aftermeal = aftermeal;
    }

    public MedicalReportDTO() {
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
                ", beforemeal=" + beforemeal +
                ", aftermeal=" + aftermeal +
                '}';
    }
}
