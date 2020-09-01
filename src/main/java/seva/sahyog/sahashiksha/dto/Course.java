package seva.sahyog.sahashiksha.dto;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "course_id")
    private int courseId;

    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Course_Teacher",
            joinColumns = { @JoinColumn(name = "course_id") },
            inverseJoinColumns = { @JoinColumn(name = "teacher_id") }
    )
    private Set<Teacher> courseTeachers;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Course_Student",
            joinColumns = { @JoinColumn(name = "course_id") },
            inverseJoinColumns = { @JoinColumn(name = "student_id") }
    )
    private Set<Student> courseStudents;

    @OneToMany(mappedBy="course")
    private Set<CourseContent> courseContents;

    @OneToMany(mappedBy="course")
    private Set<Chapter> chapters;

    @OneToMany(mappedBy="course")
    private Set<Assignment> assignments;

    @Column(name = "course_class")
    private String courseClass;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_datetime")
    private LocalDateTime createdDatetime;

    public Course(){}

    public Course(int courseId, String name, Set<Teacher> courseTeachers, Set<Student> courseStudents, Set<CourseContent> courseContents, Set<Chapter> chapters, Set<Assignment> assignments, String courseClass, String createdBy, LocalDateTime createdDatetime) {
        this.courseId = courseId;
        this.name = name;
        this.courseTeachers = courseTeachers;
        this.courseStudents = courseStudents;
        this.courseContents = courseContents;
        this.chapters = chapters;
        this.assignments = assignments;
        this.courseClass = courseClass;
        this.createdBy = createdBy;
        this.createdDatetime = createdDatetime;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Teacher> getCourseTeachers() {
        return courseTeachers;
    }

    public void setCourseTeachers(Set<Teacher> courseTeachers) {
        this.courseTeachers = courseTeachers;
    }

    public Set<Student> getCourseStudents() {
        return courseStudents;
    }

    public void setCourseStudents(Set<Student> courseStudents) {
        this.courseStudents = courseStudents;
    }

    public Set<CourseContent> getCourseContents() {
        return courseContents;
    }

    public void setCourseContents(Set<CourseContent> courseContents) {
        this.courseContents = courseContents;
    }

    public Set<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(Set<Chapter> chapters) {
        this.chapters = chapters;
    }

    public Set<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(Set<Assignment> assignments) {
        this.assignments = assignments;
    }

    public String getCourseClass() {
        return courseClass;
    }

    public void setCourseClass(String courseClass) {
        this.courseClass = courseClass;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedDatetime() {
        return createdDatetime;
    }

    public void setCreatedDatetime(LocalDateTime createdDatetime) {
        this.createdDatetime = createdDatetime;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", name='" + name + '\'' +
                ", courseTeachers=" + courseTeachers +
                ", courseStudents=" + courseStudents +
                ", courseContents=" + courseContents +
                ", chapters=" + chapters +
                ", assignments=" + assignments +
                ", courseClass='" + courseClass + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createdDatetime=" + createdDatetime +
                '}';
    }
}
