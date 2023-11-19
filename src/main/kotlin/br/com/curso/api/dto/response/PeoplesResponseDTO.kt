package br.com.curso.api.dto.response

data class PeoplesResponseDTO (
        val id: Long? =null,
        val name: String? = null,
        val gender: String? = null,
        val age: Int? = null,
        val regionName: String? = null,
        val email: String? = null,
        val phone: String? = null,
        val job: String?= null,
        val location: String? = null,
)