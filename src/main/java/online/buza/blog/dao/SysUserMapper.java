package online.buza.blog.dao;

import online.buza.blog.dto.SysUserDto;
import online.buza.blog.entity.SysUser;

import java.util.List;
import java.util.Map;

public interface SysUserMapper {

    int deleteByPrimaryKey(Integer userSeq);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer userSeq);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    List<SysUserDto> getAllSysUserList(SysUserDto sysUserDto);

    Integer existUserName(Map<String, Object> mapParams);

    List<SysUserDto> getRoleListByUserSeq(Integer userSeq);

    SysUserDto getSysUserByUsernameAndPassword(SysUserDto sysUserDto);
}