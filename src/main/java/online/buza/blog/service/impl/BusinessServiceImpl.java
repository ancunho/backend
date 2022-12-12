package online.buza.blog.service.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import online.buza.blog.dao.TbClassificationMapper;
import online.buza.blog.dao.TbCustomerMapper;
import online.buza.blog.dao.TbPostMapper;
import online.buza.blog.dto.TbClassificationDto;
import online.buza.blog.dto.TbCustomerDto;
import online.buza.blog.dto.TbPostDto;
import online.buza.blog.entity.SysUser;
import online.buza.blog.entity.TbCustomer;
import online.buza.blog.service.BusinessService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Slf4j
@Getter
@Setter
@AllArgsConstructor
@Service
public class BusinessServiceImpl implements BusinessService {

    @Resource
    private TbPostMapper tbPostMapper;

    @Resource
    private TbClassificationMapper tbClassificationMapper;

    @Resource
    private TbCustomerMapper tbCustomerMapper;

    /**
     * 로그인전용
     * @param tbCustomerDto
     * @return
     */
    public TbCustomerDto selectTbCustomerByLogin(TbCustomerDto tbCustomerDto) {
        return tbCustomerMapper.getTbCustomerByUsernameAndPassword(tbCustomerDto);
    }

    /**
     * Username중복체크
     * @param mapParams
     * @return
     */
    public Boolean existUserName(Map<String, Object> mapParams) {
        Integer existUserName = tbCustomerMapper.existUserName(mapParams);
        if (existUserName == null) {
            return false;
        }
        return true;
    }

    /**
     * 新增
     * @param tbCustomer
     * @return
     */
    public Boolean insertSysUser(TbCustomer tbCustomer) {
        int insertCount = tbCustomerMapper.insertSelective(tbCustomer);
        if (insertCount > 0) {
            return true;
        }
        return false;
    }

    /**
     * 更新用户信息
     * @param tbCustomer
     * @return
     */
    public Boolean updateSysUser(TbCustomer tbCustomer) {
        int updateCount = tbCustomerMapper.updateByPrimaryKeySelective(tbCustomer);
        if (updateCount > 0) {
            return true;
        }
        return false;
    }

    /**
     * UUID로 사용자정보가져오기
     * @param customerId
     * @return
     */
    public TbCustomerDto selectTbCustomerDtoByCustomerUuid(Integer customerId) {
        return tbCustomerMapper.selectTbCustomerDtoByCustomerUuid(customerId);
    }

    /**
     *
     * @param tbPostDto
     * @return
     */
    public List<TbPostDto> getAllTbPostListInBusiness(TbPostDto tbPostDto) {
        return tbPostMapper.getAllTbPostListInBusiness(tbPostDto);
    }

    /**
     * UUID로 포스트 상세가져오기
     * @param uuid
     * @return
     */
    public TbPostDto getPostDetailByUUID(String uuid) {
        return tbPostMapper.getPostDetailByUUID(uuid);
    }

    /**
     *
     * @param tbPostDto
     * @return
     */
    public List<TbPostDto> getPostListByAnyDepthCategoryId(TbPostDto tbPostDto) {
        return tbPostMapper.getPostListByAnyDepthCategoryId(tbPostDto);
    }

    public List<TbClassificationDto> getTopCategoryByType(TbClassificationDto tbClassificationDto) {
        return tbClassificationMapper.getTopCategoryByType(tbClassificationDto);
    }

}
