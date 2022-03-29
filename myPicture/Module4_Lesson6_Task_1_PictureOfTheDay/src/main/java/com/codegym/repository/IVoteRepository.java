package com.codegym.repository;

import com.codegym.model.Vote;

import java.util.List;

public interface IVoteRepository extends IGeneralRepository<Vote>{
    List<Vote> getTodayVotes();
}
