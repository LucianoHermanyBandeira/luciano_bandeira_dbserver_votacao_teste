package br.com.dbserver.votacao.desafiovotacao.mapper;

import br.com.dbserver.votacao.desafiovotacao.dto.VoteDto;
import br.com.dbserver.votacao.desafiovotacao.entity.Vote;

public class VoteMapper {

    private VoteMapper() {
        /* This utility class should not be instantiated */
    }
    
    public static VoteDto toVoteDto(Vote vote) {
        return new VoteDto(vote.getUserAssociatedId(), vote.getPollId(), vote.getVoteValue());
    }

    public static Vote toVote(VoteDto voteDto) {
        return new Vote(voteDto.userAssociatedId(), voteDto.pollId(), voteDto.voteValue());
    }

}
