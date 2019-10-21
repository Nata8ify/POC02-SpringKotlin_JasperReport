package com.n8ify.signink.service

import com.n8ify.signink.model.GenerateCredentialReportRequest
import org.springframework.http.ResponseEntity

interface DocumentService {

    fun generate(generateCredentialReportRequest: GenerateCredentialReportRequest) : ResponseEntity<ByteArray>

    fun generateCredentialSummary(generateCredentialReportRequest: GenerateCredentialReportRequest): ByteArray

}