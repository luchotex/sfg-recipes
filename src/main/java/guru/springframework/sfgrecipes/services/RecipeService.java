package guru.springframework.sfgrecipes.services;

import guru.springframework.sfgrecipes.domain.Recipe;

import java.util.Set;

/**
 * Created by Luis
 * on 06/10/2018.
 */
public interface RecipeService {

    Set<Recipe> getRecipes();
}
