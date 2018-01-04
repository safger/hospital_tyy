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

public interface  PiccComplicationService{ 
	
	public int deleteById(String id);

	public int insert(PiccComplication record);

	public int insertSelective(PiccComplication record);

	public PiccComplication findById(String fuid);

	public int updateSelective(PiccComplication record);

	public int update(PiccComplication record);
    
	public List<PiccComplication> selectByColum(PiccComplication record,String orderBy);
	
	public  int deleteByColum(PiccComplication record);
	
	public int deleteByByPrimaryKeys(List<String> ids);
	
	public List<PiccComplication>  selectLikeColum (String columName,String value);
	
	public PagedResult<PiccComplication> findByPage(PiccComplication record,Integer indexPage,Integer pageSize,String orderBy );
	
	public PagedResult<PiccComplication> findByPageCustom(PiccComplication record, Integer indexPage,Integer pageSize,String orderBy);
	
	public int countByColum(PiccComplication record);
	
	public List<PiccComplication> selectAll(String order);
	
}
