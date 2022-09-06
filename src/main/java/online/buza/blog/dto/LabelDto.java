package online.buza.blog.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import online.buza.blog.common.BaseRequest;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
public class LabelDto extends BaseRequest implements Serializable {

    public static final long serialVersionUID = 1L;

    public int id;
    public String label;
    public boolean hasChildren;
    public String status;
    public String statusName;
    public List<LabelDto> children;

}
