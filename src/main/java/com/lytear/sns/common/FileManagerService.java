package com.lytear.sns.common;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileManagerService {

	
	public final static String FILE_UPLOAD_PATH = "C:\\Users\\01.Web개발\\memo\\upload\\images/";
	
	public static String saveFile(int userId, MultipartFile file) {
		
//		Logger logger = LoggerFactory.getLogger(this.getClass());
		
		String directoryName = userId + "_" + System.currentTimeMillis() + "/";
		
		String filePath = FILE_UPLOAD_PATH + directoryName;
		
		// 디렉토리 생성
		File directory = new File(filePath);
		if(directory.mkdir() == false) {
//			logger.error("[FileManagerService saveFile] 디렉토리 생성 에러");
			return null;
		}
		
		// 실제 파일 저장 과정
		try {
			byte[] bytes = file.getBytes();//file.getBytes(): 실제 들어가 있는 파일 그 자체
			Path path = Paths.get(filePath + file.getOriginalFilename());
			Files.write(path, bytes);//path(경로) 에 bytes(파일) 저장
			
		} catch (IOException e) {
//			logger.error("[FileManagerService saveFile] 파일 생성 실패");;
			e.printStackTrace();
			return null;
		}
		
		return "/images/" + directoryName + file.getOriginalFilename();
		
		
		
	}
	
	
	
}
