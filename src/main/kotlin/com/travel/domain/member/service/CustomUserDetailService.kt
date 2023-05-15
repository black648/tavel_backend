package com.travel.domain.member.service

import com.travel.domain.member.domain.Member
import com.travel.domain.member.domain.MemberRepository
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class CustomUserDetailService(
        private val memberRepository: MemberRepository,
        private val passwordEncoder: PasswordEncoder
) : UserDetailsService {

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails {
        return memberRepository.findByEmail(username)
                .orElseThrow { UsernameNotFoundException("사용자를 찾을 수 없습니다.") }
    }

    private fun createUserDetails(member: Member) : UserDetails {
        return User.builder()
            .username(member.username)
            .password(passwordEncoder.encode(member.password))
            .roles(member.roles.map{it[0]}.toTypedArray().toString())
            .build()
    }
}

