import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class TestFillingBurger {
    static Faker faker = new Faker();
    public Burger burger = new Burger();
    public Bun bun = new Bun(faker.food().ingredient(), (float) faker.number().randomDouble(2,1, 1000));
    public Ingredient ingr1 = new Ingredient(SAUCE, faker.food().ingredient(), (float) faker.number().randomDouble(2,1, 1000));
    public Ingredient ingr2 = new Ingredient(FILLING, faker.food().ingredient(), (float) faker.number().randomDouble(2,1, 1000));
    public Ingredient ingr3 = new Ingredient(FILLING, faker.food().ingredient(), (float) faker.number().randomDouble(2,1, 1000));
    @Before
    public void setUp() {
        burger.setBuns(bun);
        burger.addIngredient(ingr1);
        burger.addIngredient(ingr2);
        burger.addIngredient(ingr3);
        Assert.assertTrue(!burger.ingredients.isEmpty());
    }

    @Test
    public void shouldBeRemoveIngredient() {
        burger.removeIngredient(0);
        burger.removeIngredient(0);
        burger.removeIngredient(0);
        Assert.assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void shouldBeMoveIngredient() {
        burger.moveIngredient(0,1);
        Assert.assertTrue(burger.ingredients.get(1).equals(ingr1));
        Assert.assertTrue(burger.ingredients.get(0).equals(ingr2));
    }

    @Test
    public void shouldBeReturnPrice() {

        float price = bun.getPrice()*2 + ingr1.getPrice() + ingr2.getPrice() + ingr3.getPrice();
        Assert.assertEquals(burger.getPrice(), price, 0.00001);
    }

    @Test
    public void shouldBeReturnReceipt() {

        float price = bun.getPrice()*2 + ingr1.getPrice() + ingr2.getPrice() + ingr3.getPrice();
        String text = String.format("(==== %s ====)\r\n= %s %s =\r\n= %s %s =\r\n= %s %s =\r\n" +
                        "(==== %s ====)\r\n\r\nPrice: %f\r\n",
                bun.getName(), ingr1.getType().toString().toLowerCase(), ingr1.getName(),
                ingr2.getType().toString().toLowerCase(), ingr2.getName(), ingr3.getType().toString().toLowerCase(),
                ingr3.getName(), bun.getName(), price);

        Assert.assertEquals(burger.getReceipt(), text);

    }

}
