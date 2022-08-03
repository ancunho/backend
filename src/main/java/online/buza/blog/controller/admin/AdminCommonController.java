package online.buza.blog.controller.admin;

import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import online.buza.blog.annotation.AdminUserLogin;
import online.buza.blog.common.BaseRequest;
import online.buza.blog.common.BaseResponse;
import online.buza.blog.dto.SysUserDto;
import online.buza.blog.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/common")
public class AdminCommonController {

    @Autowired
    private AdminUserService adminUserService;

    @AdminUserLogin
    @PostMapping(value = "/user/list")
    public BaseResponse user_list(BaseRequest baseRequest, @RequestBody SysUserDto sysUserDto) {
        PageHelper.startPage(baseRequest.getPage(), baseRequest.getRows());
        List<SysUserDto> lstSysUserDto = adminUserService.selectSysUserDtoByPaging(sysUserDto);
        return BaseResponse.valueOfSuccessList(lstSysUserDto);
    }

}
