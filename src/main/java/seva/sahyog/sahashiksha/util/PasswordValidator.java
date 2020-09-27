package seva.sahyog.sahashiksha.util;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator implements ConstraintValidator<ValidPassword, String> {

    private Pattern pattern;
    private Matcher matcher;
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\\\S+$).{8,20}$";

    @Override
    public void initialize(ValidPassword annotation) {
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        //Add additional conditions for password matching
        return (validatePassword(password));
    }

    private boolean validatePassword(String password) {
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
