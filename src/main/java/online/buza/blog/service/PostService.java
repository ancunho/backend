package online.buza.blog.service;

import online.buza.blog.dto.LabelDto;
import online.buza.blog.dto.TbClassificationDto;
import online.buza.blog.dto.TbPostCategoryDto;
import online.buza.blog.dto.TbPostDto;
import online.buza.blog.entity.TbPost;
import online.buza.blog.entity.TbPostCategory;

import java.util.List;
import java.util.Map;

public interface PostService {

    Boolean insertTbPost(TbPost tbPost);
    Boolean updateTbPost(TbPost tbPost);
    List<TbPostDto> getAllTbPostListByTbPost(TbPostDto tbPostDto);
    TbPostDto getTbPostByPostId(Integer postId);
    Boolean deleteTbPost(Integer postId);

    List<TbClassificationDto> getBoardType01ClassificationTree(TbClassificationDto tbClassificationDto);

    List<TbClassificationDto> buildClassificationTree(List<TbClassificationDto> classificationDtos);

    List<TbClassificationDto> getClassificationListByTypeCode(Map<String, Object> mapParams);

    List<LabelDto> buildClassificationTreeOrigin(List<LabelDto> classificationDtos);
    List<LabelDto> getClassificationListByTypeCode_LabelDTO(Map<String, Object> mapParams);

    List<TbPostCategoryDto> getPostCategoryList(TbPostCategoryDto tbPostCategoryDto);

    Boolean insertTbPostCategory(TbPostCategory tbPostCategory);
    Boolean updateTbPostCategory(TbPostCategory tbPostCategory);


    TbPostCategoryDto getPostCategoryDetailById(Integer postCategoryId);
}
