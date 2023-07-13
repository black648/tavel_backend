package com.travel.global.config.sercurity

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter


@Configuration
@EnableWebSecurity
class SecurityConfig(
        val jwtTokenProvider: JwtTokenProvider
) {
    @Bean
    @Throws(Exception::class)
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .httpBasic{ httpBasic -> httpBasic.disable() }
            .csrf { csrf -> csrf.disable() }
            .sessionManagement{session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)}
            .authorizeHttpRequests { auth ->
                auth
                    .requestMatchers("/login/**", "/join/**", "/error/**").permitAll()
                    .requestMatchers("/").hasRole("USER")
                    .requestMatchers("/admin/**").hasRole("ADMIN")
                    .anyRequest().authenticated() }
            .addFilterBefore(JwtAuthFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter::class.java)
        return http.build()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder()
    }
}