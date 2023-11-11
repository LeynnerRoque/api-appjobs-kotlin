package br.com.curso.api.request

data class LoginRequest(
        val login: String,
        val password: String
)