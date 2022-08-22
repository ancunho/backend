package online.buza.blog.controller.admin;

import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import online.buza.blog.annotation.AdminUserLogin;
import online.buza.blog.common.BaseRequest;
import online.buza.blog.common.BaseResponse;
import online.buza.blog.common.ResponseCode;
import online.buza.blog.controller.common.CommonController;
import online.buza.blog.dto.TbPostDto;
import online.buza.blog.entity.TbPost;
import online.buza.blog.service.PostService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/post")
public class PostController extends CommonController {

    @Autowired
    private PostService postService;

    @AdminUserLogin
    @PostMapping(value = "/list")
    public BaseResponse getAllTbPostListByTbPost(BaseRequest baseRequest, @RequestBody TbPostDto tbPostDto) {
        PageHelper.startPage(baseRequest.getPage(), baseRequest.getLimit());
        List<TbPostDto> returnData = postService.getAllTbPostListByTbPost(tbPostDto);
        return BaseResponse.valueOfSuccessList(returnData);
    }

    /**
     * postId => 없으면 Insert
     * postId => 있으면 Update
     * @param request
     * @param tbPostDto
     * @return
     */
    @AdminUserLogin
    @PostMapping(value = "/proc")
    public BaseResponse procTbPostByTbPostDto(HttpServletRequest request, @RequestBody TbPostDto tbPostDto) {
        if (tbPostDto == null
                || StringUtils.isEmpty(tbPostDto.getPostTitle())
                || StringUtils.isEmpty(tbPostDto.getPostType())
        ) {
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        try {
            if (tbPostDto.getPostId() == null || "".equals(tbPostDto.getPostId())) {
                // insert new
                TbPost tbPost = new TbPost();
                tbPost.setPostTitle(tbPostDto.getPostTitle());
                tbPost.setPostType(tbPostDto.getPostType());
                tbPost.setPostCategoryId(tbPostDto.getPostCategoryId());
                tbPost.setPostContent(tbPostDto.getPostContent());
                tbPost.setEventStartTime(tbPostDto.getEventStartTime());
                tbPost.setEventEndTime(tbPostDto.getEventEndTime());
                tbPost.setPostThumbnailBig(tbPostDto.getPostThumbnailBig());
                tbPost.setPostThumbnailSmall(tbPostDto.getPostThumbnailSmall());
                tbPost.setPostAuthor("username");
                tbPost.setIsJoin(tbPostDto.getIsJoin());
                tbPost.setIsNeedPay(tbPostDto.getIsNeedPay());
                tbPost.setPostPrice(tbPostDto.getPostPrice());
                tbPost.setStatus(tbPostDto.getStatus());
                tbPost.setOption01(tbPostDto.getOption01());
                tbPost.setOption02(tbPostDto.getOption02());
                tbPost.setOption03(tbPostDto.getOption03());
                tbPost.setOption04(tbPostDto.getOption04());
                tbPost.setOption05(tbPostDto.getOption05());

                boolean isSuccessInsert = postService.insertTbPost(tbPost);
                if (isSuccessInsert) {
                    return BaseResponse.valueOfSuccessMessage(ResponseCode.INSERT_SUCCESS.getDesc());
                }
                return BaseResponse.valueOfFailureMessage(ResponseCode.INSERT_ERROR.getDesc());
            } else {
                // update
                TbPost tbPost = new TbPost();
                tbPost.setPostId(tbPostDto.getPostId());
                tbPost.setPostTitle(tbPostDto.getPostTitle());
                tbPost.setPostType(tbPostDto.getPostType());
                tbPost.setPostCategoryId(tbPostDto.getPostCategoryId());
                tbPost.setPostContent(tbPostDto.getPostContent());
                tbPost.setEventStartTime(tbPostDto.getEventStartTime());
                tbPost.setEventEndTime(tbPostDto.getEventEndTime());
                tbPost.setPostThumbnailBig(tbPostDto.getPostThumbnailBig());
                tbPost.setPostThumbnailSmall(tbPostDto.getPostThumbnailSmall());
                tbPost.setPostAuthor(tbPostDto.getPostAuthor());
                tbPost.setIsJoin(tbPostDto.getIsJoin());
                tbPost.setIsNeedPay(tbPostDto.getIsNeedPay());
                tbPost.setPostPrice(tbPostDto.getPostPrice());
                tbPost.setStatus(tbPostDto.getStatus());
                tbPost.setOption01(tbPostDto.getOption01());
                tbPost.setOption02(tbPostDto.getOption02());
                tbPost.setOption03(tbPostDto.getOption03());
                tbPost.setOption04(tbPostDto.getOption04());
                tbPost.setOption05(tbPostDto.getOption05());

                boolean isSuccessUpdate = postService.updateTbPost(tbPost);
                if (isSuccessUpdate) {
                    return BaseResponse.valueOfSuccessMessage(ResponseCode.SAVE_SUCCESS.getDesc());
                }
                return BaseResponse.valueOfFailureMessage(ResponseCode.SAVE_ERROR.getDesc());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResponse.valueOfFailureMessage(ResponseCode.SAVE_ERROR.getDesc());
        }
    }

    @AdminUserLogin
    @GetMapping(value = "/info")
    public BaseResponse getTbPostByPostId(@RequestParam("postId") Integer postId) {
        if (postId == null) {
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        TbPostDto tbPostDto = postService.getTbPostByPostId(postId);
        return BaseResponse.valueOfSuccess(tbPostDto);

    }

}
