package com.min.edu;

import java.util.List;

import org.apache.commons.text.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.min.edu.model.service.IBoardService;
import com.min.edu.vo.BoardVo;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private IBoardService service;

	@RequestMapping(value = "/write.do", method = RequestMethod.POST)
	public String write(String content, Model model) {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>> @RequestMapping.POST write : {}",content);
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
	
}
