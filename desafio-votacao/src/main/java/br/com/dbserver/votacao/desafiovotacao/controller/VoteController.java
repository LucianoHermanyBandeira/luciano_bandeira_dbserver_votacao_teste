package br.com.dbserver.votacao.desafiovotacao.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.dbserver.votacao.desafiovotacao.dto.VoteDto;
import br.com.dbserver.votacao.desafiovotacao.entity.Vote;
import br.com.dbserver.votacao.desafiovotacao.mapper.VoteMapper;
import br.com.dbserver.votacao.desafiovotacao.service.VoteService;


@RestController
@RequestMapping("/votos")
public class VoteController {
    
private final VoteService voteService;

    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @GetMapping("/{pollId}")
    public List<Vote> getVotesByPollId(@PathVariable Long pollId) {
        return voteService.getVotesByPollId(pollId);
    }

    @PostMapping("/votar")
    @ResponseStatus(HttpStatus.CREATED)
    public Vote saveVote(@RequestBody VoteDto voteDto) {
        Vote vote = voteService.saveVote(VoteMapper.toVote(voteDto));
        return vote;
    }

}
