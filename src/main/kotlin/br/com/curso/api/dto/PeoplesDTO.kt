package br.com.curso.api.dto

data class PeoplesDTO (
        val id: Long? =null,
        val name: String? = null,
        val gender: String? = null,
        val age: Int? = null,
        val regionName: String? = null,
        val email: String? = null,
        val phone: String? = null,
        val jobId: Long?= null,
        val locationId: Long? = null,
)