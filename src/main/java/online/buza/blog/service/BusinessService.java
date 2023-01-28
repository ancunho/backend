package online.buza.blog.service;

import online.buza.blog.dto.TbClassificationDto;
import online.buza.blog.dto.TbCustomerDto;
import online.buza.blog.dto.TbPostDto;
import online.buza.blog.entity.TbCustomer;

import java.util.List;
import java.util.Map;

public interface BusinessService {

    public TbCustomerDto selectTbCustomerByLogin(TbCustomerDto tbCustomerDto);

    public Boolean existUserName(Map<String, Object> mapParams);

    public Boolean insertSysUser(TbCustomer tbCustomer);

    public Boolean updateSysUser(TbCustomer tbCustomer);

    public TbCustomerDto selectTbCustomerDtoByCustomerUuid(Integer customerId);

    public List<TbPostDto> getAllTbPostListInBusiness(TbPostDto tbPostDto);
    public TbPostDto getPostDetailByUUID(String uuid);

    public List<TbPostDto> getPostListByAnyDepthCategoryId(TbPostDto tbPostDto);

    public List<TbClassificationDto> getTopCategoryByType(TbClassificationDto tbClassificationDto);



}
