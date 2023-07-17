package com.travel.domain.login.service

import com.travel.domain.login.dto.LoginDto
import com.travel.domain.member.domain.Member
import com.travel.domain.member.domain.MemberRepository
import com.travel.domain.member.dto.MemberSaveDto
import com.travel.domain.member.service.MemberService
import com.travel.global.config.sercurity.JwtTokenProvider
import com.travel.global.config.sercurity.TokenInfo
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Service
import kotlin.math.log


@Service
class LoginService(
    private val authenticationManagerBuilder: AuthenticationManagerBuilder,
    private val tokenProvider: JwtTokenProvider,
    private val memberService: MemberService,
) {
    fun doJoin(dto: MemberSaveDto) : TokenInfo {
        val member : Member = memberService.save(dto);
        return login(LoginDto(member.email, member.password))
    }

    fun login(loginDto: LoginDto): TokenInfo {
        // 1. Login ID/PW 를 기반으로 Authentication 객체 생성
        // 이때 authentication 는 인증 여부를 확인하는 authenticated 값이 false
        val authenticationToken = UsernamePasswordAuthenticationToken(loginDto.email, loginDto.password)

        // 2. 실제 검증 (사용자 비밀번호 체크)이 이루어지는 부분
        // authenticate 매서드가 실행될 때 CustomUserDetailsService 에서 만든 loadUserByUsername 메서드가 실행
        val authentication = authenticationManagerBuilder.`object`.authenticate(authenticationToken)
        // 3. 인증 정보를 기반으로 JWT 토큰 생성
        return tokenProvider.generateToken(authentication)
    }
}