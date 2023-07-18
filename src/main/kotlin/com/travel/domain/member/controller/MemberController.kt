package com.travel.domain.member.controller

import com.travel.domain.member.dto.CustomUser
import com.travel.domain.member.dto.MemberResponseDto
import com.travel.domain.member.service.MemberService
import com.travel.global.base.BaseResponse
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MemberController(
    private val memberService: MemberService
) {
    @GetMapping("/get")
    fun get(): BaseResponse<MemberResponseDto> {
        val userId = (SecurityContextHolder
            .getContext()
            .authentication
            .principal as CustomUser)
            .userId
        val response = memberService.get(userId)
        return BaseResponse(data = response)
    }
}