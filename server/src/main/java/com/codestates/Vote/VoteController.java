package com.codestates.Vote;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/votes")
public class VoteController {

    private final VoteService voteService;

    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @PostMapping
    public ResponseEntity<VoteDto> createVote(@RequestBody @Valid VoteDto voteDto) {
        Vote vote = voteService.createVote(voteDto);
        VoteDto createdVoteDto = VoteMapper.INSTANCE.toDto(vote);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdVoteDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VoteDto> getVoteById(@PathVariable Long id) {
        Vote vote = voteService.getVoteById(id);
        VoteDto voteDto = VoteMapper.INSTANCE.toDto(vote);
        return ResponseEntity.ok(voteDto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<VoteDto> updateVote(@PathVariable Long id, @RequestBody @Valid VoteDto voteDto) {
        Vote updatedVote = voteService.updateVote(id, voteDto);
        VoteDto updatedVoteDto = VoteMapper.INSTANCE.toDto(updatedVote);
        return ResponseEntity.ok(updatedVoteDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVote(@PathVariable Long id) {
        voteService.deleteVote(id);
        return ResponseEntity.noContent().build();
    }
}


