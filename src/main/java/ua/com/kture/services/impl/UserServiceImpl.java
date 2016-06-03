package ua.com.kture.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.kture.model.User;
import ua.com.kture.repository.UserDAO;
import ua.com.kture.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public User getUser(String username) throws Exception {
        return userDAO.getUser(username);
    }

    @Override
    public User addUser(String username, String password) throws Exception {
        return userDAO.createUser(username, password);
    }
}
