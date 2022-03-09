package cg.repository;

import cg.model.Human;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IHumanRepo extends PagingAndSortingRepository<Human, Long> {
    Page<Human> findHumanByNameContaining(Pageable pageable,String name);

}
