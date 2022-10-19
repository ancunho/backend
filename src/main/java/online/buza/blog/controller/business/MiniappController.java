package online.buza.blog.controller.business;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import online.buza.blog.annotation.WechatPassLogin;
import online.buza.blog.common.BaseRequest;
import online.buza.blog.common.BaseResponse;
import online.buza.blog.common.ResponseCode;
import online.buza.blog.dto.TbCollectDto;
import online.buza.blog.dto.TbCommonCodeDto;
import online.buza.blog.dto.TbCustomerDto;
import online.buza.blog.dto.TbPostDto;
import online.buza.blog.entity.TbCollect;
import online.buza.blog.entity.TbCustomer;
import online.buza.blog.service.CommonService;
import online.buza.blog.service.WechatMiniappService;
import online.buza.blog.util.Box;
import online.buza.blog.util.HttpUtility;
import online.buza.blog.util.Util;
import online.buza.blog.util.WechatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Cunho
 * @since 2022.09.14
 */
@Slf4j
@RestController
@RequestMapping(value = "/miniapp/api")
public class MiniappController {

    @Autowired
    private CommonService commonService;

    @Autowired
    private WechatMiniappService wechatMiniappService;

    /**
     * Get openId and sessionKey by code
     * @param code
     * @return openId,sessionKey
     */
    @WechatPassLogin
    @GetMapping(value = "/getOpenId.do")
    public BaseResponse getOpenIdOrSessionKeyByCODE(@RequestParam(value = "code", required = true) String code) {
        JSONObject sessionKeyOrOpenId = WechatUtil.getSessionKeyOrOpenId(code);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("openId", sessionKeyOrOpenId.getString("openid"));
        resultMap.put("sessionKey", sessionKeyOrOpenId.getString("session_key"));

        return BaseResponse.valueOfSuccess(resultMap);
    }


    /**
     * Get Post Category
     * @return
     */
    @WechatPassLogin
    @PostMapping(value = "/getPostCategory.do")
    public BaseResponse getCommonCodeByCodeType() {
        TbCommonCodeDto tbCommonCodeDto = new TbCommonCodeDto();
        tbCommonCodeDto.setCodeType("POST_TYPE");
        List<TbCommonCodeDto> lstCommonCodeByPostType = commonService.getCommonCodeByCodeType(tbCommonCodeDto);
        return BaseResponse.valueOfSuccess(lstCommonCodeByPostType);
    }

    /**
     * Get Post List
     * @param baseRequest
     * @param tbPostDto
     * @return
     */
    @WechatPassLogin
    @PostMapping(value = "/getPostListByCodeName.do")
    public BaseResponse getPostListByCodeName(BaseRequest baseRequest, @RequestBody TbPostDto tbPostDto) {
        PageHelper.startPage(baseRequest.getPage(), baseRequest.getLimit());
        tbPostDto.setPostType(tbPostDto.getPostType());
        List<TbPostDto> lstPost = wechatMiniappService.getPostListByCodeName(tbPostDto);
        return BaseResponse.valueOfSuccessList(lstPost);
    }

