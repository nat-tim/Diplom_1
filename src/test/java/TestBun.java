import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;
import praktikum.IngredientType;

public class TestBun {
    static Faker faker = new Faker();
    public final String name = faker.food().ingredient();
    public final float price = (float) faker.number().randomDouble(2,1, 1000);
    private final Bun bun = new Bun(name, price);

    @Test
    public void shouldBeReturnName() {
        Assert.assertEquals(name, bun.getName());
    }

    @Test
    public void shouldBeReturnPrice() {
        Assert.assertEquals(price, bun.getPrice(), 0.000001);
    }
}
