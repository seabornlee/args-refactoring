package tdd.args;


public class Args {
    private final Schame schame;
    private final Command command;

    public Args(String schame, String command) {
        this.schame = new Schame(schame);
        this.command = new Command(command);
    }

    public Object getValue(String name) {
        return schame.getValue(name, command.getValue(name));
    }
}