    /**
     * Get TbPostDto by postId
     * @param tbPostDto
     * @return
     */
    @WechatPassLogin
    @PostMapping(value = "/getPostDetailByPostId.do")
    public BaseResponse getPostDetailByPostId(@RequestBody TbPostDto tbPostDto) {
        if (Util.isEmpty(tbPostDto.getPostId())) {
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        tbPostDto = wechatMiniappService.getPostDetailByPostId(tbPostDto.getPostId());
        return BaseResponse.valueOfSuccess(tbPostDto);
    }

    /**
     * Insert Collect
     * @param baseRequest
     * @param tbCollectDto
     * @return
     */
    @WechatPassLogin
    @PostMapping(value = "/insertCollecType.do")
    public BaseResponse insertCollectType(BaseRequest baseRequest, @RequestBody TbCollectDto tbCollectDto) {
        if (tbCollectDto == null) {
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        TbCollect tbCollect = new TbCollect();
        tbCollect.setActionType("COLLECT");
        tbCollect.setPostId(tbCollectDto.getPostId());
        tbCollect.setCustomerId(tbCollectDto.getCustomerId());

        boolean isSuccessInsert = wechatMiniappService.insertCollectType(tbCollect);
        if (isSuccessInsert) {
            return BaseResponse.valueOfSuccessMessage(ResponseCode.INSERT_SUCCESS.getDesc());
        }

        return BaseResponse.valueOfFailureMessage(ResponseCode.INSERT_ERROR.getDesc());
    }

    /**
     * Delete collect by postId and customerId
     * @param baseRequest
     * @param tbCollectDto
     * @return
     */
    @WechatPassLogin
    @PostMapping(value = "/deleteCollectTypeByPostIdAndCustomerId.do")
    public BaseResponse deleteCollectTypeByPostIdAndCustomerId(BaseRequest baseRequest, @RequestBody TbCollectDto tbCollectDto) {
        if (tbCollectDto == null || Util.isEmpty(tbCollectDto.getPostId()) || Util.isEmpty(tbCollectDto.getCustomerId())) {
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        boolean isSuccessDelete = wechatMiniappService.deleteCollectTypeByPostIdAndCustomerId(tbCollectDto);
        if (isSuccessDelete) {
            return BaseResponse.valueOfSuccessMessage(ResponseCode.DELETE_SUCCESS.getDesc());
        }

        return BaseResponse.valueOfFailureMessage(ResponseCode.DELETE_ERROR.getDesc());
    }

    /**
     * Get TbCustomerDto by DTO
     * main parameter: openId
     * @param request
     * @param tbCustomerDto
     * @return
     */
    @WechatPassLogin
    @PostMapping(value = "/getCustomerInfoByDto.do")
    public BaseResponse getCustomerInfoByDto(HttpServletRequest request, @RequestBody TbCustomerDto tbCustomerDto) {
        if (Util.isEmpty(tbCustomerDto) || Util.isEmpty(tbCustomerDto.getOpenId())) {
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        TbCustomerDto resultDto = new TbCustomerDto();
        resultDto = wechatMiniappService.getCustomerInfoByDto(tbCustomerDto);
        return BaseResponse.valueOfSuccess(resultDto);
    }

    /**
     *
     * @param request
     * @param tbCustomerDto
     * @return
     */
    @WechatPassLogin
    @PostMapping(value = "/getCustomerInfoById.do")
    public BaseResponse getCustomerInfoById(HttpServletRequest request, @RequestBody TbCustomerDto tbCustomerDto) {
        if (Util.isEmpty(tbCustomerDto) || Util.isEmpty(tbCustomerDto.getOpenId())) {
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        tbCustomerDto = wechatMiniappService.getCustomerInfoById(tbCustomerDto);
        return BaseResponse.valueOfSuccess(tbCustomerDto);
    }

    @WechatPassLogin
    @PostMapping(value = "/proc_customer.do")
    public BaseResponse proc_customer(HttpServletRequest request, @RequestBody TbCustomerDto tbCustomerDto) {
        if (Util.isEmpty(tbCustomerDto)) {
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        try {
            if (Util.isEmpty(tbCustomerDto.getCustomerId())) {
                // Insert New
                TbCustomer tbCustomer = new TbCustomer();
                tbCustomer.setWeixinOpenId(tbCustomerDto.getOpenId());
                tbCustomer.setWeixinUnionId(tbCustomerDto.getWeixinUnionId());
                tbCustomer.setUsername(tbCustomerDto.getUsername());
                tbCustomer.setPassword(tbCustomerDto.getPassword());
                tbCustomer.setMobileNo(tbCustomerDto.getMobileNo());
                tbCustomer.setNickname(tbCustomerDto.getNickName());
                tbCustomer.setGrade(tbCustomerDto.getGrade());
                tbCustomer.setCustomerType(tbCustomerDto.getCustomerType());
                tbCustomer.setRealname(tbCustomerDto.getRealname());
                tbCustomer.setBirthday(tbCustomerDto.getBirthday());
                tbCustomer.setEmail(tbCustomerDto.getEmail());
                tbCustomer.setAvatarUrl(tbCustomerDto.getAvatarUrl());
                tbCustomer.setCountry(tbCustomerDto.getProvince());
                tbCustomer.setCity(tbCustomerDto.getCity());
                tbCustomer.setAddress(tbCustomerDto.getAddress());
                tbCustomer.setStatus(tbCustomerDto.getStatus());
                tbCustomer.setOption01(tbCustomerDto.getOption01());
                tbCustomer.setOption02(tbCustomerDto.getOption02());
                tbCustomer.setOption03(tbCustomerDto.getOption03());
                tbCustomer.setOption04(tbCustomerDto.getOption04());
                tbCustomer.setOption05(tbCustomerDto.getOption05());

                boolean isSuccessInsert = wechatMiniappService.insertTbCustomer(tbCustomer);
                if (isSuccessInsert) {
                    return BaseResponse.valueOfSuccessMessage(ResponseCode.INSERT_SUCCESS.getDesc());
                }
                return BaseResponse.valueOfFailureMessage(ResponseCode.INSERT_ERROR.getDesc());

            } else {
                // Update
                TbCustomer tbCustomer = new TbCustomer();
                tbCustomer.setCustomerId(tbCustomerDto.getCustomerId());
                tbCustomer.setWeixinOpenId(tbCustomerDto.getOpenId());
                tbCustomer.setWeixinUnionId(tbCustomerDto.getWeixinUnionId());
                tbCustomer.setUsername(tbCustomerDto.getUsername());
                tbCustomer.setPassword(tbCustomerDto.getPassword());
                tbCustomer.setMobileNo(tbCustomerDto.getMobileNo());
                tbCustomer.setNickname(tbCustomerDto.getNickName());
                tbCustomer.setGrade(tbCustomerDto.getGrade());
                tbCustomer.setCustomerType(tbCustomerDto.getCustomerType());
                tbCustomer.setRealname(tbCustomerDto.getRealname());
                tbCustomer.setBirthday(tbCustomerDto.getBirthday());
                tbCustomer.setEmail(tbCustomerDto.getEmail());
                tbCustomer.setAvatarUrl(tbCustomerDto.getAvatarUrl());
                tbCustomer.setCountry(tbCustomerDto.getProvince());
                tbCustomer.setCity(tbCustomerDto.getCity());
                tbCustomer.setAddress(tbCustomerDto.getAddress());
                tbCustomer.setStatus(tbCustomerDto.getStatus());
                tbCustomer.setOption01(tbCustomerDto.getOption01());
                tbCustomer.setOption02(tbCustomerDto.getOption02());
                tbCustomer.setOption03(tbCustomerDto.getOption03());
                tbCustomer.setOption04(tbCustomerDto.getOption04());
                tbCustomer.setOption05(tbCustomerDto.getOption05());

                boolean isSuccessUpdate = wechatMiniappService.updateTbCustomer(tbCustomer);
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
