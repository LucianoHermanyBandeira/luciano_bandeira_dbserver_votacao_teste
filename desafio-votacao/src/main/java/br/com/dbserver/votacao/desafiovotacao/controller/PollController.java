package br.com.dbserver.votacao.desafiovotacao.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/pautas")
public class PollController {

   private final PollService pollService;

    PollController(PollService pollService) {
        this.pollService = pollService;
    }

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PollDto> cadastrarPoll(@RequestBody PollDto pollDto) {
        Poll poll = pollService.savePoll(PollMapper.toEntity(pollDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(PollMapper.toDto(poll));
    }

    @GetMapping("/buscarPauta/{id}")
    public ResponseEntity<PollDto> buscarPautaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(PollMapper.toDto(pollService.getpollById(id)));
    }

    @GetMapping("/buscarPautas")
    public ResponseEntity<List<PollDto>> buscarPautas() {
        return ResponseEntity.ok(pollService.getAllPolls().stream()
                .map(PollMapper::toDto).toList());
    }

    @GetMapping("/totalizarVotosNaPauta/{id}")
    public ResponseEntity<PollResultsDto> totalizeVotesPerPoll(@PathVariable Long id) {
        return ResponseEntity.ok(pollService.totalizeVotesPerPoll(id));
    }
    
    @GetMapping("/abrirPauta/{id}/tempo/{tempo}")
    public ResponseEntity<String> openPoll(@PathVariable Long id, @PathVariable Integer tempo) {
        pollService.openPoll(id, tempo);
        return ResponseEntity.ok("Pauta aberta com sucesso! Tempo de votação: " + tempo + " minutos.");
    }

    @GetMapping("/abrirPauta/{id}") 
    public ResponseEntity<String> openPoll(@PathVariable Long id) {
        pollService.openPoll(id, null);
        return ResponseEntity.ok("Pauta aberta com sucesso! Tempo de votação: 1 minuto (padrão).");
    }

}
