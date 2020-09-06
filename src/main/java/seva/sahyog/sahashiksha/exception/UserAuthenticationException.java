package seva.sahyog.sahashiksha.exception;

public class UserAuthenticationException extends Exception{

    public UserAuthenticationException(){
        super();
    }

    public UserAuthenticationException(String message){
        super(message);
    }

    public UserAuthenticationException(String message, Throwable cause){
        super(message, cause);
    }
}
