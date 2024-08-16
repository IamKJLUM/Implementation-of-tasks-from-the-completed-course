package EntityMapping;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "Subscriptions")
@IdClass(SubscriptionId.class)
@Getter
@Setter
public class Subscription {

    @Column(name = "subscription_date",
            columnDefinition = "DATE",
            insertable = false,
            updatable = false,
            nullable = false)
    private ZonedDateTime subscriptionDate;

    @Id
    @Column(name = "student_id", columnDefinition = "int unsigned")
    private Integer studentId;

    @Id
    @Column(name = "course_id", columnDefinition = "int unsigned")
    private Integer courseId;
}