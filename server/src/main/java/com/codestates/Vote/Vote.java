package com.codestates.Vote;

import com.codestates.TrashCan.TrashCan;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "votes")
@Getter
@Setter
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trash_can_id")
    private TrashCan trashCan;

    @Column(nullable = false)
    private Boolean isLike;

    @Column(nullable = false)
    private String memberId;
}

