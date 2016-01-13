package org.tamin.web.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by saeedzr on 7/14/15.
 */
public class DateUtils {


    private static final String DATE_FORMAT_TYPE = "MM/dd/YYYY HH:mm a";
    private static Date now ;
    private static String convertToFormat;

    public static Date getNow() {

        return new Date();
    }

    public static String getConvertToFormat() {

        SimpleDateFormat df = new SimpleDateFormat(DATE_FORMAT_TYPE);
        return df.format(getNow());
    }


}
