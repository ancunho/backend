package online.buza.blog.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import online.buza.blog.common.BaseRequest;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public class TbCollectDto extends BaseRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer collectId;
    private Integer postId;
    private String actionType;
    private Integer customerId;
    private String option01;
    private String option02;
    private String option03;
    private String option04;
    private String option05;
    private String createTime;
    private String updateTime;

}
