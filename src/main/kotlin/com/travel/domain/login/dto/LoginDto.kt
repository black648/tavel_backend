package com.travel.domain.login.dto

import com.travel.domain.member.domain.Member
import com.travel.domain.member.domain.MemberRole
import com.travel.global.config.sercurity.TokenInfo

data class LoginDto(
        val email: String,
        val password: String,
        val name: String,
        val memberRole: MemberRole,
        val tokenInfo: TokenInfo) {

    companion object {
        fun of(member: Member, tokenInfo: TokenInfo): LoginDto {
            return LoginDto(
                    email = member.email,
                    password = member.password,
                    name = member.name,
                    memberRole = member.memberRole,
                    tokenInfo = tokenInfo
            )
        }
    }
}
