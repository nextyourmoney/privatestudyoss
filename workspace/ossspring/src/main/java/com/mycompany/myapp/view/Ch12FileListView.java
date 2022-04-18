package com.mycompany.myapp.view;

import java.io.File;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class Ch12FileListView extends AbstractView{

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.info("tlfgod");
		
		//파일의총 개수 및 파일 이름 목록 얻기d
		String fileDir = "/Users/jbc/Desktop/upload/";
		File file = new File(fileDir);
		String[] fileList = file.list(); //파일 안의 이름들을 전부 리스트로 한다.d
		int totalFileNum = fileList.length;
		
		//JSON 응답을 생성하고 보내기
		response.setContentType("application/json; charset=UTF=8");
		
		//{"totlaFileNUm":20, "fileList": ["a", "b", "c"...]}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("totalFileNum", totalFileNum);
		JSONArray jsonArray = new JSONArray();
		for(String fileName: fileList) {
			jsonArray.put(fileName);
		}
		
		jsonObject.put("fileList", jsonArray);
		String json = jsonObject.toString();
		
		//json은 문자열이기 때문에 문자열을 응답에 싣는 과정이 필요하다.
		PrintWriter pw = response.getWriter();
		pw.println(json);
		pw.flush();
		pw.close();
		
	}

}
