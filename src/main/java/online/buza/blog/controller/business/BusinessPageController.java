package online.buza.blog.controller.business;

import lombok.extern.slf4j.Slf4j;
import online.buza.blog.annotation.PassLogin;
import online.buza.blog.dto.SysUserDto;
import online.buza.blog.util.Util;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Page URL Controller
 */
@Slf4j
@Controller
@RequestMapping("/business")
public class BusinessPageController {

    @PassLogin
    @GetMapping(value = "/")
    public String index(Model model, HttpServletRequest request, HttpServletResponse response) {
        return "redirect:business/index";
    }

    @PassLogin
    @RequestMapping("/login")
    public String login(Model model, HttpServletRequest request, HttpServletResponse response) {
        model.addAttribute("name", "cunho");
        return "index";
    }

    @PassLogin
    @RequestMapping("/customer/login")
    public String customer_login(Model model, HttpServletRequest request, HttpServletResponse response) {
        model.addAttribute("name", "cunho");
        return "customer_login";
    }



}
