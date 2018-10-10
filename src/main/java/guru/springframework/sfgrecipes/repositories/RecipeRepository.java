package guru.springframework.sfgrecipes.repositories;

import guru.springframework.sfgrecipes.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Luis
 * on 06/10/2018.
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long>  {

}
