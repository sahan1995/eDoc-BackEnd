package lk.eDoc.dto;

public class PatientFamDocDTO {
    private PatientDTO patientDTO;
    private DoctorDTO doctorDTO;

    public PatientDTO getPatientDTO() {
        return patientDTO;
    }

    public void setPatientDTO(PatientDTO patientDTO) {
        this.patientDTO = patientDTO;
    }

    public DoctorDTO getDoctorDTO() {
        return doctorDTO;
    }

    public void setDoctorDTO(DoctorDTO doctorDTO) {
        this.doctorDTO = doctorDTO;
    }

    public PatientFamDocDTO(PatientDTO patientDTO, DoctorDTO doctorDTO) {
        this.patientDTO = patientDTO;
        this.doctorDTO = doctorDTO;
    }

    public PatientFamDocDTO() {
    }

    @Override
    public String toString() {
        return "PatientFamDocDTO{" +
                "patientDTO=" + patientDTO +
                ", doctorDTO=" + doctorDTO +
                '}';
    }
}
