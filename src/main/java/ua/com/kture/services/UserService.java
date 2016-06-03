package ua.com.kture.services;

import ua.com.kture.model.User;

public interface UserService {

    User getUser(String username) throws Exception;

    User addUser(String username, String password) throws Exception;
}
