package br.com.curso.api.service

import br.com.curso.api.request.ConsultaEnvio
import br.com.curso.api.request.LoginRequest
import br.com.curso.api.response.ConsultaResponse
import br.com.curso.api.response.LoginResponse
import org.aopalliance.intercept.Interceptor
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.net.http.HttpHeaders

@Service
class Service {


    fun enviaConsulta(request : ConsultaEnvio) : ConsultaResponse?{
        var url  = "http://localhost:8080/consultas"
        val template = RestTemplate()
        val login = LoginRequest("dipples@email.com","roque1989")
        val tokenRetorno = authLogin(login)


        val envio = template.postForEntity(url, request,ConsultaResponse::class.java)!!
        val response : ConsultaResponse? = envio.body

         return  response
    }

    fun authLogin(request: LoginRequest) : String?{
        var url = "http://localhost:8080/login"
        val template = RestTemplate()
        val envio = template.postForEntity(url,request,LoginResponse::class.java)
        return envio.body!!.token
    }

}