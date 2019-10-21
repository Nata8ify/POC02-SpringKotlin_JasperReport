package com.n8ify.signink.annotation;

import com.n8ify.signink.model.UserDto;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MatchedPasswordValidator.class)
@Documented
public @interface MatchedPassword {
    String message() default "Passwords don't match";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
