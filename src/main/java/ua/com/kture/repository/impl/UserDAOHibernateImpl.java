package ua.com.kture.repository.impl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import ua.com.kture.model.User;
import ua.com.kture.repository.BaseDAO;
import ua.com.kture.repository.UserDAO;

public class UserDAOHibernateImpl extends BaseDAO implements UserDAO {

    @Override
    public User createUser(String username, String password) throws Exception {
        try {
            begin();
            User user = new User(username, password);
            getSession().save(user);
            commit();
            return user;
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not create user " + username, e);
        }
    }

    @Override
    public User getUser(String username) throws Exception {
        try {
            begin();
            Query q = getSession().createQuery("from User where username = :username");
            q.setString("username", username);
            User user = (User) q.uniqueResult();
            commit();
            return user;
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not get user " + username, e);
        }
    }
}
