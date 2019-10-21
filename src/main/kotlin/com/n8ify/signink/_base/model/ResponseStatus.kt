package com.n8ify.signink._base.model

import java.sql.Date
import java.sql.Time
import java.sql.Timestamp
import java.time.LocalDateTime

const val RESPONSE_SUCCESS = "SUCCESS"
const val RESPONSE_FAIL = "FAIL"
const val RESPONSE_ERROR = "ERROR"
const val RESPONSE_UNSET = "-"

data class ResponseStatus(val status : String = RESPONSE_UNSET, val message : String?, val timestamp: LocalDateTime = LocalDateTime.now())