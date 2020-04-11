package tdd.args;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SchameTest {

    @Test
    public void test_boolean() {
        Schame schame = new Schame("l:boolean");
        assertEquals(schame.getValue("l", "true"), Boolean.TRUE);
        assertEquals(schame.getValue("l", "false"), Boolean.FALSE);
        assertEquals(schame.getValue("l", null), Boolean.FALSE);
        assertEquals(schame.getValue("l", ""), Boolean.FALSE);
    }

    @Test
    public void test_int() {
        Schame schame = new Schame("p:int");
        assertEquals(schame.getValue("p", "1"), 1);
        assertEquals(schame.getValue("p", "8080"), 8080);
        assertEquals(schame.getValue("p", null), 0);
        assertEquals(schame.getValue("p", ""), 0);
    }

    @Test
    public void test_String() {
        Schame schame = new Schame("d:String");
        assertEquals(schame.getValue("d", "/user/local"), "/user/local");
        assertEquals(schame.getValue("d", ""), "default");
        assertEquals(schame.getValue("d", null), "default");

    }

    @Test
    public void test_boolean_type_error() {
        Schame schame = new Schame("l:boolean");
        assertEquals(schame.getValue("l", "1"), "只能输入Boolean类型的值");
    }

    @Test
    public void test_int_type_error() {
        Schame schame = new Schame("p:int");
        assertEquals(schame.getValue("p", "int"), "只能输入Integer类型的值");
    }
}
