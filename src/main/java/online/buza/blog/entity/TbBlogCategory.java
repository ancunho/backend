package online.buza.blog.entity;

import java.util.Date;

public class TbBlogCategory {
    private Integer categoryId;

    private Integer parentCategoryId;

    private String categoryName;

    private String categoryType;

    private Integer sortOrder;

    private String status;

    private String option01;

    private String option02;

    private String option03;

    private String option04;

    private String option05;

    private Date createTime;

    private Date updateTime;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(Integer parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
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
        sb.append(", categoryId=").append(categoryId);
        sb.append(", parentCategoryId=").append(parentCategoryId);
        sb.append(", categoryName=").append(categoryName);
        sb.append(", categoryType=").append(categoryType);
        sb.append(", sortOrder=").append(sortOrder);
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