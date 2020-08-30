package seva.sahyog.sahashiksha.dto;

import java.time.LocalDateTime;

public class StudentAssignment {

    private int assignmentId;

    private int studentId;

    private String assignmentResultContent;

    private int marks;

    private String createdBy;

    private LocalDateTime createdDatetime;

    public StudentAssignment(){}

    public StudentAssignment(int assignmentId, int studentId, String assignmentResultContent, int marks, String createdBy, LocalDateTime createdDatetime) {
        this.assignmentId = assignmentId;
        this.studentId = studentId;
        this.assignmentResultContent = assignmentResultContent;
        this.marks = marks;
        this.createdBy = createdBy;
        this.createdDatetime = createdDatetime;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
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
                "assignmentId=" + assignmentId +
                ", studentId=" + studentId +
                ", assignmentResultContent='" + assignmentResultContent + '\'' +
                ", marks=" + marks +
                ", createdBy='" + createdBy + '\'' +
                ", createdDatetime=" + createdDatetime +
                '}';
    }
}
