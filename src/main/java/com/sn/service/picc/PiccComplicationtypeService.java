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

public interface  PiccComplicationtypeService{ 
	
	public int deleteById(String id);

	public int insert(PiccComplicationtype record);

	public int insertSelective(PiccComplicationtype record);

	public PiccComplicationtype findById(String fuid);

	public int updateSelective(PiccComplicationtype record);

	public int update(PiccComplicationtype record);
    
	public List<PiccComplicationtype> selectByColum(PiccComplicationtype record,String orderBy);
	
	public  int deleteByColum(PiccComplicationtype record);
	
	public int deleteByByPrimaryKeys(List<String> ids);
	
	public List<PiccComplicationtype>  selectLikeColum (String columName,String value);
	
	public PagedResult<PiccComplicationtype> findByPage(PiccComplicationtype record,Integer indexPage,Integer pageSize,String orderBy );
	
	public PagedResult<PiccComplicationtype> findByPageCustom(PiccComplicationtype record, Integer indexPage,Integer pageSize,String orderBy);
	
	public int countByColum(PiccComplicationtype record);
	
	public List<PiccComplicationtype> selectAll(String order);
	
	public  List<PiccComplicationtype>  selectByVin (PiccComplicationmiddle record);
	
	public  List<PiccComplicationtype>   selectByView(PiccComplicationtype record);
	
}
