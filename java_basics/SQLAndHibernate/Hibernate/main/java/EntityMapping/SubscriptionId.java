package EntityMapping;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
public class SubscriptionId implements Serializable {

    private int studentId;
    private int courseId;

    public SubscriptionId() {
    }
    public SubscriptionId(int studentId, int courseId) {
        this.courseId = courseId;
        this.studentId = studentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubscriptionId that = (SubscriptionId) o;
        return studentId == that.studentId && courseId == that.courseId;
    }
    @Override
    public int hashCode() {
        return Objects.hash(studentId, courseId);
    }
}