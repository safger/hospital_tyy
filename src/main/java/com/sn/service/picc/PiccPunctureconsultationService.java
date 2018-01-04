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

public interface  PiccPunctureconsultationService{ 
	
	public int deleteById(String id);

	public int insert(PiccPunctureconsultation record);

	public int insertSelective(PiccPunctureconsultation record);

	public PiccPunctureconsultation findById(String fuid);

	public int updateSelective(PiccPunctureconsultation record);

	public int update(PiccPunctureconsultation record);
    
	public List<PiccPunctureconsultation> selectByColum(PiccPunctureconsultation record,String orderBy);
	
	public  int deleteByColum(PiccPunctureconsultation record);
	
	public int deleteByByPrimaryKeys(List<String> ids);
	
	public List<PiccPunctureconsultation>  selectLikeColum (String columName,String value);
	
	public PagedResult<PiccPunctureconsultation> findByPage(PiccPunctureconsultation record,Integer indexPage,Integer pageSize,String orderBy );
	
	public PagedResult<PiccPunctureconsultation> findByPageCustom(PiccPunctureconsultation record, Integer indexPage,Integer pageSize,String orderBy);
	
	public int countByColum(PiccPunctureconsultation record);
	
	public List<PiccPunctureconsultation> selectAll(String order);
	
}
