package lk.eDoc.entity;

import javax.persistence.*;

@Entity
public class Drug {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "G1")
    @TableGenerator(name = "G1",table = "AutoIncermant",allocationSize = 1,valueColumnName = "nextID")
    private int drugID;

    private String meal;

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

    private int days;

    @ManyToOne
    @JoinColumn(name = "prescriptionID",referencedColumnName = "prescriptionID")
    private
    Prescription prescription;


    public Drug(String meal, String drug, Boolean morning, Boolean noon, Boolean eve, Boolean night, int qty, int days) {
        this.setMeal(meal);
        this.setDrug(drug);
        this.setMorning(morning);
        this.setNoon(noon);
        this.setEve(eve);
        this.setNight(night);
        this.setQty(qty);
        this.setDays(days);
    }

    public Drug() {
    }

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

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    @Override
    public String toString() {
        return "Drug{" +
                "drugID=" + drugID +
                ", meal='" + meal + '\'' +
                ", drug='" + drug + '\'' +
                ", morning=" + morning +
                ", noon=" + noon +
                ", eve=" + eve +
                ", night=" + night +
                ", qty=" + qty +
                ", days=" + days +
                ", prescription=" + prescription +
                '}';
    }
}
