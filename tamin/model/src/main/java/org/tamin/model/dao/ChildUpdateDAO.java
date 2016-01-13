package org.tamin.model.dao;

import org.tamin.model.utils.DAOResult;

import java.util.List;

/**
 * Created by sector7 on 1/10/16.
 */
public interface ChildUpdateDAO {

    public List<DAOResult> updateChildRefList(long size);
}
