package br.com.dbserver.votacao.desafiovotacao.mapper;

import br.com.dbserver.votacao.desafiovotacao.entity.Poll;
import br.com.dbserver.votacao.desafiovotacao.dto.PollDto;

public class PollMapper {

    private PollMapper() {
        /* This utility class should not be instantiated */
    }

    public static PollDto toDto(Poll poll) {
        return new PollDto(poll.getId(), poll.getTheme(), poll.getTimeLengthInMinutes(), poll.getStartTime(), poll.getEndTime());
    }

    public static Poll toEntity(PollDto pollDto) {
        return new Poll(pollDto.id(), pollDto.theme(), pollDto.timeLengthInMinutes(), pollDto.startTime(), pollDto.endTime());
    }
}