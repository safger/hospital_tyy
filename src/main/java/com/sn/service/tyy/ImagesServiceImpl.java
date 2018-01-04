package com.sn.service.tyy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.sn.dao.system.UserMapper;
import com.sn.dao.tyy.ImagesMapper;
import com.sn.entity.tyy.Images;
import com.sn.util.BeanUtil;
import com.sn.util.PagedResult;


/**
 * @author xiaofeng
 * @version 1.0
 * @since 1.0
 */


@Service("imagesService")
public class ImagesServiceImpl implements ImagesService{
	
	@Autowired
	private ImagesMapper imagesMapper;

	public ImagesMapper getImagesMapper() {
		return imagesMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.imagesMapper = imagesMapper;
	} 

	 

	@Override
	public int deleteById(String fuid) {
		// TODO Auto-generated method stub
		return imagesMapper.deleteByPrimaryKey(fuid);
	}

	@Override
	public int insert(Images record) {
		// TODO Auto-generated method stub
		return imagesMapper.insert(record);
	}

	@Override
	public int insertSelective(Images record) {
		// TODO Auto-generated method stub
		return imagesMapper.insertSelective(record);
	}

	@Override
	public Images findById(String fuid) {
		// TODO Auto-generated method stub
		return imagesMapper.selectByPrimaryKey(fuid);
	}

	@Override
	public int updateSelective(Images record) {
		// TODO Auto-generated method stub
		return imagesMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int update(Images record) {
		// TODO Auto-generated method stub
		return imagesMapper.updateByPrimaryKey(record);
	}
	
	@Override
	public  int deleteByColum(Images record){
		// TODO Auto-generated method stub
		return imagesMapper.deleteByColum(record);
	}
	
	@Override
	public List<Images> selectByColum(Images record,String orderBy) {
		// TODO Auto-generated method stub
		PageHelper.orderBy(orderBy);
		return imagesMapper.selectByColum(record);
	}
	
	@Override
	public int deleteByByPrimaryKeys(List<String> ids){
		// TODO Auto-generated method stub
		return imagesMapper.deleteByByPrimaryKeys(ids);
	}
	
	@Override
	public List<Images>  selectLikeColum (Images record,String orderBy){
		// TODO Auto-generated method stub
		PageHelper.orderBy(orderBy);
		return imagesMapper.selectLikeColum(record);
	}
	
	@Override
	public PagedResult<Images> findByPage(Images record, Integer pageNo,
			Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(imagesMapper.selectByColum(record));
	}

	@Override
	public PagedResult<Images> findByPageCustom(Images record, Integer pageNo,Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(imagesMapper.selectByCustom(record));
	}
	@Override
	public int countByColum(Images record) {
		// TODO Auto-generated method stub
		return imagesMapper.countByColum(record);
	}
	@Override
	public List<Images> selectAll(String order){
		PageHelper.orderBy(order);
		return imagesMapper.selectAll();
	}
}
