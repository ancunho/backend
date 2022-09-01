package online.buza.blog.controller.admin;

import lombok.extern.slf4j.Slf4j;
import online.buza.blog.annotation.AdminUserLogin;
import online.buza.blog.annotation.PassLogin;
import online.buza.blog.common.BaseResponse;
import online.buza.blog.dto.SysUserDto;
import online.buza.blog.util.Box;
import online.buza.blog.util.HttpUtility;
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
            return "redirect:/admin/login.ahn";
        }
        
        return "redirect:/admin/index.ahn";
    }

    @PassLogin
    @RequestMapping(value = "/index.ahn")
    public String admin_index(Model model, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(true);
        SysUserDto sysUserDto = (SysUserDto) session.getAttribute("LOGINED_USER");

        if (sysUserDto == null) {
            return "redirect:/admin/login.ahn";
        }
        return "admin/index";
    }

    @PassLogin
    @RequestMapping(value = "/login.ahn")
    public String admin_login(Model model, HttpServletRequest request, HttpServletResponse response) {
        return "admin/login_new_new_new";
    }

    @PassLogin
    @PostMapping(value = "/adminLogoutProc.do")
    public String admin_logout(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        session.removeAttribute("LOGINED_USER");
        return "redirect:/admin/login.ahn";
    }

    @AdminUserLogin
    @RequestMapping(value = "/dashboard.ahn")
    public String dashboard(Model model, HttpServletRequest request, HttpServletResponse response) {
        return "admin/dashboard";
    }

    @AdminUserLogin
    @RequestMapping(value = "/customer.ahn")
    public String customer(Model model, HttpServletRequest request, HttpServletResponse response) {
        return "admin/customer/index";
    }

    @AdminUserLogin
    @RequestMapping(value = "/post.ahn")
    public String post(Model model, HttpServletRequest request, HttpServletResponse response) {
        return "admin/post/index";
    }

    @AdminUserLogin
    @RequestMapping(value = "/post/create.ahn")
    public String post_create(Model model, HttpServletRequest request, HttpServletResponse response) {
        Box box = HttpUtility.getBox(request);
        model.addAttribute("postId", box.get("postId"));
        return "admin/post/modify";
    }

    /**
     * 설정 페이지 메인 - 사용자관리
     * @param model
     * @param request
     * @param response
     * @return
     */
    @AdminUserLogin
    @RequestMapping(value = "/setting.ahn")
    public String setting(Model model, HttpServletRequest request, HttpServletResponse response) {
        return "admin/setting/index";
    }

    /**
     * 설정 - 공통코드관리 페이지
     * @param model
     * @param request
     * @param response
     * @return
     */
    @AdminUserLogin
    @RequestMapping(value = "/setting/common_code.ahn")
    public String setting_common_code(Model model, HttpServletRequest request, HttpServletResponse response) {
        return "admin/setting/common_code";
    }




}
