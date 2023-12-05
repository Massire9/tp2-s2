package fr.sdv.dao;

import fr.sdv.HibernateUtil;
import fr.sdv.entity.MicroMarket;
import org.hibernate.*;
import org.hibernate.query.*;

import java.util.Collections;
import java.util.List;

public class MicroMarketDAO implements ActionDAO<MicroMarket> {

    @Override
    public boolean create(MicroMarket o) {
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
    public MicroMarket update(MicroMarket o) {
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
    public boolean delete(MicroMarket o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            MicroMarket cu = session.get(MicroMarket.class, o.getZipCode());
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
            MicroMarket cu = session.get(MicroMarket.class, id);
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
    public List<MicroMarket> retrieveAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<MicroMarket> microMarkets = Collections.emptyList();
        try {
            transaction = session.beginTransaction();
            Query<MicroMarket> query = session.createQuery("from MicroMarket", MicroMarket.class);
            microMarkets = query.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return microMarkets;
    }

    @Override
    public MicroMarket retrieveById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        MicroMarket microMarket = null;
        try {
            transaction = session.beginTransaction();
            microMarket = session.get(MicroMarket.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return microMarket;
    }
}
