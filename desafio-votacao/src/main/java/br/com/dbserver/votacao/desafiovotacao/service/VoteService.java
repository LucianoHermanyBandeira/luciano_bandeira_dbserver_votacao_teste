package br.com.dbserver.votacao.desafiovotacao.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import br.com.dbserver.votacao.desafiovotacao.entity.Poll;
import br.com.dbserver.votacao.desafiovotacao.entity.Vote;
import br.com.dbserver.votacao.desafiovotacao.repository.VoteRepository;

@Service
public class VoteService {
    
    private final VoteRepository voteRepository;
    private final PollService pollService;

    public VoteService(VoteRepository voteRepository, @Lazy PollService pollService) {
        this.voteRepository = voteRepository;
        this.pollService = pollService;
    }

    public List<Vote> getVotesByPollId(Long pollId) {
        return voteRepository.findByPollId(pollId);
    }

    public Vote saveVote(Vote vote) {

        Poll poll = this.pollService.getpollById(vote.getPollId()); // Check if the poll exists
        if (poll == null) {
            throw new IllegalArgumentException("Pauta não encontrada com o ID: " + vote.getPollId());
        }

        if (poll.getStartTime() == null || poll.getEndTime() == null) {
            throw new IllegalArgumentException("A pauta ainda não foi aberta para votação.");
        }

        LocalDateTime now = LocalDateTime.now();

        if (poll.getEndTime().isBefore(now)) {
            throw new IllegalArgumentException("Pauta de votação já encerrada. Não é possível registrar votos.");
        }

        Vote existingVote = voteRepository.findByUserAssociatedIdAndPollId(vote.getUserAssociatedId(), vote.getPollId());

        if (existingVote != null) {            
            throw new IllegalArgumentException("Usuário já votou nesta pauta. Não é possível registrar votos duplicados.");
        }

        return voteRepository.save(vote);
    }
    

}
