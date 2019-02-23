package lk.eDoc.dto;

import lk.eDoc.entity.Appointment;
import lk.eDoc.entity.Drug;
import lk.eDoc.entity.Order;

import java.util.List;

public class PrescriptionDTO {

    private String prescriptionID;


    private String date;


    private
    AppointmentDTO appointmentDTO;


    private List<DrugDTO> drugs;


    private OrderDTO OrderDTO;

    public PrescriptionDTO(String prescriptionID, String date) {
        this.prescriptionID = prescriptionID;
        this.date = date;
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

    public AppointmentDTO getAppointmentDTO() {
        return appointmentDTO;
    }

    public void setAppointmentDTO(AppointmentDTO appointmentDTO) {
        this.appointmentDTO = appointmentDTO;
    }

    public List<DrugDTO> getDrugs() {
        return drugs;
    }

    public void setDrugs(List<DrugDTO> drugs) {
        this.drugs = drugs;
    }

    public lk.eDoc.dto.OrderDTO getOrderDTO() {
        return OrderDTO;
    }

    public void setOrderDTO(lk.eDoc.dto.OrderDTO orderDTO) {
        OrderDTO = orderDTO;
    }

    public PrescriptionDTO() {
    }

    @Override
    public String toString() {
        return "PrescriptionDTO{" +
                "prescriptionID='" + prescriptionID + '\'' +
                ", date='" + date + '\'' +
                ", appointmentDTO=" + appointmentDTO +
                ", drugs=" + drugs +
                ", OrderDTO=" + OrderDTO +
                '}';
    }
}
