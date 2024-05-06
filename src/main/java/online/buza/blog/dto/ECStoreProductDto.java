package online.buza.blog.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class ECStoreProductDto extends BaseRequest {

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

}
