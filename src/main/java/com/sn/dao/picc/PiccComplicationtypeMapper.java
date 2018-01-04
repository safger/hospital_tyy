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



public interface PiccComplicationtypeMapper {
	
	 int deleteByPrimaryKey(String fuid);

	    int insert(PiccComplicationtype record);

	    int insertSelective(PiccComplicationtype record);

	    PiccComplicationtype selectByPrimaryKey(String fuid);

	    int updateByPrimaryKeySelective(PiccComplicationtype record);

	    int updateByPrimaryKey(PiccComplicationtype record);
	    
	    List<PiccComplicationtype> selectByColum(PiccComplicationtype record);
	    
	    int deleteByColum(PiccComplicationtype record);
	 
	    int deleteByByPrimaryKeys(List<String> ids);
	    
	    List<PiccComplicationtype>  selectLikeColum (String columName,String value);
	    
	    List<PiccComplicationtype>  selectByCustom (PiccComplicationtype record);
	    
	    int countByColum(PiccComplicationtype record);
	    
	    List<PiccComplicationtype> selectAll();
	    
	    List<PiccComplicationtype>  selectByVin (PiccComplicationmiddle record);
	    
	    List<PiccComplicationtype>   selectByView(PiccComplicationtype record);
	    

}
