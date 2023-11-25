/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author WeldedScrap
 */
@Entity
@Table(name = "orders")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o")
    , @NamedQuery(name = "Orders.findByOrderId", query = "SELECT o FROM Orders o WHERE o.orderId = :orderId")
    , @NamedQuery(name = "Orders.findByCompleted", query = "SELECT o FROM Orders o WHERE o.completed = :completed")
    , @NamedQuery(name = "Orders.findByOrderDate", query = "SELECT o FROM Orders o WHERE o.orderDate = :orderDate")
    , @NamedQuery(name = "Orders.findByPaymentId", query = "SELECT o FROM Orders o WHERE o.paymentId = :paymentId")})
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "orderId")
    private Integer orderId;
    @Basic(optional = false)
    @Column(name = "completed")
    private int completed;
    @Basic(optional = false)
    @Column(name = "orderDate")
    @Temporal(TemporalType.DATE)
    private Date orderDate;
    @Basic(optional = false)
    @Column(name = "paymentId")
    private String paymentId;
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Users userId;

    public Orders() {
    }

    public Orders(Integer orderId) {
        this.orderId = orderId;
    }

    public Orders(Integer orderId, int completed, Date orderDate, String paymentId) {
        this.orderId = orderId;
        this.completed = completed;
        this.orderDate = orderDate;
        this.paymentId = paymentId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public int getCompleted() {
        return completed;
    }

    public void setCompleted(int completed) {
        this.completed = completed;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderId != null ? orderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orders)) {
            return false;
        }
        Orders other = (Orders) object;
        if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Orders[ orderId=" + orderId + " ]";
    }
    
}
