package online.buza.blog.service.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import online.buza.blog.dao.SysUserMapper;
import online.buza.blog.dto.SysUserDto;
import online.buza.blog.entity.SysUser;
import online.buza.blog.service.AdminUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Slf4j
@Getter
@Setter
@AllArgsConstructor
@Service
public class AdminCommonServiceImpl implements AdminUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    /**
     * 登录 - 后台用户
     * @param sysUserDto
     * @return
     */
    public SysUserDto selectSysUserByLogin(SysUserDto sysUserDto) {
        return sysUserMapper.getSysUserByUsernameAndPassword(sysUserDto);
    }

    /**
     * 查看用户是否已经存在
     * @param mapParams
     * @return
     */
    public Boolean existUserName(Map<String, Object> mapParams) {
        Integer existUserName = sysUserMapper.existUserName(mapParams);
        if (existUserName == null) {
            return false; // USERNAME不存在
        }
        return true;
    }

    /**
     * 插入新SysUser对象(注册管理员工)
     * @param sysUser
     * @return
     */
    public Boolean insertSysUser(SysUser sysUser) {
        int insertCount = sysUserMapper.insertSelective(sysUser);
        if (insertCount > 0) {
            return true;
        }
        return false;
    }

    /**
     * 更新用户信息
     * @param sysUser
     * @return
     */
    public Boolean updateSysUser(SysUser sysUser) {
        int updateCount = sysUserMapper.updateByPrimaryKeySelective(sysUser);
        if (updateCount > 0) {
            return true;
        }
        return false;
    }

    /**
     * 获取用户列表
     * @param sysUserDto
     * @return
     */
    public List<SysUserDto> selectSysUserDtoByPaging(SysUserDto sysUserDto) {
        List<SysUserDto> lstSysUserDto = sysUserMapper.getAllSysUserList(sysUserDto);
        return lstSysUserDto;
    }

}
