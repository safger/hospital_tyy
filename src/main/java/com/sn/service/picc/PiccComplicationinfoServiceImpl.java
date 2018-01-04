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


@Service("piccComplicationinfoService")
public class PiccComplicationinfoServiceImpl implements PiccComplicationinfoService{
	
	@Autowired
	private PiccComplicationinfoMapper piccComplicationinfoMapper;


	@Override
	public int deleteById(String fuid) {
		// TODO Auto-generated method stub
		return piccComplicationinfoMapper.deleteByPrimaryKey(fuid);
	}

	@Override
	public int insert(PiccComplicationinfo record) {
		// TODO Auto-generated method stub
		return piccComplicationinfoMapper.insert(record);
	}

	@Override
	public int insertSelective(PiccComplicationinfo record) {
		// TODO Auto-generated method stub
		return piccComplicationinfoMapper.insertSelective(record);
	}

	@Override
	public PiccComplicationinfo findById(String fuid) {
		// TODO Auto-generated method stub
		return piccComplicationinfoMapper.selectByPrimaryKey(fuid);
	}

	@Override
	public int updateSelective(PiccComplicationinfo record) {
		// TODO Auto-generated method stub
		return piccComplicationinfoMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int update(PiccComplicationinfo record) {
		// TODO Auto-generated method stub
		return piccComplicationinfoMapper.updateByPrimaryKey(record);
	}
	
	@Override
	public  int deleteByColum(PiccComplicationinfo record){
		// TODO Auto-generated method stub
		return piccComplicationinfoMapper.deleteByColum(record);
	}
	
	@Override
	public List<PiccComplicationinfo> selectByColum(PiccComplicationinfo record,String orderBy) {
		// TODO Auto-generated method stub
		PageHelper.orderBy(orderBy);
		return piccComplicationinfoMapper.selectByColum(record);
	}
	
	@Override
	public int deleteByByPrimaryKeys(List<String> ids){
		// TODO Auto-generated method stub
		return piccComplicationinfoMapper.deleteByByPrimaryKeys(ids);
	}
	
	@Override
	public List<PiccComplicationinfo>  selectLikeColum (String columName,String value){
		// TODO Auto-generated method stub
		return piccComplicationinfoMapper.selectLikeColum(columName,value);
	}
	
	@Override
	public PagedResult<PiccComplicationinfo> findByPage(PiccComplicationinfo record, Integer pageNo,
			Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(piccComplicationinfoMapper.selectByColum(record));
	}

	@Override
	public PagedResult<PiccComplicationinfo> findByPageCustom(PiccComplicationinfo record, Integer pageNo,Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(piccComplicationinfoMapper.selectByCustom(record));
	}
	@Override
	public int countByColum(PiccComplicationinfo record) {
		// TODO Auto-generated method stub
		return piccComplicationinfoMapper.countByColum(record);
	}
	@Override
	public List<PiccComplicationinfo> selectAll(String order){
		PageHelper.orderBy(order);
		return piccComplicationinfoMapper.selectAll();
	}
}
