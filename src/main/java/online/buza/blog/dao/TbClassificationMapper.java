package online.buza.blog.dao;

import online.buza.blog.dto.TbClassificationDto;
import online.buza.blog.entity.TbClassification;

import java.util.List;
import java.util.Map;

public interface TbClassificationMapper {
    int deleteByPrimaryKey(Integer classificationId);

    int insert(TbClassification record);

    int insertSelective(TbClassification record);

    TbClassification selectByPrimaryKey(Integer classificationId);

    int updateByPrimaryKeySelective(TbClassification record);

    int updateByPrimaryKey(TbClassification record);

    List<TbClassificationDto> getAllTbClassificationList(TbClassificationDto tbClassificationDto);

    TbClassificationDto selectTbClassificationDtoByClassificationId(Integer classificationId);

    Integer existClassificationName(Map<String, Object> mapParams);
}