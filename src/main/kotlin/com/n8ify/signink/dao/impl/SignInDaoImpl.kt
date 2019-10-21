package com.n8ify.signink.dao.impl

import com.n8ify.signink._base.dao.AbstractBaseDao
import com.n8ify.signink.dao.SignInDao
import com.n8ify.signink.model.SignIn
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.stereotype.Repository
import java.lang.StringBuilder
import java.math.BigInteger
import java.sql.ResultSet

@Repository
class SignInDaoImpl : AbstractBaseDao(), SignInDao {

    private val TABLE_SIGNIN = "signin"

    private val FIELD_SIGNINID = "signin_id"
    private val FIELD_ACCESSNAME = "access_name"
    private val FIELD_ACCESSPASSWORD = "access_password"
    private val FIELD_SITE = "site"
    private val FIELD_DESCIPRITON = "description"
    private val FIELD_USERID = "user_id"

    override fun insert(data: SignIn) {

        val sql = StringBuilder().apply {
            this@apply.append(" INSERT INTO $TABLE_SIGNIN ($FIELD_ACCESSNAME, $FIELD_ACCESSPASSWORD, $FIELD_SITE, $FIELD_DESCIPRITON, $FIELD_USERID)")
            this@apply.append(" VALUES (:$FIELD_ACCESSNAME, :$FIELD_ACCESSPASSWORD, :$FIELD_SITE, :$FIELD_DESCIPRITON, :$FIELD_USERID)")
        }.toString()


        val params = MapSqlParameterSource().apply {
            this@apply.addValue(FIELD_ACCESSNAME, data.accessName)
            this@apply.addValue(FIELD_ACCESSPASSWORD, data.accessPassword)
            this@apply.addValue(FIELD_SITE, data.site)
            this@apply.addValue(FIELD_DESCIPRITON, data.description)
            this@apply.addValue(FIELD_USERID, data.userId)
        }

        logQueryFactor(sql, params)

        namedParameterJdbcTemplate?.update(sql, params)
    }

    override fun update(data: SignIn) {

        val sql = StringBuilder().apply {

            var isFirstParameterPassed = false

            this@apply.append(" UPDATE $TABLE_SIGNIN SET")

            data.accessName?.let {
                this@apply.append(" $FIELD_ACCESSNAME = :$FIELD_ACCESSNAME")
                isFirstParameterPassed = true
            }
            data.accessPassword?.let {
                if(isFirstParameterPassed) { this@apply.append(", ") }
                this@apply.append(" $FIELD_ACCESSPASSWORD = :$FIELD_ACCESSPASSWORD")
                isFirstParameterPassed = true
            }
            data.site?.let {
                if(isFirstParameterPassed) { this@apply.append(", ") }
                this@apply.append(" $FIELD_SITE = :$FIELD_SITE")
                isFirstParameterPassed = true
            }
            data.description?.let {
                if(isFirstParameterPassed) { this@apply.append(", ") }
                this@apply.append(" $FIELD_DESCIPRITON = :$FIELD_DESCIPRITON")
            }


            this@apply.append(" WHERE $FIELD_SIGNINID = :$FIELD_SIGNINID")

        }.toString()


        val params = MapSqlParameterSource().apply {
            data.accessName?.let {this@apply.addValue(FIELD_ACCESSNAME, data.accessName) }
            data.accessPassword?.let { this@apply.addValue(FIELD_ACCESSPASSWORD, data.accessPassword) }
            data.site?.let { this@apply.addValue(FIELD_SITE, data.site) }
            data.description?.let { this@apply.addValue(FIELD_DESCIPRITON, data.description) }
            this@apply.addValue(FIELD_SIGNINID, data.signInId)
        }

        logQueryFactor(sql, params)

        namedParameterJdbcTemplate?.update(sql, params)
    }

    override fun delete(signInId: BigInteger) {

        val sql = StringBuilder().apply {
            this@apply.append("DELETE FROM $TABLE_SIGNIN WHERE $FIELD_SIGNINID = :$FIELD_SIGNINID")
        }.toString()

        val params = MapSqlParameterSource().apply {
            this@apply.addValue(FIELD_SIGNINID, signInId)
        }

        logQueryFactor(sql, params)

        namedParameterJdbcTemplate?.update(sql, params)
    }

    override fun findById(signInId: BigInteger): SignIn? {

        val sql = StringBuilder().apply {
            this@apply.append(" SELECT $FIELD_SIGNINID, $FIELD_ACCESSNAME, $FIELD_ACCESSPASSWORD, $FIELD_SITE, $FIELD_DESCIPRITON, $FIELD_USERID FROM $TABLE_SIGNIN")
            this@apply.append(" WHERE $FIELD_SIGNINID = :$FIELD_SIGNINID")
        }.toString()

        val params = MapSqlParameterSource().apply {
            this@apply.addValue(FIELD_SIGNINID, signInId)
        }

        logQueryFactor(sql, params)

        return namedParameterJdbcTemplate?.query(sql, params) { rs, _ ->
            SignIn(signInId = rs.getBigDecimal(FIELD_SIGNINID)?.let { return@let it.toBigInteger() }
                    , accessName = rs.getString(FIELD_ACCESSNAME)
                    , accessPassword = rs.getString(FIELD_ACCESSPASSWORD)
                    , description = rs.getString(FIELD_DESCIPRITON)
                    , site = rs.getString(FIELD_SITE)
                    , userId = rs.getBigDecimal(FIELD_USERID)?.let { return@let it.toBigInteger() })
        }?.first()

    }

    override fun findByUserId(userId: BigInteger): List<SignIn>? {
        val sql = StringBuilder().apply {
            this@apply.append(" SELECT $FIELD_SIGNINID, $FIELD_ACCESSNAME, $FIELD_ACCESSPASSWORD, $FIELD_SITE, $FIELD_DESCIPRITON, $FIELD_USERID FROM $TABLE_SIGNIN")
            this@apply.append(" WHERE $FIELD_USERID = :$FIELD_USERID")
        }.toString()

        val params = MapSqlParameterSource().apply {
            this@apply.addValue(FIELD_USERID, userId)
        }

        logQueryFactor(sql, params)

        return namedParameterJdbcTemplate?.query(sql, params, object : RowMapper<SignIn>{
            override fun mapRow(rs: ResultSet, p1: Int): SignIn? {
                return SignIn(signInId = rs.getBigDecimal(FIELD_SIGNINID)?.let { return@let it.toBigInteger() }
                        , accessName = rs.getString(FIELD_ACCESSNAME)
                        , accessPassword = rs.getString(FIELD_ACCESSPASSWORD)
                        , description = rs.getString(FIELD_DESCIPRITON)
                        , site = rs.getString(FIELD_SITE)
                        , userId = rs.getBigDecimal(FIELD_USERID)?.let { return@let it.toBigInteger() })
            }
        })
    }

    // ------------------------------------ Miscellaneous Sign-in's DAO Function --------------------------------------

    override fun getLatestSignInId(): BigInteger {
        val sql = StringBuilder().apply {
            this@apply.append("SELECT MAX($FIELD_SIGNINID) FROM $TABLE_SIGNIN")
        }.toString()

        logQueryFactor(sql, null)

        return namedParameterJdbcTemplate?.query(sql, RowMapper { rs, _ ->  rs.getBigDecimal(FIELD_USERID)?.let { return@let it.toBigInteger() }})?.first()?:0.toBigInteger()
    }
}