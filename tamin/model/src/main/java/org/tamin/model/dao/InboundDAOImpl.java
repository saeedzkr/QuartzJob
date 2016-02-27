package org.tamin.model.dao;

import org.tamin.model.utils.InboundConnection;

import java.util.List;
import java.util.Properties;

/**
 * Created by s.zakipour on 02/27/2016.
 */
public class InboundDAOImpl implements InboundDAO
{


    private String maxSize;
    private Properties properties;
    private InboundConnection inboundConnection;

    @Override
    public List listInbound() {
        return null;
    }

    public void setMaxSize(String maxSize) {
        this.maxSize = maxSize;
    }

    public String getMaxSize() {
        return maxSize;
    }




    public void setInboundConnection(InboundConnection InboundConnection) {
        inboundConnection = InboundConnection;
    }

    public InboundConnection getInboundConnection() {
        return inboundConnection;
    }
}
