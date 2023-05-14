package com.travel.domain.member.dto

import com.travel.domain.member.domain.Member
import com.travel.domain.member.domain.MemberRole

data class MemberSaveDto(
        var email: String,
        var password: String,
        var name: String,
        var memberRole: MemberRole) {

    fun toEntity(): Member {
        return Member(
                email = email,
                password = password,
                name = name,
                memberRole = memberRole,
        )
    }
}
