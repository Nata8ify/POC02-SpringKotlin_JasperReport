package com.n8ify.signink.model

import com.n8ify.signink._base.model.ResponseStatus
import java.math.BigInteger

data class SignIn(var signInId : BigInteger? = null, val accessName : String? = null, val accessPassword : String? = null, val site : String? = null, val description : String? = null, val userId : BigInteger? = null)


data class SignInUpdateRequest(val data: SignIn)
data class SignInUpdateResponse(val responseStatus: ResponseStatus)

data class SignInFindByIdRequest(val data : BigInteger? = null)
data class SignInFindByIdResponse(val responseStatus : ResponseStatus, val data : SignIn?)

data class SignInFindByUserIdRequest(val data : BigInteger? = null)
data class SignInFindByUserIdResponse(val responseStatus : ResponseStatus, val data : List<SignIn>?)
