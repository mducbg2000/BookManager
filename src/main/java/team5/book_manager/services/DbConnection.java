package team5.book_manager.services;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DbConnection {
    private static final Logger logger = LoggerFactory.getLogger(DbConnection.class);

    public static SessionFactory getSessionFactory() {
        logger.info("Create sessionFactory");
        SessionFactory sessionFactory = null;
        try {
             sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Exception e){
            logger.error(String.valueOf(e));
        }
        return sessionFactory;
    }
}
