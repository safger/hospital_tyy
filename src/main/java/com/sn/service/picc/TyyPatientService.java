package com.sn.service.picc;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sn.util.PagedResult;



import java.util.*;
import java.io.IOException;  
 

import com.sn.entity.picc.*;
import com.sn.dao.picc.*;
import com.sn.service.picc.*;  
import com.sn.util.PagedResult;
import com.sn.common.*;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sn.controller.system.CompetenceManager;
import javax.servlet.http.HttpServletRequest;
import com.sn.controller.system.ComData;


/**
 * @author xiaofeng
 * @version 1.0
 * @since 1.0
 */

public interface  TyyPatientService{ 
	
	public int deleteById(String id);

	public int insert(TyyPatient record);

	public int insertSelective(TyyPatient record);

	public TyyPatient findById(String fuid);

	public int updateSelective(TyyPatient record);

	public int update(TyyPatient record);
    
	public List<TyyPatient> selectByColum(TyyPatient record,String orderBy);
	
	public  int deleteByColum(TyyPatient record);
	
	public int deleteByByPrimaryKeys(List<String> ids);
	
	public List<TyyPatient>  selectLikeColum (String columName,String value);
	
	public PagedResult<TyyPatient> findByPage(TyyPatient record,Integer indexPage,Integer pageSize,String orderBy );
	
	public PagedResult<TyyPatient> findByPageCustom(TyyPatient record, Integer indexPage,Integer pageSize,String orderBy);
	
	public int countByColum(TyyPatient record);
	
	public List<TyyPatient> selectAll(String order);
	
}
