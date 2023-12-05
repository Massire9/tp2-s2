package fr.sdv.dao;

import fr.sdv.HibernateUtil;
import fr.sdv.entity.Discount;
import org.hibernate.*;
import org.hibernate.query.*;

import java.util.Collections;
import java.util.List;

public class DiscountDAO implements ActionDAO<Discount> {

    @Override
    public boolean create(Discount o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.persist(o);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
        return true;
    }

    @Override
    public Discount update(Discount o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.merge(o);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return o;
    }

    @Override
    public boolean delete(Discount o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Discount cu = session.get(Discount.class, o.getId());
            if(cu != null) {
                session.remove(cu);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return true;
    }

    @Override
    public boolean deleteById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Discount cu = session.get(Discount.class, (char)id);
            if(cu != null) {
                session.remove(cu);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return true;
    }

    @Override
    public List<Discount> retrieveAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<Discount> discounts = Collections.emptyList();
        try {
            transaction = session.beginTransaction();
            Query<Discount> query = session.createQuery("from Discount", Discount.class);
            discounts = query.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return discounts;
    }

    @Override
    public Discount retrieveById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        Discount discount = null;
        try {
            transaction = session.beginTransaction();
            discount = session.get(Discount.class, (char)id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return discount;
    }
}
