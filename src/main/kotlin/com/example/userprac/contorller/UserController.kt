package com.example.userprac.contorller

import com.example.userprac.dto.UserRequestDto
import com.example.userprac.dto.UserResponseDto
import com.example.userprac.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController {
    @Autowired
    var userService: UserService?= null

    @PostMapping("/signup")
    fun signUp(@RequestBody userRequestDto: UserRequestDto): Boolean {
        return userService!!.signUp(userRequestDto)
    }

    @GetMapping("/profile/{userId}")
    fun myProfile(@PathVariable userId: Int): UserResponseDto {
        return userService!!.getUserProfile(userId)
    }

    @PutMapping("/profile/{userId}")
    fun updateProfile(@PathVariable userId: Int, @RequestBody newPwd: String): Boolean{
        return userService!!.updateProfile(userId, newPwd)
    }

    @DeleteMapping("/{userId}")
    fun deleteUser(@PathVariable userId: Int): Boolean{
        return userService!!.deleteUser(userId)
    }
}