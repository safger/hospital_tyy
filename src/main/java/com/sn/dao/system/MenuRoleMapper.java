package com.sn.dao.system;

import java.util.*;

import com.sn.entity.*;
import com.sn.entity.system.MenuRole;
import com.sn.dao.*;
import com.sn.service.*;  

import java.util.List; 



public interface MenuRoleMapper {
	
	 int deleteByPrimaryKey(String fuid);

	    int insert(MenuRole record);

	    int insertSelective(MenuRole record);

	    MenuRole selectByPrimaryKey(String fuid);

	    int updateByPrimaryKeySelective(MenuRole record);

	    int updateByPrimaryKey(MenuRole record);
	    
	    List<MenuRole> selectByColum(MenuRole record);
	    
	    int deleteByColum(MenuRole record);
	 
	    int deleteByByPrimaryKeys(List<String> ids);
	    
	    List<MenuRole>  selectLikeColum (String columName,String value);
	    
	    List<MenuRole>  selectByCustom (MenuRole record);
	    
	    int countByColum(MenuRole record);

	    List<MenuRole>  selectMenuOp();

}
