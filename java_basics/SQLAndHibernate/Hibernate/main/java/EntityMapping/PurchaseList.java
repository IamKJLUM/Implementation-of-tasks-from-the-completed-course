package EntityMapping;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "PurchaseList")
@Setter
@Getter
public class PurchaseList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int unsigned")
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "student_name",
            referencedColumnName = "name",
            columnDefinition = "VARCHAR(500)"

    )
    private Student student;

    @ManyToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "course_name",
            referencedColumnName = "name",
            columnDefinition = "VARCHAR(500)"
    )
    private Course course;

    @Column(columnDefinition = "int unsigned")
    private Integer price;

    @Column(name = "subscription_date")
    private ZonedDateTime subscriptionDate;

}