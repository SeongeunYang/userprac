package com.example.userprac.model

import org.springframework.boot.autoconfigure.domain.EntityScan
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class User (
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int? = null,

        @Column(columnDefinition = "VARCHAR(10)")
        var username: String? = null,

        @Column(columnDefinition = "VARCHAR(15)")
        var password: String? = null,
) {
        fun updatePassword(newPwd: String) {
                this.password = newPwd
        }
}