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



public interface PiccComplicationMapper {
	
	 int deleteByPrimaryKey(String fuid);

	    int insert(PiccComplication record);

	    int insertSelective(PiccComplication record);

	    PiccComplication selectByPrimaryKey(String fuid);

	    int updateByPrimaryKeySelective(PiccComplication record);

	    int updateByPrimaryKey(PiccComplication record);
	    
	    List<PiccComplication> selectByColum(PiccComplication record);
	    
	    int deleteByColum(PiccComplication record);
	 
	    int deleteByByPrimaryKeys(List<String> ids);
	    
	    List<PiccComplication>  selectLikeColum (String columName,String value);
	    
	    List<PiccComplication>  selectByCustom (PiccComplication record);
	    
	    int countByColum(PiccComplication record);
	    
	    List<PiccComplication> selectAll();

}
