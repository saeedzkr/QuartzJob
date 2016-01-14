package org.tamin.config;

import javax.servlet.ServletContext;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

/**
 * Created by s.zakipour on 01/13/2016.
 */
public class TaminConfiguration {

    private TaminConfiguration () {
    }

    private static TaminConfiguration  _Configuration;

    public static TaminConfiguration  getConfiguration() {
        if (_Configuration == null) {
            _Configuration = new TaminConfiguration ();
            return _Configuration;
        } else {
            return _Configuration;
        }
    }


    public long getQueueSize() {

        Properties prop  = readfile();
        if(prop!= null)
        {
            return Long.parseLong(prop.getProperty("queueSize"));
        }
        else
        {
            return  0;
        }

    }

    public void setQueueSize(long queueSize) {

        Properties prop = new Properties();
        if (prop != null) {
            try {

                FileOutputStream outfile = new FileOutputStream("config.properties");
                prop.setProperty("queueSize", String.valueOf(queueSize));
                prop.store(outfile, null);

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {

        }

    }

    private Properties readfile() {
        Properties properties = new Properties();
        OutputStream output = null;

        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

            properties.load(classLoader.getResourceAsStream("config.properties"));

            return properties;
        } catch (IOException io) {
            io.printStackTrace();
            System.out.println(io.getMessage());
        } finally
        {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();

                }
            }
        }
        return properties;

    }

}
