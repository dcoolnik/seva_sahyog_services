package seva.sahyog.sahashiksha.dto;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "course_content")
public class CourseContent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "course_content_id")
    private int id;

    @Column(name = "content_type", nullable = false)
    private String contentType;

    @Column(name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(name="course_id", nullable=false)
    private Course course;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_datetime")
    private LocalDateTime updatedDatetime;

    public CourseContent(){}

    public CourseContent(String contentType, String content, Course course, String updatedBy, LocalDateTime updatedDatetime) {
        //this.id = id;
        this.contentType = contentType;
        this.content = content;
        this.course = course;
        this.updatedBy = updatedBy;
        this.updatedDatetime = updatedDatetime;
    }

    public int getId() {
        return id;
    }

    /*public void setId(int id) {
        this.id = id;
    }*/

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
