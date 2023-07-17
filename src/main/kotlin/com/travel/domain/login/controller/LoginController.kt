package com.travel.domain.login.controller

import com.travel.domain.login.dto.LoginDto
import com.travel.domain.login.service.LoginService
import com.travel.domain.member.dto.MemberSaveDto
import com.travel.global.result.ResultSet
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class LoginController(
    private val loginService: LoginService
) {
    @PostMapping("/join")
    fun save(@RequestBody dto: MemberSaveDto) {
        ResultSet.resultData(loginService.doJoin(dto))
    }

    @PostMapping("/login")
    fun login(@RequestBody dto: LoginDto) {
        ResultSet.resultData(loginService.login(dto))
    }
}