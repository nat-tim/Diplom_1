import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class TestFillingBurger {
    public Burger burger = new Burger();
    public Bun bun = new Bun("Хлебушек", 10.03f);
    public Ingredient ingr1 = new Ingredient(SAUCE, "кетчуп", 100.06f);
    public Ingredient ingr2 = new Ingredient(FILLING, "салат", 1.06f);
    public Ingredient ingr3 = new Ingredient(FILLING, "котлетка", 0.01f);
    @Before
    public void setUp() {
        burger.setBuns(bun);
        burger.addIngredient(ingr1);
        burger.addIngredient(ingr2);
        burger.addIngredient(ingr3);
        Assert.assertTrue(!burger.ingredients.isEmpty());
    }

    @Test
    public void ShouldBeRemoveIngredient() {
        burger.removeIngredient(0);
        burger.removeIngredient(0);
        burger.removeIngredient(0);
        Assert.assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void ShouldBeMoveIngredient() {
        burger.moveIngredient(0,1);
        Assert.assertTrue(burger.ingredients.get(1).equals(ingr1));
        Assert.assertTrue(burger.ingredients.get(0).equals(ingr2));
    }

    @Test
    public void ShouldBeReturnPrice() {
        Assert.assertEquals(burger.getPrice(), 121.19f, 0.00001);
    }

    @Test
    public void ShouldBeReturnReceipt() {
        Assert.assertEquals(burger.getReceipt(), "(==== Хлебушек ====)\r\n= sauce кетчуп =\r\n= filling салат =\r\n= filling котлетка =\r\n" +
                "(==== Хлебушек ====)\r\n\r\nPrice: 121,189995\r\n");
    }

}
