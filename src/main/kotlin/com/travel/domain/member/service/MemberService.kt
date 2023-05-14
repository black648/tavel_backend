package com.travel.domain.member.service

import com.travel.domain.member.domain.Member
import com.travel.domain.member.domain.MemberRepository
import com.travel.domain.member.dto.MemberSaveDto
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service


@Service
class MemberService(
        private val passwordEncoder: PasswordEncoder,
        private val memberRepository: MemberRepository
) {
    fun save(saveDto: MemberSaveDto): Member {
        saveDto.password = passwordEncoder.encode(saveDto.password);
        return memberRepository.save(saveDto.toEntity());
    }
}


