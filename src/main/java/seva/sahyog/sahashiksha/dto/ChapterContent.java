package seva.sahyog.sahashiksha.dto;

import java.time.LocalDateTime;

public class ChapterContent {

    private int id;

    private String contentType;

    private String content;

    private Chapter chapter;

    private String updatedBy;

    private LocalDateTime updatedDatetime;

    public ChapterContent(){}

    public ChapterContent(int id, String contentType, String content, Chapter chapter, String updatedBy, LocalDateTime updatedDatetime) {
        this.id = id;
        this.contentType = contentType;
        this.content = content;
        this.chapter = chapter;
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

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
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
        return "ChapterContent{" +
                "id=" + id +
                ", contentType='" + contentType + '\'' +
                ", content='" + content + '\'' +
                ", chapter=" + chapter +
                ", updatedBy='" + updatedBy + '\'' +
                ", updatedDatetime=" + updatedDatetime +
                '}';
    }
}
