package seva.sahyog.sahashiksha.dto;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "student_assignment")
public class StudentAssignment {

    @ManyToOne
    @JoinColumn(name="assignment_id", nullable=false)
    private Assignment assignment;

    @ManyToOne
    @JoinColumn(name="student_id", nullable=false)
    private Student student;

    @Column(name = "assignment_result_content", nullable = false)
    private String assignmentResultContent;

    @Column(name = "marks")
    private int marks;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_datetime")
    private LocalDateTime createdDatetime;

    public StudentAssignment(){}

    public StudentAssignment(Assignment assignment, Student student, String assignmentResultContent, int marks, String createdBy, LocalDateTime createdDatetime) {
        this.assignment = assignment;
        this.student = student;
        this.assignmentResultContent = assignmentResultContent;
        this.marks = marks;
        this.createdBy = createdBy;
        this.createdDatetime = createdDatetime;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getAssignmentResultContent() {
        return assignmentResultContent;
    }

    public void setAssignmentResultContent(String assignmentResultContent) {
        this.assignmentResultContent = assignmentResultContent;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
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
        return "StudentAssignment{" +
                "assignment=" + assignment +
                ", student=" + student +
                ", assignmentResultContent='" + assignmentResultContent + '\'' +
                ", marks=" + marks +
                ", createdBy='" + createdBy + '\'' +
                ", createdDatetime=" + createdDatetime +
                '}';
    }
}
