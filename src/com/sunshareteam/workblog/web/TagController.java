package com.sunshareteam.workblog.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sunshareteam.workblog.service.TagService;

@RestController("/tag")
public class TagController {
//	@Autowired
	private TagService tagService;

	
}
