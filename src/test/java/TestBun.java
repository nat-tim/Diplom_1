import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class TestBun {
    private final Bun bun = new Bun("just bun", 0.0f);
    @Test
    public void shouldBeReturnName() {
        Assert.assertEquals("just bun", bun.getName());
    }

    @Test
    public void shouldBeReturnPrice() {
        Assert.assertEquals(0.0f, bun.getPrice(), 0.000001);
    }
}
