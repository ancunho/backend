package online.buza.blog.service.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import online.buza.blog.dao.TbPostMapper;
import online.buza.blog.dto.TbPostDto;
import online.buza.blog.entity.TbPost;
import online.buza.blog.service.PostService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Getter
@Setter
@AllArgsConstructor
@Service
public class PostServiceImpl implements PostService {

    @Resource
    private TbPostMapper tbPostMapper;

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


}
