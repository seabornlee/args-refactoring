package tdd.args;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArgsTest {

    @Test
    public void normal_test() {
        Args args = new Args("l:boolean,p:int,d:String", "-l true -p 8080 -d /user/local");
        assertEquals(args.getValue("l"), Boolean.TRUE);
        assertEquals(args.getValue("p"), 8080);
        assertEquals(args.getValue("d"), "/user/local");
    }

    @Test
    public void have_no_value_test() {
        Args args = new Args("l:boolean,p:int,d:String", "-l -p 8080 -d /user/local");
        assertEquals(args.getValue("l"), Boolean.FALSE);
        assertEquals(args.getValue("p"), 8080);
        assertEquals(args.getValue("d"), "/user/local");
    }

    @Test
    public void have_negative_number_test() {
        Args args = new Args("l:boolean,p:int,d:String", "-l true -p -9 -d /user/local");
        assertEquals(args.getValue("l"), Boolean.TRUE);
        assertEquals(args.getValue("p"), -9);
        assertEquals(args.getValue("d"), "/user/local");
    }

    @Test
    public void value_type_not_match_schame() {
        Args args = new Args("l:boolean,p:int,d:String", "-l 123 -p int -d /user/local");
        assertEquals(args.getValue("l"), "只能输入Boolean类型的值");
        assertEquals(args.getValue("p"), "只能输入Integer类型的值");
        assertEquals(args.getValue("d"), "/user/local");
    }

    @Test
    public void should_get_default_value_by_type_given_incomplete_command() {
        Args args = new Args("l:boolean,p:int,d:String", "-d /user/local");
        assertEquals(args.getValue("l"), Boolean.FALSE);
        assertEquals(args.getValue("p"), 0);
        assertEquals(args.getValue("d"), "/user/local");
    }

    @Test
    public void command_not_match_schema() {
        Args args = new Args("b:boolean,i:int,s:String", "-d hello");
        assertEquals(args.getValue("b"), Boolean.FALSE);
        assertEquals(args.getValue("i"), 0);
        assertEquals(args.getValue("s"), "default");
        assertEquals(args.getValue("d"), "Please enter a valid command");
    }
}
