package org.tamin.web.bean;

import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.ee.servlet.QuartzInitializerListener;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.GroupMatcher;
import org.tamin.config.TaminConfiguration;


import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import java.awt.event.ActionEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * Created by sector7 on 1/10/16.
 */
@ManagedBean
@SessionScoped
public class QueueMonitor implements Serializable {

    private Boolean activeJob;
    private long queueSize;
    private String activeConnection;
    private String jobName;
    private long doneProcessSize;
    private long failedProcessSize;
    private long currentCycle;
    private String nextCycleTime;
    private String currentCycleTime;
    private long currentQueueSize;
    private long newQueueSize;

    private Scheduler scheduler;


    public QueueMonitor() {

    }

    public Boolean getActiveJob() {
        return activeJob;
    }

    public void setActiveJob(Boolean activeJob) {
        this.activeJob = activeJob;
    }

    public long getQueueSize() {
        return queueSize;
    }

    public void setQueueSize(long queueSize) {
        queueSize = queueSize;
    }

    public String getActiveConnection() {
        return activeConnection;
    }

    public void setActiveConnection(String activeConnection) {
        this.activeConnection = activeConnection;
    }

    public long getDoneProcessSize() {
        return doneProcessSize;
    }

    public void setDoneProcessSize(long doneProcessSize) {
        this.doneProcessSize = doneProcessSize;
    }

    public long getFailedProcessSize() {
        return failedProcessSize;
    }

    public void setFailedProcessSize(long failedProcessSize) {
        this.failedProcessSize = failedProcessSize;
    }

    public long getCurrentCycle() {
        return currentCycle;
    }

    public void setCurrentCycle(long currentCycle) {
        this.currentCycle = currentCycle;
    }


    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getNextCycleTime() {
        return nextCycleTime;
    }

    public void setNextCycleTime(String nextCycleTime) {
        this.nextCycleTime = nextCycleTime;
    }

    public String getCurrentCycleTime() {
        return currentCycleTime;
    }

    public void setCurrentCycleTime(String currentCycleTime) {
        this.currentCycleTime = currentCycleTime;
    }

    public long getCurrentQueueSize() {
        return currentQueueSize;
    }

    public void setCurrentQueueSize(long currentQueueSize) {
        this.currentQueueSize = currentQueueSize;
    }

    public long getNewQueueSize() {
        return newQueueSize;
    }

    public void setNewQueueSize(long newQueueSize) {
        this.newQueueSize = newQueueSize;
    }

    public void calculateJob() throws SchedulerException {
        try {
            ServletContext servletContext =
                    (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            StdSchedulerFactory stdSchedulerFactory =
                    (StdSchedulerFactory) servletContext.getAttribute(QuartzInitializerListener.QUARTZ_FACTORY_KEY);
            scheduler = stdSchedulerFactory.getScheduler();
            for (String groupName : scheduler.getJobGroupNames()) {
                // get jobkey
                for (JobKey jobKey : scheduler.getJobKeys(GroupMatcher.jobGroupEquals(groupName))) {
                    String jobName = jobKey.getName();
                    String jobGroup = jobKey.getGroup();
                    // get job's trigger
                    List<Trigger> triggers = (List<Trigger>) scheduler
                            .getTriggersOfJob(jobKey);
                    this.activeConnection = String.valueOf(scheduler.isShutdown());
                    //List<DAOResult> result = (List<DAOResult>) scheduler.getJobDetail(jobKey).getJobDataMap().get("result");
                    long succeed = 0;
                    long failed = 0;

                    this.doneProcessSize = succeed;
                    this.failedProcessSize = failed;
                    //this.currentCycle = triggers.get(0).getPreviousFireTime().getTime(); //- triggers.get(0).getNextFireTime().getTime()) / 10;
                    this.currentCycleTime = triggers.get(0).getPreviousFireTime().toString();
                    this.nextCycleTime = triggers.get(0).getNextFireTime().toString();
                    this.currentQueueSize = TaminConfiguration.getConfiguration().getQueueSize();
                    this.activeJob = scheduler.isShutdown();

                    //quartzJobList.add(new QuartzJob(jobName, jobGroup, nextFireTime));

                }

            }

        } catch (Exception ex) {
            FacesMessage msg = new FacesMessage();
            msg.setDetail(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(ex.getMessage(), msg);
            System.out.println(ex.getMessage());
        }

    }

    public void updateQueueSize()
    {

        try {
//            FacesContext context = FacesContext.getCurrentInstance();
//            UIInput foundComponent = (UIInput) FacesContext.getCurrentInstance().getViewRoot().findComponent("size");
//            long size = (long) foundComponent.getSubmittedValue();
            //TaminConfiguration.getConfiguration().setQueueSize(newQueueSize);

            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            Properties properties = new Properties();
// ...
            properties.load(externalContext.getResourceAsStream("/WEB-INF/config.properties"));
            FileOutputStream outfile = null;
            try {
                Properties prop = new Properties();
                ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
                prop.load(classLoader.getResourceAsStream("config.properties"));
                outfile = new FileOutputStream("config.properties");
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
        catch (Exception ex)
        {

        }


    }


}
