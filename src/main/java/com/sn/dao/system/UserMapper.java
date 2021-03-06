package com.sn.dao.system;

import java.util.*;

import com.sn.entity.*;
import com.sn.entity.system.User;
import com.sn.dao.*;
import com.sn.service.*;  

import java.util.List; 



public interface UserMapper {
	
	 int deleteByPrimaryKey(String fuid);

	    int insert(User record);

	    int insertSelective(User record);

	    User selectByPrimaryKey(String fuid);

	    int updateByPrimaryKeySelective(User record);

	    int updateByPrimaryKey(User record);
	    
	    List<User> selectByColum(User record);
	    
	    int deleteByColum(User record);
	 
	    int deleteByByPrimaryKeys(List<String> ids);
	    
	    List<User>  selectLikeColum (String columName,String value);
	    
	    List<User> selectByCustom(User record);
	    
	    int countByColum(User record);
}
