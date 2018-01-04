package com.sn.dao.tyy;

import java.util.List;

import com.sn.entity.tyy.Images;
/**
 * @author xiaofeng
 * @version 1.0
 * @since 1.0
 */



public interface ImagesMapper {
	
	 int deleteByPrimaryKey(String fuid);

	    int insert(Images record);

	    int insertSelective(Images record);

	    Images selectByPrimaryKey(String fuid);

	    int updateByPrimaryKeySelective(Images record);

	    int updateByPrimaryKey(Images record);
	    
	    List<Images> selectByColum(Images record);
	    
	    int deleteByColum(Images record);
	 
	    int deleteByByPrimaryKeys(List<String> ids);
	    
	    List<Images>  selectLikeColum (Images record);
	    
	    List<Images>  selectByCustom (Images record);
	    
	    int countByColum(Images record);
	    
	    List<Images> selectAll();

}
