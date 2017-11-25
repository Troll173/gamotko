package com.hermestechnologies.service.SupplierProducts;

import com.hermestechnologies.domain.SupplierProduct;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SupplierProductDaoImp implements SupplierProductDao{

    @Autowired
    private SessionFactory sessionFactory;

    public List<SupplierProduct> GetProductsSupplied(Integer supplier_id) {
        @SuppressWarnings("unchecked")
        Query<SupplierProduct> query = sessionFactory.getCurrentSession().createQuery("from SupplierProduct WHERE supplier.id = :supplier_id");
        query.setParameter("supplier_id", supplier_id);
        return query.getResultList();
    }

    public List<SupplierProduct> GetSuppliers(Integer product_id) {
        @SuppressWarnings("unchecked")
        Query<SupplierProduct> query = sessionFactory.getCurrentSession().createQuery("from SupplierProduct WHERE product.id = :product_id");
        query.setParameter("product_id", product_id);
        return query.getResultList();
    }
}
