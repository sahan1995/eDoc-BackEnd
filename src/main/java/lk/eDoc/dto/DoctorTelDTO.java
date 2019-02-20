package lk.eDoc.dto;

public class DoctorTelDTO {

    private String tel;

    private DoctorDTO doctorDTO;



    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public DoctorDTO getDoctorDTO() {
        return doctorDTO;
    }

    public void setDoctorDTO(DoctorDTO doctorDTO) {
        this.doctorDTO = doctorDTO;
    }

    public DoctorTelDTO(String tel, DoctorDTO doctorDTO) {
        this.tel = tel;
        this.doctorDTO = doctorDTO;
    }
    public DoctorTelDTO(String tel) {
        this.tel = tel;
    }
    public DoctorTelDTO() {
    }

    @Override
    public String toString() {
        return "DoctorTelDTO{" +
                "tel='" + tel + '\'' +
                ", doctorDTO=" + doctorDTO +
                '}';
    }
}
