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

public interface  VcomplicationPatientService{ 
	
	public int deleteById(String id);

	public int insert(VcomplicationPatient record);

	public int insertSelective(VcomplicationPatient record);

	public VcomplicationPatient findById(String fuid);

	public int updateSelective(VcomplicationPatient record);

	public int update(VcomplicationPatient record);
    
	public List<VcomplicationPatient> selectByColum(VcomplicationPatient record,String orderBy);
	
	public  int deleteByColum(VcomplicationPatient record);
	
	public int deleteByByPrimaryKeys(List<String> ids);
	
	public List<VcomplicationPatient>  selectLikeColum (String columName,String value);
	
	public PagedResult<VcomplicationPatient> findByPage(VcomplicationPatient record,Integer indexPage,Integer pageSize,String orderBy );
	
	public PagedResult<VcomplicationPatient> findByPageCustom(VcomplicationPatient record, Integer indexPage,Integer pageSize,String orderBy);
	
	public int countByColum(VcomplicationPatient record);
	
	public List<VcomplicationPatient> selectAll(String order);
	
}
