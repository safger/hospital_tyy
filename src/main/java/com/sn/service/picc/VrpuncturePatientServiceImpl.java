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


@Service("vrpuncturePatientService")
public class VrpuncturePatientServiceImpl implements VrpuncturePatientService{
	
	@Autowired
	private VrpuncturePatientMapper vrpuncturePatientMapper;


	@Override
	public int deleteById(String fuid) {
		// TODO Auto-generated method stub
		return vrpuncturePatientMapper.deleteByPrimaryKey(fuid);
	}

	@Override
	public int insert(VrpuncturePatient record) {
		// TODO Auto-generated method stub
		return vrpuncturePatientMapper.insert(record);
	}

	@Override
	public int insertSelective(VrpuncturePatient record) {
		// TODO Auto-generated method stub
		return vrpuncturePatientMapper.insertSelective(record);
	}

	@Override
	public VrpuncturePatient findById(String fuid) {
		// TODO Auto-generated method stub
		return vrpuncturePatientMapper.selectByPrimaryKey(fuid);
	}

	@Override
	public int updateSelective(VrpuncturePatient record) {
		// TODO Auto-generated method stub
		return vrpuncturePatientMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int update(VrpuncturePatient record) {
		// TODO Auto-generated method stub
		return vrpuncturePatientMapper.updateByPrimaryKey(record);
	}
	
	@Override
	public  int deleteByColum(VrpuncturePatient record){
		// TODO Auto-generated method stub
		return vrpuncturePatientMapper.deleteByColum(record);
	}
	
	@Override
	public List<VrpuncturePatient> selectByColum(VrpuncturePatient record,String orderBy) {
		// TODO Auto-generated method stub
		PageHelper.orderBy(orderBy);
		return vrpuncturePatientMapper.selectByColum(record);
	}
	
	@Override
	public int deleteByByPrimaryKeys(List<String> ids){
		// TODO Auto-generated method stub
		return vrpuncturePatientMapper.deleteByByPrimaryKeys(ids);
	}
	
	@Override
	public List<VrpuncturePatient>  selectLikeColum (String columName,String value){
		// TODO Auto-generated method stub
		return vrpuncturePatientMapper.selectLikeColum(columName,value);
	}
	
	@Override
	public PagedResult<VrpuncturePatient> findByPage(VrpuncturePatient record, Integer pageNo,
			Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(vrpuncturePatientMapper.selectByColum(record));
	}

	@Override
	public PagedResult<VrpuncturePatient> findByPageCustom(VrpuncturePatient record, Integer pageNo,Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(vrpuncturePatientMapper.selectByCustom(record));
	}
	@Override
	public int countByColum(VrpuncturePatient record) {
		// TODO Auto-generated method stub
		return vrpuncturePatientMapper.countByColum(record);
	}
	@Override
	public List<VrpuncturePatient> selectAll(String order){
		PageHelper.orderBy(order);
		return vrpuncturePatientMapper.selectAll();
	}
}
