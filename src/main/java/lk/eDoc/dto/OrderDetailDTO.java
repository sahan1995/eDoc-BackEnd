package lk.eDoc.dto;

import java.math.BigDecimal;

public class OrderDetailDTO {

    private String orderID;
    private String drug;
    private int qty;
    private BigDecimal unitPrice;

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

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public OrderDetailDTO(String orderID, String drug, int qty, BigDecimal unitPrice) {
        this.orderID = orderID;
        this.drug = drug;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public OrderDetailDTO() {
    }

    @Override
    public String toString() {
        return "OrderDetailDTO{" +
                "orderID='" + orderID + '\'' +
                ", drug='" + drug + '\'' +
                ", qty=" + qty +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
