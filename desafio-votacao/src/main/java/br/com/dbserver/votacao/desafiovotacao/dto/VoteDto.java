package br.com.dbserver.votacao.desafiovotacao.dto;

public record VoteDto(Long userAssociatedId, Long pollId, String voteValue) {}
