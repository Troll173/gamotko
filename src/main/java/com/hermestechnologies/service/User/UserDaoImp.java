package com.hermestechnologies.service.User;

import com.hermestechnologies.domain.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    public List<User> list() {
        @SuppressWarnings("unchecked")
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    public User login(User user){
        @SuppressWarnings("unchecked")
        Query<User> query = sessionFactory.getCurrentSession().createQuery("from User WHERE username =:username AND password =:password " );
        query.setParameter("username", user.getUsername());
        query.setParameter("password", user.getPassword());
        User res;
        try{
           res =  query.getSingleResult();
        }catch (Exception e){
            res = null;
        }
        return res;
    }
}
