package com.sn.dao.system;

import java.util.*;

import com.sn.entity.*;
import com.sn.entity.system.Scope;
import com.sn.dao.*;
import com.sn.service.*;  

import java.util.List; 



public interface ScopeMapper {
	
	 int deleteByPrimaryKey(String fuid);

	    int insert(Scope record);

	    int insertSelective(Scope record);

	    Scope selectByPrimaryKey(String fuid);

	    int updateByPrimaryKeySelective(Scope record);

	    int updateByPrimaryKey(Scope record);
	    
	    List<Scope> selectByColum(Scope record);
	    
	    int deleteByColum(Scope record);
	 
	    int deleteByByPrimaryKeys(List<String> ids);
	    
	    List<Scope>  selectLikeColum (String columName,String value);
	    
	    List<Scope> selectScope();
	    

}
