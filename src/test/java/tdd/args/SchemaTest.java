package tdd.args;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SchemaTest {

    @Test
    public void test_boolean() {
        Schema schema = new Schema("l:boolean");
        assertEquals(schema.getValueInType("l", "true"), Boolean.TRUE);
        assertEquals(schema.getValueInType("l", "false"), Boolean.FALSE);
        assertEquals(schema.getValueInType("l", null), Boolean.FALSE);
        assertEquals(schema.getValueInType("l", ""), Boolean.FALSE);
    }

    @Test
    public void test_int() {
        Schema schema = new Schema("p:int");
        assertEquals(schema.getValueInType("p", "1"), 1);
        assertEquals(schema.getValueInType("p", "8080"), 8080);
        assertEquals(schema.getValueInType("p", null), 0);
        assertEquals(schema.getValueInType("p", ""), 0);
    }

    @Test
    public void test_String() {
        Schema schema = new Schema("d:String");
        assertEquals(schema.getValueInType("d", "/user/local"), "/user/local");
        assertEquals(schema.getValueInType("d", ""), "default");
        assertEquals(schema.getValueInType("d", null), "default");

    }

    @Test
    public void test_boolean_type_error() {
        Schema schema = new Schema("l:boolean");
        assertEquals(schema.getValueInType("l", "1"), "只能输入Boolean类型的值");
    }

    @Test
    public void test_int_type_error() {
        Schema schema = new Schema("p:int");
        assertEquals(schema.getValueInType("p", "int"), "只能输入Integer类型的值");
    }
}
