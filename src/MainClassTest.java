import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MainClassTest {
    MainClass main = new MainClass();
    int expected;

    @Test
    public void testGetLocalNumber() {
        expected = 14;
        assertEquals(String.format("GetLocalNumber return %s, not %s.", main.getLocalNumber(), expected), main.getLocalNumber(), expected);
    }

    @Test
    public void testGetClassNumber() {
        expected = 45;
        assertTrue(String.format("GetClassNumber return less that %s.", expected), main.getClassNumber() > expected);
    }
}
