package br.com.dbserver.votacao.desafiovotacao.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.dbserver.votacao.desafiovotacao.dto.PollDto;
import br.com.dbserver.votacao.desafiovotacao.dto.PollResultsDto;
import br.com.dbserver.votacao.desafiovotacao.entity.Poll;
import br.com.dbserver.votacao.desafiovotacao.mapper.PollMapper;
import br.com.dbserver.votacao.desafiovotacao.service.PollService;


@RestController
@RequestMapping("/pautas")
public class PollController {

   private final PollService pollService;

    PollController(PollService pollService) {
        this.pollService = pollService;
    }

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public PollDto cadastrarPoll(@RequestBody PollDto pollDto) {
        Poll poll = pollService.savePoll(PollMapper.toEntity(pollDto));
        return PollMapper.toDto(poll);
    }

    @GetMapping("/buscarPauta/{id}")
    public PollDto buscarPautaPorId(@PathVariable Long id) {
        return PollMapper.toDto(pollService.getpollById(id));
    }

    @GetMapping("/buscarPautas")
    public List<PollDto> buscarPautas() {
        return pollService.getAllPolls().stream()
                .map(PollMapper::toDto).toList();
    }

    @GetMapping("/totalizarVotosNaPauta/{id}")
    public PollResultsDto totalizeVotesPerPoll(@PathVariable Long id) {
        return pollService.totalizeVotesPerPoll(id);
    }

    @PutMapping("/abrirPauta/{id}")
    public void openPoll(@PathVariable Long id) {
        pollService.openPoll(id);
    }

}
