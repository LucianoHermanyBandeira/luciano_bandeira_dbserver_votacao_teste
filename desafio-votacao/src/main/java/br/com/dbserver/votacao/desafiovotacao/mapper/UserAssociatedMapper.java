package br.com.dbserver.votacao.desafiovotacao.mapper;

import br.com.dbserver.votacao.desafiovotacao.dto.UserAssociatedDto;
import br.com.dbserver.votacao.desafiovotacao.entity.UserAssociated;

public class UserAssociatedMapper {

    private UserAssociatedMapper() {
        /* This utility class should not be instantiated */
    }

    public static UserAssociatedDto toDto(UserAssociated userAssociated) {
        return new UserAssociatedDto(userAssociated.getId(), userAssociated.getCpf(), userAssociated.getNome());
    }

    public static UserAssociated toEntity(UserAssociatedDto userAssociatedDto) {
        return new UserAssociated(userAssociatedDto.cpf(), userAssociatedDto.nome());
    }

 
}
