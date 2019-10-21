package com.n8ify.signink.controller

import com.n8ify.signink.model.UserDto
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView
import javax.validation.Valid

@Controller
class RegisterController {

    @GetMapping("/register")
    fun signUp(model : Model) : String{
        val userRegister = UserDto()
        model.addAttribute("userRegister", userRegister)
        return "register"
    }

    @PostMapping("/register")
    fun register(@Valid @ModelAttribute("user") userRegister : UserDto) : String {
        println("--> $userRegister")
        return "register"
    }
}