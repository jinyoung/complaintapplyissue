package complaintapplyissue.domain;

import complaintapplyissue.infra.AbstractEvent;
import java.util.*;
import javax.validation.constraints.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
public class Printed extends AbstractEvent {

    private Long id;

    @NotNull
    private String 민원id;

    private String 민원접수번호;
    private String 발급물여부;
    private String 뷰어실행여부;
    private String 증명서여부;
    private String 출력여부;
}
//>>> DDD / Domain Event
