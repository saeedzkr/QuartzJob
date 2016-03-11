package org.tamin.jobs;

import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Repository;
import org.tamin.Queue.TaminQueue;
import org.tamin.config.TaminConfiguration;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
//import org.tamin.
import org.tamin.model.dao.ChildUpdateDAO;
import org.tamin.model.dao.ChildUpdateDAOImpl;
import org.tamin.model.dao.InboundDAOImpl;
import org.tamin.model.dao.OutboundDAOImpl;
import org.tamin.model.utils.DAOResult;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Iterator;
import java.util.List;

/**
 * Created by sector7 on 12/31/15.
 */
public class MessageNotifier extends QuartzJobBean {

    final Logger logger = Logger.getLogger("JobLogger");


    private String fetchSize;

    private OutboundDAOImpl outboundDAOImpl;

    private InboundDAOImpl inboundDAOImpl;

    public InboundDAOImpl getInboundDAOImpl() {
        return inboundDAOImpl;
    }

    public void setInboundDAOImpl(InboundDAOImpl inboundDAOImpl) {
        this.inboundDAOImpl = inboundDAOImpl;
    }

    public OutboundDAOImpl getOutboundDAOImpl() {
        return outboundDAOImpl;
    }

    public void setOutboundDAOImpl(OutboundDAOImpl outboundDAOImpl) {
        this.outboundDAOImpl = outboundDAOImpl;
    }

    public String getFetchSize() {
        return fetchSize;
    }

    public void setFetchSize(String fetchSize) {
        this.fetchSize = fetchSize;
    }


    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {


            System.out.println("------------------------------- 001");


            List lst = outboundDAOImpl.listOutbound();

            Iterator it = lst.iterator();

            while (it.hasNext()) {
                System.out.println(it.next());
                inboundDAOImpl.
                it.remove();
            }


            System.out.println("------------------------------- 001");
            logger.log(Level.INFO, "Job start and queue size is " + TaminQueue.getInstance().getList().size());


        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error(Level.WARN, ex.getCause());
        }
    }


}
