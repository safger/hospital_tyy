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



public interface VcpuncturePatientMapper {
	
	 int deleteByPrimaryKey(String fuid);

	    int insert(VcpuncturePatient record);

	    int insertSelective(VcpuncturePatient record);

	    VcpuncturePatient selectByPrimaryKey(String fuid);

	    int updateByPrimaryKeySelective(VcpuncturePatient record);

	    int updateByPrimaryKey(VcpuncturePatient record);
	    
	    List<VcpuncturePatient> selectByColum(VcpuncturePatient record);
	    
	    int deleteByColum(VcpuncturePatient record);
	 
	    int deleteByByPrimaryKeys(List<String> ids);
	    
	    List<VcpuncturePatient>  selectLikeColum (String columName,String value);
	    
	    List<VcpuncturePatient>  selectByCustom (VcpuncturePatient record);
	    
	    int countByColum(VcpuncturePatient record);
	    
	    List<VcpuncturePatient> selectAll();

}
