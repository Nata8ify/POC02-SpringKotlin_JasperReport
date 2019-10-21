package com.n8ify.signink.service.impl

import com.n8ify.signink._base.service.AbstractBaseService
import com.n8ify.signink.model.GenerateCredentialReportRequest
import com.n8ify.signink.service.DocumentService
import net.sf.jasperreports.engine.JasperExportManager
import net.sf.jasperreports.engine.JasperFillManager
import net.sf.jasperreports.engine.JasperReport
import net.sf.jasperreports.engine.util.JRLoader
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.ClassPathResource
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.lang.Exception
import javax.sql.DataSource

@Service
class DocumentServiceImpl : AbstractBaseService(), DocumentService {

    @Autowired
    lateinit var dataSource : DataSource

    val PATH_JASPER by lazy { "static/jasper/" }
    val FILE_REPORT_CREDENTIAL by lazy { "${PATH_JASPER}Report_Credential.jasper" }
    val PARAM_USERID by lazy { "PARAM_USERID" }

    override fun generate(generateCredentialReportRequest: GenerateCredentialReportRequest): ResponseEntity<ByteArray> {
        val it = when(generateCredentialReportRequest.documentId){
            "CRED_SUMMARY" -> generateCredentialSummary(generateCredentialReportRequest)
            else -> throw Exception("No Matched ID")
        }


            val httpHeaders = HttpHeaders().apply {
                this@apply.contentType = MediaType.APPLICATION_PDF
                val filename = "${generateCredentialReportRequest.documentId}.pdf"
                this@apply.setContentDispositionFormData(filename, filename)
                this@apply.cacheControl = "must-revalidate, post-check=0, pre-check=0"

        }
        return ResponseEntity<ByteArray>(it, httpHeaders, HttpStatus.OK)
    }

    override fun generateCredentialSummary(generateCredentialReportRequest: GenerateCredentialReportRequest): ByteArray {
        return dataSource.connection.let {conn ->
            val fileInputStream = ClassPathResource(FILE_REPORT_CREDENTIAL).inputStream
            val jasperReport = JRLoader.loadObject(fileInputStream) as JasperReport
            val params = hashMapOf<String, Any?>(PARAM_USERID to generateCredentialReportRequest.userId.toInt())
            println("jasperReport =$jasperReport, params = $params, conn = $conn")
            val fillReport = JasperFillManager.fillReport(jasperReport, params, conn)
            return@let JasperExportManager.exportReportToPdf(fillReport)
        }.also {
            dataSource.connection.close()
        }
    }
}