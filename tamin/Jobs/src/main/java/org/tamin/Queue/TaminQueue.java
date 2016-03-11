package org.tamin.Queue;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by s.zakipour on 02/27/2016.
 */
public class TaminQueue implements QueueModel  {

    static final Logger logger = Logger.getLogger("JobLogger");
    //private ConcurrentHashMap queues = new ConcurrentHashMap();

    private LinkedList list = new LinkedList();

    private static TaminQueue _Instance;


    private TaminQueue()
    {

        System.out.println("instance create ...");

    }

    public static synchronized TaminQueue getInstance()
    {
        if (_Instance !=null)
        return _Instance;
        else
        {

            return new TaminQueue();
        }
    }



    public LinkedList getList() {
        return list;
    }

    @Override
    public void addToQueue(Object obj)
    {
        if(!list.contains(obj))
        {

            list.add(obj);
        }
        else
        {
            logger.log(Level.WARN , "redundant data stored ...");
        }


    }

    @Override
    public void removeFromQueue(Object obj)
    {
        list.remove(obj);
    }

    @Override
    public void destory() {
        //list.removeAll();
    }


}
