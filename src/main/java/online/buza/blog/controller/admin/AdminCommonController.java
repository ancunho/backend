package online.buza.blog.controller.admin;

import com.github.pagehelper.PageHelper;
import com.google.code.kaptcha.Producer;
import lombok.extern.slf4j.Slf4j;
import online.buza.blog.annotation.AdminUserLogin;
import online.buza.blog.annotation.PassLogin;
import online.buza.blog.common.BaseRequest;
import online.buza.blog.common.BaseResponse;
import online.buza.blog.common.Const;
import online.buza.blog.dto.SysUserDto;
import online.buza.blog.service.AdminUserService;
import online.buza.blog.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api/common")
public class AdminCommonController {

    private AdminUserService adminUserService;
    private Producer producer;
    public RedisUtil redisUtil;

    public AdminCommonController(AdminUserService adminUserService, Producer producer, RedisUtil redisUtil) {
        this.adminUserService = adminUserService;
        this.producer = producer;
        this.redisUtil = redisUtil;
    }

    @PassLogin
    @GetMapping("/captcha")
    public BaseResponse captcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String captchaCode = producer.createText();
        String captchaKey = UUID.randomUUID().toString();

        // For Test
//        code = "code111";
//        captchaKey="key111";

        BufferedImage image = producer.createImage(captchaCode);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", outputStream);
        BASE64Encoder encoder = new BASE64Encoder();
        String str = "data:image/jpeg;base64,";
        String base64Img = str + encoder.encode(outputStream.toByteArray());

        // Redis에 저장
        redisUtil.hset(Const.CAPTCHA_KEY, captchaKey, captchaCode, 120);
        log.info("验证码 -- {} - {}", captchaKey, captchaCode);

        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("captchaCode", captchaCode);
        returnMap.put("captchaKey", captchaKey);
        returnMap.put("base64Img", base64Img);

        return BaseResponse.valueOfSuccess(returnMap);
    }


    @AdminUserLogin
    @PostMapping(value = "/user/list")
    public BaseResponse user_list(BaseRequest baseRequest, @RequestBody SysUserDto sysUserDto) {
        PageHelper.startPage(baseRequest.getPage(), baseRequest.getRows());
        List<SysUserDto> lstSysUserDto = adminUserService.selectSysUserDtoByPaging(sysUserDto);
        return BaseResponse.valueOfSuccessList(lstSysUserDto);
    }

}
