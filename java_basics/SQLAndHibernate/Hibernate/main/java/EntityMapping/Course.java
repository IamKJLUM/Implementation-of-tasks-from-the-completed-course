package EntityMapping;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Courses")
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Course implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, columnDefinition = "int unsigned")
    private Integer id;

    @Column(length = 500, unique = true)
    private String name;

    @Column(columnDefinition = "int unsigned")
    private Integer duration;

    @Enumerated(EnumType.STRING)
    private CourseType type;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Subscriptions",
    joinColumns = {@JoinColumn(name = "course_id", columnDefinition = "int unsigned")},
    inverseJoinColumns = {@JoinColumn(name = "student_id", columnDefinition = "int unsigned")})
    private List<Student> students;

    @Column(length = 500)
    private String description;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id", columnDefinition = "int unsigned")
    private Teacher teacher;

    @Column(name = "students_count")
    private Integer studentsCount;

    @Column(name = "price", columnDefinition = "int unsigned")
    private Integer price;

    @Column(name = "price_per_hour")
    private Float pricePerHour;

    public Course() {}
}
