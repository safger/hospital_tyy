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


@Service("piccComplicationmiddleService")
public class PiccComplicationmiddleServiceImpl implements PiccComplicationmiddleService{
	
	@Autowired
	private PiccComplicationmiddleMapper piccComplicationmiddleMapper;


	@Override
	public int deleteById(String fuid) {
		// TODO Auto-generated method stub
		return piccComplicationmiddleMapper.deleteByPrimaryKey(fuid);
	}

	@Override
	public int insert(PiccComplicationmiddle record) {
		// TODO Auto-generated method stub
		return piccComplicationmiddleMapper.insert(record);
	}

	@Override
	public int insertSelective(PiccComplicationmiddle record) {
		// TODO Auto-generated method stub
		return piccComplicationmiddleMapper.insertSelective(record);
	}

	@Override
	public PiccComplicationmiddle findById(String fuid) {
		// TODO Auto-generated method stub
		return piccComplicationmiddleMapper.selectByPrimaryKey(fuid);
	}

	@Override
	public int updateSelective(PiccComplicationmiddle record) {
		// TODO Auto-generated method stub
		return piccComplicationmiddleMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int update(PiccComplicationmiddle record) {
		// TODO Auto-generated method stub
		return piccComplicationmiddleMapper.updateByPrimaryKey(record);
	}
	
	@Override
	public  int deleteByColum(PiccComplicationmiddle record){
		// TODO Auto-generated method stub
		return piccComplicationmiddleMapper.deleteByColum(record);
	}
	
	@Override
	public List<PiccComplicationmiddle> selectByColum(PiccComplicationmiddle record,String orderBy) {
		// TODO Auto-generated method stub
		PageHelper.orderBy(orderBy);
		return piccComplicationmiddleMapper.selectByColum(record);
	}
	
	@Override
	public int deleteByByPrimaryKeys(List<String> ids){
		// TODO Auto-generated method stub
		return piccComplicationmiddleMapper.deleteByByPrimaryKeys(ids);
	}
	
	@Override
	public List<PiccComplicationmiddle>  selectLikeColum (String columName,String value){
		// TODO Auto-generated method stub
		return piccComplicationmiddleMapper.selectLikeColum(columName,value);
	}
	
	@Override
	public PagedResult<PiccComplicationmiddle> findByPage(PiccComplicationmiddle record, Integer pageNo,
			Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(piccComplicationmiddleMapper.selectByColum(record));
	}

	@Override
	public PagedResult<PiccComplicationmiddle> findByPageCustom(PiccComplicationmiddle record, Integer pageNo,Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(piccComplicationmiddleMapper.selectByCustom(record));
	}
	@Override
	public int countByColum(PiccComplicationmiddle record) {
		// TODO Auto-generated method stub
		return piccComplicationmiddleMapper.countByColum(record);
	}
	@Override
	public List<PiccComplicationmiddle> selectAll(String order){
		PageHelper.orderBy(order);
		return piccComplicationmiddleMapper.selectAll();
	}
}
