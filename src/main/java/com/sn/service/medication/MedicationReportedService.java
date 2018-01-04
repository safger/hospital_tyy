package com.sn.service.medication;

import java.util.List;

import com.sn.entity.medication.MedicationReported;
import com.sn.util.PagedResult;


/**
 * @author xiaofeng
 * @version 1.0
 * @since 1.0
 */

public interface  MedicationReportedService{ 
	
	public int deleteById(String id);

	public int insert(MedicationReported record);

	public int insertSelective(MedicationReported record);

	public MedicationReported findById(String fuid);

	public int updateSelective(MedicationReported record);

	public int update(MedicationReported record);
    
	public List<MedicationReported> selectByColum(MedicationReported record,String orderBy);
	
	public  int deleteByColum(MedicationReported record);
	
	public int deleteByByPrimaryKeys(List<String> ids);
	
	public List<MedicationReported>  selectLikeColum (String columName,String value);
	
	public PagedResult<MedicationReported> findByPage(MedicationReported record,Integer indexPage,Integer pageSize,String orderBy );
	
	public PagedResult<MedicationReported> findByPageCustom(MedicationReported record, Integer indexPage,Integer pageSize,String orderBy);
	
	public int countByColum(MedicationReported record);
	
	public List<MedicationReported> selectAll(String order);
	
}
