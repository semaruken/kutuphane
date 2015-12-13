/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vektorel.kutuphane.semaruken.service;

import com.vektorel.kutuphane.semaruken.entity.Kitap;
import com.vektorel.kutuphane.semaruken.entity.Kullanici;
import com.vektorel.kutuphane.semaruken.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author vektorel
 */
public class KitapService {

    public Kitap save(Kitap entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(entity);
        t.commit();
        session.close();
        return entity;
    }

    public Kitap update(Kitap entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(entity);
        t.commit();
        session.close();
        return entity;
    }

    public boolean delete(Kitap entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(entity);
        t.commit();
        session.close();
        return true;
    }

    public List<Kitap> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Kullanici.class);
        return criteria.list();
    }

    public Kitap getById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Kitap.class);
        criteria.add(Restrictions.eq("id", id));
        return (Kitap) criteria.uniqueResult();
    }

    public Kitap getByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Kitap.class);
        criteria.add(Restrictions.eq("kitapAdi", name));
        return (Kitap) criteria.uniqueResult();
    }
}
