package org.tamin.model.dao;

import org.apache.log4j.Logger;
import org.tamin.model.entity.Model;
import org.tamin.model.entity.Outbound;
import org.tamin.model.utils.OutboundConnection;

import java.sql.*;
import java.util.ArrayList;
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
    public List listOutbound()
    {
        //PreparedStatement stmt = null;
        Connection cnn = null;
        List list = new ArrayList();

        try {


//            String sql = "INSERT INTO user (id ,username,password,name,family) " +
//                    "VALUES ( ? , ? , ? , ? , ?)";
//            cnn = outboundConnection.getConnection();
//            stmt = cnn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
//
//            stmt.setNull(1, Types.INTEGER);
//            stmt.setString(2, "saeedzr");
//            stmt.setString(3, "fatoldsun");
//            stmt.setString(4, "saeed");
//            stmt.setString(5, "zakipour");
//
//
//            stmt.executeUpdate();

            String sql = "SELECT * FROM user";
            cnn = outboundConnection.getConnection();
            Statement stmt = cnn.createStatement();
            ResultSet result =  stmt.executeQuery(sql);

            while (result.next())
            {
                Outbound outbound = new Outbound();
                outbound.setId(result.getLong("id"));
                outbound.setUsername(result.getString("username"));
                outbound.setPassword(result.getString("password"));
                outbound.setName(result.getString("name"));
                outbound.setFamily(result.getString("family"));
                list.add(outbound);

            }


            cnn.close();

        } catch (SQLException e) {

            logger.error(e);
            if (cnn != null)
                try {
                    cnn.close();
                } catch (SQLException e1) {

                    e1.printStackTrace();
                    logger.error(e1);
                }
            e.printStackTrace();
        } finally {
            try {
                if (cnn != null)
                    cnn.close();
            } catch (SQLException se)
            {
                logger.error(se);
                se.printStackTrace();
            }

        }


        return  list;
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
