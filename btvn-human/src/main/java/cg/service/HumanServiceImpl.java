package cg.service;

import cg.model.Human;
import cg.repository.IHumanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HumanServiceImpl implements IHumanService{

    @Autowired
    private IHumanRepo iHumanRepo;

    @Override
    public Page<Human> findAll(Pageable pageable) {
        return iHumanRepo.findAll(pageable);
    }

    @Override
    public void save(Human human) {
        iHumanRepo.save(human);
    }

    @Override
    public void delete(Long id) {
        iHumanRepo.deleteById(id);
    }

    @Override
    public Optional<Human> findById(Long id) {
        return iHumanRepo.findById(id);
    }

    @Override
    public Page<Human> findByName(Pageable pageable, String name) {
        return iHumanRepo.findHumanByNameContaining(pageable,name);
    }
}
