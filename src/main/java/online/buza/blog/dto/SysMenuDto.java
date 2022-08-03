package online.buza.blog.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class SysMenuDto extends BaseRequest {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long menuId;
    private Long parentId;
    private String name;
    private String path;
    private String status;
    private String statusName;
    private String perms;
    private String component;
    private Integer type;
    private String icon;
    private Integer orderNum;
    private String option01;
    private String option02;
    private String option03;
    private String option04;
    private String option05;

    List<SysMenuDto> children = new ArrayList<>();

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createtime;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updatetime;


}