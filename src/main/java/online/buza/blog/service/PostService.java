package online.buza.blog.service;

import online.buza.blog.dto.TbClassificationDto;
import online.buza.blog.dto.TbPostDto;
import online.buza.blog.entity.TbPost;

import java.util.List;

public interface PostService {

    public Boolean insertTbPost(TbPost tbPost);
    public Boolean updateTbPost(TbPost tbPost);
    public List<TbPostDto> getAllTbPostListByTbPost(TbPostDto tbPostDto);
    public TbPostDto getTbPostByPostId(Integer postId);
    public Boolean deleteTbPost(Integer postId);

    public List<TbClassificationDto> getBoardType01ClassificationTree(TbClassificationDto tbClassificationDto);
    public List<TbClassificationDto> buildClassificationTree(List<TbClassificationDto> classificationDtos);

}
