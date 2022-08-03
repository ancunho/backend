package online.buza.blog.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public class SysRole implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;

    private String name;

    private String code;

    private String remark;

    private String status;

    private Date createtime;

    private Date updatetime;




}