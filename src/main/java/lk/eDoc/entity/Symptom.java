package lk.eDoc.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Symptom {


    @Id
    private
    String syID;
    private String name;

    @OneToMany(mappedBy = "symptom",fetch = FetchType.LAZY)
    private
    List<PatientSymptoms> patientSymptoms  = new ArrayList<>();


    public Symptom(String syID, String name) {
        this.setSyID(syID);
        this.setName(name);
    }

    public Symptom() {
    }


    public String getSyID() {
        return syID;
    }

    public void setSyID(String syID) {
        this.syID = syID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Symptom{" +
                "syID='" + syID + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public List<PatientSymptoms> getPatientSymptoms() {
        return patientSymptoms;
    }

    public void setPatientSymptoms(List<PatientSymptoms> patientSymptoms) {
        this.patientSymptoms = patientSymptoms;
    }
}
