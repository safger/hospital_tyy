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


@Service("vmpuncturePatientService")
public class VmpuncturePatientServiceImpl implements VmpuncturePatientService{
	
	@Autowired
	private VmpuncturePatientMapper vmpuncturePatientMapper;


	@Override
	public int deleteById(String fuid) {
		// TODO Auto-generated method stub
		return vmpuncturePatientMapper.deleteByPrimaryKey(fuid);
	}

	@Override
	public int insert(VmpuncturePatient record) {
		// TODO Auto-generated method stub
		return vmpuncturePatientMapper.insert(record);
	}

	@Override
	public int insertSelective(VmpuncturePatient record) {
		// TODO Auto-generated method stub
		return vmpuncturePatientMapper.insertSelective(record);
	}

	@Override
	public VmpuncturePatient findById(String fuid) {
		// TODO Auto-generated method stub
		return vmpuncturePatientMapper.selectByPrimaryKey(fuid);
	}

	@Override
	public int updateSelective(VmpuncturePatient record) {
		// TODO Auto-generated method stub
		return vmpuncturePatientMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int update(VmpuncturePatient record) {
		// TODO Auto-generated method stub
		return vmpuncturePatientMapper.updateByPrimaryKey(record);
	}
	
	@Override
	public  int deleteByColum(VmpuncturePatient record){
		// TODO Auto-generated method stub
		return vmpuncturePatientMapper.deleteByColum(record);
	}
	
	@Override
	public List<VmpuncturePatient> selectByColum(VmpuncturePatient record,String orderBy) {
		// TODO Auto-generated method stub
		PageHelper.orderBy(orderBy);
		return vmpuncturePatientMapper.selectByColum(record);
	}
	
	@Override
	public int deleteByByPrimaryKeys(List<String> ids){
		// TODO Auto-generated method stub
		return vmpuncturePatientMapper.deleteByByPrimaryKeys(ids);
	}
	
	@Override
	public List<VmpuncturePatient>  selectLikeColum (String columName,String value){
		// TODO Auto-generated method stub
		return vmpuncturePatientMapper.selectLikeColum(columName,value);
	}
	
	@Override
	public PagedResult<VmpuncturePatient> findByPage(VmpuncturePatient record, Integer pageNo,
			Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(vmpuncturePatientMapper.selectByColum(record));
	}

	@Override
	public PagedResult<VmpuncturePatient> findByPageCustom(VmpuncturePatient record, Integer pageNo,Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(vmpuncturePatientMapper.selectByCustom(record));
	}
	@Override
	public int countByColum(VmpuncturePatient record) {
		// TODO Auto-generated method stub
		return vmpuncturePatientMapper.countByColum(record);
	}
	@Override
	public List<VmpuncturePatient> selectAll(String order){
		PageHelper.orderBy(order);
		return vmpuncturePatientMapper.selectAll();
	}
}
