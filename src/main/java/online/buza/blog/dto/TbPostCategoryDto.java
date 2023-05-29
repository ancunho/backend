package online.buza.blog.dto;

import java.io.Serializable;

public class TbPostCategoryDto extends BaseRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer postCategoryId;
    private String postCategoryName;
    private Integer postCategoryParentId;

    private String postCategoryParentName;
    private String postCategoryStatus;
    private Integer postCategorySort;
    private String postCategoryDesc;
    private String option01;
    private String option02;
    private String option03;
    private String option04;
    private String option05;
    private String createTime;
    private String updateTime;

    public Integer getPostCategoryId() {
        return postCategoryId;
    }

    public void setPostCategoryId(Integer postCategoryId) {
        this.postCategoryId = postCategoryId;
    }

    public String getPostCategoryName() {
        return postCategoryName;
    }

    public void setPostCategoryName(String postCategoryName) {
        this.postCategoryName = postCategoryName;
    }

    public Integer getPostCategoryParentId() {
        return postCategoryParentId;
    }

    public void setPostCategoryParentId(Integer postCategoryParentId) {
        this.postCategoryParentId = postCategoryParentId;
    }

    public String getPostCategoryParentName() {
        return postCategoryParentName;
    }

    public void setPostCategoryParentName(String postCategoryParentName) {
        this.postCategoryParentName = postCategoryParentName;
    }

    public String getPostCategoryStatus() {
        return postCategoryStatus;
    }

    public void setPostCategoryStatus(String postCategoryStatus) {
        this.postCategoryStatus = postCategoryStatus;
    }

    public Integer getPostCategorySort() {
        return postCategorySort;
    }

    public void setPostCategorySort(Integer postCategorySort) {
        this.postCategorySort = postCategorySort;
    }

    public String getPostCategoryDesc() {
        return postCategoryDesc;
    }

    public void setPostCategoryDesc(String postCategoryDesc) {
        this.postCategoryDesc = postCategoryDesc;
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "TbPostCategoryDto{" +
                "postCategoryId=" + postCategoryId +
                ", postCategoryName='" + postCategoryName + '\'' +
                ", postCategoryParentId=" + postCategoryParentId +
                ", postCategoryParentName='" + postCategoryParentName + '\'' +
                ", postCategoryStatus='" + postCategoryStatus + '\'' +
                ", postCategorySort=" + postCategorySort +
                ", postCategoryDesc='" + postCategoryDesc + '\'' +
                ", option01='" + option01 + '\'' +
                ", option02='" + option02 + '\'' +
                ", option03='" + option03 + '\'' +
                ", option04='" + option04 + '\'' +
                ", option05='" + option05 + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}
