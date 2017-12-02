package com.hermestechnologies.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="suppliers")
public class Supplier {

    @Id
    @GeneratedValue
    private Integer id;
    private String supplier_name;
    private String supplier_address;
    private String contact_number;
    private String email;
    @OneToMany(mappedBy="supplier", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Po> poSet;
    @OneToMany(mappedBy="supplier", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<SupplierProduct> supplierProducts;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSupplier_name() {
        return supplier_name;
    }

    public void setSupplier_name(String supplier_name) {
        this.supplier_name = supplier_name;
    }

    public String getSupplier_address() {
        return supplier_address;
    }

    public void setSupplier_address(String supplier_address) {
        this.supplier_address = supplier_address;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Po> getPoSet() {
        return poSet;
    }

    public void setPoSet(Set<Po> poSet) {
        this.poSet = poSet;
    }

    public Set<SupplierProduct> getSupplierProducts() {
        return supplierProducts;
    }

    public void setSupplierProducts(Set<SupplierProduct> supplierProducts) {
        this.supplierProducts = supplierProducts;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", supplier_name='" + supplier_name + '\'' +
                ", supplier_address='" + supplier_address + '\'' +
                ", contact_number='" + contact_number + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
