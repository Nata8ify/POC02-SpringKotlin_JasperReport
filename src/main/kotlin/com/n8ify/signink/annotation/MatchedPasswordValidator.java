package com.n8ify.signink.annotation;

import com.n8ify.signink.model.UserDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MatchedPasswordValidator implements ConstraintValidator<MatchedPassword, UserDto> {

    @Override
    public boolean isValid(UserDto userDto, ConstraintValidatorContext context) {
        return userDto.getPassword().equals(userDto.getMatchingPassword());
    }

}
