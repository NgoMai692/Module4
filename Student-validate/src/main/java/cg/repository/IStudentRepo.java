package cg.repository;

import cg.model.ClassRoom;
import cg.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IStudentRepo extends PagingAndSortingRepository<Student, Long> {
    Page<Student> findStudentsByNameContaining(String name);
    Page<Student> findStudentsByPhoneContaining(String phone);
    Page<Student> findStudentsByAvgPointBetween(double min, double max);
    Page<Student> findStudentsByClassRoom(ClassRoom classRoom);
}
