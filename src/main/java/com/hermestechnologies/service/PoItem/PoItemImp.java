package com.hermestechnologies.service.PoItem;

import com.hermestechnologies.domain.PoItem;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PoItemImp implements PoItemDao{


    @Autowired
    private SessionFactory sessionFactory;

    public void save(PoItem poItem) {
        sessionFactory.getCurrentSession().save(poItem);
    }

    public List getQueued() {
        try {
            @SuppressWarnings("unchecked")
            Query query = sessionFactory.getCurrentSession().createQuery("from PoItem WHERE po_id = null");
            return query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
