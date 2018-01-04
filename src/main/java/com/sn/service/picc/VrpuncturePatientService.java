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

public interface  VrpuncturePatientService{ 
	
	public int deleteById(String id);

	public int insert(VrpuncturePatient record);

	public int insertSelective(VrpuncturePatient record);

	public VrpuncturePatient findById(String fuid);

	public int updateSelective(VrpuncturePatient record);

	public int update(VrpuncturePatient record);
    
	public List<VrpuncturePatient> selectByColum(VrpuncturePatient record,String orderBy);
	
	public  int deleteByColum(VrpuncturePatient record);
	
	public int deleteByByPrimaryKeys(List<String> ids);
	
	public List<VrpuncturePatient>  selectLikeColum (String columName,String value);
	
	public PagedResult<VrpuncturePatient> findByPage(VrpuncturePatient record,Integer indexPage,Integer pageSize,String orderBy );
	
	public PagedResult<VrpuncturePatient> findByPageCustom(VrpuncturePatient record, Integer indexPage,Integer pageSize,String orderBy);
	
	public int countByColum(VrpuncturePatient record);
	
	public List<VrpuncturePatient> selectAll(String order);
	
}
