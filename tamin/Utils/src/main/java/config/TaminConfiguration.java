package config;

import java.io.*;
import java.util.Properties;

/**
 * Created by sector7 on 1/13/16.
 */
public class TaminConfiguration {


    private TaminConfiguration() {

    }


    private static TaminConfiguration taminConfiguration;


    public static TaminConfiguration getTaminConfiguration() {
        if (taminConfiguration == null)
            return new TaminConfiguration();
        else
            return taminConfiguration;
    }



    public long getQueueSize()
    {

        return Long.parseLong(readfile().get("queueSize").toString());
    }

    private Properties readfile()
    {
        Properties prop = new Properties();

        InputStream input = null;

        try {

            input = new FileInputStream("config.properties");

            prop.load(input);


        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return prop;
    }


}
