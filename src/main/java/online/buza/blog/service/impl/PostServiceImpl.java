package online.buza.blog.service.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import online.buza.blog.dao.TbClassificationMapper;
import online.buza.blog.dao.TbPostMapper;
import online.buza.blog.dto.LabelDto;
import online.buza.blog.dto.TbClassificationDto;
import online.buza.blog.dto.TbPostDto;
import online.buza.blog.entity.TbPost;
import online.buza.blog.service.PostService;
import online.buza.blog.util.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

@Slf4j
@Getter
@Setter
@AllArgsConstructor
@Service
public class PostServiceImpl implements PostService {

    @Resource
    private TbPostMapper tbPostMapper;

    @Resource
    private TbClassificationMapper tbClassificationMapper;

    @Transactional
    public Boolean insertTbPost(TbPost tbPost) {
        int insertCount = tbPostMapper.insertSelective(tbPost);
        if (insertCount > 0) {
            return true;
        }
        return false;
    }

    @Transactional
    public Boolean updateTbPost(TbPost tbPost) {
        int updateCount = tbPostMapper.updateByPrimaryKeySelective(tbPost);
        if (updateCount > 0) {
            return true;
        }
        return false;
    }

    public List<TbPostDto> getAllTbPostListByTbPost(TbPostDto tbPostDto) {
        return tbPostMapper.getAllTbPostListByTbPost(tbPostDto);
    }

    public TbPostDto getTbPostByPostId(Integer postId) {
        return tbPostMapper.getTbPostByPostId(postId);
    }

    @Override
    public Boolean deleteTbPost(Integer postId) {
        int deleteCount = tbPostMapper.deleteTbPost(postId);
        if (deleteCount > 0) {
            return true;
        }
        return false;
    }

    public List<TbClassificationDto> getBoardType01ClassificationTree(TbClassificationDto tbClassificationDto) {
        return tbClassificationMapper.getBoardType01Classification(tbClassificationDto);
    }



    public List<TbClassificationDto> buildClassificationTree(List<TbClassificationDto> classificationDtos) {
        List<TbClassificationDto> returnList = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();

        for (TbClassificationDto classificationDto : classificationDtos) {
            tempList.add(classificationDto.getClassificationId());
        }

        for (TbClassificationDto classificationDto : classificationDtos) {
            if (!tempList.contains(classificationDto.getParentClassificationId())) {
                recursionFn(classificationDtos, classificationDto);
                returnList.add(classificationDto);
            }
        }

        if (returnList.isEmpty()) {
            returnList = classificationDtos;
        }
        return returnList;
    }

    public List<TbClassificationDto> getClassificationListByTypeCode(Map<String, Object> mapParams) {
        return tbClassificationMapper.getClassificationListByTypeCode(mapParams);
    }

    public List<LabelDto> buildClassificationTreeOrigin(List<LabelDto> labelDtos) {
        List<LabelDto> returnList = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();

        for (LabelDto labelDto : labelDtos) {
            tempList.add(labelDto.getId());
        }

        for (LabelDto labelDto : labelDtos) {
            if (!tempList.contains(labelDto.getParentId())) {
                recursionLabelFn(labelDtos, labelDto);
                returnList.add(labelDto);
            }
        }

        if (returnList.isEmpty()) {
            returnList = labelDtos;
        }
        return returnList;
    }

    public List<LabelDto> getClassificationListByTypeCode_LabelDTO(Map<String, Object> mapParams) {
        return tbClassificationMapper.getClassificationListByTypeCode_LabelDTO(mapParams);
    }

    private void recursionFn(List<TbClassificationDto> list, TbClassificationDto t) {
        // 得到子节点列表
        List<TbClassificationDto> childList = getChildClassificationList(list, t);
        t.setChildren(childList);
        for (TbClassificationDto tbClassificationDto : childList) {
            if (hasChildClassification(list, tbClassificationDto)) {
                recursionFn(list, tbClassificationDto);
            }
        }
    }

    private List<TbClassificationDto> getChildClassificationList(List<TbClassificationDto> list, TbClassificationDto t) {
        List<TbClassificationDto> tlist = new ArrayList<>();
        Iterator<TbClassificationDto> it = list.iterator();
        while (it.hasNext()) {
            TbClassificationDto n = (TbClassificationDto) it.next();
            if (StringUtils.isNotNull(n.getParentClassificationId()) && n.getParentClassificationId() == t.getClassificationId()) {
                tlist.add(n);
            }
        }
        return tlist;
    }

    private boolean hasChildClassification(List<TbClassificationDto> list, TbClassificationDto t) {
        return getChildClassificationList(list, t).size() > 0;
    }

    private boolean hasChildLabel(List<LabelDto> list, LabelDto t) {
        return getChildLabelList(list, t).size() > 0;
    }

    private void recursionLabelFn(List<LabelDto> list, LabelDto t) {
        // 得到子节点列表
        List<LabelDto> childList = getChildLabelList(list, t);
        t.setChildren(childList);
        for (LabelDto labelDto : childList) {
            if (hasChildLabel(list, labelDto)) {
                recursionLabelFn(list, labelDto);
            }
        }
    }

    private List<LabelDto> getChildLabelList(List<LabelDto> list, LabelDto t) {
        List<LabelDto> tlist = new ArrayList<>();
        Iterator<LabelDto> it = list.iterator();
        while (it.hasNext()) {
            LabelDto n = (LabelDto) it.next();
            if (StringUtils.isNotNull(n.getParentId()) && n.getParentId() == t.getId()) {
                tlist.add(n);
            }
        }
        return tlist;
    }



}
