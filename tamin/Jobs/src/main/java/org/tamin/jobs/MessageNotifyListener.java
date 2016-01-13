package org.tamin.jobs;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;
import org.tamin.model.utils.DAOResult;

import java.util.List;

/**
 * Created by sector7 on 1/10/16.
 */
public class MessageNotifyListener implements JobListener {


    private List<DAOResult> result;


    public List<DAOResult> getResult() {
        return result;
    }

    public void setResult(List<DAOResult> result) {
        this.result = result;
    }

    public String getName() {
        return null;
    }

    public void jobToBeExecuted(JobExecutionContext jobExecutionContext) {

    }

    public void jobExecutionVetoed(JobExecutionContext jobExecutionContext) {

    }

    public void jobWasExecuted(JobExecutionContext jobExecutionContext, JobExecutionException e) {

        this.result = (List<DAOResult>) jobExecutionContext.getResult();
    }
}
