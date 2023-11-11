package br.com.curso.api.dto.mapper

interface IMapper<T,U> {

    fun mapTo(t: T): U
}