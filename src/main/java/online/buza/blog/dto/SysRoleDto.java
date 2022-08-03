package online.buza.blog.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public class SysRoleDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long rn;
    private Long id;
    private String name;
    private String code;
    private String status;
    private String statusName;
    private String remark;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createtime;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updatetime;

}
