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


@Service("piccComplicationService")
public class PiccComplicationServiceImpl implements PiccComplicationService{
	
	@Autowired
	private PiccComplicationMapper piccComplicationMapper;


	@Override
	public int deleteById(String fuid) {
		// TODO Auto-generated method stub
		return piccComplicationMapper.deleteByPrimaryKey(fuid);
	}

	@Override
	public int insert(PiccComplication record) {
		// TODO Auto-generated method stub
		return piccComplicationMapper.insert(record);
	}

	@Override
	public int insertSelective(PiccComplication record) {
		// TODO Auto-generated method stub
		return piccComplicationMapper.insertSelective(record);
	}

	@Override
	public PiccComplication findById(String fuid) {
		// TODO Auto-generated method stub
		return piccComplicationMapper.selectByPrimaryKey(fuid);
	}

	@Override
	public int updateSelective(PiccComplication record) {
		// TODO Auto-generated method stub
		return piccComplicationMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int update(PiccComplication record) {
		// TODO Auto-generated method stub
		return piccComplicationMapper.updateByPrimaryKey(record);
	}
	
	@Override
	public  int deleteByColum(PiccComplication record){
		// TODO Auto-generated method stub
		return piccComplicationMapper.deleteByColum(record);
	}
	
	@Override
	public List<PiccComplication> selectByColum(PiccComplication record,String orderBy) {
		// TODO Auto-generated method stub
		PageHelper.orderBy(orderBy);
		return piccComplicationMapper.selectByColum(record);
	}
	
	@Override
	public int deleteByByPrimaryKeys(List<String> ids){
		// TODO Auto-generated method stub
		return piccComplicationMapper.deleteByByPrimaryKeys(ids);
	}
	
	@Override
	public List<PiccComplication>  selectLikeColum (String columName,String value){
		// TODO Auto-generated method stub
		return piccComplicationMapper.selectLikeColum(columName,value);
	}
	
	@Override
	public PagedResult<PiccComplication> findByPage(PiccComplication record, Integer pageNo,
			Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(piccComplicationMapper.selectByColum(record));
	}

	@Override
	public PagedResult<PiccComplication> findByPageCustom(PiccComplication record, Integer pageNo,Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(piccComplicationMapper.selectByCustom(record));
	}
	@Override
	public int countByColum(PiccComplication record) {
		// TODO Auto-generated method stub
		return piccComplicationMapper.countByColum(record);
	}
	@Override
	public List<PiccComplication> selectAll(String order){
		PageHelper.orderBy(order);
		return piccComplicationMapper.selectAll();
	}
}
