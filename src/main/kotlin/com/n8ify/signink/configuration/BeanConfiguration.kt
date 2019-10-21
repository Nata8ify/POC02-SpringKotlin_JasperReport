package com.n8ify.signink.configuration

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.servlet.http.HttpSession

@Configuration
class BeanConfiguration {


    @Autowired
    lateinit var httpSession: HttpSession

}