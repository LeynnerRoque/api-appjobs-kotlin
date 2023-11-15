package br.com.curso.api.controller

import br.com.curso.api.dto.LocationDTO
import br.com.curso.api.service.LocationService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
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
}