/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vektorel.kutuphane.semaruken.service;

import com.vektorel.kutuphane.semaruken.entity.Kisi;
import com.vektorel.kutuphane.semaruken.entity.KisiOdunc;
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
public class KisiOduncService {

    public KisiOdunc save(KisiOdunc entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(entity);
        t.commit();
        session.close();
        return entity;
    }

    public KisiOdunc update(KisiOdunc entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(entity);
        t.commit();
        session.close();
        return entity;
    }

    public boolean delete(KisiOdunc entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(entity);
        t.commit();
        session.close();
        return true;
    }

    public List<KisiOdunc> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(KisiOdunc.class);
        return criteria.list();
    }

    public KisiOdunc getById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(KisiOdunc.class);
        criteria.add(Restrictions.eq("id", id));
        return (KisiOdunc) criteria.uniqueResult();
    }
}
