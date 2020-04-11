package tdd.args;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SchemaTest {

    @Test
    public void test_boolean() {
        Schema schema = new Schema("l:boolean");
        assertEquals(schema.getValue("l", "true"), Boolean.TRUE);
        assertEquals(schema.getValue("l", "false"), Boolean.FALSE);
        assertEquals(schema.getValue("l", null), Boolean.FALSE);
        assertEquals(schema.getValue("l", ""), Boolean.FALSE);
    }

    @Test
    public void test_int() {
        Schema schema = new Schema("p:int");
        assertEquals(schema.getValue("p", "1"), 1);
        assertEquals(schema.getValue("p", "8080"), 8080);
        assertEquals(schema.getValue("p", null), 0);
        assertEquals(schema.getValue("p", ""), 0);
    }

    @Test
    public void test_String() {
        Schema schema = new Schema("d:String");
        assertEquals(schema.getValue("d", "/user/local"), "/user/local");
        assertEquals(schema.getValue("d", ""), "default");
        assertEquals(schema.getValue("d", null), "default");

    }

    @Test
    public void test_boolean_type_error() {
        Schema schema = new Schema("l:boolean");
        assertEquals(schema.getValue("l", "1"), "只能输入Boolean类型的值");
    }

    @Test
    public void test_int_type_error() {
        Schema schema = new Schema("p:int");
        assertEquals(schema.getValue("p", "int"), "只能输入Integer类型的值");
    }
}
