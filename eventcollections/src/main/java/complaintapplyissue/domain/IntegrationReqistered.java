package complaintapplyissue.domain;

import complaintapplyissue.infra.AbstractEvent;
import java.util.*;
import javax.validation.constraints.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
public class IntegrationReqistered extends AbstractEvent {

    private Long 연계Id;

    @NotNull
    private String 신청번호;
}
//>>> DDD / Domain Event
