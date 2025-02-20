package complaintapplyissue.domain;

import complaintapplyissue.infra.AbstractEvent;
import java.util.*;
import javax.validation.constraints.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
public class EdmsStored extends AbstractEvent {

    private Long id;
    private String 신청번호;
    private String 파일id;
    private String 파일명;
    private Boolean 저장유무;
}
//>>> DDD / Domain Event
