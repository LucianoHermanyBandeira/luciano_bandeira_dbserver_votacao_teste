
package br.com.dbserver.votacao.desafiovotacao.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.dbserver.votacao.desafiovotacao.dto.UserAssociatedDto;
import br.com.dbserver.votacao.desafiovotacao.entity.UserAssociated;
import br.com.dbserver.votacao.desafiovotacao.mapper.UserAssociatedMapper;
import br.com.dbserver.votacao.desafiovotacao.service.UserAssociatedService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/associados")
public class UserAssociatedController {
   

    private final UserAssociatedService userAssociatedService;

    public UserAssociatedController(UserAssociatedService userAssociatedService) {
        this.userAssociatedService = userAssociatedService;
    }

    @GetMapping("buscarAssociadoPorCpf/{cpf}")
    public UserAssociatedDto getUserAssociatedCpf(@PathVariable String cpf) {               

        UserAssociated userAssociated = this.userAssociatedService.getUserAssociatedByCpf(cpf);
        return UserAssociatedMapper.toDto(userAssociated);
    }

    @GetMapping("buscarAssociadoPorNome/{nome}")
    public UserAssociatedDto getUserAssociatedByName(@PathVariable String nome) {               

        UserAssociated userAssociated = this.userAssociatedService.getUserAssociatedByName(nome);
        return UserAssociatedMapper.toDto(userAssociated);
    }

    @GetMapping("buscarAssociadoById/{id}")
    public UserAssociatedDto getUserAssociatedById(@PathVariable Long id) {               

        UserAssociated userAssociated = this.userAssociatedService.getUserAssociatedById(id);
        return UserAssociatedMapper.toDto(userAssociated);
    }



    @GetMapping("buscarTodosAssociados")
    public List<UserAssociatedDto> getAllUserAssociated() {
        return userAssociatedService.getAllUserAssociated().stream()
                .map(UserAssociatedMapper::toDto)
                .toList();

    }

    @PostMapping("cadastrarAssociado")
    public UserAssociatedDto createUserAssociated(@RequestBody UserAssociatedDto userAssociatedDto) {

        UserAssociated userAssociated = userAssociatedService.createUserAssociated( UserAssociatedMapper.toEntity(userAssociatedDto));
        this.userAssociatedService.createUserAssociated(userAssociated);

        return UserAssociatedMapper.toDto(userAssociated);
    }


}