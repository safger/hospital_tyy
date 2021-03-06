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

public interface  VcpuncturePatientService{ 
	
	public int deleteById(String id);

	public int insert(VcpuncturePatient record);

	public int insertSelective(VcpuncturePatient record);

	public VcpuncturePatient findById(String fuid);

	public int updateSelective(VcpuncturePatient record);

	public int update(VcpuncturePatient record);
    
	public List<VcpuncturePatient> selectByColum(VcpuncturePatient record,String orderBy);
	
	public  int deleteByColum(VcpuncturePatient record);
	
	public int deleteByByPrimaryKeys(List<String> ids);
	
	public List<VcpuncturePatient>  selectLikeColum (String columName,String value);
	
	public PagedResult<VcpuncturePatient> findByPage(VcpuncturePatient record,Integer indexPage,Integer pageSize,String orderBy );
	
	public PagedResult<VcpuncturePatient> findByPageCustom(VcpuncturePatient record, Integer indexPage,Integer pageSize,String orderBy);
	
	public int countByColum(VcpuncturePatient record);
	
	public List<VcpuncturePatient> selectAll(String order);
	
}
