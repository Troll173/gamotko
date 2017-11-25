package com.hermestechnologies.service.Supplier;

import com.hermestechnologies.domain.Supplier;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SupplierDaoImp implements SupplierDao{

    @Autowired
    private SessionFactory sessionFactory;

    public Supplier getSupplier(Integer id) {
        @SuppressWarnings("unchecked")
        Query<Supplier> query = sessionFactory.getCurrentSession().createQuery("from Supplier WHERE id = :id");
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    public List<Supplier> getSupplierList() {
        @SuppressWarnings("unchecked")
        Query<Supplier> query = sessionFactory.getCurrentSession().createQuery("from Supplier");
        return query.getResultList();
    }

    public Supplier saveSupplier(Supplier supplier) {
        sessionFactory.getCurrentSession().save(supplier);
        return supplier;
    }
}
