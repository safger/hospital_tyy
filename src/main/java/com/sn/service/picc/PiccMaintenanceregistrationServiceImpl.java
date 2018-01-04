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


@Service("piccMaintenanceregistrationService")
public class PiccMaintenanceregistrationServiceImpl implements PiccMaintenanceregistrationService{
	
	@Autowired
	private PiccMaintenanceregistrationMapper piccMaintenanceregistrationMapper;


	@Override
	public int deleteById(String fuid) {
		// TODO Auto-generated method stub
		return piccMaintenanceregistrationMapper.deleteByPrimaryKey(fuid);
	}

	@Override
	public int insert(PiccMaintenanceregistration record) {
		// TODO Auto-generated method stub
		return piccMaintenanceregistrationMapper.insert(record);
	}

	@Override
	public int insertSelective(PiccMaintenanceregistration record) {
		// TODO Auto-generated method stub
		return piccMaintenanceregistrationMapper.insertSelective(record);
	}

	@Override
	public PiccMaintenanceregistration findById(String fuid) {
		// TODO Auto-generated method stub
		return piccMaintenanceregistrationMapper.selectByPrimaryKey(fuid);
	}

	@Override
	public int updateSelective(PiccMaintenanceregistration record) {
		// TODO Auto-generated method stub
		return piccMaintenanceregistrationMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int update(PiccMaintenanceregistration record) {
		// TODO Auto-generated method stub
		return piccMaintenanceregistrationMapper.updateByPrimaryKey(record);
	}
	
	@Override
	public  int deleteByColum(PiccMaintenanceregistration record){
		// TODO Auto-generated method stub
		return piccMaintenanceregistrationMapper.deleteByColum(record);
	}
	
	@Override
	public List<PiccMaintenanceregistration> selectByColum(PiccMaintenanceregistration record,String orderBy) {
		// TODO Auto-generated method stub
		PageHelper.orderBy(orderBy);
		return piccMaintenanceregistrationMapper.selectByColum(record);
	}
	
	@Override
	public int deleteByByPrimaryKeys(List<String> ids){
		// TODO Auto-generated method stub
		return piccMaintenanceregistrationMapper.deleteByByPrimaryKeys(ids);
	}
	
	@Override
	public List<PiccMaintenanceregistration>  selectLikeColum (PiccMaintenanceregistration record,String orderBy){
		// TODO Auto-generated method stub
		PageHelper.orderBy(orderBy);
		return piccMaintenanceregistrationMapper.selectLikeColum(record);
	}
	
	@Override
	public PagedResult<PiccMaintenanceregistration> findByPage(PiccMaintenanceregistration record, Integer pageNo,
			Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(piccMaintenanceregistrationMapper.selectByColum(record));
	}

	@Override
	public PagedResult<PiccMaintenanceregistration> findByPageCustom(PiccMaintenanceregistration record, Integer pageNo,Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(piccMaintenanceregistrationMapper.selectByCustom(record));
	}
	@Override
	public int countByColum(PiccMaintenanceregistration record) {
		// TODO Auto-generated method stub
		return piccMaintenanceregistrationMapper.countByColum(record);
	}
	@Override
	public List<PiccMaintenanceregistration> selectAll(String order){
		PageHelper.orderBy(order);
		return piccMaintenanceregistrationMapper.selectAll();
	}
}
