package online.buza.blog.dao;

import online.buza.blog.dto.TbCustomerDto;
import online.buza.blog.dto.TbPostDto;

import java.util.List;

public interface WechatMapper {

    public List<TbPostDto> getPostListByCodeName(TbPostDto tbPostDto);

    public TbPostDto getPostDetailByPostId(Integer postId);

    TbCustomerDto getCustomerInfoByDto(TbCustomerDto tbCustomerDto);

}
