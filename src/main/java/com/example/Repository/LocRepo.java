package com.example.Repository;

import com.example.Entity.XeDap;
import com.example.Util.HIbernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class LocRepo {
    public List<XeDap> getHang(){

        List<XeDap> listXeDap = new ArrayList<XeDap>();
        try (Session session = HIbernateUtil.getFactory().openSession()) {

            Query query = session.createQuery("from XeDap x where hang = 'thong nhat'", XeDap.class);
            listXeDap = query.getResultList();

            return listXeDap;
        }
    }
}
