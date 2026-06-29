package br.com.dbserver.votacao.desafiovotacao.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.dbserver.votacao.desafiovotacao.dto.PollResultsDto;
import br.com.dbserver.votacao.desafiovotacao.entity.Poll;
import br.com.dbserver.votacao.desafiovotacao.entity.Vote;
import br.com.dbserver.votacao.desafiovotacao.repository.PollRepository;

@Service
public class PollService {

    private final PollRepository pollRepository;
    private final VoteService voteService;

    public PollService(PollRepository pollRepository, VoteService voteService) {
        this.pollRepository = pollRepository;
        this.voteService = voteService;
    }

    public Poll savePoll(Poll poll) {
        return pollRepository.save(poll);       
    }

    public List<Poll> getAllPolls() {
        return pollRepository.findAll();
    }
    
    public Poll getpollById(Long id) {
        return pollRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pauta não encontrada com o ID: " + id));
    }

    public void deletePollById(Long id) {
        pollRepository.deleteById(id);        
    }

    @SuppressWarnings("null")
    public PollResultsDto  totalizeVotesPerPoll(Long pollId) {

        List<Vote> votes = voteService.getVotesByPollId(pollId);
        Map<String, Long> voteResults = votes.stream()
                .collect(Collectors.groupingBy(Vote::getVoteValue, Collectors.counting()));
        return new PollResultsDto(getpollById(pollId).getTheme(), voteResults);
    }

    public Poll openPoll(Long pollId, Integer timeLengthInMinutes) {

        Poll poll = getpollById(pollId);
        LocalDateTime now = LocalDateTime.now();
        poll.setStartTime(now);

        if (timeLengthInMinutes != null) {
            poll.setTimeLengthInMinutes(timeLengthInMinutes);
        } else {
            poll.setTimeLengthInMinutes(1); // Default to 1 minute if no time is provided
        }

        poll.setEndTime(now.plusMinutes(poll.getTimeLengthInMinutes())); 

        return this.pollRepository.save(poll);
    }

}
