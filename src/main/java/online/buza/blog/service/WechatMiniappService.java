package online.buza.blog.service;

import online.buza.blog.dto.TbPostDto;

import java.util.List;

public interface WechatMiniappService {

    public List<TbPostDto> getPostListByCodeName(TbPostDto tbPostDto);

}
