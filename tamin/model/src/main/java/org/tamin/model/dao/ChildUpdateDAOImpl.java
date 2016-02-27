package org.tamin.model.dao;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.tamin.model.utils.DAOResult;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by sector7 on 1/10/16.
 */
public class ChildUpdateDAOImpl implements ChildUpdateDAO {

    final Logger logger = Logger.getLogger("JobLogger");

    private static final long UPDATE_RECORD = 2;


    private String maxSize;

    private ConnectionManager connectionManager;

    public void setConnectionManager(ConnectionManager ConnectionManager) {
        connectionManager = ConnectionManager;
    }

    public ConnectionManager getConnectionManager() {
        return connectionManager;
    }


    synchronized public List<DAOResult> updateChildRefList(long size) {
        List<DAOResult> resultList = new ArrayList<DAOResult>();

        try {


            System.out.println("++++++++++++++++++++++++++++++++++++ 001");

            //todo create Queue base on count that has been set
            //todo read form parameters file

            /*query for oracle*/
            //String query = "SELECT t.*  FROM tbl_user t where t.status = 1 And ROWNUM <= 100;" ;

            /*query for mysql*/
            String query = String.format("SELECT t.*  FROM ibsfx01 t ", getMaxSize());

             EntityManager en =  ConnectionManager.getInstance(ConnectionManager.ORACLE_CONENECTION)
                    .getEntityManagerFactory().createEntityManager();

            List lst = en.createNativeQuery(query)
                    .getResultList();
            en.close();

            logger.log(Level.INFO, "count of data is  : " + lst.size());

            DAOResult result = new DAOResult(DAOResult.PERSIST_DONE, "");
            resultList.add(result);
        } catch (Exception ex)
        {
            logger.log(Level.ERROR , ex.getMessage());
            DAOResult result = new DAOResult(DAOResult.PERSIST_FAILED, "");
            resultList.add(result);
        }

        return resultList;
    }

    public void setMaxSize(String maxSize) {
        this.maxSize = maxSize;
    }

    public String getMaxSize() {
        return maxSize;
    }



}
