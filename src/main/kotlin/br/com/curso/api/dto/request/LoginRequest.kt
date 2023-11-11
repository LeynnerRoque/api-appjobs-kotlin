package br.com.curso.api.dto.request

data class LoginRequest(
        val login: String,
        val password: String
)