package com.travel.domain.member.dto

import com.travel.domain.member.domain.Member
import com.travel.domain.member.domain.MemberRole

data class MemberSaveDto(
        var email: String,
        var pw: String,
        var name: String,
        var memberRole: MemberRole) {

    fun toEntity(): Member {
        return Member(
                email = email,
                pw = pw,
                name = name,
                memberRole = memberRole,
        )
    }
}
