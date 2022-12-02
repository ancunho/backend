package online.buza.blog.controller.business;

import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import online.buza.blog.annotation.BusinessPassLogin;
import online.buza.blog.common.BaseRequest;
import online.buza.blog.common.BaseResponse;
import online.buza.blog.dto.TbPostDto;
import online.buza.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Slf4j
@Controller
@RequestMapping("/business/post")
public class BusinessController {

    @Autowired
    private PostService postService;

    @BusinessPassLogin
    @ResponseBody
    @PostMapping(value = "/list.do")
    public BaseResponse getAllTbPostListByTbPost(BaseRequest baseRequest, @RequestBody TbPostDto tbPostDto) {
        PageHelper.startPage(baseRequest.getPage(), baseRequest.getLimit());
        List<TbPostDto> returnData = postService.getAllTbPostListInBusiness(tbPostDto);
        return BaseResponse.valueOfSuccessList(returnData);
    }



}
