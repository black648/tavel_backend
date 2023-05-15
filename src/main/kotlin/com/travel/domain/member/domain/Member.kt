package com.travel.domain.member.domain

import jakarta.persistence.*
import lombok.Builder
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.stream.Collectors

@Entity
@Table(name = "member")
class Member(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,

        @Column(nullable = false)
        val name: String,

        @Column(nullable = false)
        val email: String,

        @Column(nullable = false)
        val pw: String,

        @Enumerated(EnumType.STRING)
        @Column(nullable = false)
        val memberRole: MemberRole,

        @ElementCollection(fetch = FetchType.EAGER)
        @Builder.Default
        val roles: MutableList<String> = mutableListOf<String>()

) : UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return this.roles.stream()
            .map{SimpleGrantedAuthority(it)}
            .collect(Collectors.toList())
    }

    override fun getPassword(): String {
        return pw
    }

    override fun getUsername(): String {
        return email
    }

    override fun isAccountNonExpired(): Boolean {
        return true;
    }

    override fun isAccountNonLocked(): Boolean {
        return true;
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true;
    }

    override fun isEnabled(): Boolean {
        return true;
    }

}