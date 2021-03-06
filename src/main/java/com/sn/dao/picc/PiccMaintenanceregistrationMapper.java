package com.sn.dao.picc;

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



import java.util.List; 



public interface PiccMaintenanceregistrationMapper {
	
	 int deleteByPrimaryKey(String fuid);

	    int insert(PiccMaintenanceregistration record);

	    int insertSelective(PiccMaintenanceregistration record);

	    PiccMaintenanceregistration selectByPrimaryKey(String fuid);

	    int updateByPrimaryKeySelective(PiccMaintenanceregistration record);

	    int updateByPrimaryKey(PiccMaintenanceregistration record);
	    
	    List<PiccMaintenanceregistration> selectByColum(PiccMaintenanceregistration record);
	    
	    int deleteByColum(PiccMaintenanceregistration record);
	 
	    int deleteByByPrimaryKeys(List<String> ids);
	    
	    List<PiccMaintenanceregistration>  selectLikeColum (PiccMaintenanceregistration record);
	    
	    List<PiccMaintenanceregistration>  selectByCustom (PiccMaintenanceregistration record);
	    
	    int countByColum(PiccMaintenanceregistration record);
	    
	    List<PiccMaintenanceregistration> selectAll();

}
