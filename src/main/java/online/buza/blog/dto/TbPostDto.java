package online.buza.blog.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@ToString
public class TbPostDto extends BaseRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer postId;
    private String postType;
    private Integer postCategoryId;
    private String postTitle;
    private String postContent;
    private String eventStartTime;
    private String eventEndTime;
    private String postThumbnailSmall;
    private String postThumbnailBig;
    private String postAuthor;
    private String isJoin;
    private String isNeedPay;
    private BigDecimal postPrice;
    private String status;
    private String option01;
    private String option02;
    private String option03;
    private String option04;
    private String option05;
    private Date createTime;
    private Date updateTime;

    private String postTypeName;
    private String statusName;
    private String postCategoryName;

}
