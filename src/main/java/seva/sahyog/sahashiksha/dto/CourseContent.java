package seva.sahyog.sahashiksha.dto;

import java.time.LocalDateTime;

public class CourseContent {

    private int id;

    private String contentType;

    private String content;

    private Course course;

    private String updatedBy;

    private LocalDateTime updatedDatetime;

    public CourseContent(){}

    public CourseContent(int id, String contentType, String content, Course course, String updatedBy, LocalDateTime updatedDatetime) {
        this.id = id;
        this.contentType = contentType;
        this.content = content;
        this.course = course;
        this.updatedBy = updatedBy;
        this.updatedDatetime = updatedDatetime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDateTime getUpdatedDatetime() {
        return updatedDatetime;
    }

    public void setUpdatedDatetime(LocalDateTime updatedDatetime) {
        this.updatedDatetime = updatedDatetime;
    }

    @Override
    public String toString() {
        return "CourseContent{" +
                "id=" + id +
                ", contentType='" + contentType + '\'' +
                ", content='" + content + '\'' +
                ", course=" + course +
                ", updatedBy='" + updatedBy + '\'' +
                ", updatedDatetime=" + updatedDatetime +
                '}';
    }
}
