package online.buza.blog.controller.admin;

import lombok.extern.slf4j.Slf4j;
import online.buza.blog.annotation.PassLogin;
import online.buza.blog.common.BaseResponse;
import online.buza.blog.common.ResponseCode;
import online.buza.blog.dao.SysUserMapper;
import online.buza.blog.dto.BaseRequest;
import online.buza.blog.dto.SysUserDto;
import online.buza.blog.entity.SysUser;
import online.buza.blog.service.AdminUserService;
import online.buza.blog.util.MD5Util;
import online.buza.blog.util.Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/")
public class AdminController {

    @Autowired
    private AdminUserService adminUserService;

    @PassLogin
    @PostMapping(value = "/adminLoginProc")
    @ResponseBody
    public BaseResponse login_proc(HttpServletRequest request, @RequestBody SysUserDto sysUserDto) {
        if (sysUserDto.getUsername() == null || "".equals(sysUserDto.getUsername())) {
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        sysUserDto.setPassword(MD5Util.MD5EncodeUtf8(sysUserDto.getPassword()));
        SysUserDto selectedSysUser = adminUserService.selectSysUserByLogin(sysUserDto);
        if (selectedSysUser == null || "".equals(Util.nullempty(selectedSysUser.getUsername()))) {
            return BaseResponse.valueOfFailureMessage("账号名或登录密码不正确");
        } else {
            HttpSession session = request.getSession(true);
            session.setAttribute("LOGINED_USER", selectedSysUser);
            session.setMaxInactiveInterval(60 * 60 * 2); //2Hour

            return BaseResponse.valueOfSuccessMessage("登录成功");
        }

    }

    @PassLogin
    @PostMapping(value = "/adminRegisterProc")
    @ResponseBody
    public BaseResponse register_proc(BaseRequest baseRequest, @RequestBody SysUserDto sysUserDto) {
        if (StringUtils.isEmpty(sysUserDto.getUsername())
                || StringUtils.isEmpty(sysUserDto.getPassword())
        ) {
            return BaseResponse.valueOfFailureMessage("用户名或密码必填");
        }

        Map<String, Object> mapParams = new HashMap<>();
        mapParams.put("username", sysUserDto.getUsername());
        boolean isExistUsername = adminUserService.existUserName(mapParams);
        if (isExistUsername) {
            return BaseResponse.valueOfFailureMessage("Username重复,请使用其他用户名");
        }

        SysUser sysUser = new SysUser();
        sysUser.setUsername(sysUserDto.getUsername());
        sysUser.setPassword(MD5Util.MD5EncodeUtf8(sysUserDto.getPassword()));
        sysUser.setRoleNo(sysUserDto.getRoleNo());
        sysUser.setRole(sysUserDto.getRole());
        sysUser.setStatus("1");
        sysUser.setUserType(sysUserDto.getUserType());
        sysUser.setRealname(sysUserDto.getRealname());
        sysUser.setCompany(sysUserDto.getCompany());
        sysUser.setCompanyType(sysUserDto.getCompanyType());
        sysUser.setMobileNo(sysUserDto.getMobileNo());
        sysUser.setEmail(sysUserDto.getEmail());
        sysUser.setSex(sysUserDto.getSex());
        sysUser.setBirthday(sysUserDto.getBirthday());
        sysUser.setWechat(sysUserDto.getWechat());
        sysUser.setProvinceCode(sysUserDto.getProvinceCode());
        sysUser.setCityCode(sysUserDto.getCityCode());
        sysUser.setDistrictCode(sysUserDto.getDistrictCode());
        sysUser.setAddress(sysUserDto.getAddress());
        sysUser.setQuestion(sysUserDto.getQuestion());
        sysUser.setAnswer(sysUserDto.getAnswer());
        sysUser.setImagePhoto(sysUserDto.getImagePhoto());
        sysUser.setOption01(sysUserDto.getOption01());
        sysUser.setOption02(sysUserDto.getOption02());
        sysUser.setOption03(sysUserDto.getOption03());
        sysUser.setOption04(sysUserDto.getOption04());
        sysUser.setOption05(sysUserDto.getOption05());
        sysUser.setUseYn(sysUserDto.getUseYn());

        boolean isSuccessInsert = adminUserService.insertSysUser(sysUser);
        if (isSuccessInsert) {
            return BaseResponse.valueOfSuccessMessage(ResponseCode.INSERT_SUCCESS.getDesc());
        }
        return BaseResponse.valueOfFailureMessage(ResponseCode.INSERT_ERROR.getDesc());
    }



}
