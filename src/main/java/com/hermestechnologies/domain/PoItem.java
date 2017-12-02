package com.hermestechnologies.domain;

import javax.persistence.*;

@Entity
@Table(name = "po_items")
public class PoItem {

    @Id
    @GeneratedValue
    private Integer id;
    private Integer qty;
    @ManyToOne
    @JoinColumn(name="po_id")
    private Po po;
    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Po getPo() {
        return po;
    }

    public void setPo(Po po) {
        this.po = po;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "PoItem{" +
                "id=" + id +
                ", qty=" + qty +
                ", po=" + po +
                ", product=" + product +
                '}';
    }
}
