package com.hermestechnologies.service.User;

import com.hermestechnologies.domain.User;

import java.util.List;

public interface UserDao {
    void save(User user);
    List<User> list();
    User login(User user);
}

