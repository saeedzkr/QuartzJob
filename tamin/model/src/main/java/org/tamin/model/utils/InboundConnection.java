package org.tamin.model.utils;

import java.util.Properties;

/**
 * Created by s.zakipour on 02/27/2016.
 */
public class InboundConnection implements TaminConnection
{

    private Properties properties;

    @Override
    public void initialize() {

    }

    @Override
    public void destroy() {

    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Properties getProperties() {
        return properties;
    }
}
