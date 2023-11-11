package br.com.curso.api.repository

import br.com.curso.api.model.Location
import org.springframework.data.jpa.repository.JpaRepository

interface LocationRepository: JpaRepository<Location, Long> {
}