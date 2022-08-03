package online.buza.blog.dao;

import online.buza.blog.dto.SysRoleMenuDto;
import online.buza.blog.entity.SysRoleMenu;

import java.util.List;
import java.util.Map;

public interface SysRoleMenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysRoleMenu record);

    int insertSelective(SysRoleMenu record);

    SysRoleMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRoleMenu record);

    int updateByPrimaryKey(SysRoleMenu record);

    List<SysRoleMenuDto> getSysRoleMenuByRoleId(Integer roleId);

    void deleteSysRoleMenuByRoleId(Integer roleId);

    int insertSysRoleMenuByRoleIdMenuIds(Map<String, Object> mapParams);
}