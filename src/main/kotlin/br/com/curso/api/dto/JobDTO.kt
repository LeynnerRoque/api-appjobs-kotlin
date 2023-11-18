package br.com.curso.api.dto

data class JobDTO (
    val id: Long? = null,
    val title: String? = null,
    val description: String? = null,
    val salary: Double? = null,
    val enterpriseId: Long? = null,
)