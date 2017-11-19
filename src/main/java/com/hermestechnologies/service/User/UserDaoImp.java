package com.hermestechnologies.service.User;

import com.hermestechnologies.domain.User;
import org.hibernate.SessionFactory;
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
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User WHERE username = " + user.getUsername() + " AND password = "+ user.getPassword() );
        return query.getSingleResult();
    }
}
