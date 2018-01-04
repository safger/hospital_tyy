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


@Service("vcomplicationPatientService")
public class VcomplicationPatientServiceImpl implements VcomplicationPatientService{
	
	@Autowired
	private VcomplicationPatientMapper vcomplicationPatientMapper;


	@Override
	public int deleteById(String fuid) {
		// TODO Auto-generated method stub
		return vcomplicationPatientMapper.deleteByPrimaryKey(fuid);
	}

	@Override
	public int insert(VcomplicationPatient record) {
		// TODO Auto-generated method stub
		return vcomplicationPatientMapper.insert(record);
	}

	@Override
	public int insertSelective(VcomplicationPatient record) {
		// TODO Auto-generated method stub
		return vcomplicationPatientMapper.insertSelective(record);
	}

	@Override
	public VcomplicationPatient findById(String fuid) {
		// TODO Auto-generated method stub
		return vcomplicationPatientMapper.selectByPrimaryKey(fuid);
	}

	@Override
	public int updateSelective(VcomplicationPatient record) {
		// TODO Auto-generated method stub
		return vcomplicationPatientMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int update(VcomplicationPatient record) {
		// TODO Auto-generated method stub
		return vcomplicationPatientMapper.updateByPrimaryKey(record);
	}
	
	@Override
	public  int deleteByColum(VcomplicationPatient record){
		// TODO Auto-generated method stub
		return vcomplicationPatientMapper.deleteByColum(record);
	}
	
	@Override
	public List<VcomplicationPatient> selectByColum(VcomplicationPatient record,String orderBy) {
		// TODO Auto-generated method stub
		PageHelper.orderBy(orderBy);
		return vcomplicationPatientMapper.selectByColum(record);
	}
	
	@Override
	public int deleteByByPrimaryKeys(List<String> ids){
		// TODO Auto-generated method stub
		return vcomplicationPatientMapper.deleteByByPrimaryKeys(ids);
	}
	
	@Override
	public List<VcomplicationPatient>  selectLikeColum (String columName,String value){
		// TODO Auto-generated method stub
		return vcomplicationPatientMapper.selectLikeColum(columName,value);
	}
	
	@Override
	public PagedResult<VcomplicationPatient> findByPage(VcomplicationPatient record, Integer pageNo,
			Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(vcomplicationPatientMapper.selectByColum(record));
	}

	@Override
	public PagedResult<VcomplicationPatient> findByPageCustom(VcomplicationPatient record, Integer pageNo,Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(vcomplicationPatientMapper.selectByCustom(record));
	}
	@Override
	public int countByColum(VcomplicationPatient record) {
		// TODO Auto-generated method stub
		return vcomplicationPatientMapper.countByColum(record);
	}
	@Override
	public List<VcomplicationPatient> selectAll(String order){
		PageHelper.orderBy(order);
		return vcomplicationPatientMapper.selectAll();
	}
}
