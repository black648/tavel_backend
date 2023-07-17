package com.travel.domain.member.domain

import com.travel.domain.member.dto.MemberResponseDto
import com.travel.global.base.BaseEntity
import com.travel.global.enum.MemberRoles
import jakarta.persistence.*

@Entity
@Table(name = "member", uniqueConstraints = [
        UniqueConstraint(name = "uk_member_email", columnNames = ["email"])
    ])
class Member(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,

        @Column(nullable = false, length = 10)
        val name: String,

        @Column(nullable = false, length = 30)
        val email: String,

        @Column(nullable = false, length = 50)
        val password: String
): BaseEntity() {
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
    val memberRole: List<MemberRole>? = null

    fun toDto(): MemberResponseDto = MemberResponseDto(
        id!!,
        email,
        name
    )
}

@Entity
class MemberRole(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null,

    @Column(nullable = false, length = 30)
    @Enumerated(EnumType.STRING)
    val role: MemberRoles,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = ForeignKey(name = "fk_member_role_member_id"))
    val member: Member
)