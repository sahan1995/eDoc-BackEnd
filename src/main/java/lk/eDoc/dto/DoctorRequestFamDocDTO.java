package lk.eDoc.dto;

public class DoctorRequestFamDocDTO {

    private String PID;
    private String DID;
    private boolean isCanle;
    private boolean isAccepnt;
    private PatientDTO patientDTO;
    private DoctorDTO doctorDTO;

    public DoctorRequestFamDocDTO(String PID, String DID, boolean isCanle, boolean isAccepnt) {
        this.setPID(PID);
        this.setDID(DID);
        this.setCanle(isCanle);
        this.setAccepnt(isAccepnt);
    }

    public DoctorRequestFamDocDTO() {
    }


    public String getPID() {
        return PID;
    }

    public void setPID(String PID) {
        this.PID = PID;
    }

    public String getDID() {
        return DID;
    }

    public void setDID(String DID) {
        this.DID = DID;
    }

    public boolean isCanle() {
        return isCanle;
    }

    public void setCanle(boolean canle) {
        isCanle = canle;
    }

    public boolean isAccepnt() {
        return isAccepnt;
    }

    public void setAccepnt(boolean accepnt) {
        isAccepnt = accepnt;
    }

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

    @Override
    public String toString() {
        return "DoctorRequestFamDocDTO{" +
                "PID='" + PID + '\'' +
                ", DID='" + DID + '\'' +
                ", isCanle=" + isCanle +
                ", isAccepnt=" + isAccepnt +
                ", patientDTO=" + patientDTO +
                ", doctorDTO=" + doctorDTO +
                '}';
    }

}
