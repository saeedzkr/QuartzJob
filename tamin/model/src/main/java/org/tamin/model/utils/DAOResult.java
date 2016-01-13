package org.tamin.model.utils;

import java.io.Serializable;

/**
 * Created by sector7 on 1/10/16.
 */
public class DAOResult implements Serializable {

    public static final long PERSIST_DONE = 1;
    public static final long PERSIST_FAILED = 2;


    private long persisResult;
    private String resultMessage;

    public DAOResult(long result , String message)
    {
        this.persisResult = result;
        this.resultMessage = message;
    }


    public long getPersisResult() {
        return persisResult;
    }

    public void setPersisResult(long persisResult) {
        this.persisResult = persisResult;
    }




}
