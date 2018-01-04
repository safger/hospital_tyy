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

public interface  PiccComplicationinfoService{ 
	
	public int deleteById(String id);

	public int insert(PiccComplicationinfo record);

	public int insertSelective(PiccComplicationinfo record);

	public PiccComplicationinfo findById(String fuid);

	public int updateSelective(PiccComplicationinfo record);

	public int update(PiccComplicationinfo record);
    
	public List<PiccComplicationinfo> selectByColum(PiccComplicationinfo record,String orderBy);
	
	public  int deleteByColum(PiccComplicationinfo record);
	
	public int deleteByByPrimaryKeys(List<String> ids);
	
	public List<PiccComplicationinfo>  selectLikeColum (String columName,String value);
	
	public PagedResult<PiccComplicationinfo> findByPage(PiccComplicationinfo record,Integer indexPage,Integer pageSize,String orderBy );
	
	public PagedResult<PiccComplicationinfo> findByPageCustom(PiccComplicationinfo record, Integer indexPage,Integer pageSize,String orderBy);
	
	public int countByColum(PiccComplicationinfo record);
	
	public List<PiccComplicationinfo> selectAll(String order);
	
}
