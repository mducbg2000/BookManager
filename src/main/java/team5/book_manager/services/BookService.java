package team5.book_manager.services;

import org.hibernate.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import team5.book_manager.entities.BookEntity;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookService {
    private static final Logger logger = LoggerFactory.getLogger(BookService.class);
    private static SessionFactory sessionFactory= DbConnection.getSessionFactory();

    public int insertBook (BookEntity bookEntity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        int result = -1;

        try {
            transaction = session.beginTransaction();
            session.save(bookEntity);
            transaction.commit();
            result = 1;
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            logger.error(String.valueOf(e));
        }
        return result;
    }

    public List getAllBook(){
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        List result = new ArrayList<>();

        try {
            transaction = session.beginTransaction();
            String hql = "FROM BookEntity b ";
            Query query = session.createQuery(hql, BookEntity.class);
            result = query.getResultList();
            transaction.commit();
        } catch (HibernateException e){
            if (transaction != null) transaction.rollback();
            logger.error(String.valueOf(e));
        }

        return result;
    }

    public BookEntity getBookById(int id){
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        List result = new ArrayList<>();

        try {
            transaction = session.beginTransaction();
            String hql = "FROM BookEntity b WHERE b.id = :id";
            Query query = session.createQuery(hql, BookEntity.class);
            query.setParameter("id", id);
            result = query.getResultList();
            transaction.commit();
        } catch (HibernateException e){
            if (transaction != null) transaction.rollback();
            logger.error(String.valueOf(e));
        }
        if (result.isEmpty()) return null;
        return (BookEntity) result.get(0);
    }

    public List getListBookByName (String name) {

        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        List result = new ArrayList<>();

        try {
            transaction = session.beginTransaction();
            String hql = "FROM BookEntity b WHERE b.name LIKE '%" + name + "%'";
            Query query = session.createQuery(hql, BookEntity.class);
            result = query.getResultList();
            transaction.commit();
        } catch (HibernateException e){
            if (transaction != null) transaction.rollback();
            logger.error(String.valueOf(e));
        }

        return result;
    }

    public int updateBook (int id, BookEntity bookEntity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        int result = 0;

        try {
            transaction = session.beginTransaction();
            String hql = "UPDATE BookEntity b SET name = :name, publisher = :publisher, price = :price WHERE id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("name", bookEntity.getName());
            query.setParameter("publisher", bookEntity.getPublisher());
            query.setParameter("price", bookEntity.getPrice());
            query.setParameter("id", id);
            result = query.executeUpdate();
            transaction.commit();
        } catch (HibernateException e){
            if (transaction != null) transaction.rollback();
            logger.error(String.valueOf(e));
        }
        return result;
    }

    public int deleteBook(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        int result = -1;

        try {
            transaction = session.beginTransaction();
            String hql = "DELETE BookEntity WHERE id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            result = query.executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            logger.error(String.valueOf(e));
        }
        return result;
    }

}
