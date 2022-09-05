package online.buza.blog.controller.admin;

import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import online.buza.blog.annotation.AdminUserLogin;
import online.buza.blog.common.BaseRequest;
import online.buza.blog.common.BaseResponse;
import online.buza.blog.common.ResponseCode;
import online.buza.blog.dto.SysUserDto;
import online.buza.blog.entity.SysUser;
import online.buza.blog.service.AdminCommonService;
import online.buza.blog.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/setting")
public class SettingController {

    @Autowired
    private AdminCommonService adminCommonService;

    /**
     * User Management
     */
    @AdminUserLogin
    @PostMapping(value = "/user/list.do")
    public BaseResponse user_list(BaseRequest baseRequest, @RequestBody SysUserDto sysUserDto) {
        PageHelper.startPage(baseRequest.getPage(), baseRequest.getLimit());
        List<SysUserDto> lstSysUserDto = adminCommonService.selectSysUserDtoByPaging(sysUserDto);
        return BaseResponse.valueOfSuccessList(lstSysUserDto);
    }

    @AdminUserLogin
    @PostMapping(value = "/user/detail.do")
    public BaseResponse user_detail_by_user_seq(BaseRequest baseRequest, @RequestBody SysUserDto sysUserDto) {
        if (sysUserDto.getUserSeq() == null || "".equals(String.valueOf(sysUserDto.getUserSeq()))) {
            return BaseResponse.valueOfFailureMessage(ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        SysUserDto sysUserDtoDetail = adminCommonService.selectSysUserDtoByUserSeq(sysUserDto.getUserSeq());
        return BaseResponse.valueOfSuccess(sysUserDtoDetail);
    }

    @AdminUserLogin
    @PostMapping(value = "/user/modify.do")
    public BaseResponse user_create(BaseRequest baseRequest, @RequestBody SysUserDto sysUserDto) {
        if (StringUtils.isEmpty(sysUserDto.getUsername())) {
            return BaseResponse.valueOfFailureMessage("用户名和姓名必填");
        }

        if (sysUserDto.getUserSeq() == null || "".equals(String.valueOf(sysUserDto.getUserSeq()))) {
            Map<String, Object> mapParams = new HashMap<>();
            mapParams.put("username", sysUserDto.getUsername());
            boolean isExistUsername = adminCommonService.existUserName(mapParams);
            if (isExistUsername) {
                return BaseResponse.valueOfFailureMessage("Username重复,请使用其他用户名");
            }

            SysUser sysUser = new SysUser();
            sysUser.setUsername(sysUserDto.getUsername());
            if (StringUtils.isEmpty(sysUserDto.getPassword())) {
                sysUser.setPassword(MD5Util.MD5EncodeUtf8("g12345678"));
            } else {
                sysUser.setPassword(MD5Util.MD5EncodeUtf8(sysUserDto.getPassword()));
            }
            sysUser.setRoleNo(sysUserDto.getRoleNo());
            sysUser.setRole(sysUserDto.getRole());
            sysUser.setStatus(sysUserDto.getStatus());
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

            boolean isSuccessInsert = adminCommonService.insertSysUser(sysUser);
            if (isSuccessInsert) {
                return BaseResponse.valueOfSuccessMessage(ResponseCode.INSERT_SUCCESS.getDesc());
            }
            return BaseResponse.valueOfFailureMessage(ResponseCode.INSERT_ERROR.getDesc());
        } else {
            Map<String, Object> mapParams = new HashMap<>();
            mapParams.put("username", sysUserDto.getUsername());
            mapParams.put("userSeq", sysUserDto.getUserSeq());
            boolean isExistUsername = adminCommonService.existUserName(mapParams);
            if (isExistUsername) {
                return BaseResponse.valueOfFailureMessage("Username重复,请使用其他用户名");
            }

            SysUser sysUser = new SysUser();
            sysUser.setUserSeq(sysUserDto.getUserSeq());
            sysUser.setUsername(sysUserDto.getUsername());
            sysUser.setPassword(MD5Util.MD5EncodeUtf8(sysUserDto.getPassword()));
            sysUser.setRoleNo(sysUserDto.getRoleNo());
            sysUser.setRole(sysUserDto.getRole());
            sysUser.setStatus(sysUserDto.getStatus());
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

            boolean isSuccessUpdate = adminCommonService.updateSysUser(sysUser);
            if (isSuccessUpdate) {
                return BaseResponse.valueOfSuccessMessage(ResponseCode.SAVE_SUCCESS.getDesc());
            }
            return BaseResponse.valueOfFailureMessage(ResponseCode.SAVE_ERROR.getDesc());
        }

    }

    @AdminUserLogin
    @GetMapping(value = "/user/delete.do")
    public BaseResponse user_delete(BaseRequest baseRequest, Integer userSeq) {
        if (userSeq == null || "".equals(String.valueOf(userSeq))) {
            return BaseResponse.valueOfFailureMessage(ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        boolean isSuccessDelete = adminCommonService.deleteSysUser(userSeq);
        if (isSuccessDelete) {
            return BaseResponse.valueOfSuccessMessage(ResponseCode.DELETE_SUCCESS.getDesc());
        }
        return BaseResponse.valueOfFailureMessage(ResponseCode.DELETE_ERROR.getDesc());
    }

    /**
     * Classification Management
     */



}
