package com.sn.service.system;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sn.util.PagedResult;





import java.util.*;

import com.sn.entity.*;
import com.sn.entity.system.Scope;
import com.sn.entity.system.User;
import com.sn.dao.*;
import com.sn.service.*;  

/**
 * @author xiaofeng
 * @version 1.0
 * @since 1.0
 */

public interface  ScopeService{ 
	
	public int deleteById(String id);

	public int insert(Scope record);

	public int insertSelective(Scope record);

	public Scope findById(String fuid);

	public int updateSelective(Scope record);

	public int update(Scope record);
    
	public List<Scope> selectByColum(Scope record);
	
	public  int deleteByColum(Scope record);
	
	public int deleteByByPrimaryKeys(List<String> ids);
	
	public List<Scope>  selectLikeColum (String columName,String value);
	
	public PagedResult<Scope> findByPage(Scope record,Integer pageNo,Integer pageSize );
	
	public  List<Scope> selectScope();
	
}
