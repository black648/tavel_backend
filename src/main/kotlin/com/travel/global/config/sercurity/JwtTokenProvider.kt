package com.travel.global.config.sercurity

import com.travel.domain.member.dto.CustomUser
import com.travel.global.util.LogSupport
import io.jsonwebtoken.*
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import io.jsonwebtoken.security.SecurityException
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import java.lang.Exception
import java.util.*

@Component
class JwtTokenProvider {
    @Value("\${jwt.secret}")
    lateinit var secretKey: String;

    private val key by lazy { Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey))}

    companion object: LogSupport

    //토큰 생성
    fun generateToken(authentication: Authentication): TokenInfo {
        // 권한 가져오기
        val authorities: String = authentication.authorities.joinToString(",", transform = GrantedAuthority::getAuthority)
        val now = Date()
        val accessTokenExpiresIn = Date(now.time + 86400000)

        // Access Token 생성
        val accessToken: String = Jwts.builder()
                .setSubject(authentication.name)
                .claim("auth", authorities)
                .claim("userId", (authentication.principal as CustomUser).userId)
                .setIssuedAt(now)
                .setExpiration(accessTokenExpiresIn)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact()

        // Refresh Token 생성
        val refreshToken: String = Jwts.builder()
                .setExpiration(accessTokenExpiresIn)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact()

        return TokenInfo(
                grantType = "Bearer",
                accessToken = accessToken,
                refreshToken = refreshToken)
    }

    // JWT 토큰을 복호화하여 토큰에 들어있는 정보를 꺼내는 메서드
    fun getAuthentication(accessToken: String): Authentication {
        // 토큰 복호화
        val claims: Claims = parseClaims(accessToken)
        val auth = claims["auth"] ?: throw RuntimeException("잘못된 토큰입니다.")
        val userId = claims["userId"] ?: throw RuntimeException("잘못된 토큰입니다.")

        // 권한정보 추출
        val authorities: Collection<GrantedAuthority> = (auth as String).split(",").map{SimpleGrantedAuthority(it)}
        val principal: UserDetails =  CustomUser(userId.toString().toLong(), claims.subject, "", authorities)

        return UsernamePasswordAuthenticationToken(principal, "", authorities)
    }

    // 토큰 정보를 검증하는 메서드
    fun validateToken(token: String): Boolean {
        try {
            parseClaims(token)
            return true
        } catch (e: Exception) {
            when (e) {
                is SecurityException -> {}
                is MalformedJwtException -> {}
                is ExpiredJwtException -> {}
                is UnsupportedJwtException -> {}
                is IllegalArgumentException -> {}
                else -> {}
            }
            logger.error(e.message)
        }
        return false
    }

    private fun parseClaims(accessToken: String): Claims =
        Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(accessToken).body

}