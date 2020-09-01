package seva.sahyog.sahashiksha.dto;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "chapter")
public class Chapter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "chapter_id")
    private int chapterId;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy="chapter")
    private Set<ChapterContent> chapterContents;

    @ManyToOne
    @JoinColumn(name="course_id", nullable=false)
    private Course course;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_datetime")
    private LocalDateTime createdDatetime;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_datetime")
    private LocalDateTime updatedDatetime;

    public Chapter(){}

    public Chapter(int chapterId, String name, Set<ChapterContent> chapterContents, Course course, String createdBy, LocalDateTime createdDatetime, String updatedBy, LocalDateTime updatedDatetime) {
        this.chapterId = chapterId;
        this.name = name;
        this.chapterContents = chapterContents;
        this.course = course;
        this.createdBy = createdBy;
        this.createdDatetime = createdDatetime;
        this.updatedBy = updatedBy;
        this.updatedDatetime = updatedDatetime;
    }

    public int getChapterId() {
        return chapterId;
    }

    public void setChapterId(int chapterId) {
        this.chapterId = chapterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ChapterContent> getChapterContents() {
        return chapterContents;
    }

    public void setChapterContents(Set<ChapterContent> chapterContents) {
        this.chapterContents = chapterContents;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
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
        return "Chapter{" +
                "chapterId=" + chapterId +
                ", name='" + name + '\'' +
                ", chapterContents=" + chapterContents +
                ", course=" + course +
                ", createdBy='" + createdBy + '\'' +
                ", createdDatetime=" + createdDatetime +
                ", updatedBy='" + updatedBy + '\'' +
                ", updatedDatetime=" + updatedDatetime +
                '}';
    }
}
