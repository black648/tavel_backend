package com.travel.global.config.sercurity

import com.travel.global.util.LogSupport
import io.jsonwebtoken.*
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import io.jsonwebtoken.security.SecurityException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import java.security.Key
import java.util.*
import java.util.stream.Collectors
//볼로그 참조해보자
//https://mslim8803.tistory.com/57

@Component
class JwtTokenProvider(
        private var key: Key? = null
) {
    companion object: LogSupport

    fun JwtTokenProvider() {
        val keyBytes = Decoders.BASE64.decode("hanry")
        this.key = Keys.hmacShaKeyFor(keyBytes)
    }

    //토큰 생성
    fun generateToken(authentication: Authentication): TokenInfo {
        // 권한 가져오기
        val authorities: String = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","))
        val now: Long = Date().getTime()

        // Access Token 생성
        val accessTokenExpiresIn = Date(now + 86400000)
        val accessToken: String = Jwts.builder()
                .setSubject(authentication.getName())
                .claim("auth", authorities)
                .setExpiration(accessTokenExpiresIn)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact()

        // Refresh Token 생성
        val refreshToken: String = Jwts.builder()
                .setExpiration(Date(now + 86400000))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact()

        return TokenInfo(
                grantType = "Bearer",
                accessToken = accessToken,
                refreshToken = refreshToken)
    }

    // JWT 토큰을 복호화하여 토큰에 들어있는 정보를 꺼내는 메서드
    fun getAuthentication(accessToken: String): Authentication? {
        // 토큰 복호화
        val claims: Claims = parseClaims(accessToken)
        if (claims["auth"] == null) {
            throw RuntimeException("권한 정보가 없는 토큰입니다.")
        }

        // 클레임에서 권한 정보 가져오기
        val authorities: Collection<GrantedAuthority> = Arrays.stream(claims["auth"].toString().split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray())
                .map { role: String? -> SimpleGrantedAuthority(role) }
                .collect(Collectors.toList())

        // UserDetails 객체를 만들어서 Authentication 리턴
        val principal: UserDetails = User(claims.subject, "", authorities)
        return UsernamePasswordAuthenticationToken(principal, "", authorities)
    }

    // 토큰 정보를 검증하는 메서드
    fun validateToken(token: String?): Boolean {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token)
            return true
        } catch (e: SecurityException) {
            logger.info("Invalid JWT Token", e)
        } catch (e: MalformedJwtException) {
            logger.info("Invalid JWT Token", e)
        } catch (e: ExpiredJwtException) {
            logger.info("Expired JWT Token", e)
        } catch (e: UnsupportedJwtException) {
            logger.info("Unsupported JWT Token", e)
        } catch (e: IllegalArgumentException) {
            logger.info("JWT claims string is empty.", e)
        }
        return false
    }

    private fun parseClaims(accessToken: String): Claims {
        return try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(accessToken).getBody()
        } catch (e: ExpiredJwtException) {
            e.claims
        }
    }
}