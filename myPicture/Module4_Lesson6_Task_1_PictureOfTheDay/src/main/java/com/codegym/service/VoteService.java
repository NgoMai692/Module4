package com.codegym.service;

import com.codegym.dao.IVoteDao;
import com.codegym.model.Vote;
import com.codegym.repository.IVoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteService implements IVoteService {
    @Autowired
    IVoteRepository voteRepository;

    @Override
    public List<Vote> findAll() {
        return voteRepository.findAll();
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
    public List<Vote> getTodayVotes() {
        return voteRepository.getTodayVotes();
    }
}
