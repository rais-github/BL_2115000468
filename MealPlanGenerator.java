interface MealPlan {
    void displayMeal();
}

class VegetarianMeal implements MealPlan {
    @Override
    public void displayMeal() {
        System.out.println("Vegetarian Meal: Salad, Grilled Vegetables, Fruit Smoothie");
    }
}

class VeganMeal implements MealPlan {
    @Override
    public void displayMeal() {
        System.out.println("Vegan Meal: Quinoa Salad, Tofu Stir-fry, Green Juice");
    }
}

class KetoMeal implements MealPlan {
    @Override
    public void displayMeal() {
        System.out.println("Keto Meal: Grilled Chicken, Avocado Salad, Bulletproof Coffee");
    }
}

class HighProteinMeal implements MealPlan {
    @Override
    public void displayMeal() {
        System.out.println("High-Protein Meal: Steak, Eggs, Protein Shake");
    }
}

class Meal<T extends MealPlan> {
    private T mealPlan;

    public Meal(T mealPlan) {
        this.mealPlan = mealPlan;
    }

    public void displayMealPlan() {
        mealPlan.displayMeal();
    }
}

public class MealPlanGenerator {
    public static <T extends MealPlan> Meal<T> generateMealPlan(T mealPlan) {
        return new Meal<>(mealPlan);
    }

    public static void main(String[] args) {
        Meal<VegetarianMeal> vegetarianMeal = generateMealPlan(new VegetarianMeal());
        vegetarianMeal.displayMealPlan();

        Meal<VeganMeal> veganMeal = generateMealPlan(new VeganMeal());
        veganMeal.displayMealPlan();

        Meal<KetoMeal> ketoMeal = generateMealPlan(new KetoMeal());
        ketoMeal.displayMealPlan();

        Meal<HighProteinMeal> highProteinMeal = generateMealPlan(new HighProteinMeal());
        highProteinMeal.displayMealPlan();
    }
}