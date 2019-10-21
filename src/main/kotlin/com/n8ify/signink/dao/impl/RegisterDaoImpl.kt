package com.n8ify.signink.dao.impl

import com.n8ify.signink._base.dao.AbstractBaseDao
import com.n8ify.signink.dao.RegisterDao
import com.n8ify.signink.model.User
import org.springframework.stereotype.Repository
import java.math.BigInteger

@Repository
class RegisterDaoImpl : AbstractBaseDao(), RegisterDao {

    private val TABLE_USER = "user"
    private val FIELD_USERID = "user_id"
    private val FIELD_USERNAME = "username"
    private val FIELD_PASSWORD = "password"

    override fun insert(user: User) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun update(user: User) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(userId: BigInteger) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findByUsernameAndPassword(username: String, password: String): User? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}