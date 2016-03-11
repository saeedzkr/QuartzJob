package org.tamin.model.dao;

import java.util.List;

/**
 * Created by s.zakipour on 02/27/2016.
 */
public interface InboundDAO {

    List listInbound();

    void insert(Object obj);

    Object getObject(long id);
}
