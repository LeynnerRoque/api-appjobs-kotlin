package br.com.curso.api.controller

import br.com.curso.api.dto.PeoplesDTO
import br.com.curso.api.dto.response.PeoplesResponseDTO
import br.com.curso.api.service.PeoplesService
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
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/peoples")
class PeoplesController (private val service: PeoplesService){

    @PostMapping("")
    fun create(@RequestBody request: PeoplesDTO): ResponseEntity<PeoplesResponseDTO>{
        return ResponseEntity.ok(service.create(request))
    }

    @PutMapping("")
    fun update(@RequestBody request: PeoplesDTO): ResponseEntity<PeoplesResponseDTO>{
        return ResponseEntity.ok(service.update(request))
    }

    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable("id") id: Long){
        service.delete(id)
    }

    @GetMapping("/listAll")
    fun listAll(): ResponseEntity<List<PeoplesResponseDTO>>{
        return ResponseEntity.ok(service.listAll())
    }

    @GetMapping("/pagination")
    fun pagination(@PageableDefault(size = 3) pageable: Pageable): Page<PeoplesResponseDTO>{
        return service.pagination(pageable)
    }
    @GetMapping("/filterByTitle/{title}")
    fun filterByTitle(@PathVariable("title") title: String): ResponseEntity<List<PeoplesResponseDTO>>{
        return ResponseEntity.ok(service.listByJobTitle(title))
    }
}