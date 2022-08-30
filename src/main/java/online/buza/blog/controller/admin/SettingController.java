package online.buza.blog.controller.admin;

import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import online.buza.blog.annotation.AdminUserLogin;
import online.buza.blog.common.BaseRequest;
import online.buza.blog.common.BaseResponse;
import online.buza.blog.common.ResponseCode;
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
@RequestMapping("/api/setting")
public class SettingController {

    @Autowired
    private AdminUserService adminUserService;

    @AdminUserLogin
    @PostMapping(value = "/user/list.do")
    public BaseResponse user_list(BaseRequest baseRequest, @RequestBody SysUserDto sysUserDto) {
        PageHelper.startPage(baseRequest.getPage(), baseRequest.getLimit());
        List<SysUserDto> lstSysUserDto = adminUserService.selectSysUserDtoByPaging(sysUserDto);
        return BaseResponse.valueOfSuccessList(lstSysUserDto);
    }

    @AdminUserLogin
    @PostMapping(value = "/user/detail.do")
    public BaseResponse user_detail_by_user_seq(BaseRequest baseRequest, @RequestBody SysUserDto sysUserDto) {
        if (sysUserDto.getUserSeq() == null || "".equals(String.valueOf(sysUserDto.getUserSeq()))) {
            return BaseResponse.valueOfFailureMessage(ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        SysUserDto sysUserDtoDetail = adminUserService.selectSysUserDtoByUserSeq(sysUserDto.getUserSeq());
        return BaseResponse.valueOfSuccess(sysUserDtoDetail);
    }

    @AdminUserLogin
    @PostMapping(value = "/user/create.do")
    public BaseResponse user_create(BaseRequest baseRequest, @RequestBody SysUserDto sysUserDto) {
        if (sysUserDto == null) {
            return BaseResponse.valueOfFailureMessage(ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        SysUserDto sysUserDtoDetail = adminUserService.selectSysUserDtoByUserSeq(sysUserDto.getUserSeq());
        return BaseResponse.valueOfSuccess(sysUserDtoDetail);
    }




}
