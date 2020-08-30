package seva.sahyog.sahashiksha.dto;

import java.time.LocalDateTime;

public class Assignment {

    private int assignmentId;

    //online, mcq, etc
    private String assignmentType;

    private String assignmentContent;

    private String assignmentAnswerType;

    private String assignmentAnswerContent;

    private int totalMarks;

    private Course course;

    private LocalDateTime startDate;

    private LocalDateTime EndDate;

    private String createdBy;

    private LocalDateTime createdDatetime;

    public Assignment(){}

    public Assignment(int assignmentId, String assignmentType, String assignmentContent, String assignmentAnswerType, String assignmentAnswerContent, int totalMarks, Course course, LocalDateTime startDate, LocalDateTime endDate, String createdBy, LocalDateTime createdDatetime) {
        this.assignmentId = assignmentId;
        this.assignmentType = assignmentType;
        this.assignmentContent = assignmentContent;
        this.assignmentAnswerType = assignmentAnswerType;
        this.assignmentAnswerContent = assignmentAnswerContent;
        this.totalMarks = totalMarks;
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
                ", course=" + course +
                ", startDate=" + startDate +
                ", EndDate=" + EndDate +
                ", createdBy='" + createdBy + '\'' +
                ", createdDatetime=" + createdDatetime +
                '}';
    }
}
