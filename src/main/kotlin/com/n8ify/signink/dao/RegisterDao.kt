package com.n8ify.signink.dao

import com.n8ify.signink.model.User
import java.math.BigInteger

interface RegisterDao {

    fun insert(user : User)
    fun update(user : User)

    fun delete(userId : BigInteger)

    fun findByUsernameAndPassword(username : String, password : String) : User?
}