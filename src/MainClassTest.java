import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainClassTest {
    MainClass main = new MainClass();

    @Test
    public void testGetLocalNumber() {
        assertEquals("Incorrect return from getLocalNumber function.", main.getLocalNumber(), 14);
    }
}
