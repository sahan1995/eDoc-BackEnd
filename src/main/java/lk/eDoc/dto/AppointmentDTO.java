package lk.eDoc.dto;

import java.sql.Time;
import java.util.Date;

public class AppointmentDTO {


    private
    String AppCode;


    private
    String time;

    private
    String date;

    private String AppType;

    private boolean isCheck;

    private
    PatientDTO patientDTO;

    private
    DoctorDTO doctorDTO;


    private  PrescriptionDTO prescriptionDTO;

    public PrescriptionDTO getPrescriptionDTO() {
        return prescriptionDTO;
    }

    public void setPrescriptionDTO(PrescriptionDTO prescriptionDTO) {
        this.prescriptionDTO = prescriptionDTO;
    }

    private boolean isCancle;

    public boolean isCancle() {
        return isCancle;
    }

    public void setCancle(boolean cancle) {
        isCancle = cancle;
    }

    public AppointmentDTO(String appCode, String time, String date, String appType, boolean isCheck, PatientDTO patientDTO, DoctorDTO doctorDTO, boolean isCancle) {
        AppCode = appCode;
        this.time = time;
        this.date = date;
        AppType = appType;
        this.isCheck = isCheck;
        this.patientDTO = patientDTO;
        this.doctorDTO = doctorDTO;
        this.isCancle = isCancle;
    }

    public String getAppCode() {
        return AppCode;
    }

    public void setAppCode(String appCode) {
        AppCode = appCode;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAppType() {
        return AppType;
    }

    public void setAppType(String appType) {
        AppType = appType;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
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

    public AppointmentDTO(String appCode, String time, String date, String appType, boolean isCheck) {
        AppCode = appCode;
        this.time = time;
        this.date = date;
        AppType = appType;
        this.isCheck = isCheck;
    }

//    public AppointmentDTO(String appCode, String time, String date, String appType, boolean isCheck, PatientDTO patientDTO, DoctorDTO doctorDTO) {
//        AppCode = appCode;
//        this.time = time;
//        this.date = date;
//        AppType = appType;
//        this.isCheck = isCheck;
//        this.patientDTO = patientDTO;
//        this.doctorDTO = doctorDTO;
//    }


    @Override
    public String toString() {
        return "AppointmentDTO{" +
                "AppCode='" + AppCode + '\'' +
                ", time='" + time + '\'' +
                ", date='" + date + '\'' +
                ", AppType='" + AppType + '\'' +
                ", isCheck=" + isCheck +
                ", patientDTO=" + patientDTO +
                ", doctorDTO=" + doctorDTO +
                ", prescriptionDTO=" + prescriptionDTO +
                ", isCancle=" + isCancle +
                '}';
    }

    public AppointmentDTO() {
    }
}
