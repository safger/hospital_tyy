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


@Service("piccPunctureconsultationService")
public class PiccPunctureconsultationServiceImpl implements PiccPunctureconsultationService{
	
	@Autowired
	private PiccPunctureconsultationMapper piccPunctureconsultationMapper;


	@Override
	public int deleteById(String fuid) {
		// TODO Auto-generated method stub
		return piccPunctureconsultationMapper.deleteByPrimaryKey(fuid);
	}

	@Override
	public int insert(PiccPunctureconsultation record) {
		// TODO Auto-generated method stub
		return piccPunctureconsultationMapper.insert(record);
	}

	@Override
	public int insertSelective(PiccPunctureconsultation record) {
		// TODO Auto-generated method stub
		return piccPunctureconsultationMapper.insertSelective(record);
	}

	@Override
	public PiccPunctureconsultation findById(String fuid) {
		// TODO Auto-generated method stub
		return piccPunctureconsultationMapper.selectByPrimaryKey(fuid);
	}

	@Override
	public int updateSelective(PiccPunctureconsultation record) {
		// TODO Auto-generated method stub
		return piccPunctureconsultationMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int update(PiccPunctureconsultation record) {
		// TODO Auto-generated method stub
		return piccPunctureconsultationMapper.updateByPrimaryKey(record);
	}
	
	@Override
	public  int deleteByColum(PiccPunctureconsultation record){
		// TODO Auto-generated method stub
		return piccPunctureconsultationMapper.deleteByColum(record);
	}
	
	@Override
	public List<PiccPunctureconsultation> selectByColum(PiccPunctureconsultation record,String orderBy) {
		// TODO Auto-generated method stub
		PageHelper.orderBy(orderBy);
		return piccPunctureconsultationMapper.selectByColum(record);
	}
	
	@Override
	public int deleteByByPrimaryKeys(List<String> ids){
		// TODO Auto-generated method stub
		return piccPunctureconsultationMapper.deleteByByPrimaryKeys(ids);
	}
	
	@Override
	public List<PiccPunctureconsultation>  selectLikeColum (String columName,String value){
		// TODO Auto-generated method stub
		return piccPunctureconsultationMapper.selectLikeColum(columName,value);
	}
	
	@Override
	public PagedResult<PiccPunctureconsultation> findByPage(PiccPunctureconsultation record, Integer pageNo,
			Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(piccPunctureconsultationMapper.selectByColum(record));
	}

	@Override
	public PagedResult<PiccPunctureconsultation> findByPageCustom(PiccPunctureconsultation record, Integer pageNo,Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(piccPunctureconsultationMapper.selectByCustom(record));
	}
	@Override
	public int countByColum(PiccPunctureconsultation record) {
		// TODO Auto-generated method stub
		return piccPunctureconsultationMapper.countByColum(record);
	}
	@Override
	public List<PiccPunctureconsultation> selectAll(String order){
		PageHelper.orderBy(order);
		return piccPunctureconsultationMapper.selectAll();
	}
}
