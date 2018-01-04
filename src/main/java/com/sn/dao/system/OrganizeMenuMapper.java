package com.sn.dao.system;

import java.util.*;

import com.sn.entity.*;
import com.sn.entity.system.OrganizeMenu;
import com.sn.dao.*;
import com.sn.service.*;  

import java.util.List; 



public interface OrganizeMenuMapper {
	
	 int deleteByPrimaryKey(String fuid);

	    int insert(OrganizeMenu record);

	    int insertSelective(OrganizeMenu record);

	    OrganizeMenu selectByPrimaryKey(String fuid);

	    int updateByPrimaryKeySelective(OrganizeMenu record);

	    int updateByPrimaryKey(OrganizeMenu record);
	    
	    List<OrganizeMenu> selectByColum(OrganizeMenu record);
	    
	    int deleteByColum(OrganizeMenu record);
	 
	    int deleteByByPrimaryKeys(List<String> ids);
	    
	    List<OrganizeMenu>  selectLikeColum (String columName,String value);
	    

}
