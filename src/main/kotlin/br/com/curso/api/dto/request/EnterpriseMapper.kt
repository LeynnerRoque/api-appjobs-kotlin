package br.com.curso.api.dto.request

import br.com.curso.api.dto.EnterpriseDTO
import br.com.curso.api.dto.mapper.IMapper
import br.com.curso.api.model.Enterprise
import org.springframework.stereotype.Component

@Component
class EnterpriseMapper: IMapper<EnterpriseDTO, Enterprise> {

    override fun mapTo(t: EnterpriseDTO): Enterprise {
        val entity  = Enterprise(
                t.id,
                t.foundationName,
                t.email,
                t.phone,
        )
        return entity
    }


}