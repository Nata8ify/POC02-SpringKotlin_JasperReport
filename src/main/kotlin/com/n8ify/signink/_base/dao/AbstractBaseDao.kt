package com.n8ify.signink._base.dao

import com.n8ify.signink.utils.LogUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport
import java.lang.StringBuilder
import javax.servlet.http.HttpSession
import javax.sql.DataSource


abstract class AbstractBaseDao : NamedParameterJdbcDaoSupport() {

    @Autowired
    lateinit var httpSession : HttpSession

    @Autowired
    fun setBaseDataSource(dataSource: DataSource) {
        setDataSource(dataSource)
    }

    fun logQueryFactor(sql : String, params : MapSqlParameterSource?){
        LogUtils.info(logRef = httpSession.id, message = "SQL Statement", any = *arrayOf(sql))
        LogUtils.info(logRef = httpSession.id, message = "SQL Parameter(s)", any = *arrayOf(params?.values))
    }

}