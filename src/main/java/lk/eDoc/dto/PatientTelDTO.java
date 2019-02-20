package lk.eDoc.dto;

public class PatientTelDTO {

    private String tel;

    private PatientDTO patientDTO;


    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public PatientDTO getPatientDTO() {
        return patientDTO;
    }

    public void setPatientDTO(PatientDTO patientDTO) {
        this.patientDTO = patientDTO;
    }

    public PatientTelDTO(String tel, PatientDTO patientDTO) {
        this.tel = tel;
        this.patientDTO = patientDTO;
    }

    public PatientTelDTO() {
    }

    @Override
    public String toString() {
        return "PatientTelDTO{" +
                "tel='" + tel + '\'' +
                ", patientDTO=" + patientDTO +
                '}';
    }


}
