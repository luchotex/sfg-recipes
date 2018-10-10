package guru.springframework.sfgrecipes.bootstrap;

import guru.springframework.sfgrecipes.domain.*;
import guru.springframework.sfgrecipes.repositories.CategoryRepository;
import guru.springframework.sfgrecipes.repositories.RecipeRepository;
import guru.springframework.sfgrecipes.repositories.UnitOfMeasureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Luis
 * on 06/10/2018.
 */
@Component
public class DataLoader implements CommandLineRunner {

    private final RecipeRepository recipeRepository;
    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public DataLoader(RecipeRepository recipeRepository, CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        loadData();

    }

    private void loadData() {

        UnitOfMeasure tableSpoonMeasure = unitOfMeasureRepository.findByDescription("Tablespoon").get();
        UnitOfMeasure teaSpoonMeasure = unitOfMeasureRepository.findByDescription("Teaspoon").get();
        UnitOfMeasure cupMeasure = unitOfMeasureRepository.findByDescription("Cup").get();
        UnitOfMeasure dashMeasure = unitOfMeasureRepository.findByDescription("Dash").get();

        Category mexicanCategory = categoryRepository.findByDescription("Mexican").get();

        List<Recipe> listRecipes = new ArrayList<>();


        listRecipes.add(createGuacamoleRecipe(tableSpoonMeasure, teaSpoonMeasure, dashMeasure, mexicanCategory));
        listRecipes.add(createSpicyGrilledChicken(tableSpoonMeasure, teaSpoonMeasure, cupMeasure, mexicanCategory));

        recipeRepository.saveAll(listRecipes);
    }

    private Recipe createGuacamoleRecipe(UnitOfMeasure tableSpoonMeasure, UnitOfMeasure teaSpoonMeasure,
                                         UnitOfMeasure dashMeasure, Category category) {

        Recipe guacamoleRecipe = new Recipe();
        guacamoleRecipe.getCategories().add(category);
        guacamoleRecipe.setPrepTime(10);
        guacamoleRecipe.setDescription("Perfect Guacamole");

        guacamoleRecipe.setDifficulty(Difficulty.EASY);
        Notes note = new Notes();
        note.setRecipeNotes("Making Guacamole is easy\n" +
                "\n" +
                "All you really need to make guacamole is ripe avocados and salt. After that, a little lime or lemon juice—a splash of acidity—will help to balance the richness of the avocado. Then if you want, add chopped cilantro, chiles, onion, and/or tomato.\n" +
                "\n" +
                "Once you have basic guacamole down, feel free to experiment with variations including strawberries, peaches, pineapple, mangoes, even watermelon. You can get creative with homemade guacamole!\n" +
                "Guacamole Tip: Use Ripe Avocados\n" +
                "\n" +
                "The trick to making perfect guacamole is using ripe avocados that are just the right amount of ripeness. Not ripe enough and the avocado will be hard and tasteless. Too ripe and the taste will be off.\n" +
                "\n" +
                "Check for ripeness by gently pressing the outside of the avocado. If there is no give, the avocado is not ripe yet and will not taste good. If there is a little give, the avocado is ripe. If there is a lot of give, the avocado may be past ripe and not good. In this case, taste test first before using.");
        guacamoleRecipe.setNotes(note);

        guacamoleRecipe.setDirections("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.\n" +
                "\n" +
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\n" +
                "\n" +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "\n" +
                "4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\n" +
                "\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.\n" +
                "\n" +
                "Variations\n" +
                "\n" +
                "For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                "\n" +
                "Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries (see our Strawberry Guacamole).\n" +
                "\n" +
                "The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\n" +
                "\n" +
                "To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.\n" +
                "\n" +
                "For a deviled egg version with guacamole, try our Guacamole Deviled Eggs!\n");

        guacamoleRecipe.addIngredient(new Ingredient("ripe avocados", new BigDecimal(2), null));
        guacamoleRecipe.addIngredient(new Ingredient("Kosher salt", new BigDecimal(0.5d), teaSpoonMeasure));
        guacamoleRecipe.addIngredient(new Ingredient("fresh lime juice or lemon juice", new BigDecimal(1), tableSpoonMeasure));
        guacamoleRecipe.addIngredient(new Ingredient("minced red onion or thinly sliced green onion", new BigDecimal(2), tableSpoonMeasure));
        guacamoleRecipe.addIngredient(new Ingredient("serrano chiles, stems and seeds removed, minced", new BigDecimal(2), null));
        guacamoleRecipe.addIngredient(new Ingredient("cilantro (leaves and tender stems), finely chopped", new BigDecimal(2), tableSpoonMeasure));
        guacamoleRecipe.addIngredient(new Ingredient("freshly grated black pepper", new BigDecimal(1), dashMeasure));
        guacamoleRecipe.addIngredient(new Ingredient("ripe tomato, seeds and pulp removed, chopped", new BigDecimal(0.5d), null));

        return guacamoleRecipe;
    }

