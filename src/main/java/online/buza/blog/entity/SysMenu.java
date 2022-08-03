package online.buza.blog.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class SysMenu implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Long parentId;
    private String name;
    private String path;
    private String status;
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
    private Date createtime;
    private Date updatetime;
    private List<SysMenu> children = new ArrayList<>();

}