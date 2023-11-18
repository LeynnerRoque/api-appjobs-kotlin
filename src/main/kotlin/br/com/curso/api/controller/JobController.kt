package br.com.curso.api.controller

import br.com.curso.api.dto.JobDTO
import br.com.curso.api.service.JobService
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
@RequestMapping("/jobs")
class JobController (private val service: JobService){

    @PostMapping("")
    fun create(@RequestBody request: JobDTO): ResponseEntity<JobDTO>{
        val response = service.create(request)
        return ResponseEntity.ok(response)
    }

    @PutMapping("")
    fun update(@RequestBody request: JobDTO): ResponseEntity<JobDTO>{
        val response = service.update(request)
        return ResponseEntity.ok(response)
    }

    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable("id") id: Long){
        service.delete(id)
    }

    @GetMapping("all")
    fun listAll(): ResponseEntity<List<JobDTO>>{
        return ResponseEntity.ok(service.listAll())
    }

    @GetMapping("pages")
    fun pagination(@PageableDefault(size = 3)pageable: Pageable) : ResponseEntity<Page<JobDTO>>{
        return ResponseEntity.ok(service.pageAll(pageable))
    }
}