package online.buza.blog.service;

import online.buza.blog.dto.TbCollectDto;
import online.buza.blog.dto.TbCustomerDto;
import online.buza.blog.dto.TbPostDto;
import online.buza.blog.entity.TbCollect;

import java.util.List;

public interface WechatMiniappService {

    public List<TbPostDto> getPostListByCodeName(TbPostDto tbPostDto);

    public TbPostDto getPostDetailByPostId(Integer postId);

    public Boolean insertCollectType(TbCollect tbCollect);

    public Boolean deleteCollectTypeByCollectId(Integer collectId);

    public Boolean deleteCollectTypeByPostIdAndCustomerId(TbCollectDto tbCollectDto);

    public TbCustomerDto getCustomerInfoByDto(TbCustomerDto tbCustomerDto);

}
