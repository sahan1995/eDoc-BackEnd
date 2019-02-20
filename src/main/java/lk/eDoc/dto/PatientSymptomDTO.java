package lk.eDoc.dto;

import java.sql.Date;
import java.sql.Time;

public class PatientSymptomDTO {

    private int ID;

    private PatientDTO patientDTO;

    private SymptomDTO symptomDTO;


    private Date date;


    private Time time;

    public PatientDTO getPatientDTO() {
        return patientDTO;
    }

    public void setPatientDTO(PatientDTO patientDTO) {
        this.patientDTO = patientDTO;
    }

    public SymptomDTO getSymptomDTO() {
        return symptomDTO;
    }

    public void setSymptomDTO(SymptomDTO symptomDTO) {
        this.symptomDTO = symptomDTO;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public PatientSymptomDTO(int ID, PatientDTO patientDTO, SymptomDTO symptomDTO, Date date, Time time) {
        this.ID = ID;
        this.patientDTO = patientDTO;
        this.symptomDTO = symptomDTO;
        this.date = date;
        this.time = time;
    }

    public PatientSymptomDTO(Date date, Time time) {
        this.date = date;
        this.time = time;
    }

    public PatientSymptomDTO(int ID, Date date, Time time) {
        this.ID = ID;
        this.date = date;
        this.time = time;
    }

    public PatientSymptomDTO() {
    }

    @Override
    public String toString() {
        return "PatientSymptomDTO{" +
                "ID=" + ID +
                ", date=" + date +
                ", time=" + time +
                '}';
    }

}
