package com.mycompany.myapp.view;

import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.OutputStream;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class Ch12FileDownloadView extends AbstractView{

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.info("실행");
		String fileName = (String) model.get("fileName");
		String userAgent = (String) model.get("userAgent");
		
		 //DB에서 가져올 정보
	      String contentType = request.getServletContext().getMimeType(fileName); //파일의 확장명에 따라 리턴을 다르게 한다. 
	      
	      //다운로드 할 파일 이름
	      String originalFilename = fileName;
	      
	      //다운로드 받아서 할 파일 이름 //다운을 하면 다음과 같은 파일이름으로 되어야 한다.
	      String saveFilename = fileName;
	      
	      //응답 내용의 데이터 타입을 응답 헤더에 추가
	      response.setContentType(contentType);
	      
	      //다운로드할 파일명을 헤더에 추가
	      if(userAgent.contains("Trident") || userAgent.contains("MSIE")) {
	         //IE 브라우저일 경우
	         originalFilename = URLEncoder.encode(originalFilename, "UTF-8");
	      } else {
	         //크롬, 엣지, 사파리일 경우
	         originalFilename = new String(originalFilename.getBytes("UTF-8"), "ISO-8859-1");
	      }
	      
	      //attachment를 통해 첨부파일임을 선언한다.
	      response.setHeader("Content-Disposition", "attachment; filename=\"" + originalFilename + "\"");
	      
	      //파일 데이터를 응답 본문에 실기
	      File file = new File("/Users/jbc/Desktop/upload/" + saveFilename);
	      if(file.exists()) {
//	    	 InputStream is = new FileInputStream(file);
//	    	 ServletOutputStream os = response.getOutputStream();
//	    	 
//	    	 //이미지 동영상 등 바이트 단위의 저장 및 전송
//	         FileCopyUtils.copy(new FileInputStream(file), response.getOutputStream());
//	         FileCopyUtils.copy(is, os);
//	         os.flush();
//	         is.close();
//	         os.close();
	    	  //파일 또는 바이너리 데이터를 응답 본문에 넣는다. 
	    	  FileCopyUtils.copy(new FileInputStream(file), response.getOutputStream());
	      }
	}
	
}
