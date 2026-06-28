package br.com.dbserver.votacao.desafiovotacao.dto;

import java.time.LocalDateTime;

public record PollDto(Long id,String theme, Integer timeLengthInMinutes, LocalDateTime startTime, LocalDateTime endTime) {}
