package example;

import microunit.Assert;
import microunit.Test;

public class ExampleTest {

    public ExampleTest() {
    }

    @Test
    public void a() {
        Assert.assertTrue(1 + 1 == 2,"This should always be true");
    }

    @Test
    public void b() {
        Assert.assertTrue(1 + 2 == 4,"This should always be false");
    }

    public void c() {
    }


}
