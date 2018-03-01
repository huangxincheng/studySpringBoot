package com.iba.controller;

import java.io.File;
import java.nio.file.Files;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.iba.entity.FileStatus;

/**
 * 文件上传
 * @Title FileController
 * @Description :
 * @Author: ~琴兽~
 * @Date:2018年2月23日
 */
@Controller
@RequestMapping("/file")
public class FileController {

	
	
	private static final Logger logger = LoggerFactory.getLogger(FileController.class);
	
	@RequestMapping
	public String toPage() {
		return "fileupload/fileupload";
	}
	
	
	@RequestMapping(value = "upload", method = RequestMethod.POST)
	@ResponseBody
	public String upload(@RequestParam(name = "uploadFile", required = true) MultipartFile file) {
		if (file.isEmpty()) {
			return FileStatus.fileIsNull;
		}
		
		// 获取上传的文件名
		String fileName = file.getOriginalFilename();
		logger.info("上传的文件名为:{}", fileName);
		
		// 获取文件的后缀名
		String suffixName = fileName.substring(fileName.lastIndexOf("."));
		logger.info("上传的文件的后缀名为:{}", suffixName);
		
		//防止文件名重复 替换上传的文件名
		String newFileName = UUID.randomUUID() + "." + suffixName;
		
		File storeFile = new File("d:/uploadFile/" + newFileName);
		
		// 判断是否存在父目录 如果不存在则创建 
		if (!storeFile.getParentFile().exists()) {
			storeFile.getParentFile().mkdirs();
		}
		try {
			file.transferTo(storeFile);
			return FileStatus.uploadSuccess;
		} catch (Exception e) {
			logger.error("上传失败", e);
			return FileStatus.uploadError;
		}
	}
	
	@RequestMapping("/index")
	@ResponseBody
	public FileStatus index() {
		return FileStatus.toSuccess(FileStatus.uploadSuccess);
	}
}
