package online.buza.blog.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class ClassificationTreeDto extends BaseRequest implements Serializable {

    public String classificationId;
    public String classificationName;
    public String childClassificationId;
    public String parentClassificationId;
    public int sortOrder;
    public String status;
    public String option01;
    public String option02;
    public String option03;
    public String option04;
    public String option05;

}
