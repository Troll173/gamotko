package com.hermestechnologies.service.PurchaseOrder;

import com.hermestechnologies.domain.Po;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PoDaoImp implements PoDao{

    @Autowired
    private SessionFactory sessionFactory;

    public Po getPo(Integer id) {
        @SuppressWarnings("unchecked")
        Query<Po> query = sessionFactory.getCurrentSession().createQuery("from Po WHERE id = :id");
        query.setParameter("id", id);
        return query.getSingleResult();
    }

}
