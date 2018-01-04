package com.sn.service.picc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.sn.dao.picc.TyyWarduserMapper;
import com.sn.dao.system.UserMapper;
import com.sn.entity.picc.TyyWarduser;
import com.sn.util.BeanUtil;
import com.sn.util.PagedResult;


/**
 * @author xiaofeng
 * @version 1.0
 * @since 1.0
 */


@Service("tyyWarduserService")
public class TyyWarduserServiceImpl implements TyyWarduserService{
	
	@Autowired
	private TyyWarduserMapper tyyWarduserMapper;

	  

	@Override
	public int deleteById(String fuid) {
		// TODO Auto-generated method stub
		return tyyWarduserMapper.deleteByPrimaryKey(fuid);
	}

	@Override
	public int insert(TyyWarduser record) {
		// TODO Auto-generated method stub
		return tyyWarduserMapper.insert(record);
	}

	@Override
	public int insertSelective(TyyWarduser record) {
		// TODO Auto-generated method stub
		return tyyWarduserMapper.insertSelective(record);
	}

	@Override
	public TyyWarduser findById(String fuid) {
		// TODO Auto-generated method stub
		return tyyWarduserMapper.selectByPrimaryKey(fuid);
	}

	@Override
	public int updateSelective(TyyWarduser record) {
		// TODO Auto-generated method stub
		return tyyWarduserMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int update(TyyWarduser record) {
		// TODO Auto-generated method stub
		return tyyWarduserMapper.updateByPrimaryKey(record);
	}
	
	@Override
	public  int deleteByColum(TyyWarduser record){
		// TODO Auto-generated method stub
		return tyyWarduserMapper.deleteByColum(record);
	}
	
	@Override
	public List<TyyWarduser> selectByColum(TyyWarduser record,String orderBy) {
		// TODO Auto-generated method stub
		PageHelper.orderBy(orderBy);
		return tyyWarduserMapper.selectByColum(record);
	}
	
	@Override
	public int deleteByByPrimaryKeys(List<String> ids){
		// TODO Auto-generated method stub
		return tyyWarduserMapper.deleteByByPrimaryKeys(ids);
	}
	
	@Override
	public List<TyyWarduser>  selectLikeColum (String columName,String value){
		// TODO Auto-generated method stub
		return tyyWarduserMapper.selectLikeColum(columName,value);
	}
	
	@Override
	public PagedResult<TyyWarduser> findByPage(TyyWarduser record, Integer pageNo,
			Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(tyyWarduserMapper.selectByColum(record));
	}

	@Override
	public PagedResult<TyyWarduser> findByPageCustom(TyyWarduser record, Integer pageNo,Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(tyyWarduserMapper.selectByCustom(record));
	}
	@Override
	public int countByColum(TyyWarduser record) {
		// TODO Auto-generated method stub
		return tyyWarduserMapper.countByColum(record);
	}
	@Override
	public List<TyyWarduser> selectAll(String order){
		PageHelper.orderBy(order);
		return tyyWarduserMapper.selectAll();
	}
}
