/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vektorel.kutuphane.semaruken.service;

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
public class KullaniciService {

    public Kullanici save(Kullanici entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(entity);
        t.commit();
        session.close();
        return entity;
    }

    public Kullanici update(Kullanici entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(entity);
        t.commit();
        session.close();
        return entity;
    }

    public boolean delete(Kullanici entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(entity);
        t.commit();
        session.close();
        return true;
    }

    public List<Kullanici> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Kullanici.class);
        return criteria.list();
    }

    public Kullanici getById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Kullanici.class);
        criteria.add(Restrictions.eq("id", id));
        return (Kullanici) criteria.uniqueResult();
    }

    public Kullanici getUserByUsernameAndPwd(String username, String pwd) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Kullanici.class);
        criteria.add(Restrictions.and(Restrictions.eq("username", username), Restrictions.eq("password", pwd)));
        return (Kullanici) criteria.uniqueResult();
    }
}
