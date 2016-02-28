package org.tamin.model.utils;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.Properties;



/**
 * Created by s.zakipour on 02/27/2016.
 */
public class OutboundConnection implements TaminConnection
{
    final Logger logger = Logger.getLogger("JobLogger");

    private static final String CONNECTION_DRIVER_CLASS = "gl.out.connection.jdbc.driver.class";
    private static final String CONNECTION_URL = "gl.out.connection.jdbc.url";
    private static final String CONNECTION_USERNAME = "gl.out.connection.jdbc.username";
    private static final String CONNECTION_PASSWORD = "gl.out.connection.jdbc.password";
    private static final String CONNECTION_PORT = "gl.out.connection.jdbc.port";

    private BasicDataSource dataSource;

    private Properties properties;

    public void initialize()
    {
     try {

            dataSource = new BasicDataSource();
            dataSource.setDriverClassName(properties.getProperty(CONNECTION_DRIVER_CLASS));
            dataSource.setUrl(properties.getProperty(CONNECTION_URL));
            dataSource.setPassword(properties.getProperty(CONNECTION_PASSWORD));
            dataSource.setUsername(properties.getProperty(CONNECTION_USERNAME));

        }
        catch (Exception ex)
        {
            System.out.println("+++++++++++++++++++");
            ex.printStackTrace();
            System.out.println("+++++++++++++++++++");
            logger.log(Level.INFO, ex.getMessage());
        }
    }


    public java.sql.Connection getConnection() throws SQLException
    {
        return dataSource.getConnection();
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Properties getProperties() {
        return properties;
    }



}
