package online.buza.blog.controller.error;

import lombok.extern.slf4j.Slf4j;
import online.buza.blog.annotation.PassLogin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
@RequestMapping("/error")
public class ErrorController {

    @PassLogin
    @RequestMapping(value = {"/401", "/403", "/404"})
    public String error_400(Model model, HttpServletRequest request) {
        return "error/4xx";
    }

    @PassLogin
    @RequestMapping("/500")
    public String error_500(Model model, HttpServletRequest request) {
        return "error/5xx";
    }

}
