package com.codestates.TrashCan;

import com.codestates.Vote.Vote;
import com.codestates.exception.ExceptionCode;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrashCanService {

    private final TrashCanRepository trashCanRepository;

    public TrashCanService(TrashCanRepository trashCanRepository) {
        this.trashCanRepository = trashCanRepository;
    }

    public TrashCan getTrashCanById(Long id) {
        return trashCanRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, ExceptionCode.TRASH_CAN_NOT_FOUND.getMessage()));
    }

    public List<TrashCan> getAllTrashCans() {
        return trashCanRepository.findAll();
    }

    public TrashCan createTrashCan(TrashCan trashCan) {
        return trashCanRepository.save(trashCan);
    }

    public TrashCan updateTrashCan(Long id, TrashCan trashCan) {
        TrashCan oldTrashCan = getTrashCanById(id);
        oldTrashCan.setLatitude(trashCan.getLatitude());
        oldTrashCan.setLongitude(trashCan.getLongitude());
        oldTrashCan.setCanType(trashCan.getCanType());
        oldTrashCan.setLocation(trashCan.getLocation());
        oldTrashCan.setDislikeCount(trashCan.getDislikeCount());
        oldTrashCan.setLikeCount(trashCan.getLikeCount());
        return trashCanRepository.save(oldTrashCan);
    }

    public void deleteTrashCan(Long id) {
        TrashCan trashCan = getTrashCanById(id);
        trashCanRepository.delete(trashCan);
    }

    public TrashCan voteForTrashCan(Long id, Vote vote) {
        TrashCan trashCan = getTrashCanById(id);

        if (vote.getIsLike()) {
            trashCan.setLikeCount(trashCan.getLikeCount() + 1);
        } else {
            trashCan.setDislikeCount(trashCan.getDislikeCount() + 1);
        }

        List<Vote> votes = trashCan.getVotes();
        if (votes == null) {
            votes = new ArrayList<>();
        }
        votes.add(vote);
        trashCan.setVotes(votes);
        return trashCanRepository.save(trashCan);
    }


}
