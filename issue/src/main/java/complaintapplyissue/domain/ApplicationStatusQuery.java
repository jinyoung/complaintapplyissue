package complaintapplyissue.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "ApplicationStatusQuery_table")
@Data
public class ApplicationStatusQuery {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private String id;

    private String status;
    private String edmsDocumentId;
}
