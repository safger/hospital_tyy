package com.sn.controller.tyy;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sn.common.UUIDCreater;
import com.sn.entity.tyy.Images;
import com.sn.service.tyy.ImagesService;
import com.sn.type.Result;

/**
 * @author xiaofeng
 * @version 1.0
 * @since 1.0
 */

@Controller
@RequestMapping("/backstage/images")
public class ImagesController {

	@Autowired
	private ImagesService imagesService;
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpServletResponse response;

	/**
	 * @see 定义接受的时间格式
	 */

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true)); // true:允许输入空值，false:不能为空值
	}

	 
	@RequestMapping("/{id}/showImg")
	@ResponseBody
	public String showImg(@PathVariable String id, Map<String, Object> model) throws IOException {
		Images images = imagesService.findById(id);
		if(images!=null){
            byte[] in2bddd = images.getContent();
            // 将byte[]转为InputStream
            InputStream input = new ByteArrayInputStream(in2bddd);
            response.setContentType("image/jpeg");
            OutputStream outputStream = response.getOutputStream();
            byte[] buffer = new byte[1024];
            int j = -1;
            while ((j = input.read(buffer)) != -1) {
                outputStream.write(buffer, 0, j);
            }
            outputStream.flush();
            outputStream.close();
            input.close();
            outputStream = null;
        }
		return null;
	}

	/**
	 * @see 获得编辑数据
	 * @author xiao
	 * @throws IOException
	 */
	@RequestMapping("getEditData")
	@ResponseBody
	public Result getEditData(String fuid, Map<String, Object> model) throws IOException {
		Result result = new Result();
		Images images = imagesService.findById(fuid);
		model.put("images", images);
		result.setData(model);
		return result;
	}

	/**
	 * @see 执行修改或新增操作
	 * @author xiao
	 * @param skey
	 *            搜索关键字
	 * @param images
	 *            实体参数
	 * @param model
	 * @return 列表显示页
	 * @throws IOException
	 */
	@RequestMapping("edit")
	@ResponseBody
	public Result edit(Images images, Map<String, Object> model) throws IOException {
		Result result = new Result();
		String userid = (String) request.getSession().getAttribute("userid");
		String id = images.getFuid();
		if (id != null && id.length() > 0) {
			imagesService.updateSelective(images);
		} else {
			images.setFuid(UUIDCreater.getUUID());
			images.setCreatedate(new Date());
			imagesService.insertSelective(images);
		}
		return result;
	}

	/**
	 * @deprecated  删除
	 * @author xiao
	 * @return 列表显示页
	 */
	@RequestMapping("delete")
	@ResponseBody
	public Result delete(String fuid) {
		Result result = new Result();
		if (fuid != null && fuid.length() > 0) {
			imagesService.deleteById(fuid);
		}
		return result;
	}

}
