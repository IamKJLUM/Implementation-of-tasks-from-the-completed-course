package EntityMapping;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Teachers")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Setter
@Getter
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(fetch = FetchType.LAZY)
    private int id;

    @Column(length = 45)
    private String name;

    private Integer salary;

    private Integer age;
}
