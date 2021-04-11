package team5.book_manager.services;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import team5.book_manager.entities.UserEntity;

import javax.persistence.Query;

public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private static SessionFactory sessionFactory= DbConnection.getSessionFactory();

    public boolean login(UserEntity userEntity){
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        boolean result = false;
        try {
            transaction = session.beginTransaction();
            String hql = "FROM UserEntity WHERE username = :username AND password = :pwd";
            Query query = session.createQuery(hql, UserEntity.class);
            query.setParameter("username", userEntity.getUsername());
            query.setParameter("pwd", userEntity.getPassword());
            result = !query.getResultList().isEmpty();
            transaction.commit();
        } catch (HibernateException e){
            if (transaction != null) transaction.rollback();
            logger.error(String.valueOf(e));
        }
        return result;
    }

    public int register(UserEntity userEntity){
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        int result = 0;
        if (login(userEntity)) result = 2;
        else try {
            transaction = session.beginTransaction();
            session.save(userEntity);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            logger.error(String.valueOf(e));
        }
        return result;
    }
}
