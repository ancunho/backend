package online.buza.blog.controller.business;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import online.buza.blog.annotation.WechatPassLogin;
import online.buza.blog.common.BaseRequest;
import online.buza.blog.common.BaseResponse;
import online.buza.blog.dto.TbCommonCodeDto;
import online.buza.blog.dto.TbPostDto;
import online.buza.blog.service.CommonService;
import online.buza.blog.service.WechatMiniappService;
import online.buza.blog.util.WechatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    @WechatPassLogin
    @PostMapping(value = "/getPostCategory.do")
    public BaseResponse getCommonCodeByCodeType() {
        TbCommonCodeDto tbCommonCodeDto = new TbCommonCodeDto();
        tbCommonCodeDto.setCodeType("POST_TYPE");
        List<TbCommonCodeDto> lstCommonCodeByPostType = commonService.getCommonCodeByCodeType(tbCommonCodeDto);
        return BaseResponse.valueOfSuccess(lstCommonCodeByPostType);
    }

    @WechatPassLogin
    @PostMapping(value = "/getPostListByCodeName.do")
    public BaseResponse getPostListByCodeName(BaseRequest baseRequest, @RequestBody TbPostDto tbPostDto) {
        PageHelper.startPage(baseRequest.getPage(), baseRequest.getLimit());
        tbPostDto.setPostType(tbPostDto.getPostType());
        List<TbPostDto> lstPost = wechatMiniappService.getPostListByCodeName(tbPostDto);
        return BaseResponse.valueOfSuccessList(lstPost);
    }

}
