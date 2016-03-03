package org.tamin.model.utils;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.Properties;


/**
 * Created by s.zakipour on 02/27/2016.
 */
public class OutboundConnection implements TaminConnection {
    final Logger logger = Logger.getLogger("JobLogger");


    private Properties properties;
    private BasicDataSource dataSource;

    public void initialize() {
        try {
            logger.log(Level.INFO, " datasource initialize");

        } catch (Exception ex) {
            ex.printStackTrace();
            logger.log(Level.INFO, ex.getMessage());
        }
    }

    @Override
    public void destroy() {
        try {
            dataSource.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public java.sql.Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Properties getProperties() {
        return properties;
    }


    public void setDataSource(BasicDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public BasicDataSource getDataSource() {
        return dataSource;
    }
}
