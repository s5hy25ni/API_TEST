package com.min.edu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.text.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import com.min.edu.model.service.IBoardService;
import com.min.edu.vo.BoardVo;

@Controller
public class BoardController {
private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private IBoardService service;

	@RequestMapping(value = "/write.do", method = RequestMethod.POST)
	public String write(String content, Model model) {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>> @RequestMapping.POST write : {}",content);
		// 화면에서 가져온 html 데이터를 escappe함 : '<' -> '&lt;'
		String escapedContent = StringEscapeUtils.escapeHtml4(content);
		logger.info(">>>>>>>>>>>>>>>>>>>>>>> @RequestMapping.POST write escapedContent : {}",escapedContent);
		int n = service.insertBoard(escapedContent);
		
		return (n==0)?"list":"redirect:/detail.do?seq="+n;
	}
	
	@RequestMapping(value="/boardList.do", method = RequestMethod.GET)
	public String boardList(Model model) {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>> @RequestMapping.GET boardList");
		List<BoardVo> list = service.getList();
		model.addAttribute("list", list);
		return "list";
	}
	
	@RequestMapping(value="/detail.do", method = RequestMethod.GET)
	public String detail(String seq, Model model) {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>> @RequestMapping.GET detail : {}",seq);
		String content = service.getDetail(seq);
		logger.info(">>>>>>>>>>>>>>>>>>>>>>> @RequestMapping.GET detail service.getDetail : {}", content);
		// escaped된 html을 다시 원본으로 변경
		String unescapedContent = StringEscapeUtils.unescapeHtml4(content);
		model.addAttribute("content",unescapedContent);
		model.addAttribute("seq",seq);
		return "detail";
	}
	
	@RequestMapping(value="/updateForm.do", method = RequestMethod.GET)
	public String updateForm(String seq, Model model) {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>> @RequestMapping.GET updateForm : {}",seq);
		model.addAttribute("seq",seq);		
		return "updateForm";
	}
	
	@RequestMapping(value="/getContent.do", method = RequestMethod.POST, produces = "text/html; charset=UTF-8")
	@ResponseBody
	public String getContent(String seq) {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>> @RequestMapping.POST getContent : {}",seq);
		String content = service.getDetail(seq);
		String unescapedContent = StringEscapeUtils.unescapeHtml4(content);
		
		return unescapedContent;
	}
	
	@RequestMapping(value="/updateBoard.do", method = RequestMethod.POST)
	public String updateBoard(BoardVo vo) {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>> @RequestMapping.POST updateBoard : {}",vo);
		service.updateBoard(vo);
		return "redirect:/detail.do?seq="+vo.getSeq();
	}
	
	@RequestMapping(value="/uploadImage.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> uploadImage(MultipartFile upload, HttpServletRequest req) {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>> @RequestMapping.POST uploadImage : {}",upload);
		
		String ext = upload.getOriginalFilename().substring(upload.getOriginalFilename().lastIndexOf("."));
		String saveName = UUID.randomUUID().toString().replace("-", "")+ext;
		
		InputStream inputStream = null;
		OutputStream outputStream = null;
		String path="";
		
		try {
			// 파일읽기
			inputStream = upload.getInputStream();
			
			// 저장 위치 문자열 만들기(상대경로)
			path = WebUtils.getRealPath(req.getSession().getServletContext(),"/ckupload");
			System.out.println(path);
			
			// 저장 위치가 존재하지 않으면 폴더 생성
			File storage = new File(path);
			if(!storage.exists()) {
				storage.mkdir();
			}
			
			// 저장할 파일이 해당 위치에 없다면 만들어주고 아니면 오버라이드 함
			File newFile = new File(path+"/"+saveName);
			if(!newFile.exists()) {
				newFile.createNewFile();
			}
			
			// client에서 받아온 파일(upload)를 쓸 대상(newFile) 지정
			outputStream = new FileOutputStream(newFile);
			
			// 파일(upload)를 읽어 대상(newFile)에 씀
			int read = 0;
			byte[] b = new byte[(int)upload.getSize()];
			while((read=inputStream.read(b))!=-1) {
				outputStream.write(b,0,read);
			}
			
		} catch (IOException e) {
			logger.error("!!!!!!!!!!!!!!!! uploadImage read Error : \n"+e.getMessage());
		} finally {
				try {
					inputStream.close();
					outputStream.close();
				} catch (IOException e) {
					logger.error("!!!!!!!!!!!!!!!! uploadImage close Error : \n"+e.getMessage());
					e.printStackTrace();
				}
		}
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("url", "./ckupload/"+saveName);
		
		return map;
	}
	
	@RequestMapping(value="/removeImage.do", method = RequestMethod.POST)
	@ResponseBody
	public void removeImage(String saveName, HttpServletRequest req) {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>> @RequestMapping.POST removeImage : {}", saveName);		
		
		String path = "";
		
		try {
			path = WebUtils.getRealPath(req.getSession().getServletContext(),"/ckupload");
			File oldFile = new File(path+"/"+saveName);
			// 파일이 존재하면 삭제
			if(oldFile.exists()) {
				oldFile.delete();
			}
		} catch (FileNotFoundException e) {
			logger.error("!!!!!!!!!!!!!!!! removeImage Error : \n"+e.getMessage());
		}
	}
}
