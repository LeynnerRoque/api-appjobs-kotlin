package br.com.curso.api.dto

data class LocationDTO (
        val id: Long,
        val streetAddress: String,
        val postalCode: String,
        val city: String,
        val stateProvince: String

)