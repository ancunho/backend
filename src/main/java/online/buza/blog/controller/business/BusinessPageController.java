package online.buza.blog.controller.business;

import lombok.extern.slf4j.Slf4j;
import online.buza.blog.annotation.PassLogin;
import online.buza.blog.dto.SysUserDto;
import online.buza.blog.util.Util;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Page URL Controller
 */
@Slf4j
@Controller
@RequestMapping("/")
public class BusinessPageController {

    @PassLogin
    @GetMapping(value = "")
    public String index(Model model, HttpServletRequest request, HttpServletResponse response) {
        return "business/index";
    }

    @PassLogin
    @GetMapping(value = "/post/{postUuid}.ahn")
    public String post_detail(@PathVariable String postUuid, Model model, HttpServletRequest request, HttpServletResponse response) {
        model.addAttribute("postUuid", postUuid);
        return "business/post_detail";
    }

    @PassLogin
    @RequestMapping("/register.ahn")
    public String register(Model model, HttpServletRequest request, HttpServletResponse response) {
        return "register";
    }

    @PassLogin
    @RequestMapping("/login.ahn")
    public String login(Model model, HttpServletRequest request, HttpServletResponse response) {
        model.addAttribute("name", "cunho");
        return "index";
    }

    @PassLogin
    @RequestMapping("/customer/login.ahn")
    public String customer_login(Model model, HttpServletRequest request, HttpServletResponse response) {
        model.addAttribute("name", "cunho");
        return "customer_login";
    }



}
