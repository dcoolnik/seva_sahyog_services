package seva.sahyog.sahashiksha.dto;

import java.time.LocalDateTime;
import java.util.Set;

public class School {

    private int schoolId;

    private String schoolCode;

    private String schoolName;

    private Set<Student> students;

    private Set<Teacher> teachers;

    private String createdBy;

    private LocalDateTime createdDatetime;

    public School(){}

    public School(int schoolId, String schoolCode, String schoolName, Set<Student> students, Set<Teacher> teachers, String createdBy, LocalDateTime createdDatetime) {
        this.schoolId = schoolId;
        this.schoolCode = schoolCode;
        this.schoolName = schoolName;
        this.students = students;
        this.teachers = teachers;
        this.createdBy = createdBy;
        this.createdDatetime = createdDatetime;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolCode() {
        return schoolCode;
    }

    public void setSchoolCode(String schoolCode) {
        this.schoolCode = schoolCode;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
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
        return "School{" +
                "schoolId=" + schoolId +
                ", schoolCode='" + schoolCode + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", students=" + students +
                ", teachers=" + teachers +
                ", createdBy='" + createdBy + '\'' +
                ", createdDatetime=" + createdDatetime +
                '}';
    }
}
