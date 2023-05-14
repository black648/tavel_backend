package com.travel.domain.login.dto

import com.travel.domain.member.domain.Member
import com.travel.domain.member.domain.MemberRole

data class LoginDto(
        val email: String,
        val password: String,
        val name: String,
        val memberRole: MemberRole,
        val tokenKey: String) {

    companion object {
        fun of(member: Member, tokenKey: String): LoginDto {
            return LoginDto(
                    email = member.email,
                    password = member.password,
                    name = member.name,
                    memberRole = member.memberRole,
                    tokenKey = tokenKey
            )
        }
    }
}
