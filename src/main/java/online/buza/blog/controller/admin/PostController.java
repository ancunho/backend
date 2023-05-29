package online.buza.blog.controller.admin;

import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import online.buza.blog.annotation.AdminUserLogin;
import online.buza.blog.common.BaseRequest;
import online.buza.blog.common.BaseResponse;
import online.buza.blog.common.ResponseCode;
import online.buza.blog.controller.common.CommonController;
import online.buza.blog.dto.*;
import online.buza.blog.entity.TbPost;
import online.buza.blog.entity.TbPostCategory;
import online.buza.blog.service.PostService;
import online.buza.blog.util.Util;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api/post")
public class PostController extends CommonController {

    @Autowired
    private PostService postService;


    @AdminUserLogin
    @PostMapping(value = "/list.do")
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
    @PostMapping(value = "/proc.do")
    public BaseResponse procTbPostByTbPostDto(HttpServletRequest request, @RequestBody TbPostDto tbPostDto) {
        if (tbPostDto == null || StringUtils.isEmpty(tbPostDto.getPostTitle())) {
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        HttpSession session = request.getSession();
        SysUserDto loginUser = (SysUserDto) session.getAttribute("LOGINED_USER");
        try {
            if (tbPostDto.getPostId() == null || "".equals(tbPostDto.getPostId())) {
                // insert new
                TbPost tbPost = new TbPost();
                tbPost.setPostUuid(Util.generateUUID());
                tbPost.setPostTitle(tbPostDto.getPostTitle());
                tbPost.setPostType(tbPostDto.getPostType());
                tbPost.setPostCategoryId(tbPostDto.getPostCategoryId());
                tbPost.setPostContent(tbPostDto.getPostContent());
                tbPost.setEventStartTime(tbPostDto.getEventStartTime());
                tbPost.setEventEndTime(tbPostDto.getEventEndTime());
                tbPost.setPostThumbnailBig(tbPostDto.getPostThumbnailBig());
                tbPost.setPostThumbnailSmall(tbPostDto.getPostThumbnailSmall());
                tbPost.setPostAuthor(loginUser.getUsername());
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
                tbPost.setPostAuthor(loginUser.getUsername());
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
    @GetMapping(value = "/detail.do")
    public BaseResponse getTbPostByPostId(@RequestParam("postId") Integer postId) {
        if (postId == null) {
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        TbPostDto tbPostDto = postService.getTbPostByPostId(postId);
        return BaseResponse.valueOfSuccess(tbPostDto);
    }

    @AdminUserLogin
    @GetMapping(value = "/delete.do")
    public BaseResponse delete_post(@RequestParam("postId") Integer postId) {
        if (postId == null) {
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        boolean isSuccessDelete = postService.deleteTbPost(postId);
        if (isSuccessDelete) {
            return BaseResponse.valueOfSuccessMessage(ResponseCode.DELETE_SUCCESS.getDesc());
        }
        return BaseResponse.valueOfFailureMessage(ResponseCode.DELETE_ERROR.getDesc());
    }

    @AdminUserLogin
    @PostMapping(value = "/getBlogCategoryTree.do")
    public BaseResponse get_blog_category_list(@RequestBody TbClassificationDto tbClassificationDto) {
        List<TbClassificationDto> classificationDtoList = postService.getBoardType01ClassificationTree(tbClassificationDto);
        List<TbClassificationDto> resultList = postService.buildClassificationTree(classificationDtoList);
        return BaseResponse.valueOfSuccess(resultList);
    }

    @AdminUserLogin
    @PostMapping(value = "/getClassificationListByTypeCode.do")
    public BaseResponse get_category_tree_by_type(@RequestBody TbCommonCodeDto tbCommonCodeDto) {
        Map<String, Object> mapParams = new HashMap<>();
        mapParams.put("codeTypeAndCd", tbCommonCodeDto.getCodeTypeAndCd());
        List<LabelDto> labelDtoList = postService.getClassificationListByTypeCode_LabelDTO(mapParams);
        List<LabelDto> resultList = postService.buildClassificationTreeOrigin(labelDtoList);
        return BaseResponse.valueOfSuccess(resultList);
    }

    @AdminUserLogin
    @PostMapping(value = "/category/list.do")
    public BaseResponse get_post_category_list(@RequestBody TbPostCategoryDto tbPostCategoryDto) {
        List<TbPostCategoryDto> resultList = postService.getPostCategoryList(tbPostCategoryDto);
        return BaseResponse.valueOfSuccess(resultList);
    }


    @AdminUserLogin
    @GetMapping(value = "/category/detail.do")
    public BaseResponse get_post_category_detail_by_id(@RequestParam("postCategoryId") Integer postCategoryId) {
        if (postCategoryId == null) {
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        TbPostCategoryDto tbPostCategoryDto = postService.getPostCategoryDetailById(postCategoryId);
        return BaseResponse.valueOfSuccess(tbPostCategoryDto);
    }

    @AdminUserLogin
    @PostMapping(value = "/category/proc.do")
    public BaseResponse procTbPostCategoryDto(@RequestBody TbPostCategoryDto tbPostCategoryDto) {
        if (tbPostCategoryDto == null || StringUtils.isEmpty(tbPostCategoryDto.getPostCategoryName())) {
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        try {
            if (tbPostCategoryDto.getPostCategoryId() == null || "".equals(tbPostCategoryDto.getPostCategoryId())) {
                // insert new
                TbPostCategory tbPostCategory = new TbPostCategory();
                tbPostCategory.setPostCategoryParentId(tbPostCategoryDto.getPostCategoryParentId());
                tbPostCategory.setPostCategoryName(tbPostCategoryDto.getPostCategoryName());
                tbPostCategory.setPostCategoryDesc(tbPostCategoryDto.getPostCategoryDesc());
                tbPostCategory.setPostCategoryStatus(tbPostCategoryDto.getPostCategoryStatus());
                tbPostCategory.setPostCategorySort(tbPostCategoryDto.getPostCategorySort());
                tbPostCategory.setOption01(tbPostCategoryDto.getOption01());
                tbPostCategory.setOption02(tbPostCategoryDto.getOption02());
                tbPostCategory.setOption03(tbPostCategoryDto.getOption03());
                tbPostCategory.setOption04(tbPostCategoryDto.getOption04());
                tbPostCategory.setOption05(tbPostCategoryDto.getOption05());

                boolean isSuccessInsert = postService.insertTbPostCategory(tbPostCategory);
                if (isSuccessInsert) {
                    return BaseResponse.valueOfSuccessMessage(ResponseCode.INSERT_SUCCESS.getDesc());
                }
                return BaseResponse.valueOfFailureMessage(ResponseCode.INSERT_ERROR.getDesc());
            } else {
                // update
                TbPostCategory tbPostCategory = new TbPostCategory();
                tbPostCategory.setPostCategoryId(tbPostCategoryDto.getPostCategoryId());
                tbPostCategory.setPostCategoryParentId(tbPostCategoryDto.getPostCategoryParentId());
                tbPostCategory.setPostCategoryName(tbPostCategoryDto.getPostCategoryName());
                tbPostCategory.setPostCategoryDesc(tbPostCategoryDto.getPostCategoryDesc());
                tbPostCategory.setPostCategoryStatus(tbPostCategoryDto.getPostCategoryStatus());
                tbPostCategory.setPostCategorySort(tbPostCategoryDto.getPostCategorySort());
                tbPostCategory.setOption01(tbPostCategoryDto.getOption01());
                tbPostCategory.setOption02(tbPostCategoryDto.getOption02());
                tbPostCategory.setOption03(tbPostCategoryDto.getOption03());
                tbPostCategory.setOption04(tbPostCategoryDto.getOption04());
                tbPostCategory.setOption05(tbPostCategoryDto.getOption05());

                boolean isSuccessUpdate = postService.updateTbPostCategory(tbPostCategory);
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




}
