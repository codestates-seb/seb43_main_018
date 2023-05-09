package com.codestates.Vote;

import com.codestates.TrashCan.TrashCan;
import com.codestates.TrashCan.TrashCanRepository;
import com.codestates.exception.ExceptionCode;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class VoteService {

    private final VoteRepository voteRepository;
    private final TrashCanRepository trashCanRepository;

    public VoteService(VoteRepository voteRepository, TrashCanRepository trashCanRepository) {
        this.voteRepository = voteRepository;
        this.trashCanRepository = trashCanRepository;
    }

    public Vote createVote(VoteDto voteDto) {
        Vote vote = VoteMapper.INSTANCE.toEntity(voteDto);
        TrashCan trashCan = trashCanRepository.getById(voteDto.getTrashCanId());
        vote.setTrashCan(trashCan);
        return voteRepository.save(vote);
    }

    public Vote getVoteById(Long id) {
        return voteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,ExceptionCode.VOTE_NOT_FOUND.getMessage()));
    }

    public Vote updateVote(Long id, VoteDto voteDto) {
        Vote vote = getVoteById(id);
        Vote updatedVote = VoteMapper.INSTANCE.toEntity(voteDto);
        updatedVote.setId(vote.getId());
        updatedVote.setTrashCan(vote.getTrashCan());
        return voteRepository.save(updatedVote);
    }

    public void deleteVote(Long id) {
        voteRepository.deleteById(id);
    }
}




