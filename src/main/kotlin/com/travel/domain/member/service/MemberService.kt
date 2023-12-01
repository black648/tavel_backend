package com.travel.domain.member.service

import com.travel.domain.member.domain.Member
import com.travel.domain.member.domain.MemberRepository
import com.travel.domain.member.domain.MemberRole
import com.travel.domain.member.domain.MemberRoleRepository
import com.travel.domain.member.dto.MemberResponseDto
import com.travel.domain.member.dto.MemberSaveDto
import com.travel.global.enum.MemberRoles
import com.travel.global.exception.InvalidInputException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class MemberService(
        private val passwordEncoder: PasswordEncoder,
        private val memberRepository: MemberRepository,
        private val memberRoleRepository: MemberRoleRepository
) {
    fun save(saveDto: MemberSaveDto): Member {
        // email 중복검사
        memberRepository.findByEmail(saveDto.email)
            .ifPresent{ InvalidInputException("이미 등록된 이메일 입니다.") };

        saveDto.password = passwordEncoder.encode(saveDto.password);
        var member = memberRepository.save(saveDto.toEntity());
        memberRoleRepository.save(MemberRole(null, MemberRoles.USER, member))

        return member;
    }

    fun get(id: Long): MemberResponseDto {
        val member: Member = memberRepository.findByIdOrNull(id) ?: throw InvalidInputException("id", "회원번호(${id})가 존재하지 않는 유저입니다.")
        return member.toDto()
    }
}