    private Recipe createSpicyGrilledChicken(UnitOfMeasure tableSpoonMeasure, UnitOfMeasure teaSpoonMeasure,
                                           UnitOfMeasure cupMeasure, Category category) {
        Recipe spicyGrilledChicken = new Recipe();
        spicyGrilledChicken.getCategories().add(category);
        spicyGrilledChicken.setPrepTime(20);
        spicyGrilledChicken.setCookTime(30);
        spicyGrilledChicken.setDescription("Spicy Grilled Chicken Tacos");

        spicyGrilledChicken.setDifficulty(Difficulty.MODERATE);
        Notes note = new Notes();
        note.setRecipeNotes("We have a family motto and it is this: Everything goes better in a tortilla.\n" +
                "\n" +
                "Any and every kind of leftover can go inside a warm tortilla, usually with a healthy dose of pickled jalapenos. I can always sniff out a late-night snacker when the aroma of tortillas heating in a hot pan on the stove comes wafting through the house.\n" +
                "\n" +
                "Today’s tacos are more purposeful – a deliberate meal instead of a secretive midnight snack!\n" +
                "\n" +
                "First, I marinate the chicken briefly in a spicy paste of ancho chile powder, oregano, cumin, and sweet orange juice while the grill is heating. You can also use this time to prepare the taco toppings.\n" +
                "\n" +
                "Grill the chicken, then let it rest while you warm the tortillas. Now you are ready to assemble the tacos and dig in. The whole meal comes together in about 30 minutes!");

        spicyGrilledChicken.setNotes(note);

        spicyGrilledChicken.setDirections("1 Prepare a gas or charcoal grill for medium-high, direct heat.\n" +
                "\n" +
                "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                "\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" +
                "\n" +
                "Spicy Grilled Chicken Tacos\n" +
                "\n" +
                "3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
                "\n" +
                "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                "\n" +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
                "\n" +
                "5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.\n");


        spicyGrilledChicken.addIngredient(new Ingredient("ancho chili powder", new BigDecimal(2), tableSpoonMeasure));
        spicyGrilledChicken.addIngredient(new Ingredient("dried oregano", new BigDecimal(1), tableSpoonMeasure));
        spicyGrilledChicken.addIngredient(new Ingredient("dried oregano", new BigDecimal(1),  teaSpoonMeasure));
        spicyGrilledChicken.addIngredient(new Ingredient("sugar", new BigDecimal(0.5d), teaSpoonMeasure));
        spicyGrilledChicken.addIngredient(new Ingredient("clove garlic, finely chopped", new BigDecimal(1),  null));
        spicyGrilledChicken.addIngredient(new Ingredient("finely grated orange zest", new BigDecimal(1), tableSpoonMeasure));
        spicyGrilledChicken.addIngredient(new Ingredient("fresh-squeezed orange juice", new BigDecimal(3),  tableSpoonMeasure));
        spicyGrilledChicken.addIngredient(new Ingredient("olive oil", new BigDecimal(2),  tableSpoonMeasure));
        spicyGrilledChicken.addIngredient(new Ingredient("skinless, boneless chicken thighs (1 1/4 pounds)", new BigDecimal(4),  null));

        return spicyGrilledChicken;
    }
}
