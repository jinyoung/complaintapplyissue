package complaintapplyissue.domain;

import complaintapplyissue.infra.AbstractEvent;
import java.util.*;
import javax.validation.constraints.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
public class ComplaintAccepted extends AbstractEvent {

    private Long 신청데이터일렬번호;

    @NotNull
    private String 신청번호;

    private String 서식Json내용;
    private String 신청데이터Xml내용;
    private String 신청메타Xml내용;
    private Boolean 사용여부;
    private Date 등록일시;
    private Date 수정일시;
}
//>>> DDD / Domain Event
