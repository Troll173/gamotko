package com.hermestechnologies.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "stocks")
public class Stock {

    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;
    private Integer qty;
    private String lot_number;
    private String batch_number;
    @ManyToOne
    @JoinColumn(name="po_id")
    private Po po;
    private Date expiration_date;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public String getLot_number() {
        return lot_number;
    }

    public void setLot_number(String lot_number) {
        this.lot_number = lot_number;
    }

    public String getBatch_number() {
        return batch_number;
    }

    public void setBatch_number(String batch_number) {
        this.batch_number = batch_number;
    }

    public Po getPo() {
        return po;
    }

    public void setPo(Po po) {
        this.po = po;
    }

    public Date getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(Date expiration_date) {
        this.expiration_date = expiration_date;
    }


    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", po=" + po +
                ", qty=" + qty +
                ", lot_number='" + lot_number + '\'' +
                ", batch_number='" + batch_number + '\'' +
                ", expiration_date=" + expiration_date +
                '}';
    }
}
