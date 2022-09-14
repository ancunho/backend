package online.buza.blog.controller.business;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import online.buza.blog.common.BaseResponse;
import online.buza.blog.util.WechatUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Cunho
 * @since 2022.09.14
 */
@Slf4j
@RestController
@RequestMapping(value = "/api/miniapp")
public class MiniappController {

    /**
     * Get openId and sessionKey by code
     * @param code
     * @return openId,sessionKey
     */
    @RequestMapping(value = "/getOpenId.do")
    public BaseResponse getOpenIdOrSessionKeyByCODE(@RequestParam(value = "code", required = true) String code) {
        log.info("code:" + code);
        JSONObject sessionKeyOrOpenId = WechatUtil.getSessionKeyOrOpenId(code);

        log.info("openId:" + sessionKeyOrOpenId.getString("openid") + ", session_key:" + sessionKeyOrOpenId.getString("session_key"));

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("openId", sessionKeyOrOpenId.getString("openid"));
        resultMap.put("sessionKey", sessionKeyOrOpenId.getString("session_key"));

        return BaseResponse.valueOfSuccess(resultMap);


    }

}
