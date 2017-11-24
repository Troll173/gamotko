package com.hermestechnologies.service.Product;

import com.hermestechnologies.domain.Product;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

@Repository
public class ProductDaoImp implements ProductDao{

    @Autowired
    private SessionFactory sessionFactory;

    public List<Product> getProductList() {
        @SuppressWarnings("unchecked")
        TypedQuery<Product> query = sessionFactory.getCurrentSession().createQuery("from Product");
        return query.getResultList();
    }

    public Product getProduct(Integer id) {
        @SuppressWarnings("unchecked")
        Query<Product> query = sessionFactory.getCurrentSession().createQuery("from Product WHERE id = :id");
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    public Product save(Product product) {
        Object res = sessionFactory.getCurrentSession().save(product);
        System.out.println(res);
        return product;
    }
}
