package com.sunshareteam.workblog.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.UUID; 
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bigbrotherlee.utils.LeeConstant;
import com.bigbrotherlee.utils.ResponseResult;


/**
 * 文件上传和视频播放用
 */
@RestController
@RequestMapping("/file")
public class FileController {
	public static final String BASE_D="/home/imageserver";
	public static final String BASE_URL="http://image.bigbrotherlee.com";
	
	/**
	 * 文件上传
	 * @param session
	 * @param file 你要上传的文件
	 * @return
	 */
	@RequiresPermissions("file:insert:*")
	@PostMapping(value="/upload")
	public ResponseResult<String>  fileUpload(MultipartFile file) {
		ResponseResult<String> result=new ResponseResult<String>();
		Calendar calendar= Calendar.getInstance();
		String filename="/"+UUID.randomUUID().toString()+file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
		String uri="/"+calendar.get(Calendar.YEAR)+"/"+(calendar.get(Calendar.MONTH)+1)+"/"+calendar.get(Calendar.DAY_OF_MONTH);
		File savedir=new File(BASE_D,uri);
		savedir.mkdirs();
		File savefile=new File(savedir,filename);
		try {
			file.transferTo(savefile);
			result.setData(BASE_URL+uri+filename);
			result.setMessage("保存成功！");
			result.setState(LeeConstant.STATE_SUCCESS);
		} catch (Exception e) {
			result.setState(LeeConstant.STATE_ERROR);
			result.setMessage("保存出错");
		}
		
		return result;
	}
	/**
	 * base64图片上传
	 * @param file 你要上传的文件
	 * @return
	 */
	@RequiresPermissions("file:insert:*")
	@PostMapping(value="/uploadBase64",produces="text/html; charset=UTF-8")
	public ResponseResult<String> uploadBase64(String img){
		ResponseResult<String> result=new ResponseResult<>();
		String slip=img.substring(img.indexOf(",")+1, img.length());
		byte [] b=Base64Utils.decodeFromString(slip);//base64图片转化
		Calendar calendar= Calendar.getInstance();
		String filename="/"+UUID.randomUUID().toString()+".png";
		String uri="/"+calendar.get(Calendar.YEAR)+"/"+(calendar.get(Calendar.MONTH)+1)+"/"+calendar.get(Calendar.DAY_OF_MONTH);
		File savedir=new File(BASE_D,uri);
		savedir.mkdirs();
		File savefile=new File(savedir,filename);
		try {
			OutputStream out=new FileOutputStream(savefile);
			out.write(b);
			out.flush();
			out.close();
			result.setState(LeeConstant.STATE_SUCCESS);
			result.setMessage("保存成功");
			result.setData(BASE_URL+uri+filename);
		} catch (Exception e) {
			result.setState(LeeConstant.STATE_FAIL);
			result.setMessage(e.getMessage());
		}
		return result;
	}
	
	/**
	 * 文件下载，这种化为流的方式可以使视频播放流畅
	 * @param fileurl 你要播放的文件路径
	 */
	@GetMapping("/play")
	public void fileAsStream(String fileurl) {
		
	}
}
