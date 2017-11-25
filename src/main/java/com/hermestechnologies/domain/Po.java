package com.hermestechnologies.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="pos")
public class Po {

    @Id
    @GeneratedValue
    private Integer id;
    private String po_number;
    @ManyToOne
    @JoinColumn(name="supplier_id")
    private Supplier supplier;
    private Date date_created;
    @OneToMany(mappedBy="po", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Stock> stocks;
    @OneToMany(mappedBy="po", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<PoItem> poItems;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPo_number() {
        return po_number;
    }

    public void setPo_number(String po_number) {
        this.po_number = po_number;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }


    public Set<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(Set<Stock> stocks) {
        this.stocks = stocks;
    }

    public Set<PoItem> getPoItems() {
        return poItems;
    }

    public void setPoItems(Set<PoItem> poItems) {
        this.poItems = poItems;
    }

    @Override
    public String toString() {
        return "Po{" +
                "id=" + id +
                ", po_number='" + po_number + '\'' +
                ", supplier=" + supplier +
                ", date_created=" + date_created +
                '}';
    }
}
