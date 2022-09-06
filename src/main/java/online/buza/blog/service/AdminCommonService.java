package online.buza.blog.service;

import online.buza.blog.dto.ClassificationTreeDto;
import online.buza.blog.dto.LabelDto;
import online.buza.blog.dto.SysUserDto;
import online.buza.blog.dto.TbClassificationDto;
import online.buza.blog.entity.SysUser;
import online.buza.blog.entity.TbClassification;

import java.util.List;
import java.util.Map;

public interface AdminCommonService {

    /**
     * Login
     * @param sysUserDto
     * @return
     */
    public SysUserDto selectSysUserByLogin(SysUserDto sysUserDto);

    /**
     * User
     * @param mapParams
     * @return
     */
    public Boolean existUserName(Map<String, Object> mapParams);
    public Boolean insertSysUser(SysUser sysUser);
    public Boolean updateSysUser(SysUser sysUser);
    public Boolean deleteSysUser(Integer userSeq);
    public List<SysUserDto> selectSysUserDtoByPaging(SysUserDto sysUserDto);
    public SysUserDto selectSysUserDtoByUserSeq(Integer userSeq);

    /**
     * Classificaiton
     * @param tbClassificationDto
     * @return
     */
    public List<TbClassificationDto> selectTbClassificationDtoByPaging(TbClassificationDto tbClassificationDto);
    public TbClassificationDto selectTbClassificationDtoByClassificationId(Integer classificaitonId);
    public Boolean existClassificationName(Map<String, Object> mapParam);
    public Boolean insertTbClassification(TbClassification tbClassification);
    public Boolean updateTbClassification(TbClassification tbClassification);
    public Boolean deleteTbClassification(Integer classificationId);
    public List<LabelDto> getClassificationTree(ClassificationTreeDto classificationTreeDto);



}
