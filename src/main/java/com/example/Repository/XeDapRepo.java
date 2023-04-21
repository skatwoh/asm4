package com.example.Repository;

import com.example.Entity.XeDap;
import com.example.Util.HIbernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class XeDapRepo {

    public List<XeDap> getALl(){

        List<XeDap> listXeDap = new ArrayList<XeDap>();
        try (Session session = HIbernateUtil.getFactory().openSession()) {

            Query query = session.createQuery("from XeDap x", XeDap.class);
            listXeDap = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listXeDap;
    }

    public String add(XeDap xeDap){
            SessionFactory factory = HIbernateUtil.getFactory();
            Session session = factory.openSession();
            Transaction transaction = session.beginTransaction();
            session.save(xeDap);
            transaction.commit();
            session.close();
            return null;
    }

    public String update(XeDap xeDap){
        SessionFactory factory = HIbernateUtil.getFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(xeDap);
        transaction.commit();
        session.close();
        return null;
    }

    public XeDap getById(Long id){
        XeDap xeDap = new XeDap();
        SessionFactory factory = HIbernateUtil.getFactory();
        Session session = factory.openSession();
        xeDap = session.get(XeDap.class, id);
        session.close();
        return xeDap;
    }

    public void delete(Long id){
        SessionFactory factory = HIbernateUtil.getFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        XeDap xeDap = session.get(XeDap.class, id);
        if (xeDap != null) {
            session.delete(xeDap);
            transaction.commit();
        } else {
            transaction.rollback();
        }
    }

    public List<XeDap> getThongNhat(){
        List<XeDap> listLoc = new ArrayList<XeDap>();
        try (Session session = HIbernateUtil.getFactory().openSession()) {

            Query query = session.createQuery("from XeDap x where hang ='thong nhat'", XeDap.class);
            listLoc = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listLoc;
    }
}
