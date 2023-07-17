package com.travel.domain.login.controller

import com.travel.domain.login.dto.LoginDto
import com.travel.domain.login.service.LoginService
import com.travel.domain.member.dto.MemberSaveDto
import com.travel.global.base.BaseResponse
import com.travel.global.config.sercurity.TokenInfo
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class LoginController(
    private val loginService: LoginService
) {
    @PostMapping("/join")
    fun save(@RequestBody dto: MemberSaveDto): BaseResponse<TokenInfo> {
        val message: String = loginService.doJoin(dto)
        return BaseResponse(
            data = loginService.login(LoginDto(_email = dto.email, _password = dto.password)),
            message = message
        )
    }

    @PostMapping("/login")
    fun login(@RequestBody dto: LoginDto): BaseResponse<TokenInfo> {
        return BaseResponse(data = loginService.login(dto))
    }
}