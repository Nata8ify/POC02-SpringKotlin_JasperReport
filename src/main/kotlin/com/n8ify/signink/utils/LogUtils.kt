package com.n8ify.signink.utils

import org.slf4j.LoggerFactory
import java.lang.Exception
import java.util.logging.Logger

const val LOG_LEVEL_DEBUG = "DEBUG"
const val LOG_LEVEL_INFO = "INFO"
const val LOG_LEVEL_WARN = "WARN"
const val LOG_LEVEL_ERROR = "ERROR"

const val LOG_STATUS_SUCCESS = "SUCCESS"
const val LOG_STATUS_FAILED = "FAIL"

class LogUtils {

    companion object {

        private val debugLogger = LoggerFactory.getLogger(LOG_LEVEL_DEBUG)
        private val infoLogger  = LoggerFactory.getLogger(LOG_LEVEL_INFO)
        private val warnLogger  = LoggerFactory.getLogger(LOG_LEVEL_WARN)
        private val errorLogger = LoggerFactory.getLogger(LOG_LEVEL_ERROR)

        fun debug(logRef: String, status: String = LOG_STATUS_SUCCESS, message: String, vararg any : Any?) {
            debugLogger.debug("[$status] :: [$logRef] -- [Message = $message] \n [$any]")
        }

        fun info(logRef: String, status: String = LOG_STATUS_SUCCESS, message: String, vararg any : Any?) {
            infoLogger.debug("[$status] :: [$logRef] -- [Message = $message] \n [$any]")
        }

        fun warn(logRef: String, status: String = LOG_STATUS_SUCCESS, message: String, vararg any : Any?) {
            warnLogger.debug("[$status] :: [$logRef] -- [Message = $message] \n [$any]")
        }

        fun error(logRef: String, status: String = LOG_STATUS_FAILED, message: String, e: Exception, vararg any : Any?) {
            errorLogger.debug("[$status] :: [$logRef] -- [Message = $message] \n [Error = $e]  \n [$any]")
        }

        fun debugAccess(logRef: String, status: String = LOG_STATUS_SUCCESS, message: String, input: Any? = null, output: Any? = null) {
            debugLogger.debug("[$status] :: [$logRef] -- [Message = $message] \n [Input = $input, Output = $output]")
        }

        fun infoAccess(logRef: String, status: String = LOG_STATUS_SUCCESS, message: String, input: Any? = null, output: Any? = null) {
            infoLogger.debug("[$status] :: [$logRef] -- [Message = $message] \n [Input = $input, Output = $output]")
        }

        fun warnAccess(logRef: String, status: String = LOG_STATUS_SUCCESS, message: String, input: Any? = null, output: Any? = null) {
            warnLogger.debug("[$status] :: [$logRef] -- [Message = $message] \n [Input = $input, Output = $output]")
        }

        fun errorAccess(logRef: String, status: String = LOG_STATUS_FAILED, message: String, e: Exception, input: Any? = null, output: Any? = null) {
            errorLogger.debug("[$status] :: [$logRef] -- [Message = $message] \n [Error = $e] [Input = $input, Output = $output]")
        }
    }

}