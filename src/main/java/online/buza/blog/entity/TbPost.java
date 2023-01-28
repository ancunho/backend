package online.buza.blog.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TbPost implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer postId;

    private String postUuid;

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

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getPostUuid() {
        return postUuid;
    }

    public void setPostUuid(String postUuid) {
        this.postUuid = postUuid;
    }

    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType;
    }

    public Integer getPostCategoryId() {
        return postCategoryId;
    }

    public void setPostCategoryId(Integer postCategoryId) {
        this.postCategoryId = postCategoryId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getEventStartTime() {
        return eventStartTime;
    }

    public void setEventStartTime(String eventStartTime) {
        this.eventStartTime = eventStartTime;
    }

    public String getEventEndTime() {
        return eventEndTime;
    }

    public void setEventEndTime(String eventEndTime) {
        this.eventEndTime = eventEndTime;
    }

    public String getPostThumbnailSmall() {
        return postThumbnailSmall;
    }

    public void setPostThumbnailSmall(String postThumbnailSmall) {
        this.postThumbnailSmall = postThumbnailSmall;
    }

    public String getPostThumbnailBig() {
        return postThumbnailBig;
    }

    public void setPostThumbnailBig(String postThumbnailBig) {
        this.postThumbnailBig = postThumbnailBig;
    }

    public String getPostAuthor() {
        return postAuthor;
    }

    public void setPostAuthor(String postAuthor) {
        this.postAuthor = postAuthor;
    }

    public String getIsJoin() {
        return isJoin;
    }

    public void setIsJoin(String isJoin) {
        this.isJoin = isJoin;
    }

    public String getIsNeedPay() {
        return isNeedPay;
    }

    public void setIsNeedPay(String isNeedPay) {
        this.isNeedPay = isNeedPay;
    }

    public BigDecimal getPostPrice() {
        return postPrice;
    }

    public void setPostPrice(BigDecimal postPrice) {
        this.postPrice = postPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOption01() {
        return option01;
    }

    public void setOption01(String option01) {
        this.option01 = option01;
    }

    public String getOption02() {
        return option02;
    }

    public void setOption02(String option02) {
        this.option02 = option02;
    }

    public String getOption03() {
        return option03;
    }

    public void setOption03(String option03) {
        this.option03 = option03;
    }

    public String getOption04() {
        return option04;
    }

    public void setOption04(String option04) {
        this.option04 = option04;
    }

    public String getOption05() {
        return option05;
    }

    public void setOption05(String option05) {
        this.option05 = option05;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", postId=").append(postId);
        sb.append(", postUuid=").append(postUuid);
        sb.append(", postType=").append(postType);
        sb.append(", postCategoryId=").append(postCategoryId);
        sb.append(", postTitle=").append(postTitle);
        sb.append(", postContent=").append(postContent);
        sb.append(", eventStartTime=").append(eventStartTime);
        sb.append(", eventEndTime=").append(eventEndTime);
        sb.append(", postThumbnailSmall=").append(postThumbnailSmall);
        sb.append(", postThumbnailBig=").append(postThumbnailBig);
        sb.append(", postAuthor=").append(postAuthor);
        sb.append(", isJoin=").append(isJoin);
        sb.append(", isNeedPay=").append(isNeedPay);
        sb.append(", postPrice=").append(postPrice);
        sb.append(", status=").append(status);
        sb.append(", option01=").append(option01);
        sb.append(", option02=").append(option02);
        sb.append(", option03=").append(option03);
        sb.append(", option04=").append(option04);
        sb.append(", option05=").append(option05);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}
