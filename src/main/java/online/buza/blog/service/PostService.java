package online.buza.blog.service;

import online.buza.blog.dto.LabelDto;
import online.buza.blog.dto.TbClassificationDto;
import online.buza.blog.dto.TbPostDto;
import online.buza.blog.entity.TbPost;

import java.util.List;
import java.util.Map;

public interface PostService {

    public Boolean insertTbPost(TbPost tbPost);
    public Boolean updateTbPost(TbPost tbPost);
    public List<TbPostDto> getAllTbPostListByTbPost(TbPostDto tbPostDto);
    public TbPostDto getTbPostByPostId(Integer postId);
    public Boolean deleteTbPost(Integer postId);

    public List<TbClassificationDto> getBoardType01ClassificationTree(TbClassificationDto tbClassificationDto);

    public List<TbClassificationDto> buildClassificationTree(List<TbClassificationDto> classificationDtos);

    public List<TbClassificationDto> getClassificationListByTypeCode(Map<String, Object> mapParams);

    public List<LabelDto> buildClassificationTreeOrigin(List<LabelDto> classificationDtos);
    public List<LabelDto> getClassificationListByTypeCode_LabelDTO(Map<String, Object> mapParams);

}
