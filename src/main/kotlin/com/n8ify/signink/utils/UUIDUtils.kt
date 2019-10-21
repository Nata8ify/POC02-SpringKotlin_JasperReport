package com.n8ify.signink.utils

import java.util.*

class UUIDUtils {

    companion object {
        fun generate(noDash : Boolean = false) : String {
            return if(noDash){
                UUID.randomUUID().toString().replace("-", "")
            } else {
                UUID.randomUUID().toString()
            }
        }
    }

}