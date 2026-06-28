package br.com.dbserver.votacao.desafiovotacao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.dbserver.votacao.desafiovotacao.entity.UserAssociated;
import br.com.dbserver.votacao.desafiovotacao.repository.UserAssociatedRepository;

@Service
public class UserAssociatedService {

    private final UserAssociatedRepository userAssociatedRepository;

    public UserAssociatedService(UserAssociatedRepository userAssociatedRepository) {
        this.userAssociatedRepository = userAssociatedRepository;
    }

    public UserAssociated getUserAssociatedByCpf(String cpf) {        
        return this.userAssociatedRepository.findByCpf(cpf);        
    }

    @SuppressWarnings("unchecked")
    public UserAssociated getUserAssociatedById(Long id) {

        Optional<UserAssociated> userAssociatedOptional = this.userAssociatedRepository.findById(id);

        return userAssociatedOptional.orElse(null);
    }

    public UserAssociated getUserAssociatedByName(String nome) {
        return this.userAssociatedRepository.findByNome(nome);
    }

    public List<UserAssociated> getAllUserAssociated() {
        // Lógica para buscar todos os associados
        return userAssociatedRepository.findAll();
    }

    public UserAssociated createUserAssociated(UserAssociated userAssociated) {
        // Lógica para cadastrar um novo associado
       return userAssociatedRepository.save(userAssociated);
       
    }

    
}
