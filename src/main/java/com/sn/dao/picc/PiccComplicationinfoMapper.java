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



public interface PiccComplicationinfoMapper {
	
	 int deleteByPrimaryKey(String fuid);

	    int insert(PiccComplicationinfo record);

	    int insertSelective(PiccComplicationinfo record);

	    PiccComplicationinfo selectByPrimaryKey(String fuid);

	    int updateByPrimaryKeySelective(PiccComplicationinfo record);

	    int updateByPrimaryKey(PiccComplicationinfo record);
	    
	    List<PiccComplicationinfo> selectByColum(PiccComplicationinfo record);
	    
	    int deleteByColum(PiccComplicationinfo record);
	 
	    int deleteByByPrimaryKeys(List<String> ids);
	    
	    List<PiccComplicationinfo>  selectLikeColum (String columName,String value);
	    
	    List<PiccComplicationinfo>  selectByCustom (PiccComplicationinfo record);
	    
	    int countByColum(PiccComplicationinfo record);
	    
	    List<PiccComplicationinfo> selectAll();

}
