package com.sn.dao.tyy;

import java.util.List;

import com.sn.entity.tyy.Doctors;
/**
 * @author xiaofeng
 * @version 1.0
 * @since 1.0
 */



public interface DoctorsMapper {
	
	 int deleteByPrimaryKey(String fuid);

	    int insert(Doctors record);

	    int insertSelective(Doctors record);

	    Doctors selectByPrimaryKey(String fuid);

	    int updateByPrimaryKeySelective(Doctors record);

	    int updateByPrimaryKey(Doctors record);
	    
	    List<Doctors> selectByColum(Doctors record);
	    
	    int deleteByColum(Doctors record);
	 
	    int deleteByByPrimaryKeys(List<String> ids);
	    
	    List<Doctors>  selectLikeColum (Doctors record);
	    
	    List<Doctors>  selectByCustom (Doctors record);
	    
	    int countByColum(Doctors record);
	    
	    List<Doctors> selectAll();

}
