package ua.com.kture.repository;

import ua.com.kture.model.User;

public interface UserDAO {

    User createUser(String username, String password) throws Exception;
    User getUser(String username) throws Exception;
}
