package online.buza.blog.controller.business;

import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import online.buza.blog.annotation.BusinessPassLogin;
import online.buza.blog.common.BaseRequest;
import online.buza.blog.common.BaseResponse;
import online.buza.blog.dto.TbClassificationDto;
import online.buza.blog.dto.TbPostDto;
import online.buza.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @BusinessPassLogin
    @ResponseBody
    @GetMapping(value = "/detail/{postUuid}.do")
    public BaseResponse getPostDetailByUUID(BaseRequest baseRequest, @PathVariable(value = "postUuid") String postUuid) {
        TbPostDto returnData = postService.getPostDetailByUUID(postUuid);
        return BaseResponse.valueOfSuccess(returnData);
    }

    @BusinessPassLogin
    @ResponseBody
    @PostMapping(value = "/menu.do")
    public BaseResponse getTopCategoryByType(BaseRequest baseRequest, @RequestBody TbClassificationDto tbClassificationDto) {
        List<TbClassificationDto> returnData = postService.getTopCategoryByType(tbClassificationDto);
        return BaseResponse.valueOfSuccess(returnData);
    }

    @BusinessPassLogin
    @ResponseBody
    @PostMapping(value = "/list_by_category_id.do")
    public BaseResponse getPostListByAnyDepthCategoryId(BaseRequest baseRequest, @RequestBody TbPostDto tbPostDto) {
        PageHelper.startPage(baseRequest.getPage(), baseRequest.getLimit());
        List<TbPostDto> returnData = postService.getPostListByAnyDepthCategoryId(tbPostDto);
        return BaseResponse.valueOfSuccessList(returnData);
    }

}
