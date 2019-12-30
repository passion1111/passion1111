package com.coding.platform.util.file.service.impl;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class MultipartFileDAO extends SqlSessionDaoSupport {
	
	/** log */
    protected static final Log Logger = LogFactory.getLog(MultipartFileDAO.class);
    
	public Object insertAttachFile(HashMap<String, Object> params){
    	return getSqlSession().insert("attachFile.insertAttachFile", params);
	}
}
