package com.codegym.service;

import com.codegym.model.Vote;
import com.codegym.repository.IVoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteService implements IVoteService {
    @Autowired
    IVoteRepository voteRepository;

    @Override
    public Page<Vote> findAll(Pageable pageable) {
        return voteRepository.findAll(pageable);
    }

    @Override
    public Vote findOne(Long id) {
        return voteRepository.findById(id);
    }

    @Override
    public void save(Vote vote) {
        voteRepository.save(vote);
    }

    @Override
    public void remove(Vote vote) {
        voteRepository.remove(vote);
    }

    @Override
    public void remove(Long id) {
        voteRepository.remove(id);
    }

    @Override
    public Page<Vote> getTodayVotes(Pageable pageable) {
        return voteRepository.getTodayVotes(pageable);
    }
}
