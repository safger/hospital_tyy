package com.sn.service.medication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.sn.dao.medication.MedicationReportedMapper;
import com.sn.dao.system.UserMapper;
import com.sn.entity.medication.MedicationReported;
import com.sn.util.BeanUtil;
import com.sn.util.PagedResult;


/**
 * @author xiaofeng
 * @version 1.0
 * @since 1.0
 */


@Service("medicationReportedService")
public class MedicationReportedServiceImpl implements MedicationReportedService{
	
	@Autowired
	private MedicationReportedMapper medicationReportedMapper;

	public MedicationReportedMapper getMedicationReportedMapper() {
		return medicationReportedMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.medicationReportedMapper = medicationReportedMapper;
	} 

	 

	@Override
	public int deleteById(String fuid) {
		// TODO Auto-generated method stub
		return medicationReportedMapper.deleteByPrimaryKey(fuid);
	}

	@Override
	public int insert(MedicationReported record) {
		// TODO Auto-generated method stub
		return medicationReportedMapper.insert(record);
	}

	@Override
	public int insertSelective(MedicationReported record) {
		// TODO Auto-generated method stub
		return medicationReportedMapper.insertSelective(record);
	}

	@Override
	public MedicationReported findById(String fuid) {
		// TODO Auto-generated method stub
		return medicationReportedMapper.selectByPrimaryKey(fuid);
	}

	@Override
	public int updateSelective(MedicationReported record) {
		// TODO Auto-generated method stub
		return medicationReportedMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int update(MedicationReported record) {
		// TODO Auto-generated method stub
		return medicationReportedMapper.updateByPrimaryKey(record);
	}
	
	@Override
	public  int deleteByColum(MedicationReported record){
		// TODO Auto-generated method stub
		return medicationReportedMapper.deleteByColum(record);
	}
	
	@Override
	public List<MedicationReported> selectByColum(MedicationReported record,String orderBy) {
		// TODO Auto-generated method stub
		PageHelper.orderBy(orderBy);
		return medicationReportedMapper.selectByColum(record);
	}
	
	@Override
	public int deleteByByPrimaryKeys(List<String> ids){
		// TODO Auto-generated method stub
		return medicationReportedMapper.deleteByByPrimaryKeys(ids);
	}
	
	@Override
	public List<MedicationReported>  selectLikeColum (String columName,String value){
		// TODO Auto-generated method stub
		return medicationReportedMapper.selectLikeColum(columName,value);
	}
	
	@Override
	public PagedResult<MedicationReported> findByPage(MedicationReported record, Integer pageNo,
			Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(medicationReportedMapper.selectByColum(record));
	}

	@Override
	public PagedResult<MedicationReported> findByPageCustom(MedicationReported record, Integer pageNo,Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(medicationReportedMapper.selectByCustom(record));
	}
	@Override
	public int countByColum(MedicationReported record) {
		// TODO Auto-generated method stub
		return medicationReportedMapper.countByColum(record);
	}
	@Override
	public List<MedicationReported> selectAll(String order){
		PageHelper.orderBy(order);
		return medicationReportedMapper.selectAll();
	}
}
