package com.sn.service.tyy;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.sn.common.UUIDCreater;
import com.sn.dao.system.UserMapper;
import com.sn.dao.tyy.DoctorsMapper;
import com.sn.dao.tyy.ImagesMapper;
import com.sn.entity.tyy.Doctors;
import com.sn.entity.tyy.Images;
import com.sn.util.BeanUtil;
import com.sn.util.PagedResult;


/**
 * @author xiaofeng
 * @version 1.0
 * @since 1.0
 */


@Service("doctorsService")
public class DoctorsServiceImpl implements DoctorsService{
	
	@Autowired
	private DoctorsMapper doctorsMapper;
	@Autowired
	private ImagesMapper imagesMapper;

	public DoctorsMapper getDoctorsMapper() {
		return doctorsMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.doctorsMapper = doctorsMapper;
	} 

	 

	@Override
	public int deleteById(String fuid) {
		// TODO Auto-generated method stub
		return doctorsMapper.deleteByPrimaryKey(fuid);
	}

	@Override
	public int insert(Doctors record) {
		// TODO Auto-generated method stub
		return doctorsMapper.insert(record);
	}

	@Override
	public int insertSelective(Doctors record) {
		// TODO Auto-generated method stub
		
		
		return doctorsMapper.insertSelective(record);
	}

	@Override
	public Doctors findById(String fuid) {
		// TODO Auto-generated method stub
		return doctorsMapper.selectByPrimaryKey(fuid);
	}

	@Override
	public int updateSelective(Doctors record) {
		// TODO Auto-generated method stub
		return doctorsMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int update(Doctors record) {
		// TODO Auto-generated method stub
		return doctorsMapper.updateByPrimaryKey(record);
	}
	
	@Override
	public  int deleteByColum(Doctors record){
		// TODO Auto-generated method stub
		return doctorsMapper.deleteByColum(record);
	}
	
	@Override
	public List<Doctors> selectByColum(Doctors record,String orderBy) {
		// TODO Auto-generated method stub
		PageHelper.orderBy(orderBy);
		return doctorsMapper.selectByColum(record);
	}
	
	@Override
	public int deleteByByPrimaryKeys(List<String> ids){
		// TODO Auto-generated method stub
		return doctorsMapper.deleteByByPrimaryKeys(ids);
	}
	
	@Override
	public List<Doctors>  selectLikeColum (Doctors record,String orderBy){
		// TODO Auto-generated method stub
		PageHelper.orderBy(orderBy);
		return doctorsMapper.selectLikeColum(record);
	}
	
	@Override
	public PagedResult<Doctors> findByPage(Doctors record, Integer pageNo,
			Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(doctorsMapper.selectByColum(record));
	}

	@Override
	public PagedResult<Doctors> findByPageCustom(Doctors record, Integer pageNo,Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(doctorsMapper.selectByCustom(record));
	}
	@Override
	public int countByColum(Doctors record) {
		// TODO Auto-generated method stub
		return doctorsMapper.countByColum(record);
	}
	@Override
	public List<Doctors> selectAll(String order){
		PageHelper.orderBy(order);
		return doctorsMapper.selectAll();
	}

	@Override
	public int insertImgSelective(Doctors record, MultipartFile file1, MultipartFile file2) throws IOException {
		// TODO Auto-generated method stub
		if(file1!=null&&file1.getSize()>0){
			Images images=new Images();
			images.setFuid(UUIDCreater.getUUID());
			images.setCreatedate(new Date());
			images.setModifydate(new Date());
			images.setContent(file1.getBytes());
			images.setOriginalName(file1.getOriginalFilename());
			imagesMapper.insertSelective(images);
			record.setAvatar(images.getFuid());
		}
		if(file2!=null&&file2.getSize()>0){
			Images images=new Images();
			images.setFuid(UUIDCreater.getUUID());
			images.setCreatedate(new Date());
			images.setModifydate(new Date());
			images.setContent(file2.getBytes());
			images.setOriginalName(file2.getOriginalFilename());
			imagesMapper.insertSelective(images);
			record.setPhoto(images.getFuid());
		}
		return doctorsMapper.insertSelective(record);
	}

	@Override
	public int updateImgSelective(Doctors record, MultipartFile file1, MultipartFile file2) throws IOException {
		Doctors doctors=doctorsMapper.selectByPrimaryKey(record.getFuid());
		if(file1!=null&&file1.getSize()>0){
			String fuid1=doctors.getAvatar();
			if(fuid1!=null&&fuid1.length()>0){
				Images images1=imagesMapper.selectByPrimaryKey(fuid1);
				images1.setModifydate(new Date());
				images1.setContent(file1.getBytes());
				images1.setOriginalName(file1.getOriginalFilename());
				record.setAvatar(images1.getFuid());
				imagesMapper.updateByPrimaryKeySelective(images1);
			}else{
				Images images1=new Images();
				images1.setFuid(UUIDCreater.getUUID());
				images1.setCreatedate(new Date());
				images1.setModifydate(new Date());
				images1.setContent(file1.getBytes());
				images1.setOriginalName(file1.getOriginalFilename());
				record.setAvatar(images1.getFuid());
				imagesMapper.insertSelective(images1);
			}
			
		}
		if(file2!=null&&file2.getSize()>0){
			String fuid2=doctors.getPhoto();
			if(fuid2!=null&&fuid2.length()>0){
				Images images2=imagesMapper.selectByPrimaryKey(fuid2);
				images2.setModifydate(new Date());
				images2.setContent(file2.getBytes());
				images2.setOriginalName(file2.getOriginalFilename());
				record.setPhoto(images2.getFuid());
				imagesMapper.updateByPrimaryKeySelective(images2);
			}else{
				Images images2=new Images();
				images2.setFuid(UUIDCreater.getUUID());
				images2.setCreatedate(new Date());
				images2.setModifydate(new Date());
				images2.setContent(file2.getBytes());
				images2.setOriginalName(file2.getOriginalFilename());
				record.setPhoto(images2.getFuid());
				imagesMapper.insertSelective(images2);
			}
			
		}
		 
		return doctorsMapper.updateByPrimaryKeySelective(record);
	}
}
