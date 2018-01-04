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



public interface PiccPunctureregisterMapper {
	
	 int deleteByPrimaryKey(String fuid);

	    int insert(PiccPunctureregister record);

	    int insertSelective(PiccPunctureregister record);

	    PiccPunctureregister selectByPrimaryKey(String fuid);

	    int updateByPrimaryKeySelective(PiccPunctureregister record);

	    int updateByPrimaryKey(PiccPunctureregister record);
	    
	    List<PiccPunctureregister> selectByColum(PiccPunctureregister record);
	    
	    int deleteByColum(PiccPunctureregister record);
	 
	    int deleteByByPrimaryKeys(List<String> ids);
	    
	    List<PiccPunctureregister>  selectLikeColum (String columName,String value);
	    
	    List<PiccPunctureregister>  selectByCustom (PiccPunctureregister record);
	    
	    int countByColum(PiccPunctureregister record);
	    
	    List<PiccPunctureregister> selectAll();

}
