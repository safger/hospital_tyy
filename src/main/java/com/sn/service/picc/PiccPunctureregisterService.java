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

public interface  PiccPunctureregisterService{ 
	
	public int deleteById(String id);

	public int insert(PiccPunctureregister record);

	public int insertSelective(PiccPunctureregister record);

	public PiccPunctureregister findById(String fuid);

	public int updateSelective(PiccPunctureregister record);

	public int update(PiccPunctureregister record);
    
	public List<PiccPunctureregister> selectByColum(PiccPunctureregister record,String orderBy);
	
	public  int deleteByColum(PiccPunctureregister record);
	
	public int deleteByByPrimaryKeys(List<String> ids);
	
	public List<PiccPunctureregister>  selectLikeColum (String columName,String value);
	
	public PagedResult<PiccPunctureregister> findByPage(PiccPunctureregister record,Integer indexPage,Integer pageSize,String orderBy );
	
	public PagedResult<PiccPunctureregister> findByPageCustom(PiccPunctureregister record, Integer indexPage,Integer pageSize,String orderBy);
	
	public int countByColum(PiccPunctureregister record);
	
	public List<PiccPunctureregister> selectAll(String order);
	
}
