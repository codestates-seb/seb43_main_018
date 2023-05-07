package com.codestates.TrashCan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrashCanRepository extends JpaRepository<TrashCan, Long> {

}

