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

public interface  VmpuncturePatientService{ 
	
	public int deleteById(String id);

	public int insert(VmpuncturePatient record);

	public int insertSelective(VmpuncturePatient record);

	public VmpuncturePatient findById(String fuid);

	public int updateSelective(VmpuncturePatient record);

	public int update(VmpuncturePatient record);
    
	public List<VmpuncturePatient> selectByColum(VmpuncturePatient record,String orderBy);
	
	public  int deleteByColum(VmpuncturePatient record);
	
	public int deleteByByPrimaryKeys(List<String> ids);
	
	public List<VmpuncturePatient>  selectLikeColum (String columName,String value);
	
	public PagedResult<VmpuncturePatient> findByPage(VmpuncturePatient record,Integer indexPage,Integer pageSize,String orderBy );
	
	public PagedResult<VmpuncturePatient> findByPageCustom(VmpuncturePatient record, Integer indexPage,Integer pageSize,String orderBy);
	
	public int countByColum(VmpuncturePatient record);
	
	public List<VmpuncturePatient> selectAll(String order);
	
}
