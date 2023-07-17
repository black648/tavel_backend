package com.travel.domain.member.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MemberRoleRepository : JpaRepository<MemberRole, Long> {
}