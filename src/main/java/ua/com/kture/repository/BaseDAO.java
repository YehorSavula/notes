package ua.com.kture.repository;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseDAO {

    @Autowired
    private SessionFactory sessionFactory;

    protected BaseDAO() {
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    protected void begin() {
        getSession().beginTransaction();
    }

    protected void commit() {
        getSession().getTransaction().commit();
    }

    protected void rollback() throws Exception {
        try {
            getSession().getTransaction().rollback();
            getSession().close();
        } catch (HibernateException e) {
            throw new Exception("Repository fail");
        }
    }

    public void close() {
        getSession().close();
    }


}
