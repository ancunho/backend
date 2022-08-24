package online.buza.blog.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
@Getter
@Setter
@ToString
public class TbCommonCodeDto extends BaseRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer codeId;
    private String codeType;
    private String codeCd;
    private String codeName;
    private String useYn;
    private String sort;
    private String remark;
    private String option01;
    private String option02;
    private String option03;
    private String option04;
    private String option05;
    private String createTime;
    private String updateTime;

    private String status;
    private String statusName;

}
