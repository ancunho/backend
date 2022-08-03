package online.buza.blog.controller.common;

import lombok.extern.slf4j.Slf4j;
import online.buza.blog.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/common")
public class CommonController {

    @Autowired
    private CommonService commonService;

}
