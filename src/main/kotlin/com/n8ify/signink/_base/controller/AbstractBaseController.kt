package com.n8ify.signink._base.controller

import com.n8ify.signink._base.model.ResponseStatus
import org.springframework.beans.factory.annotation.Autowired
import sun.security.provider.certpath.OCSPResponse
import javax.servlet.http.HttpSession

abstract class AbstractBaseController {

    fun getResponseStatus(status : String, message : String? = null) : ResponseStatus {
        return ResponseStatus(status = status, message = message)
    }

}