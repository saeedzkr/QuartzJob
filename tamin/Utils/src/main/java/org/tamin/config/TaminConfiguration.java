package org.tamin.config;

import javax.servlet.ServletContext;
import java.io.*;
import java.net.URL;
import java.util.Properties;

/**
 * Created by s.zakipour on 01/13/2016.
 */
public class TaminConfiguration {

    private TaminConfiguration() {
    }

    private static TaminConfiguration _Configuration;

    private static final String SERVLET_ADDRESS= "http://127.0.0.1:8085/config";

    public static TaminConfiguration getConfiguration() {
        if (_Configuration == null) {
            _Configuration = new TaminConfiguration();
            return _Configuration;
        } else {
            return _Configuration;
        }
    }


    public long getQueueSize() {

        Properties prop = readfile();
        if (prop != null) {
            return Long.parseLong(prop.getProperty("queueSize"));
        } else {
            return 0;
        }

    }

    public void setQueueSize(long queueSize) {

        FileOutputStream outfile = null;
        try {
            Properties prop = new Properties();
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            prop.load(classLoader.getResourceAsStream("/WEB-INF/config.properties"));
            outfile = new FileOutputStream("/WEB-INF/config.properties");
            prop.setProperty("queueSize", String.valueOf(queueSize));
            prop.store(outfile, null);
            outfile.close();


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {
            try {
                outfile.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }


        }

    }

    private Properties readfile() {
        Properties properties = new Properties();
        OutputStream output = null;

        try {
            URL url = new URL( SERVLET_ADDRESS);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            //line = in.readLine();

            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

            properties.load(classLoader.getResourceAsStream("/WEB-INF/config.properties"));

            return properties;
        } catch (IOException io) {
            io.printStackTrace();
            System.out.println(io.getMessage());
        } finally {
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
