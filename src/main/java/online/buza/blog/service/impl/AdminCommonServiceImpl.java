package online.buza.blog.service.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import online.buza.blog.dao.SysUserMapper;
import online.buza.blog.dao.TbClassificationMapper;
import online.buza.blog.dto.SysUserDto;
import online.buza.blog.dto.TbClassificationDto;
import online.buza.blog.entity.SysUser;
import online.buza.blog.entity.TbClassification;
import online.buza.blog.service.AdminCommonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Slf4j
@Getter
@Setter
@AllArgsConstructor
@Service
public class AdminCommonServiceImpl implements AdminCommonService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private TbClassificationMapper tbClassificationMapper;

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
     * 删除用户信息
     * @param userSeq
     * @return
     */
    public Boolean deleteSysUser(Integer userSeq) {
        int deleteCount = sysUserMapper.deleteByPrimaryKey(userSeq);
        if (deleteCount > 0) {
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

    /**
     * UserSeq로 유저상세정보 가져오기
     * @param userSeq
     * @return
     */
    public SysUserDto selectSysUserDtoByUserSeq(Integer userSeq) {
        return sysUserMapper.selectSysUserDtoByUserSeq(userSeq);
    }

    public List<TbClassificationDto> selectTbClassificationDtoByPaging(TbClassificationDto tbClassificationDto) {
        List<TbClassificationDto> lstTbClassificationDto = tbClassificationMapper.getAllTbClassificationList(tbClassificationDto);
        return lstTbClassificationDto;
    }

    public TbClassificationDto selectTbClassificationDtoByClassificationId(Integer classificaitonId) {
        TbClassificationDto tbClassificationDto = tbClassificationMapper.selectTbClassificationDtoByClassificationId(classificaitonId);
        return tbClassificationDto;
    }

    public Boolean existClassificationName(Map<String, Object> mapParam) {
        Integer existClassificationName = tbClassificationMapper.existClassificationName(mapParam);
        if (existClassificationName == null) {
            return false; // Classification Name 不存在
        }
        return true;
    }


    public Boolean insertTbClassification(TbClassification tbClassification) {
        int insertCount = tbClassificationMapper.insertSelective(tbClassification);
        if (insertCount > 0) {
            return true;
        }
        return false;
    }

    public Boolean updateTbClassification(TbClassification tbClassification) {
        int updateCount = tbClassificationMapper.updateByPrimaryKeySelective(tbClassification);
        if (updateCount > 0) {
            return true;
        }
        return false;
    }

    public Boolean deleteTbClassification(Integer classificationId) {
        int deleteCount = tbClassificationMapper.deleteByPrimaryKey(classificationId);
        if (deleteCount > 0) {
            return true;
        }
        return false;
    }


}
