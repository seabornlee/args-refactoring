package tdd.args;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CommandTest {

    @Test
    public void test_normal() {
        Command command = new Command("-l true -p 8080 -d /user/local");
        assertEquals(command.getValue("l"), "true");
        assertEquals(command.getValue("p"), "8080");
        assertEquals(command.getValue("d"), "/user/local");
    }

    @Test
    public void test_no_value() {
        Command command = new Command("-l -p 8080 -d /user/local");
        assertNull(command.getValue("l"));
        assertEquals(command.getValue("p"), "8080");
        assertEquals(command.getValue("d"), "/user/local");
    }

    @Test
    public void test_have_negative() {
        Command command = new Command("-l -p -9 -d /user/local");
        assertNull(command.getValue("l"));
        assertEquals(command.getValue("p"), "-9");
        assertEquals(command.getValue("d"), "/user/local");
    }


}
