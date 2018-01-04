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



public interface PiccPunctureconsultationMapper {
	
	 int deleteByPrimaryKey(String fuid);

	    int insert(PiccPunctureconsultation record);

	    int insertSelective(PiccPunctureconsultation record);

	    PiccPunctureconsultation selectByPrimaryKey(String fuid);

	    int updateByPrimaryKeySelective(PiccPunctureconsultation record);

	    int updateByPrimaryKey(PiccPunctureconsultation record);
	    
	    List<PiccPunctureconsultation> selectByColum(PiccPunctureconsultation record);
	    
	    int deleteByColum(PiccPunctureconsultation record);
	 
	    int deleteByByPrimaryKeys(List<String> ids);
	    
	    List<PiccPunctureconsultation>  selectLikeColum (String columName,String value);
	    
	    List<PiccPunctureconsultation>  selectByCustom (PiccPunctureconsultation record);
	    
	    int countByColum(PiccPunctureconsultation record);
	    
	    List<PiccPunctureconsultation> selectAll();

}
