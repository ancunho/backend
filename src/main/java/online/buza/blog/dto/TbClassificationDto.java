package online.buza.blog.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public class TbClassificationDto extends BaseRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer classificationId;
    private Integer parentClassificationId;
    private String classificationName;
    private String classificationType;
    private String classificationImage;
    private Integer sortOrder;
    private Integer depthNum;
    private String status;
    private String option01;
    private String option02;
    private String option03;
    private String option04;
    private String option05;
    private Date createTime;
    private Date updateTime;

}
