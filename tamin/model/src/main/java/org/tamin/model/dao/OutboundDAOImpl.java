package org.tamin.model.dao;

import org.apache.log4j.Logger;
import org.tamin.model.utils.OutboundConnection;

import java.sql.*;
import java.util.List;
import java.util.Properties;

/**
 * Created by s.zakipour on 02/27/2016.
 */
public class OutboundDAOImpl implements OutboundDAO {

    private String maxSize;
    private Properties properties;
    private OutboundConnection outboundConnection;

    final Logger logger = Logger.getLogger("JobLogger");

    @Override
    public List listOutbound() {
        PreparedStatement stmt = null;
        Connection cnn = null;

        try {
            //String sql  ="SELECT t.*  FROM ibsfx01 t";
            String sql = "INSERT INTO user (id ,username,password,name,family) " +
                    "VALUES ( ? , ? , ? , ? , ?)";
            cnn = outboundConnection.getConnection();
            stmt = cnn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            stmt.setNull(1, Types.INTEGER);
            stmt.setString(2, "saeedzr");
            stmt.setString(3, "fatoldsun");
            stmt.setString(4, "saeed");
            stmt.setString(5, "zakipour");


            stmt.executeUpdate();
            cnn.close();

        } catch (SQLException e) {

            logger.fatal(e);
            if (cnn != null)
                try {
                    cnn.close();
                } catch (SQLException e1) {

                    e1.printStackTrace();
                    logger.fatal(e1);
                }
            e.printStackTrace();
        } finally {
            try {
                if (cnn != null)
                    cnn.close();
            } catch (SQLException se)
            {
                logger.fatal(se);
                se.printStackTrace();
            }

        }


        return null;
    }


    public void setMaxSize(String maxSize) {
        this.maxSize = maxSize;
    }

    public String getMaxSize() {
        return maxSize;
    }

    public void setOutboundConnection(OutboundConnection OutboundConnection) {
        outboundConnection = OutboundConnection;
    }

    public OutboundConnection getOutboundConnection() {
        return outboundConnection;
    }
}
