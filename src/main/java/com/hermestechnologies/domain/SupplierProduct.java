package com.hermestechnologies.domain;

import javax.persistence.*;

@Entity
@Table(name="supplied_products")
public class SupplierProduct {

    @Id
    private Integer id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="product_id",referencedColumnName="id")
    private Product product;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="supplier_id",referencedColumnName="id")
    private Supplier supplier;
    private Double last_price;


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

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Double getLast_price() {
        return last_price;
    }

    public void setLast_price(Double last_price) {
        this.last_price = last_price;
    }

    @Override
    public String toString() {
        return "SupplierProduct{" +
                "id=" + id +
                ", product=" + product +
                ", supplier=" + supplier +
                ", last_price=" + last_price +
                '}';
    }
}
