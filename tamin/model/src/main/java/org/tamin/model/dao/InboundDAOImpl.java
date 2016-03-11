package org.tamin.model.dao;

import org.apache.log4j.Logger;
import org.tamin.model.entity.Outbound;
import org.tamin.model.utils.InboundConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by s.zakipour on 02/27/2016.
 */
public class InboundDAOImpl implements InboundDAO
{

    final Logger logger = Logger.getLogger("JobLogger");


    private String maxSize;
    private Properties properties;
    private InboundConnection inboundConnection;

    @Override
    public List listInbound() {
        return null;
    }

    @Override
    public void insert(Object obj)
    {
        Connection cnn = null;
        List list = new ArrayList();
        PreparedStatement stmt = null;


        try {
            String sql = "INSERT INTO usertmp (id ,username,password,name,family) " +
                    "VALUES ( ? , ? , ? , ? , ?)";
            cnn = inboundConnection.getConnection();
            stmt = cnn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            stmt.setNull(1, Types.INTEGER);
            stmt.setString(2, "saeedzr");
            stmt.setString(3, "fatoldsun");
            stmt.setString(4, "saeed");
            stmt.setString(5, "zakipour");

            stmt.executeUpdate();

        }
        catch (Exception ex)
        {
            logger.error(ex);
        }

    }

    @Override
    public Object getObject(long id) {

        //PreparedStatement stmt = null;
        Connection cnn = null;
        List list = new ArrayList();

        try {

            String sql = "SELECT * FROM user where id = " + id;
            cnn = inboundConnection.getConnection();
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
    }


    public void setMaxSize(String maxSize) {
        this.maxSize = maxSize;
    }

    public String getMaxSize() {
        return maxSize;
    }




    public void setInboundConnection(InboundConnection inboundConnection) {
        _inboundConnection = inboundConnection;
    }

    public InboundConnection getInboundConnection() {
        return _inboundConnection;
    }
}
