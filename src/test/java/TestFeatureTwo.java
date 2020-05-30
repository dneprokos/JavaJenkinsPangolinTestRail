import org.junit.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestFeatureTwo {
    @Test
    public void passTestExample() {
        Assertions.assertTrue(true);
    }

    @Ignore("Logic is ignore case example")
    @Test
    public void ignoreTestExample() {
        Assertions.assertEquals(1, 1);
    }
}
