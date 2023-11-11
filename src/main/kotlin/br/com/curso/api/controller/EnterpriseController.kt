package br.com.curso.api.controller

import br.com.curso.api.dto.EnterpriseDTO
import br.com.curso.api.dto.response.EnterpriseViewMapper
import br.com.curso.api.service.EnterpriseService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/enterprises")
class EnterpriseController (
        private val service: EnterpriseService,
        private val mapper: EnterpriseViewMapper
){

    @PostMapping("/")
    fun create(@RequestBody dto: EnterpriseDTO): ResponseEntity<EnterpriseDTO>{
      val response = service.create(dto)
        return ResponseEntity.ok(mapper.mapTo(response))
    }
}