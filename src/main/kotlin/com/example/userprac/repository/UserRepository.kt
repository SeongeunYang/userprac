package com.example.userprac.repository

import com.example.userprac.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Int> {

}