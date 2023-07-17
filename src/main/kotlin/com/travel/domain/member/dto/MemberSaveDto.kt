package com.travel.domain.member.dto

import com.travel.domain.member.domain.Member

data class MemberSaveDto(
        var email: String,
        var password: String,
        var name: String) {

    fun toEntity(): Member {
        return Member(
                email = email,
                password = password,
                name = name,
        )
    }
}
