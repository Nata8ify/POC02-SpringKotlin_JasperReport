package com.n8ify.signink.model

import com.n8ify.signink.annotation.MatchedPassword
import java.math.BigInteger
import javax.validation.constraints.Max
import javax.validation.constraints.NotBlank

@MatchedPassword
data class UserDto(val userId : BigInteger? = null, @NotBlank @Max(50) val username : String? = null, @NotBlank @Max(50) val password : String? = null, @NotBlank @Max(50) val matchingPassword : String? = null)

data class User(val userId : BigInteger, @Max(50) val username : String, @Max(50) val password : String)

data class UserSignUpRequest(val data : User)
data class UserUpdateRequest(val data : User)

data class UserSignUpResponse(val data : User)
data class UserUpdateResponse(val data : User)