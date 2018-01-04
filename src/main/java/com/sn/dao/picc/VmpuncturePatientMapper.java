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



public interface VmpuncturePatientMapper {
	
	 int deleteByPrimaryKey(String fuid);

	    int insert(VmpuncturePatient record);

	    int insertSelective(VmpuncturePatient record);

	    VmpuncturePatient selectByPrimaryKey(String fuid);

	    int updateByPrimaryKeySelective(VmpuncturePatient record);

	    int updateByPrimaryKey(VmpuncturePatient record);
	    
	    List<VmpuncturePatient> selectByColum(VmpuncturePatient record);
	    
	    int deleteByColum(VmpuncturePatient record);
	 
	    int deleteByByPrimaryKeys(List<String> ids);
	    
	    List<VmpuncturePatient>  selectLikeColum (String columName,String value);
	    
	    List<VmpuncturePatient>  selectByCustom (VmpuncturePatient record);
	    
	    int countByColum(VmpuncturePatient record);
	    
	    List<VmpuncturePatient> selectAll();

}
