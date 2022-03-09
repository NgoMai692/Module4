package cg.service;

import cg.model.ClassRoom;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface IClassRoomService {
    Iterable<ClassRoom> selectALL();
    Optional<ClassRoom> selectById(long id);
    ClassRoom save(ClassRoom classRoom);
    void delete(long id);
}
