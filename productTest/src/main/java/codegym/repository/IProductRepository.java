package codegym.repository;

import codegym.model.Product;
import net.bytebuddy.dynamic.loading.PackageDefinitionStrategy;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IProductRepository extends PagingAndSortingRepository<Product, Integer> {
 Page<Product> findAllByNameContaining(String name);

}
