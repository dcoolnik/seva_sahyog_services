package seva.sahyog.sahashiksha.util;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Target({TYPE, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)
public @interface ValidPassword {

    String message() default "Invalid password";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
