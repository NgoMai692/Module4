package com.codegym.repository;

import com.codegym.model.Vote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Transactional
public class VoteRepository implements IVoteRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Page<Vote> findAll(Pageable pageable) {
        TypedQuery<Vote> query = entityManager.createQuery("select v from Vote v", Vote.class);
        return query.getResultList();
    }

    @Override
    public Vote findById(Long id) {
        TypedQuery<Vote> query = entityManager.createQuery("select v from Vote v where v.id=:id", Vote.class);
        query.setParameter("id",id);
        try {
            return query.getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public void save(Vote vote) {
        vote.setDate(getCurrentDate());
        if(vote.getId() != null){
            entityManager.merge(vote);
        }else {
            entityManager.persist(vote);
        }
    }

    @Override
    public void remove(Long id) {
        Vote vote= findById(id);
        if(vote != null){
            entityManager.remove(vote);
        }
    }

    @Override
    public void remove(Vote vote) {
        if(findById(vote.getId()) != null){
            entityManager.remove(vote);
        }
    }

    @Override
    public List<Vote> getTodayVotes() {
        String qlString = "select v from Vote as v where v.date = current_date";
        TypedQuery<Vote> query =  entityManager.createQuery(qlString, Vote.class);
        List<Vote> votes = query.getResultList();
        return votes;
    }

    public String getCurrentDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        return String.valueOf(now);
    }

    @Override
    public Page<Vote> getTodayVotes(Pageable pageable) {
        return null;
    }
}
