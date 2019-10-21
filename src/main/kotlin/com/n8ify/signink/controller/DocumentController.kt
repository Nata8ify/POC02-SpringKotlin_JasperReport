package com.n8ify.signink.controller

import com.n8ify.signink._base.controller.AbstractBaseController
import com.n8ify.signink.model.GenerateCredentialReportRequest
import com.n8ify.signink.service.DocumentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping


@Controller
class DocumentController : AbstractBaseController() {

    @Autowired
    lateinit var documentService: DocumentService

    @GetMapping("/credsummary")
    fun credsummary(@RequestBody generateCredentialReportRequest: GenerateCredentialReportRequest) : ResponseEntity<ByteArray> {
        return documentService.generate(generateCredentialReportRequest)
    }
}