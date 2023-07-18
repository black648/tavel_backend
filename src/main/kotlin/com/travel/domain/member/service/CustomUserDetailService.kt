package com.travel.domain.member.service

import com.travel.domain.member.domain.Member
import com.travel.domain.member.domain.MemberRepository
import com.travel.domain.member.dto.CustomUser
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class CustomUserDetailService(
        private val memberRepository: MemberRepository,
        private val passwordEncoder: PasswordEncoder
) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails =
        memberRepository.findByEmail(username)
            ?.let { createUserDetails(it) }
            ?: throw Exception("해당 유저를 찾을 수 없습니다.")

    private fun createUserDetails(member: Member): UserDetails =
        CustomUser(member.id!!
            , member.email
            , passwordEncoder.encode(member.password)
            , member.memberRole!!.map { SimpleGrantedAuthority("ROLE_${it.role}") })

}

