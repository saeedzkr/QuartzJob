package org.tamin.model.dao;

import org.tamin.model.utils.OutboundConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

/**
 * Created by s.zakipour on 02/27/2016.
 */
public class OutboundDAOImpl implements OutboundDAO {

    private String maxSize;
    private Properties properties;
    private OutboundConnection outboundConnection;

    @Override
    public List listOutbound() {
        PreparedStatement stmt;
        Connection cnn;
        try {
            String sql  ="SELECT t.*  FROM ibsfx01 t";
            cnn = outboundConnection.getConnection();
            stmt = cnn.prepareStatement(sql);
            //ResultSet resultSet =
            stmt.executeQuery();

        } catch (SQLException e)
        {

            e.printStackTrace();
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
