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

public interface  PiccMaintenanceregistrationService{ 
	
	public int deleteById(String id);

	public int insert(PiccMaintenanceregistration record);

	public int insertSelective(PiccMaintenanceregistration record);

	public PiccMaintenanceregistration findById(String fuid);

	public int updateSelective(PiccMaintenanceregistration record);

	public int update(PiccMaintenanceregistration record);
    
	public List<PiccMaintenanceregistration> selectByColum(PiccMaintenanceregistration record,String orderBy);
	
	public  int deleteByColum(PiccMaintenanceregistration record);
	
	public int deleteByByPrimaryKeys(List<String> ids);
	
	public List<PiccMaintenanceregistration>  selectLikeColum (PiccMaintenanceregistration record,String orderBy);
	
	public PagedResult<PiccMaintenanceregistration> findByPage(PiccMaintenanceregistration record,Integer indexPage,Integer pageSize,String orderBy );
	
	public PagedResult<PiccMaintenanceregistration> findByPageCustom(PiccMaintenanceregistration record, Integer indexPage,Integer pageSize,String orderBy);
	
	public int countByColum(PiccMaintenanceregistration record);
	
	public List<PiccMaintenanceregistration> selectAll(String order);
	
}
