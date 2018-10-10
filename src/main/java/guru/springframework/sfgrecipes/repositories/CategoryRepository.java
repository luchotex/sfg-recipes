package guru.springframework.sfgrecipes.repositories;

import guru.springframework.sfgrecipes.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created by Luis
 * on 06/10/2018.
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {


    Optional<Category> findByDescription(String description);

}

