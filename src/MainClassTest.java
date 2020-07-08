import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MainClassTest {
    MainClass main = new MainClass();
    int expected_int;
    String expected_hello;
    String expected_Hello;

    @Test
    public void testGetLocalNumber() {
        expected_int = 14;
        assertEquals(String.format("GetLocalNumber return %s, not %s.", main.getLocalNumber(), expected_int), main.getLocalNumber(), expected_int);
    }

    @Test
    public void testGetClassNumber() {
        expected_int = 45;
        assertTrue(String.format("GetClassNumber return less than %s.", expected_int), main.getClassNumber() > expected_int);
    }

    @Test
    public void testGetClassString() {
        expected_hello = "hello";
        expected_Hello = "Hello";
        assertThat(String.format("GetClassString don't have '%s' or '%s'.", expected_hello, expected_Hello),
                main.getClassString().contains(expected_hello) || main.getClassString().contains(expected_Hello));
    }
}
