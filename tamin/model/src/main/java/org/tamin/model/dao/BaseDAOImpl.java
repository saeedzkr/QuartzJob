package org.tamin.model.dao;

/**
 * Created by s.zakipour on 12/27/2015.
 */

import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public class BaseDAOImpl<T> {



////    @PersistenceContext(unitName = "Myconnection")
////    protected EntityManager em;
//
//
//
//
//
//    public T update(T entity) {
//        try {
//            return em.merge(entity);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            return null;
//        }
//    }
//
//    public void delete(T entity) {
//        try {
//            em.remove(em.merge(entity));
//        } catch (Exception e) {
//            System.out.println("Deleted Entity Error is ===========" +e.getMessage());
//        }
//    }
//
//    public T create(T entity) {
//        try {
//            em.persist(entity);
//            return entity;
//        } catch (Exception e) {
//            System.out.println("Created Entity Error is ==========" + e.getMessage());
//            return null;
//        }
//    }

}
