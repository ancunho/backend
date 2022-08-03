package online.buza.blog.controller.business;

import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.extern.slf4j.Slf4j;
import online.buza.blog.annotation.AdminUserLogin;
import online.buza.blog.annotation.PassLogin;
import online.buza.blog.annotation.UserLogin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Controller
@RequestMapping("/")
public class BusinessController {

    /**
     *
     * @PassLogin 로그인 패스
     * @UserLogin 고객로그인필요
     * @AdminUserLogin 관리자로그인필요
     */

    /**
     * 비즈니스 - 메인
     * @param model
     * @param request
     * @param response
     * @return
     */
    @PassLogin
    @GetMapping(value = "/business/index")
    public String index(Model model, HttpServletRequest request, HttpServletResponse response) {
        return "business/index";
    }




}
