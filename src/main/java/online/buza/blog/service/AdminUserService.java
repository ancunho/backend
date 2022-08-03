package online.buza.blog.service;

import online.buza.blog.dto.SysUserDto;
import online.buza.blog.entity.SysUser;

import java.util.List;
import java.util.Map;

public interface AdminUserService {

    public SysUserDto selectSysUserByLogin(SysUserDto sysUserDto);

    public Boolean existUserName(Map<String, Object> mapParams);
    public Boolean insertSysUser(SysUser sysUser);
    public Boolean updateSysUser(SysUser sysUser);

    public List<SysUserDto> selectSysUserDtoByPaging(SysUserDto sysUserDto);



}
