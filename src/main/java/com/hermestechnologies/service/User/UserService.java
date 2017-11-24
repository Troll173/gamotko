package com.hermestechnologies.service.User;

import com.hermestechnologies.domain.User;
import com.hermestechnologies.service.HermesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService extends HermesService{

    @Autowired
    private UserDaoImp userDao;

    @Transactional
    public void save(User user) {
        userDao.save(user);
    }

    @Transactional(readOnly = true)
    public List<User> list() {
        return userDao.list();
    }

    @Transactional(readOnly = true)
    public User login(User user) {
        return userDao.login(user);
    }
}
