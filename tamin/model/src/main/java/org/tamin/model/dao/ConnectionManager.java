package org.tamin.model.dao;

import org.apache.log4j.Logger;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Map;

/**
 * Created by s.zakipour on 02/27/2016.
 */
public class ConnectionManager
{

    final Logger logger = Logger.getLogger("JobLogger");

    public static final String ORACLE_CONENECTION = "ORACLE";
    public static final String MYSQL_CONNECTION = "MYSQL";

    private EntityManagerFactory entityManagerFactory;

    private static ConnectionManager ConnectionInstance;
    private Map dbconfig;


    private ConnectionManager()
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("MyConnection");
    }

    public static ConnectionManager getInstance(String DB_TYPE)
    {
        if (ConnectionInstance == null) {
            ConnectionInstance = new ConnectionManager();
            return ConnectionInstance;
        }
        else
        {

            return ConnectionInstance;
        }
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public void setDbconfig(Map dbconfig) {
        this.dbconfig = dbconfig;
    }

    public Map getDbconfig() {
        return dbconfig;
    }
}
