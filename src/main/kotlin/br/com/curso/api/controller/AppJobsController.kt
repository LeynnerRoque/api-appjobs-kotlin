package br.com.curso.api.controller

import br.com.curso.api.request.ConsultaEnvio
import br.com.curso.api.request.LoginRequest
import br.com.curso.api.response.ConsultaResponse
import br.com.curso.api.response.LoginResponse
import br.com.curso.api.service.Service
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.http.HttpHeaders

@RestController
@RequestMapping("/init")
class AppJobsController (private val service: Service){

    @GetMapping
    fun init() : String{
        return "API App Jobs"
    }

    @PostMapping("/login")
    fun login(@RequestBody requestBody: LoginRequest): String?{
        return service.authLogin(requestBody)
    }

    @PostMapping
    fun consulta(@RequestBody requestBody: ConsultaEnvio): ConsultaResponse?{
        return service.enviaConsulta(requestBody)
    }
}