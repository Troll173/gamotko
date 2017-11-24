package com.hermestechnologies.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product{

    @Id
    @GeneratedValue
    private Integer id;
    private String generic_name;
    private String dosage;
    private String preparation;
    private String packaging;
    private String brand_name;
    @OneToMany(mappedBy="product", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Stock> stocks;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGeneric_name() {
        return generic_name;
    }

    public void setGeneric_name(String generic_name) {
        this.generic_name = generic_name;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getPreparation() {
        return preparation;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }

    public String getPackaging() {
        return packaging;
    }

    public void setPackaging(String packaging) {
        this.packaging = packaging;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }


    public Set<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(Set<Stock> stocks) {
        this.stocks = stocks;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", generic_name='" + generic_name + '\'' +
                ", dosage='" + dosage + '\'' +
                ", preparation='" + preparation + '\'' +
                ", packaging='" + packaging + '\'' +
                ", brand_name='" + brand_name + '\'' +
                ", stocks=" + stocks +
                '}';
    }
}
