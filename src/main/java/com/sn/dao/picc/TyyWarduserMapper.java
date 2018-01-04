package com.sn.dao.picc;

import java.util.List;

import com.sn.entity.picc.TyyWarduser;
/**
 * @author xiaofeng
 * @version 1.0
 * @since 1.0
 */



public interface TyyWarduserMapper {
	
	 int deleteByPrimaryKey(String fuid);

	    int insert(TyyWarduser record);

	    int insertSelective(TyyWarduser record);

	    TyyWarduser selectByPrimaryKey(String fuid);

	    int updateByPrimaryKeySelective(TyyWarduser record);

	    int updateByPrimaryKey(TyyWarduser record);
	    
	    List<TyyWarduser> selectByColum(TyyWarduser record);
	    
	    int deleteByColum(TyyWarduser record);
	 
	    int deleteByByPrimaryKeys(List<String> ids);
	    
	    List<TyyWarduser>  selectLikeColum (String columName,String value);
	    
	    List<TyyWarduser>  selectByCustom (TyyWarduser record);
	    
	    int countByColum(TyyWarduser record);
	    
	    List<TyyWarduser> selectAll();

}
