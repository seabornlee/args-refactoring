package tdd.args;


public class Args {
    private final Schema schema;
    private final Command command;

    public Args(String schema, String command) {
        this.schema = new Schema(schema);
        this.command = new Command(command);
    }

    public Object getValue(String name) {
        return schema.getValueInType(name, command.getValue(name));
    }
}
