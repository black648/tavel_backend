package com.travel.global.config.sercurity

data class TokenInfo(
        val grantType: String,
        val accessToken: String,
        val refreshToken: String) {
}