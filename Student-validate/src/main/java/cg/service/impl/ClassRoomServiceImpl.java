package cg.service.impl;

import cg.model.ClassRoom;
import cg.repository.IClassRoomRepo;
import cg.service.IClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Repository
public class ClassRoomServiceImpl implements IClassRoomService {

    @Autowired
    private IClassRoomRepo repository;

    @Override
    public Page<ClassRoom> selectALL() {
        return (Page<ClassRoom>) repository.findAll();
    }

    @Override
    public Optional<ClassRoom> selectById(long id) {
        return repository.findById(id);
    }

    @Override
    public ClassRoom save(ClassRoom classRoom) {
        return repository.save(classRoom);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
}
