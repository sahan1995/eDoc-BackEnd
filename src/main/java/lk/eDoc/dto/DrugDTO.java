package lk.eDoc.dto;

public class DrugDTO {

    private int drugID;

    private String meal;

    private
    String drug;


    private Boolean morning;


    private Boolean noon;


    private Boolean eve;


    private Boolean night;

    private int qty;

    private int days;


    private
    PrescriptionDTO prescriptionDTO;

    public int getDrugID() {
        return drugID;
    }

    public void setDrugID(int drugID) {
        this.drugID = drugID;
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
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

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public PrescriptionDTO getPrescriptionDTO() {
        return prescriptionDTO;
    }

    public void setPrescriptionDTO(PrescriptionDTO prescriptionDTO) {
        this.prescriptionDTO = prescriptionDTO;
    }

    public DrugDTO(int drugID, String meal, String drug, Boolean morning, Boolean noon, Boolean eve, Boolean night, int qty, int days) {
        this.drugID = drugID;
        this.meal = meal;
        this.drug = drug;
        this.morning = morning;
        this.noon = noon;
        this.eve = eve;
        this.night = night;
        this.qty = qty;
        this.days = days;
    }

    public DrugDTO() {
    }

    @Override
    public String toString() {
        return "DrugDTO{" +
                "drugID=" + drugID +
                ", meal='" + meal + '\'' +
                ", drug='" + drug + '\'' +
                ", morning=" + morning +
                ", noon=" + noon +
                ", eve=" + eve +
                ", night=" + night +
                ", qty=" + qty +
                ", days=" + days +
                ", prescriptionDTO=" + prescriptionDTO +
                '}';
    }
}
