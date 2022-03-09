package cg.service;

import cg.model.ClassRoom;
import cg.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.Optional;

public interface IStudentService {
    Page<Student> selectAll(Pageable pageable);
    Student save(Student student);
    void delete(long id);
    Optional<Student> selectById(long id);
    Page<Student> searchByName(String name, Pageable pageable);
    Page<Student> searchByClassRoom(ClassRoom classRoom, Pageable pageable);
    Page<Student> searchByPhone(String phone, Pageable pageable);
    Page<Student> searchByAvgPoint(double min,double max, Pageable pageable);

}
