package lk.eDoc.dto;

import java.sql.Date;

public class OrderDTO {



    private String orderID;


    private
    Date date;



    private
    Date placeDate;


    private boolean placed;



    private
    MedicalReportDTO medicalReportDTO;

    private PharmacyDTO pharmacyDTO;


    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getPlaceDate() {
        return placeDate;
    }

    public void setPlaceDate(Date placeDate) {
        this.placeDate = placeDate;
    }

    public boolean isPlaced() {
        return placed;
    }

    public void setPlaced(boolean placed) {
        this.placed = placed;
    }

    public MedicalReportDTO getMedicalReportDTO() {
        return medicalReportDTO;
    }

    public void setMedicalReportDTO(MedicalReportDTO medicalReportDTO) {
        this.medicalReportDTO = medicalReportDTO;
    }

    public PharmacyDTO getPharmacyDTO() {
        return pharmacyDTO;
    }

    public void setPharmacyDTO(PharmacyDTO pharmacyDTO) {
        this.pharmacyDTO = pharmacyDTO;
    }

    public OrderDTO(String orderID, Date date, Date placeDate, boolean placed) {
        this.orderID = orderID;
        this.date = date;
        this.placeDate = placeDate;
        this.placed = placed;
    }

    public OrderDTO() {
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "orderID='" + orderID + '\'' +
                ", date=" + date +
                ", placeDate=" + placeDate +
                ", placed=" + placed +
                '}';
    }



}
