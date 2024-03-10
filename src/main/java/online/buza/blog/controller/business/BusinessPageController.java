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
//        return "business/index";
        return "business/index_2024";
    }

    @PassLogin
    @GetMapping(value = "/about")
    public String about(Model model, HttpServletRequest request, HttpServletResponse response) {
        return "business/about_2024";
    }

    @PassLogin
    @GetMapping(value = "/service")
    public String service(Model model, HttpServletRequest request, HttpServletResponse response) {
        return "business/service_2024";
    }

    @PassLogin
    @GetMapping(value = "/blog")
    public String blog(Model model, HttpServletRequest request, HttpServletResponse response) {
        return "business/post_list_2024";
    }

    @PassLogin
    @RequestMapping("/contact")
    public String contact(Model model, HttpServletRequest request, HttpServletResponse response) {
        return "business/contact";
    }

    @PassLogin
    @GetMapping(value = "/post/{postUuid}.ahn")
    public String post_detail(@PathVariable String postUuid, Model model, HttpServletRequest request, HttpServletResponse response) {
        model.addAttribute("postUuid", postUuid);
//        return "business/post_detail";
        return "business/post_detail_2024";
    }

    @PassLogin
    @RequestMapping("/register.ahn")
    public String register(Model model, HttpServletRequest request, HttpServletResponse response) {
        return "register";
    }

    @PassLogin
    @RequestMapping("/login.ahn")
    public String login(Model model, HttpServletRequest request, HttpServletResponse response) {
        return "login";
    }

    @PassLogin
    @RequestMapping("/intro.ahn")
    public String intro(Model model, HttpServletRequest request, HttpServletResponse response) {
        return "business/intro";
    }

    @PassLogin
    @RequestMapping("/life.ahn")
    public String life(Model model, HttpServletRequest request, HttpServletResponse response) {
        return "business/life";
    }

    @PassLogin
    @RequestMapping("/customer/login.ahn")
    public String customer_login(Model model, HttpServletRequest request, HttpServletResponse response) {
        model.addAttribute("name", "cunho");
        return "customer_login";
    }



}
