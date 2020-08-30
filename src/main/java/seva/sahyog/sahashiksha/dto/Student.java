package seva.sahyog.sahashiksha.dto;

import java.time.LocalDateTime;
import java.util.Set;

public class Student {

    private int studentId;

    private String name;

    private String email;

    private String mobileNumber;

    private boolean isActive;

    private School school;

    private Set<Course> courses;

    private String createdBy;

    private LocalDateTime createdDatetime;

    public Student(){}

    public Student(int studentId, String name, String email, String mobileNumber, boolean isActive, School school, Set<Course> courses, String createdBy, LocalDateTime createdDatetime) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.isActive = isActive;
        this.school = school;
        this.courses = courses;
        this.createdBy = createdBy;
        this.createdDatetime = createdDatetime;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
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
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", isActive=" + isActive +
                ", school=" + school +
                ", courses=" + courses +
                ", createdBy='" + createdBy + '\'' +
                ", createdDatetime=" + createdDatetime +
                '}';
    }
}