package online.buza.blog.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import online.buza.blog.common.BaseRequest;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
public class TreeDto extends BaseRequest implements Serializable {

    public static final long serialVersionUID = 1L;

    private int id;
    private String label;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TreeDto> children;

    public TreeDto() {

    }

    public TreeDto(TbClassificationDto tbClassificationDto) {
        this.id = tbClassificationDto.getClassificationId();
        this.label = tbClassificationDto.getClassificationName();
        this.children = tbClassificationDto.getChildren().stream().map(TreeDto::new).collect(Collectors.toList());
    }



}
