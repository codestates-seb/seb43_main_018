package com.codestates.TrashCan;

import com.codestates.Vote.Vote;
import com.codestates.Vote.VoteDto;
import com.codestates.Vote.VoteMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/trash-cans")
public class TrashCanController {

    private final TrashCanService trashCanService;
    private final TrashCanMapper trashCanMapper;
    private final VoteMapper voteMapper;

    public TrashCanController(TrashCanService trashCanService, TrashCanMapper trashCanMapper, VoteMapper voteMapper) {
        this.trashCanService = trashCanService;
        this.trashCanMapper = trashCanMapper;
        this.voteMapper = voteMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrashCanDto> getTrashCan(@PathVariable Long id) {
        TrashCan trashCan = trashCanService.getTrashCanById(id);
        TrashCanDto trashCanDto = trashCanMapper.toDto(trashCan);
        return ResponseEntity.ok(trashCanDto);
    }

    @GetMapping
    public ResponseEntity<List<TrashCanDto>> getTrashCans() {
        List<TrashCan> trashCans = trashCanService.getAllTrashCans();
        List<TrashCanDto> trashCanDtos = trashCanMapper.toDtoList(trashCans);
        return ResponseEntity.ok(trashCanDtos);
    }

    @PostMapping
    public ResponseEntity<TrashCanDto> createTrashCan(@RequestBody @Valid TrashCanDto trashCanDto) {
        TrashCan trashCan = trashCanService.createTrashCan(trashCanMapper.toEntity(trashCanDto));
        TrashCanDto createdTrashCanDto = trashCanMapper.toDto(trashCan);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTrashCanDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrashCanDto> updateTrashCan(@PathVariable Long id, @RequestBody @Valid TrashCanDto trashCanDto) {
        TrashCan updatedTrashCan = trashCanService.updateTrashCan(id, trashCanMapper.toEntity(trashCanDto));
        TrashCanDto updatedTrashCanDto = trashCanMapper.toDto(updatedTrashCan);
        return ResponseEntity.ok(updatedTrashCanDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrashCan(@PathVariable Long id) {
        trashCanService.deleteTrashCan(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/vote")
    public ResponseEntity<TrashCanDto> voteForTrashCan(@PathVariable Long id, @RequestBody @Valid VoteDto voteDto) {
        Vote vote = voteMapper.toEntity(voteDto);
        TrashCan trashCan = trashCanService.voteForTrashCan(id, vote);
        TrashCanDto trashCanDto = trashCanMapper.toDto(trashCan);
        return ResponseEntity.status(HttpStatus.CREATED).body(trashCanDto);
    }

}

