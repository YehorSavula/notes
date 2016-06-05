package ua.com.kture.repository;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseDAO {

    @Autowired
    private SessionFactory sessionFactory;

    protected BaseDAO() {
    }

    public Session getSession() {
        try {
            return sessionFactory.getCurrentSession();
        } catch(HibernateException e) {
            return sessionFactory.openSession();
        }
    }

    protected void begin() {
        getSession().getTransaction().begin();
    }

    protected void commit() {
        Transaction tx = getSession().getTransaction();
        if(tx.isActive()) {
            tx.commit();
        }
    }

    protected void rollback() throws Exception {
        try {
            getSession().getTransaction().rollback();
            getSession().close();
        } catch (HibernateException e) {
            throw new Exception("Repository fail", e);
        }
    }

    public void close() {
        getSession().close();
    }


}
