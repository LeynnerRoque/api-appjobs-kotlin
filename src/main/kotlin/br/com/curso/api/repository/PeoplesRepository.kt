package br.com.curso.api.repository

import br.com.curso.api.model.Peoples
import org.springframework.data.jpa.repository.JpaRepository

interface PeoplesRepository: JpaRepository<Peoples, Long> {

    fun findPeoplesByJob_Title(title: String): List<Peoples>
}