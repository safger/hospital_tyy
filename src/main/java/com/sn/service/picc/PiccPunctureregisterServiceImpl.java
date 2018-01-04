package com.sn.service.picc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.sn.util.BeanUtil;
import com.sn.util.PagedResult;

 

import java.util.*;
import java.io.IOException;  
 

import com.sn.entity.picc.*;
import com.sn.dao.picc.*;
import com.sn.service.picc.*;  
import com.sn.util.PagedResult;
import com.sn.common.*;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sn.controller.system.CompetenceManager;
import javax.servlet.http.HttpServletRequest;
import com.sn.controller.system.ComData;


/**
 * @author xiaofeng
 * @version 1.0
 * @since 1.0
 */


@Service("piccPunctureregisterService")
public class PiccPunctureregisterServiceImpl implements PiccPunctureregisterService{
	
	@Autowired
	private PiccPunctureregisterMapper piccPunctureregisterMapper;


	@Override
	public int deleteById(String fuid) {
		// TODO Auto-generated method stub
		return piccPunctureregisterMapper.deleteByPrimaryKey(fuid);
	}

	@Override
	public int insert(PiccPunctureregister record) {
		// TODO Auto-generated method stub
		return piccPunctureregisterMapper.insert(record);
	}

	@Override
	public int insertSelective(PiccPunctureregister record) {
		// TODO Auto-generated method stub
		return piccPunctureregisterMapper.insertSelective(record);
	}

	@Override
	public PiccPunctureregister findById(String fuid) {
		// TODO Auto-generated method stub
		return piccPunctureregisterMapper.selectByPrimaryKey(fuid);
	}

	@Override
	public int updateSelective(PiccPunctureregister record) {
		// TODO Auto-generated method stub
		return piccPunctureregisterMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int update(PiccPunctureregister record) {
		// TODO Auto-generated method stub
		return piccPunctureregisterMapper.updateByPrimaryKey(record);
	}
	
	@Override
	public  int deleteByColum(PiccPunctureregister record){
		// TODO Auto-generated method stub
		return piccPunctureregisterMapper.deleteByColum(record);
	}
	
	@Override
	public List<PiccPunctureregister> selectByColum(PiccPunctureregister record,String orderBy) {
		// TODO Auto-generated method stub
		PageHelper.orderBy(orderBy);
		return piccPunctureregisterMapper.selectByColum(record);
	}
	
	@Override
	public int deleteByByPrimaryKeys(List<String> ids){
		// TODO Auto-generated method stub
		return piccPunctureregisterMapper.deleteByByPrimaryKeys(ids);
	}
	
	@Override
	public List<PiccPunctureregister>  selectLikeColum (String columName,String value){
		// TODO Auto-generated method stub
		return piccPunctureregisterMapper.selectLikeColum(columName,value);
	}
	
	@Override
	public PagedResult<PiccPunctureregister> findByPage(PiccPunctureregister record, Integer pageNo,
			Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(piccPunctureregisterMapper.selectByColum(record));
	}

	@Override
	public PagedResult<PiccPunctureregister> findByPageCustom(PiccPunctureregister record, Integer pageNo,Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(piccPunctureregisterMapper.selectByCustom(record));
	}
	@Override
	public int countByColum(PiccPunctureregister record) {
		// TODO Auto-generated method stub
		return piccPunctureregisterMapper.countByColum(record);
	}
	@Override
	public List<PiccPunctureregister> selectAll(String order){
		PageHelper.orderBy(order);
		return piccPunctureregisterMapper.selectAll();
	}
}
