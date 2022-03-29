package com.codegym.repository;

import com.codegym.model.Vote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IVoteRepository extends PagingAndSortingRepository<Vote, Long> {
    Page<Vote> getTodayVotes(Pageable pageable);
}
