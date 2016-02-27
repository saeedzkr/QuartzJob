package org.tamin.jobs;

import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Repository;
import org.tamin.config.TaminConfiguration;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
//import org.tamin.
import org.tamin.model.dao.ChildUpdateDAO;
import org.tamin.model.dao.ChildUpdateDAOImpl;
import org.tamin.model.utils.DAOResult;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by sector7 on 12/31/15.
 */
public class MessageNotifier extends QuartzJobBean {

    final Logger logger = Logger.getLogger("JobLogger");


    private ChildUpdateDAOImpl childUpdateDAOImpl;



    public ChildUpdateDAOImpl getChildUpdateDAOImpl() {
        return childUpdateDAOImpl;
    }

    public void setChildUpdateDAOImpl(ChildUpdateDAOImpl childUpdateDAOImpl) {
        this.childUpdateDAOImpl = childUpdateDAOImpl;
    }

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {

            List<DAOResult> result = childUpdateDAOImpl.updateChildRefList(10);


            System.out.println("------------------------------- 001");
            //logger.log(Level.INFO, "Job start and queue size is " + result.size());


        } catch (Exception ex) {
            logger.log(Level.INFO, ex.getMessage());
        }
    }


}
