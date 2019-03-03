package lk.eDoc.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Prescription {

    @Id
    private String prescriptionID;


    private String date;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "appCode",referencedColumnName = "AppCode")
    private
    Appointment appointment;

    @OneToMany(mappedBy = "prescription")
    private List<Drug> drugs;

    @OneToOne(mappedBy = "prescription",cascade = CascadeType.ALL)
    private Order order;

    public Prescription(String prescriptionID, String date) {
        this.setPrescriptionID(prescriptionID);
        this.setDate(date);
    }

    public Prescription() {
    }

    public String getPrescriptionID() {
        return prescriptionID;
    }

    public void setPrescriptionID(String prescriptionID) {
        this.prescriptionID = prescriptionID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "prescriptionID='" + prescriptionID + '\'' +
                ", date='" + date + '\'' +
                ", appointment=" + appointment +
                '}';
    }

    public List<Drug> getDrugs() {
        return drugs;
    }

    public void setDrugs(List<Drug> drugs) {
        this.drugs = drugs;
    }
}
