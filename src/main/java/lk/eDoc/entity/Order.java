package lk.eDoc.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "`Order`")
public class Order {

    @Id
    private String orderID;

    @Temporal(TemporalType.DATE)
    private
    Date date;


    @Temporal(TemporalType.DATE)
    private
    Date placeDate;


    private boolean placed;



    @ManyToOne
    @JoinColumn(name = "phyCode",referencedColumnName = "phyCode")
    private
    Pharmacy pharmacy;


    @OneToMany(mappedBy = "order",fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private
    List<OrderDetail> orderDetails = new ArrayList<>();


    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    @OneToOne
    @JoinColumn(name = "prescriptionID",referencedColumnName = "prescriptionID")
    private Prescription prescription;

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

    public Order(String orderID, Date date, Date placeDate, boolean placed) {
        this.orderID = orderID;
        this.date = date;
        this.placeDate = placeDate;
        this.placed = placed;
    }

    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID='" + orderID + '\'' +
                ", date=" + date +
                ", placeDate=" + placeDate +
                ", placed=" + placed +
                '}';
    }


    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
