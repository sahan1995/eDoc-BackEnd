package lk.eDoc.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class OrderDetail_PK  implements Serializable {

    private String orderID;
    private String drug;


    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getDrug() {
        return drug;
    }

    public void setDrug(String drug) {
        this.drug = drug;
    }

    public OrderDetail_PK(String orderID, String drug) {
        this.orderID = orderID;
        this.drug = drug;
    }

    public OrderDetail_PK() {
    }

    @Override
    public String toString() {
        return "OrderDetail_PK{" +
                "orderID='" + orderID + '\'' +
                ", drug='" + drug + '\'' +
                '}';
    }
}
