package complaintapplyissue.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

//<<< DDD / Value Object
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequiredDocument {

    private String 파일id;

    private String 파일명;

    private String 파일경로명;

    private String 파일확장자명;

    private String 파일크기;

    private String 파일순서;

    private Boolean 사용여부;

    private FileType fileType;
}
//>>> DDD / Value Object
