package online.buza.blog.entity;

import java.util.Date;

public class TbSpu {
    private Integer spuId;

    private Integer classificationId;

    private Integer depth01Id;

    private String depth01Name;

    private Integer depth02Id;

    private String depth02Name;

    private Integer depth03Id;

    private String depth03Name;

    private Integer brandId;

    private String spuName;

    private String spuType;

    private String status;

    private String mainImage01;

    private String mainImage02;

    private String mainImage03;

    private String subImage01;

    private String subImage02;

    private String subImage03;

    private String subImage04;

    private String subImage05;

    private String option01;

    private String option02;

    private String option03;

    private String option04;

    private String option05;

    private Date createTime;

    private Date updateTime;

    public Integer getSpuId() {
        return spuId;
    }

    public void setSpuId(Integer spuId) {
        this.spuId = spuId;
    }

    public Integer getClassificationId() {
        return classificationId;
    }

    public void setClassificationId(Integer classificationId) {
        this.classificationId = classificationId;
    }

    public Integer getDepth01Id() {
        return depth01Id;
    }

    public void setDepth01Id(Integer depth01Id) {
        this.depth01Id = depth01Id;
    }

    public String getDepth01Name() {
        return depth01Name;
    }

    public void setDepth01Name(String depth01Name) {
        this.depth01Name = depth01Name;
    }

    public Integer getDepth02Id() {
        return depth02Id;
    }

    public void setDepth02Id(Integer depth02Id) {
        this.depth02Id = depth02Id;
    }

    public String getDepth02Name() {
        return depth02Name;
    }

    public void setDepth02Name(String depth02Name) {
        this.depth02Name = depth02Name;
    }

    public Integer getDepth03Id() {
        return depth03Id;
    }

    public void setDepth03Id(Integer depth03Id) {
        this.depth03Id = depth03Id;
    }

    public String getDepth03Name() {
        return depth03Name;
    }

    public void setDepth03Name(String depth03Name) {
        this.depth03Name = depth03Name;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getSpuName() {
        return spuName;
    }

    public void setSpuName(String spuName) {
        this.spuName = spuName;
    }

    public String getSpuType() {
        return spuType;
    }

    public void setSpuType(String spuType) {
        this.spuType = spuType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMainImage01() {
        return mainImage01;
    }

    public void setMainImage01(String mainImage01) {
        this.mainImage01 = mainImage01;
    }

    public String getMainImage02() {
        return mainImage02;
    }

    public void setMainImage02(String mainImage02) {
        this.mainImage02 = mainImage02;
    }

    public String getMainImage03() {
        return mainImage03;
    }

    public void setMainImage03(String mainImage03) {
        this.mainImage03 = mainImage03;
    }

    public String getSubImage01() {
        return subImage01;
    }

    public void setSubImage01(String subImage01) {
        this.subImage01 = subImage01;
    }

    public String getSubImage02() {
        return subImage02;
    }

    public void setSubImage02(String subImage02) {
        this.subImage02 = subImage02;
    }

    public String getSubImage03() {
        return subImage03;
    }

    public void setSubImage03(String subImage03) {
        this.subImage03 = subImage03;
    }

    public String getSubImage04() {
        return subImage04;
    }

    public void setSubImage04(String subImage04) {
        this.subImage04 = subImage04;
    }

    public String getSubImage05() {
        return subImage05;
    }

    public void setSubImage05(String subImage05) {
        this.subImage05 = subImage05;
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
        sb.append(", spuId=").append(spuId);
        sb.append(", classificationId=").append(classificationId);
        sb.append(", depth01Id=").append(depth01Id);
        sb.append(", depth01Name=").append(depth01Name);
        sb.append(", depth02Id=").append(depth02Id);
        sb.append(", depth02Name=").append(depth02Name);
        sb.append(", depth03Id=").append(depth03Id);
        sb.append(", depth03Name=").append(depth03Name);
        sb.append(", brandId=").append(brandId);
        sb.append(", spuName=").append(spuName);
        sb.append(", spuType=").append(spuType);
        sb.append(", status=").append(status);
        sb.append(", mainImage01=").append(mainImage01);
        sb.append(", mainImage02=").append(mainImage02);
        sb.append(", mainImage03=").append(mainImage03);
        sb.append(", subImage01=").append(subImage01);
        sb.append(", subImage02=").append(subImage02);
        sb.append(", subImage03=").append(subImage03);
        sb.append(", subImage04=").append(subImage04);
        sb.append(", subImage05=").append(subImage05);
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