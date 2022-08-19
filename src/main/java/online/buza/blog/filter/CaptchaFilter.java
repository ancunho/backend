package online.buza.blog.filter;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import online.buza.blog.common.BaseResponse;
import online.buza.blog.common.Const;
import online.buza.blog.exception.CaptchaException;
import online.buza.blog.util.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 图片验证码校验过滤器，在登录过滤器前
 * */
@Slf4j
@Component
public class CaptchaFilter extends OncePerRequestFilter {

    @Autowired
    private RedisUtil redisUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String url = request.getRequestURI();

        if (url.contains(PropertiesUtils.getAdminLoginUrl()) && request.getMethod().equals("POST")) {
            //1. 校验验证码
            try {
                this.validateCaptcha(request);
            } catch (CaptchaException e) {
                //交给认证失败处理器
                response.setContentType("application/json;charset=UTF-8");
                ServletOutputStream outputStream = response.getOutputStream();

                BaseResponse serverResponse = BaseResponse.valueOfFailureMessage(Const.Message.CAPTCHAR_KEY_ERROR);
                outputStream.write(JSONObject.toJSONString(serverResponse).getBytes(StandardCharsets.UTF_8));

                outputStream.flush();
                outputStream.close();
            }
        }

        filterChain.doFilter(request, response);
    }

    private void validateCaptcha(HttpServletRequest request) {
        String captchaCode = request.getParameter("captchaCode");
        String captchaKey = request.getParameter("captchaKey"); //captchaKey

        if (StringUtils.isBlank(captchaCode) || StringUtils.isBlank(captchaKey)) {
            throw new CaptchaException("验证码不能为空");
        }

        if (!captchaCode.equals(redisUtil.hget(Const.CAPTCHA_KEY, captchaKey))) {
            throw new CaptchaException("验证码错误");
        }

        redisUtil.hdel(Const.CAPTCHA_KEY, captchaKey);
    }
}
