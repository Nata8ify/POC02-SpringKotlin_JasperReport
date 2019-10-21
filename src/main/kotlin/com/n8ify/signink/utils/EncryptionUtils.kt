package com.n8ify.signink.utils

import java.security.MessageDigest
import java.util.*
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec
import javax.xml.bind.DatatypeConverter

class EncryptionUtils {

    companion object {

        private const val CHARSET_UTF8 = "UTF-8"
        private const val ALGORITHM_AES = "AES"
        private const val ALGORITHM_MD5 = "MD5"

        fun toMD5Hash(secret : String ) : String {
            val md5 = MessageDigest.getInstance(ALGORITHM_MD5)
            md5.update(secret.toByteArray())
            return DatatypeConverter.printHexBinary(md5.digest())
        }

        fun aesEncrypt(secret : String, key : String) : String {
            val byteKey = key.toByteArray(charset(CHARSET_UTF8))
            val secretKeySpec = SecretKeySpec(byteKey, ALGORITHM_AES)
            val cipher = Cipher.getInstance(ALGORITHM_AES)
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec)

            return cipher.doFinal(Base64.getDecoder().decode(secret.toByteArray(charset(CHARSET_UTF8)))).toString()

        }

        fun aesDecrypt(secret : String, key : String) : String {
            val byteKey = key.toByteArray(charset(CHARSET_UTF8))
            val secretKeySpec = SecretKeySpec(byteKey, ALGORITHM_AES)
            val cipher = Cipher.getInstance(ALGORITHM_AES)
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec)

            return cipher.doFinal(Base64.getDecoder().decode(secret.toByteArray(charset(CHARSET_UTF8)))).toString()
        }
    }
}

fun main(args: Array<String>) {
    println(EncryptionUtils.aesEncrypt("Hellooooo", "134c1ea111eaabcf"))
    println(EncryptionUtils.aesDecrypt("[B@548b7f67", "134c1ea111eaabcf"))
}