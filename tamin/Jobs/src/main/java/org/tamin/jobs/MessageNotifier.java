package org.tamin.jobs;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.tamin.model.dao.ChildUpdateDAOImpl;
import org.tamin.model.utils.DAOResult;

import java.util.List;

/**
 * Created by sector7 on 12/31/15.
 */
public class MessageNotifier implements Job {

    final Logger logger = Logger.getLogger("JobLogger");

    private ChildUpdateDAOImpl childUpdateDAOImpl;

    public void setChildUpdateDAOImpl(ChildUpdateDAOImpl ChildUpdateDAOImpl) {
        childUpdateDAOImpl = ChildUpdateDAOImpl;
    }

    public ChildUpdateDAOImpl getChildUpdateDAOImpl() {
        return childUpdateDAOImpl;
    }


    public void execute(JobExecutionContext jobExecutionContext)  {
        try
        {


//            List<DAOResult> resultList = getChildUpdateDAOImpl().updateChildRefList(1000);
//
//            jobExecutionContext.getJobDetail().getJobDataMap().put("result" , resultList);


            System.out.println("------------------------------- 001");
            logger.log(Level.INFO, "Job start");

        }
        catch (Exception ex)
        {
            logger.log(Level.INFO , ex.getMessage());
        }

    }


}
