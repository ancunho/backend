package online.buza.blog.dao;

import online.buza.blog.dto.SysMenuDto;
import online.buza.blog.entity.SysMenu;

import java.util.List;
import java.util.Map;

public interface SysMenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);

    public List<SysMenuDto> getAllSysMenuList();

    Integer existMenuName(Map<String, Object> mapParams);

}