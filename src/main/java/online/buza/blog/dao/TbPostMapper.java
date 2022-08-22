package online.buza.blog.dao;

import online.buza.blog.dto.TbPostDto;
import online.buza.blog.entity.TbPost;

import java.util.List;

public interface TbPostMapper {
    int deleteByPrimaryKey(Integer postId);

    int insert(TbPost record);

    int insertSelective(TbPost record);

    TbPost selectByPrimaryKey(Integer postId);

    int updateByPrimaryKeySelective(TbPost record);

    int updateByPrimaryKey(TbPost record);

    List<TbPostDto> getAllTbPostListByTbPost(TbPostDto tbPostDto);

    TbPostDto getTbPostByPostId(Integer postId);

}