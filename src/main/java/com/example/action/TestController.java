package com.example.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.framework.base.BaseController;

@Controller
@RequestMapping(value = "tc")
public class TestController extends BaseController {
	private Logger log = Logger.getLogger(TestController.class);

	@RequestMapping(value = "stat", method = RequestMethod.POST)
	public String stat(@RequestBody List<Map<String, Object>> list) {
		log.info("*********************");
		Map<String, Object> map = new HashMap<String, Object>();
		return this.SUCCESS(map);
	}
}
