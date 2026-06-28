package br.com.dbserver.votacao.desafiovotacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.dbserver.votacao.desafiovotacao.entity.Poll;

public interface PollRepository extends JpaRepository <Poll , Long>{

    
} 