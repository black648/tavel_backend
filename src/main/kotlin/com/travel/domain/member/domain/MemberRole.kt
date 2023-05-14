package com.travel.domain.member.domain

enum class MemberRole(
        val key: String? = null,
        val title: String? = null
) {
    USER("ROLE_USER", "일반회원"),
    AGENT("ROLE_AGENT", "중개인"),
    ADMIN("ROLE_ADMIN", "관리자");
}