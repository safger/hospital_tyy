package com.sn.service.tyy;

import java.util.List;

import com.sn.entity.tyy.Images;
import com.sn.util.PagedResult;


/**
 * @author xiaofeng
 * @version 1.0
 * @since 1.0
 */

public interface  ImagesService{ 
	
	public int deleteById(String id);

	public int insert(Images record);

	public int insertSelective(Images record);

	public Images findById(String fuid);

	public int updateSelective(Images record);

	public int update(Images record);
    
	public List<Images> selectByColum(Images record,String orderBy);
	
	public  int deleteByColum(Images record);
	
	public int deleteByByPrimaryKeys(List<String> ids);
	
	public List<Images>  selectLikeColum (Images record,String orderBy);
	
	public PagedResult<Images> findByPage(Images record,Integer indexPage,Integer pageSize,String orderBy );
	
	public PagedResult<Images> findByPageCustom(Images record, Integer indexPage,Integer pageSize,String orderBy);
	
	public int countByColum(Images record);
	
	public List<Images> selectAll(String order);
	
}
