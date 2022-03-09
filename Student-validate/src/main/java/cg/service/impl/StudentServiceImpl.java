package cg.service.impl;

import cg.model.ClassRoom;
import cg.model.Student;
import cg.repository.IStudentRepo;
import cg.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
@Repository
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentRepo repository;

    @Override
    public Page<Student> selectAll(Pageable pageable) {
        return (Page<Student>) repository.findAll(pageable);
    }

    @Override
    public Student save(Student student) {
        return repository.save(student);
    }

    @Override
    public void delete(long id) {
        repository.deleteById( id);
    }

    @Override
    public Optional<Student> selectById(long id) {
        return repository.findById(id);
    }

    @Override
    public Page<Student> searchByName(String name, Pageable pageable) {
        return repository.findStudentsByNameContaining(name);
    }

    @Override
    public Page<Student> searchByClassRoom(ClassRoom classRoom, Pageable pageable) {
        return repository.findStudentsByClassRoom(classRoom);
    }

    @Override
    public Page<Student> searchByPhone(String phone, Pageable pageable) {
        return repository.findStudentsByPhoneContaining(phone);
    }

    @Override
    public Page<Student> searchByAvgPoint(double min, double max, Pageable pageable) {
        return repository.findStudentsByAvgPointBetween(min,max);
    }
}
