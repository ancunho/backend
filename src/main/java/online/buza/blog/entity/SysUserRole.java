package online.buza.blog.entity;

import java.io.Serializable;

public class SysUserRole implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private Long userSeq;

    private Long roleId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserSeq() {
        return userSeq;
    }

    public void setUserSeq(Long userSeq) {
        this.userSeq = userSeq;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userSeq=").append(userSeq);
        sb.append(", roleId=").append(roleId);
        sb.append("]");
        return sb.toString();
    }
}