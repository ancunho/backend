package online.buza.blog.controller.admin;

import lombok.extern.slf4j.Slf4j;
import online.buza.blog.annotation.AdminUserLogin;
import online.buza.blog.annotation.PassLogin;
import online.buza.blog.common.BaseResponse;
import online.buza.blog.dto.SysUserDto;
import online.buza.blog.util.Util;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Page URL Controller
 */
@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminPageController {

    @PassLogin
    @GetMapping(value = "")
    public String admin(Model model, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(true);
        SysUserDto sysUserDto = (SysUserDto) session.getAttribute("LOGINED_USER");
        
        if (sysUserDto == null || "".equals(Util.nullempty(sysUserDto.getUserSeq()))) {
            return "redirect:/admin/login";
        }
        
        return "redirect:/admin/index";
    }

    @PassLogin
    @RequestMapping(value = "/index")
    public String admin_index(Model model, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(true);
        SysUserDto sysUserDto = (SysUserDto) session.getAttribute("LOGINED_USER");

        if (sysUserDto == null) {
            return "redirect:/admin/login";
        }
        return "admin/index";
    }

    @PassLogin
    @RequestMapping(value = "/login")
    public String admin_login(Model model, HttpServletRequest request, HttpServletResponse response) {
        return "admin/login_new";
    }

    @PassLogin
    @PostMapping(value = "/adminLogoutProc")
    public String admin_logout(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        session.removeAttribute("LOGINED_USER");
        return "redirect:/admin/login";
    }

    @AdminUserLogin
    @RequestMapping(value = "/dashboard")
    public String dashboard(Model model, HttpServletRequest request, HttpServletResponse response) {
        return "admin/dashboard";
    }

    @AdminUserLogin
    @RequestMapping(value = "/customer")
    public String customer(Model model, HttpServletRequest request, HttpServletResponse response) {
        return "admin/customer/index";
    }

    @AdminUserLogin
    @RequestMapping(value = "/post")
    public String post(Model model, HttpServletRequest request, HttpServletResponse response) {
        return "admin/post/index";
    }

    @AdminUserLogin
    @RequestMapping(value = "/post/create")
    public String post_create(Model model, HttpServletRequest request, HttpServletResponse response) {
        return "admin/post/create";
    }

    @AdminUserLogin
    @RequestMapping(value = "/setting")
    public String setting(Model model, HttpServletRequest request, HttpServletResponse response) {
        return "admin/setting/index";
    }


}
