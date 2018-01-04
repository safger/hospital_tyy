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


@Service("piccComplicationtypeService")
public class PiccComplicationtypeServiceImpl implements PiccComplicationtypeService{
	
	@Autowired
	private PiccComplicationtypeMapper piccComplicationtypeMapper;


	@Override
	public int deleteById(String fuid) {
		// TODO Auto-generated method stub
		return piccComplicationtypeMapper.deleteByPrimaryKey(fuid);
	}

	@Override
	public int insert(PiccComplicationtype record) {
		// TODO Auto-generated method stub
		return piccComplicationtypeMapper.insert(record);
	}

	@Override
	public int insertSelective(PiccComplicationtype record) {
		// TODO Auto-generated method stub
		return piccComplicationtypeMapper.insertSelective(record);
	}

	@Override
	public PiccComplicationtype findById(String fuid) {
		// TODO Auto-generated method stub
		return piccComplicationtypeMapper.selectByPrimaryKey(fuid);
	}

	@Override
	public int updateSelective(PiccComplicationtype record) {
		// TODO Auto-generated method stub
		return piccComplicationtypeMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int update(PiccComplicationtype record) {
		// TODO Auto-generated method stub
		return piccComplicationtypeMapper.updateByPrimaryKey(record);
	}
	
	@Override
	public  int deleteByColum(PiccComplicationtype record){
		// TODO Auto-generated method stub
		return piccComplicationtypeMapper.deleteByColum(record);
	}
	
	@Override
	public List<PiccComplicationtype> selectByColum(PiccComplicationtype record,String orderBy) {
		// TODO Auto-generated method stub
		PageHelper.orderBy(orderBy);
		return piccComplicationtypeMapper.selectByColum(record);
	}
	
	@Override
	public int deleteByByPrimaryKeys(List<String> ids){
		// TODO Auto-generated method stub
		return piccComplicationtypeMapper.deleteByByPrimaryKeys(ids);
	}
	
	@Override
	public List<PiccComplicationtype>  selectLikeColum (String columName,String value){
		// TODO Auto-generated method stub
		return piccComplicationtypeMapper.selectLikeColum(columName,value);
	}
	
	@Override
	public PagedResult<PiccComplicationtype> findByPage(PiccComplicationtype record, Integer pageNo,
			Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(piccComplicationtypeMapper.selectByColum(record));
	}

	@Override
	public PagedResult<PiccComplicationtype> findByPageCustom(PiccComplicationtype record, Integer pageNo,Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(piccComplicationtypeMapper.selectByCustom(record));
	}
	@Override
	public int countByColum(PiccComplicationtype record) {
		// TODO Auto-generated method stub
		return piccComplicationtypeMapper.countByColum(record);
	}
	@Override
	public List<PiccComplicationtype> selectAll(String order){
		PageHelper.orderBy(order);
		return piccComplicationtypeMapper.selectAll();
	}

	@Override
	public List<PiccComplicationtype> selectByVin(PiccComplicationmiddle record) {
		// TODO Auto-generated method stub
		return piccComplicationtypeMapper.selectByVin(record);
	}

	@Override
	public List<PiccComplicationtype> selectByView(PiccComplicationtype record) {
		// TODO Auto-generated method stub
		return piccComplicationtypeMapper.selectByView(record);
	}
}
