package com.sn.service.picc;

import java.util.List;

import com.sn.entity.picc.TyyWarduser;
import com.sn.util.PagedResult;


/**
 * @author xiaofeng
 * @version 1.0
 * @since 1.0
 */

public interface  TyyWarduserService{ 
	
	public int deleteById(String id);

	public int insert(TyyWarduser record);

	public int insertSelective(TyyWarduser record);

	public TyyWarduser findById(String fuid);

	public int updateSelective(TyyWarduser record);

	public int update(TyyWarduser record);
    
	public List<TyyWarduser> selectByColum(TyyWarduser record,String orderBy);
	
	public  int deleteByColum(TyyWarduser record);
	
	public int deleteByByPrimaryKeys(List<String> ids);
	
	public List<TyyWarduser>  selectLikeColum (String columName,String value);
	
	public PagedResult<TyyWarduser> findByPage(TyyWarduser record,Integer indexPage,Integer pageSize,String orderBy );
	
	public PagedResult<TyyWarduser> findByPageCustom(TyyWarduser record, Integer indexPage,Integer pageSize,String orderBy);
	
	public int countByColum(TyyWarduser record);
	
	public List<TyyWarduser> selectAll(String order);
	
}
