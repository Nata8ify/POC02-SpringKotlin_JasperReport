package com.n8ify.signink.dao

import com.n8ify.signink.model.SignIn
import java.math.BigInteger

interface SignInDao {

    fun insert(data : SignIn)

    fun update(data : SignIn)

    fun delete(signInId : BigInteger)

    fun findById(signInId : BigInteger) : SignIn?
    fun findByUserId(userId : BigInteger) : List<SignIn>?

    // ------------------------------------ Miscellaneous Sign-in's DAO Function --------------------------------------
    fun getLatestSignInId(): BigInteger
}