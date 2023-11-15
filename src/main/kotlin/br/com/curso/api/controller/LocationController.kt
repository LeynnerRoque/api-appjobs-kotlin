package br.com.curso.api.controller

import br.com.curso.api.dto.LocationDTO
import br.com.curso.api.service.LocationService
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
@RequestMapping("/locations")
class LocationController (private val service: LocationService){

    @PostMapping
    fun create(@RequestBody request: LocationDTO): ResponseEntity<LocationDTO>{
        return ResponseEntity.ok(service.create(request))
    }

    @GetMapping("/all")
    fun listAll(): ResponseEntity<List<LocationDTO>>{
        return ResponseEntity.ok(service.listALL())
    }

    @GetMapping("/pagination")
    fun pagination(@PageableDefault(size = 2) pageable: Pageable): Page<LocationDTO>{
        return service.pagination(pageable)
    }

    @PutMapping("/update")
        fun update(@RequestBody request: LocationDTO): ResponseEntity<LocationDTO>{
            return ResponseEntity.ok(service.update(request))
    }

    @DeleteMapping("/remove/{id}")
    fun delete(@PathVariable("id") id: Long){
        service.delete(id)
    }
}