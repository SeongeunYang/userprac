package com.example.userprac.service

import com.example.userprac.dto.UserRequestDto
import com.example.userprac.dto.UserResponseDto
import com.example.userprac.model.User
import com.example.userprac.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService {
    @Autowired
    var userRepository: UserRepository?= null

    @Transactional
    fun signUp(userRequestDto: UserRequestDto): Boolean {
        val user: User = User().apply {
            this.username = userRequestDto.username
            this.password = userRequestDto.password
        }

        userRepository!!.save(user)

        return true
    }

    fun getUserProfile(userId: Int): UserResponseDto {
        val user = userRepository!!.findByIdOrNull(userId)?: throw java.lang.IllegalArgumentException("해당 유저 아이디가 없습니다")

        return UserResponseDto(user.username, user.password)
    }

    @Transactional
    fun updateProfile(userId: Int, newPwd: String): Boolean {
        var user = userRepository!!.findByIdOrNull(userId)?: throw java.lang.IllegalArgumentException("해당 유저 아이디가 없습니다")
        user.updatePassword(newPwd)

        return true
    }

    @Transactional
    fun deleteUser(userId: Int): Boolean{
        userRepository!!.deleteById(userId)
        return true
    }
}