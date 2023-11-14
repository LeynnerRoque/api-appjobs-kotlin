package br.com.curso.api.controller

import br.com.curso.api.dto.EnterpriseDTO
import br.com.curso.api.dto.response.EnterpriseViewMapper
import br.com.curso.api.service.EnterpriseService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/enterprises")
class EnterpriseController (
        private val service: EnterpriseService
){

    @PostMapping("")
    fun create(@RequestBody dto: EnterpriseDTO): ResponseEntity<EnterpriseDTO>{
      val response = service.create(dto)
        return ResponseEntity.ok(response)
    }

    @GetMapping("/all")
    fun listAll(): ResponseEntity<List<EnterpriseDTO>>{
        return ResponseEntity.ok(service.listAll())
    }

    @PutMapping("/update")
    fun update(@RequestBody update: EnterpriseDTO): ResponseEntity<EnterpriseDTO>{
        return ResponseEntity.accepted().body(service.update(update))
    }

    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable("id") id: Long){
        service.delete(id)
    }

    @GetMapping("")
    fun pages(@PageableDefault(size = 2) page: Pageable): ResponseEntity<Page<EnterpriseDTO>>{
        return ResponseEntity.ok(service.pagination(page))
    }
}