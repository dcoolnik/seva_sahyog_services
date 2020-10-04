package seva.sahyog.sahashiksha.model;

public class RegistrationResponse {

    private boolean isSuccess;
    private String message;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
