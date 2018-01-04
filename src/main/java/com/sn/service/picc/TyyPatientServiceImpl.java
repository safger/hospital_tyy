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


@Service("tyyPatientService")
public class TyyPatientServiceImpl implements TyyPatientService{
	
	@Autowired
	private TyyPatientMapper tyyPatientMapper;

	 

	@Override
	public int deleteById(String fuid) {
		// TODO Auto-generated method stub
		return tyyPatientMapper.deleteByPrimaryKey(fuid);
	}

	@Override
	public int insert(TyyPatient record) {
		// TODO Auto-generated method stub
		return tyyPatientMapper.insert(record);
	}

	@Override
	public int insertSelective(TyyPatient record) {
		// TODO Auto-generated method stub
		return tyyPatientMapper.insertSelective(record);
	}

	@Override
	public TyyPatient findById(String fuid) {
		// TODO Auto-generated method stub
		return tyyPatientMapper.selectByPrimaryKey(fuid);
	}

	@Override
	public int updateSelective(TyyPatient record) {
		// TODO Auto-generated method stub
		return tyyPatientMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int update(TyyPatient record) {
		// TODO Auto-generated method stub
		return tyyPatientMapper.updateByPrimaryKey(record);
	}
	
	@Override
	public  int deleteByColum(TyyPatient record){
		// TODO Auto-generated method stub
		return tyyPatientMapper.deleteByColum(record);
	}
	
	@Override
	public List<TyyPatient> selectByColum(TyyPatient record,String orderBy) {
		// TODO Auto-generated method stub
		PageHelper.orderBy(orderBy);
		return tyyPatientMapper.selectByColum(record);
	}
	
	@Override
	public int deleteByByPrimaryKeys(List<String> ids){
		// TODO Auto-generated method stub
		return tyyPatientMapper.deleteByByPrimaryKeys(ids);
	}
	
	@Override
	public List<TyyPatient>  selectLikeColum (String columName,String value){
		// TODO Auto-generated method stub
		return tyyPatientMapper.selectLikeColum(columName,value);
	}
	
	@Override
	public PagedResult<TyyPatient> findByPage(TyyPatient record, Integer pageNo,
			Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(tyyPatientMapper.selectByColum(record));
	}

	@Override
	public PagedResult<TyyPatient> findByPageCustom(TyyPatient record, Integer pageNo,Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(tyyPatientMapper.selectByCustom(record));
	}
	@Override
	public int countByColum(TyyPatient record) {
		// TODO Auto-generated method stub
		return tyyPatientMapper.countByColum(record);
	}
	@Override
	public List<TyyPatient> selectAll(String order){
		PageHelper.orderBy(order);
		return tyyPatientMapper.selectAll();
	}
}
