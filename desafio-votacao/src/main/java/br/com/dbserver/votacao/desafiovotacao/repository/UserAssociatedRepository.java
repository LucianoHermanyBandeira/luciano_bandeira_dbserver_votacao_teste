package br.com.dbserver.votacao.desafiovotacao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dbserver.votacao.desafiovotacao.entity.UserAssociated;
import java.util.List;


public interface UserAssociatedRepository extends JpaRepository<UserAssociated, Long> {

    public UserAssociated findByCpf(String cpf);

    public Optional findById(Long id);

    public UserAssociated findByNome(String nome);
    
}
