package com.n8ify.signink.controller.rest

import com.n8ify.signink._base.controller.AbstractBaseController
import com.n8ify.signink._base.model.RESPONSE_SUCCESS
import com.n8ify.signink.model.*
import com.n8ify.signink.service.SignInService
import com.sun.beans.TypeResolver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/signin")
class SignInController : AbstractBaseController(){

    @Autowired
    lateinit var signInService : SignInService

    val ENDPOINT_ROOT = "/"

    @GetMapping("/")
    fun findById(@RequestBody signInFindByIdRequest: SignInFindByIdRequest) : SignInFindByIdResponse {
        signInService.findById(signInFindByIdRequest).let {
            return SignInFindByIdResponse(getResponseStatus(RESPONSE_SUCCESS), it)
        }
    }

    @GetMapping("/findByUserId")
    fun findByUserId(@RequestBody signInFindByUserIdRequest: SignInFindByUserIdRequest) : SignInFindByUserIdResponse {
        signInService.findByUserId(signInFindByUserIdRequest).let {
            return SignInFindByUserIdResponse(getResponseStatus(RESPONSE_SUCCESS), it)
        }

    }

    @PostMapping("/update")
    fun update(@RequestBody signInUpdateRequest : SignInUpdateRequest) : SignInUpdateResponse {
        signInService.update(signInUpdateRequest).let {
            return SignInUpdateResponse(getResponseStatus(RESPONSE_SUCCESS))
        }
    }

}
