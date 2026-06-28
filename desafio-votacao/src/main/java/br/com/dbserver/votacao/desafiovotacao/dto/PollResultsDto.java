package br.com.dbserver.votacao.desafiovotacao.dto;

import java.util.Map;

public record PollResultsDto(String theme, Map<String, Long> voteResults) {
    
}
