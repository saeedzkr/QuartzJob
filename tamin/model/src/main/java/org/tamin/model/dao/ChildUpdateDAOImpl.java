package org.tamin.model.dao;

import org.tamin.model.entity.User;
import org.tamin.model.utils.DAOResult;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sector7 on 1/10/16.
 */
public class ChildUpdateDAOImpl implements ChildUpdateDAO {

    private static final long UPDATE_RECORD = 2;

    private static final EntityManagerFactory entityManagerFactory;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("MyConnection");
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }


    synchronized public List<DAOResult> updateChildRefList(long size) {
        List<DAOResult> resultList = new ArrayList<DAOResult>();

        try {

            //todo create Queue base on count that has been set
            //todo read form parameters file
            String query = "SELECT * FROM tbl_user" ;

            List<User> lstUsr = (List<User>) getEntityManagerFactory().createEntityManager().createNativeQuery(query, User.class)
                    .getResultList();


            for (int i=0; i<= lstUsr.size() ; i++)
            {
                User usr = lstUsr.get(i);
                usr.setUserid(Long.valueOf(2));
                getEntityManagerFactory().createEntityManager().merge(usr);
            }

            DAOResult result = new DAOResult(DAOResult.PERSIST_DONE, "");
            resultList.add(result);
        }
        catch (Exception ex)
        {
            DAOResult result = new DAOResult(DAOResult.PERSIST_FAILED, "");
            resultList.add(result);
        }

        return resultList;
    }
}
