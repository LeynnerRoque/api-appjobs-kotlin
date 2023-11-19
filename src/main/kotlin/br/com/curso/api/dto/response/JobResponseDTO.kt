package br.com.curso.api.dto.response

data class JobResponseDTO (
        val id: Long? = null,
        val title: String? = null,
        val description: String? = null,
        val salary: Double? = null,
        val enterpriseName: String? = null,
)