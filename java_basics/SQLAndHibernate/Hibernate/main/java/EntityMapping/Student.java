package EntityMapping;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;

@Entity
@Setter
@Getter
@Table(name = "Students")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(fetch = FetchType.LAZY)
    @Column(nullable = false, columnDefinition = "int unsigned")
    private Integer id;

    @Column(length = 45)
    private String name;

    @Column(columnDefinition = "int unsigned")
    private Integer age;

    @Column(name = "registration_date", nullable = false)
    private ZonedDateTime registrationDate;

    public Student() {
    }
}
