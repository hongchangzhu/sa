package com.example.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.bo.User;

@Controller
@RequestMapping(value = "ec")
public class EntryOrJsonController {

	private Logger log = Logger.getLogger(EntryOrJsonController.class);

	/**
	 * 输入为JSON格式的数据的方式 1、@RequestBody 将httpRequest的body绑定到方法参数上
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "annotationParam", method = RequestMethod.POST)
	public ModelAndView annotationParam(@RequestBody User user) {
		ModelAndView mav = new ModelAndView();
		log.info("============" + user);
		mav.setViewName("welcome");
		return mav;
	}

	/**
	 * 输出为JSON格式的数据的方式 1、@ResponseBody的作用是把返回值直接写到HTTP response body里
	 * 
	 * @param session
	 * @return
	 * @throws ServletRequestBindingException
	 */
	@RequestMapping(value = "commonReturnType", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView commonReturnType(HttpSession session) throws ServletRequestBindingException {
		ModelAndView mav = new ModelAndView();
		session.setAttribute("userName", "使用ResponseBody输出！");
		log.info("=================使用ResponseBody输出====================");
		ModelMap modelMap = new ModelMap();
		modelMap.put("mapKey", "mapValue");
		modelMap.addAttribute("attributeKey", "attributeValue");

		mav.addObject("model", modelMap);
		mav.addObject("modelMap", modelMap);
		mav.setViewName("welcome");
		return mav;
	}

	/**
	 * 输出为JSON格式的数据的方式 2、ResponseEntity<?>
	 * 
	 * @return
	 */
	@RequestMapping(value = "annotationReturnType", method = RequestMethod.GET)
	public ResponseEntity<String> annotationReturnType() {
		log.info("=================使用ResponseEntity<?>输出====================");
		HttpHeaders httpHeaders = new HttpHeaders();
		ResponseEntity<String> responseEntity = new ResponseEntity<String>("Hello WY!", httpHeaders, HttpStatus.CREATED);
		return responseEntity;
	}

	/**
	 * 输入 和输出为JSON格式的数据的方式 3、HttpEntity<?> ResponseEntity<?>
	 * 
	 * @param u
	 * @return
	 */
	@RequestMapping(value = "annotationParamsReturn", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> annotationParamsReturn(HttpEntity<User> user) {
		String temp = user.getBody().getUserName();
		ResponseEntity<String> responseResult = new ResponseEntity<String>(temp, HttpStatus.OK);
		return responseResult;
	}

	/**
	 * 
	 * @param request
	 * @param session
	 * @return
	 * @throws ServletRequestBindingException
	 */
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request, HttpSession session) throws ServletRequestBindingException {
		ModelAndView mav = new ModelAndView();
		String userName = request.getParameter("userName");
		String password = ServletRequestUtils.getStringParameter(request, "password");
		log.info("============================\r\n接收到的参数: " + userName + " " + password);
		session.setAttribute("userName", userName);
		mav.setViewName("welcome");
		return mav;
	}
}