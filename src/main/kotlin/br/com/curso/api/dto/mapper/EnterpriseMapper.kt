package br.com.curso.api.dto.mapper

import br.com.curso.api.dto.EnterpriseDTO
import br.com.curso.api.model.Enterprise
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
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

    fun toDTO(t: Enterprise): EnterpriseDTO{
        val dto : EnterpriseDTO = EnterpriseDTO(
                t.id!!,
                t.foundationName!!,
                t.email!!,
                t.phoneNumber!!,
        )
        return dto
    }

    fun toList(list: List<Enterprise>) : List<EnterpriseDTO>{
        return list.map {a -> toDTO(a) }.toList()
    }

    fun toPage(page: Page<Enterprise>): Page<EnterpriseDTO>{
        val pages = page.map { a -> toDTO(a) }.toList()
        return PageImpl<EnterpriseDTO>(pages)
    }


}