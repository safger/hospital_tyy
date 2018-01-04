package com.sn.dao.medication;

import java.util.List;

import com.sn.entity.medication.MedicationReported;
/**
 * @author xiaofeng
 * @version 1.0
 * @since 1.0
 */



public interface MedicationReportedMapper {
	
	 int deleteByPrimaryKey(String fuid);

	    int insert(MedicationReported record);

	    int insertSelective(MedicationReported record);

	    MedicationReported selectByPrimaryKey(String fuid);

	    int updateByPrimaryKeySelective(MedicationReported record);

	    int updateByPrimaryKey(MedicationReported record);
	    
	    List<MedicationReported> selectByColum(MedicationReported record);
	    
	    int deleteByColum(MedicationReported record);
	 
	    int deleteByByPrimaryKeys(List<String> ids);
	    
	    List<MedicationReported>  selectLikeColum (String columName,String value);
	    
	    List<MedicationReported>  selectByCustom (MedicationReported record);
	    
	    int countByColum(MedicationReported record);
	    
	    List<MedicationReported> selectAll();

}
