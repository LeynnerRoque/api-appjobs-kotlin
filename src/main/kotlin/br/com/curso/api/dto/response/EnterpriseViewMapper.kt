package br.com.curso.api.dto.response

import br.com.curso.api.dto.EnterpriseDTO
import br.com.curso.api.dto.mapper.IMapper
import br.com.curso.api.model.Enterprise
import org.springframework.stereotype.Component

@Component
class EnterpriseViewMapper: IMapper<Enterprise, EnterpriseDTO> {
    override fun mapTo(t: Enterprise): EnterpriseDTO {
        val dto = EnterpriseDTO(
                t.id!!,
                t.foundationName!!,
                t.email!!,
                t.phoneNumber!!
        )

        return dto
    }

}