package online.buza.blog.entity;

import java.math.BigDecimal;

public class EcStoreProduct {
    private Integer id;

    private Integer merId;

    private String productCode;

    private String mainImage;

    private String sliderImage;

    private String productName;

    private String productInfo;

    private String productKeyword;

    private String barCode;

    private String cateId;

    private BigDecimal salesPrice;

    private BigDecimal vipPrice;

    private BigDecimal otPrice;

    private BigDecimal postage;

    private String unitName;

    private Short sort;

    private Integer stock;

    private Boolean isShow;

    private Boolean isHot;

    private Boolean isBenefit;

    private Boolean isBest;

    private Boolean isNew;

    private Integer addTime;

    private Byte isPostage;

    private Byte isDel;

    private Integer canUsePoint;

    private BigDecimal tagPrice;

    private Integer tempId;

    private Boolean specType;

    private Boolean isRecycle;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMerId() {
        return merId;
    }

    public void setMerId(Integer merId) {
        this.merId = merId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public String getSliderImage() {
        return sliderImage;
    }

    public void setSliderImage(String sliderImage) {
        this.sliderImage = sliderImage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(String productInfo) {
        this.productInfo = productInfo;
    }

    public String getProductKeyword() {
        return productKeyword;
    }

    public void setProductKeyword(String productKeyword) {
        this.productKeyword = productKeyword;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getCateId() {
        return cateId;
    }

    public void setCateId(String cateId) {
        this.cateId = cateId;
    }

    public BigDecimal getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(BigDecimal salesPrice) {
        this.salesPrice = salesPrice;
    }

    public BigDecimal getVipPrice() {
        return vipPrice;
    }

    public void setVipPrice(BigDecimal vipPrice) {
        this.vipPrice = vipPrice;
    }

    public BigDecimal getOtPrice() {
        return otPrice;
    }

    public void setOtPrice(BigDecimal otPrice) {
        this.otPrice = otPrice;
    }

    public BigDecimal getPostage() {
        return postage;
    }

    public void setPostage(BigDecimal postage) {
        this.postage = postage;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public Short getSort() {
        return sort;
    }

    public void setSort(Short sort) {
        this.sort = sort;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Boolean getIsShow() {
        return isShow;
    }

    public void setIsShow(Boolean isShow) {
        this.isShow = isShow;
    }

    public Boolean getIsHot() {
        return isHot;
    }

    public void setIsHot(Boolean isHot) {
        this.isHot = isHot;
    }

    public Boolean getIsBenefit() {
        return isBenefit;
    }

    public void setIsBenefit(Boolean isBenefit) {
        this.isBenefit = isBenefit;
    }

    public Boolean getIsBest() {
        return isBest;
    }

    public void setIsBest(Boolean isBest) {
        this.isBest = isBest;
    }

    public Boolean getIsNew() {
        return isNew;
    }

    public void setIsNew(Boolean isNew) {
        this.isNew = isNew;
    }

    public Integer getAddTime() {
        return addTime;
    }

    public void setAddTime(Integer addTime) {
        this.addTime = addTime;
    }

    public Byte getIsPostage() {
        return isPostage;
    }

    public void setIsPostage(Byte isPostage) {
        this.isPostage = isPostage;
    }

    public Byte getIsDel() {
        return isDel;
    }

    public void setIsDel(Byte isDel) {
        this.isDel = isDel;
    }

    public Integer getCanUsePoint() {
        return canUsePoint;
    }

    public void setCanUsePoint(Integer canUsePoint) {
        this.canUsePoint = canUsePoint;
    }

    public BigDecimal getTagPrice() {
        return tagPrice;
    }

    public void setTagPrice(BigDecimal tagPrice) {
        this.tagPrice = tagPrice;
    }

    public Integer getTempId() {
        return tempId;
    }

    public void setTempId(Integer tempId) {
        this.tempId = tempId;
    }

    public Boolean getSpecType() {
        return specType;
    }

    public void setSpecType(Boolean specType) {
        this.specType = specType;
    }

    public Boolean getIsRecycle() {
        return isRecycle;
    }

    public void setIsRecycle(Boolean isRecycle) {
        this.isRecycle = isRecycle;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", merId=").append(merId);
        sb.append(", productCode=").append(productCode);
        sb.append(", mainImage=").append(mainImage);
        sb.append(", sliderImage=").append(sliderImage);
        sb.append(", productName=").append(productName);
        sb.append(", productInfo=").append(productInfo);
        sb.append(", productKeyword=").append(productKeyword);
        sb.append(", barCode=").append(barCode);
        sb.append(", cateId=").append(cateId);
        sb.append(", salesPrice=").append(salesPrice);
        sb.append(", vipPrice=").append(vipPrice);
        sb.append(", otPrice=").append(otPrice);
        sb.append(", postage=").append(postage);
        sb.append(", unitName=").append(unitName);
        sb.append(", sort=").append(sort);
        sb.append(", stock=").append(stock);
        sb.append(", isShow=").append(isShow);
        sb.append(", isHot=").append(isHot);
        sb.append(", isBenefit=").append(isBenefit);
        sb.append(", isBest=").append(isBest);
        sb.append(", isNew=").append(isNew);
        sb.append(", addTime=").append(addTime);
        sb.append(", isPostage=").append(isPostage);
        sb.append(", isDel=").append(isDel);
        sb.append(", canUsePoint=").append(canUsePoint);
        sb.append(", tagPrice=").append(tagPrice);
        sb.append(", tempId=").append(tempId);
        sb.append(", specType=").append(specType);
        sb.append(", isRecycle=").append(isRecycle);
        sb.append("]");
        return sb.toString();
    }
}