package cg.repository;

import cg.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface IStudentRepo extends CrudRepository<Student, Long> {
}
