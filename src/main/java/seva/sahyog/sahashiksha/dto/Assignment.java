package seva.sahyog.sahashiksha.dto;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "assignment")
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "assignment_id")
    private int assignmentId;

    //online, mcq, etc
    @Column(name = "assignment_type", nullable = false)
    private String assignmentType;

    @Column(name = "assignment_content", nullable = false)
    private String assignmentContent;

    @Column(name = "assignment_answer_type")
    private String assignmentAnswerType;

    @Column(name = "assignment_answer_content")
    private String assignmentAnswerContent;

    @Column(name = "total_marks")
    private int totalMarks;

    @OneToMany(mappedBy="assignment")
    private Set<StudentAssignment> studentAssignments;

    @ManyToOne
    @JoinColumn(name="course_id", nullable=false)
    private Course course;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime EndDate;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_datetime")
    private LocalDateTime createdDatetime;

    public Assignment(){}

    public Assignment(int assignmentId, String assignmentType, String assignmentContent, String assignmentAnswerType, String assignmentAnswerContent, int totalMarks, Set<StudentAssignment> studentAssignments, Course course, LocalDateTime startDate, LocalDateTime endDate, String createdBy, LocalDateTime createdDatetime) {
        this.assignmentId = assignmentId;
        this.assignmentType = assignmentType;
        this.assignmentContent = assignmentContent;
        this.assignmentAnswerType = assignmentAnswerType;
        this.assignmentAnswerContent = assignmentAnswerContent;
        this.totalMarks = totalMarks;
        this.studentAssignments = studentAssignments;
        this.course = course;
        this.startDate = startDate;
        EndDate = endDate;
        this.createdBy = createdBy;
        this.createdDatetime = createdDatetime;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public String getAssignmentType() {
        return assignmentType;
    }

    public void setAssignmentType(String assignmentType) {
        this.assignmentType = assignmentType;
    }

    public String getAssignmentContent() {
        return assignmentContent;
    }

    public void setAssignmentContent(String assignmentContent) {
        this.assignmentContent = assignmentContent;
    }

    public String getAssignmentAnswerType() {
        return assignmentAnswerType;
    }

    public void setAssignmentAnswerType(String assignmentAnswerType) {
        this.assignmentAnswerType = assignmentAnswerType;
    }

    public String getAssignmentAnswerContent() {
        return assignmentAnswerContent;
    }

    public void setAssignmentAnswerContent(String assignmentAnswerContent) {
        this.assignmentAnswerContent = assignmentAnswerContent;
    }

    public int getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }

    public Set<StudentAssignment> getStudentAssignments() {
        return studentAssignments;
    }

    public void setStudentAssignments(Set<StudentAssignment> studentAssignments) {
        this.studentAssignments = studentAssignments;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return EndDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        EndDate = endDate;
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
        return "Assignment{" +
                "assignmentId=" + assignmentId +
                ", assignmentType='" + assignmentType + '\'' +
                ", assignmentContent='" + assignmentContent + '\'' +
                ", assignmentAnswerType='" + assignmentAnswerType + '\'' +
                ", assignmentAnswerContent='" + assignmentAnswerContent + '\'' +
                ", totalMarks=" + totalMarks +
                ", studentAssignments=" + studentAssignments +
                ", course=" + course +
                ", startDate=" + startDate +
                ", EndDate=" + EndDate +
                ", createdBy='" + createdBy + '\'' +
                ", createdDatetime=" + createdDatetime +
                '}';
    }
}
