package lk.eDoc.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class OrderDetail implements Serializable {
    @EmbeddedId
    private
    OrderDetail_PK orderDetail_pk;

    @ManyToOne
    @JoinColumn(name = "orderID",referencedColumnName = "orderID",insertable = false,updatable = false)
    private
    Order order;

    private int qty;

    private BigDecimal unitPrice;

    public OrderDetail_PK getOrderDetail_pk() {
        return orderDetail_pk;
    }

    public void setOrderDetail_pk(OrderDetail_PK orderDetail_pk) {
        this.orderDetail_pk = orderDetail_pk;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
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

    public OrderDetail(OrderDetail_PK orderDetail_pk, Order order, int qty, BigDecimal unitPrice) {
        this.orderDetail_pk = orderDetail_pk;
        this.order = order;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public OrderDetail(String orderId,String Drug, Order order, int qty, BigDecimal unitPrice) {
        this.orderDetail_pk = new OrderDetail_PK(orderId,Drug);
        this.order = order;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public OrderDetail() {
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "orderDetail_pk=" + orderDetail_pk +
                ", order=" + order +
                ", qty=" + qty +
                ", unitPrice=" + unitPrice +
                '}';
    }



}
