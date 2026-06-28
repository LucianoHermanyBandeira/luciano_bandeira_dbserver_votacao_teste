package br.com.dbserver.votacao.desafiovotacao.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.dbserver.votacao.desafiovotacao.entity.Vote;

public interface VoteRepository extends JpaRepository<Vote, Long> {
    
    public List<Vote> findByPollId(Long pollId);

    public Vote findByUserAssociatedIdAndPollId(Long userAssociatedId, Long pollId);

    

}
