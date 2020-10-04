package seva.sahyog.sahashiksha.model;

public enum UserType {

    STUDENT("Student"),
    TEACHER("Teacher"),
    ADMIN("Admin"),
    SCHOOL("School");

    private String value;

    UserType(String name) { this.value = value; }

    public String value() {
        return value;
    }
}
